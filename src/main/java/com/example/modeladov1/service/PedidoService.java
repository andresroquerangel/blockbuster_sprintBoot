package com.example.modeladov1.service;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import com.example.modeladov1.model.Pedido;
import com.example.modeladov1.model.Tienda;
import com.example.modeladov1.model.Venta;
import com.example.modeladov1.model.Usuario;
import com.example.modeladov1.model.EstadoPedido;
import com.example.modeladov1.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
    @Autowired
    PedidoRepository repo;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    TiendaService tiendaService;

    @Autowired
    VentaService ventaService;

    @Autowired
    private EstadoPedidoService estadoPedidoService;

    public List<Pedido> getAll(){
        List<Pedido> pedidos = new ArrayList<>();
        for(Pedido pedido : repo.findAll()){
            pedidos.add(pedido);
        }
        return pedidos;
    }

    public Pedido getOne(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public void add(Pedido pedido){
        repo.save(pedido);
    }

    public void eliminarPedido(int id) {
        repo.deleteById(id);
    }

    public Pedido actualizarPedido(Integer id_pedido, Pedido pedidoActualizado) {
        Optional<Pedido> pedidoExistente = repo.findById(id_pedido);

        if (pedidoExistente.isPresent()) {
            return repo.save(pedidoActualizado);
        } else {
            throw new NoSuchElementException("Pedido no encontrado");
        }
    }

    //Workflow
    public Pedido actualizarEstadoPedido(Integer idPedido, Integer nuevoEstadoId) {
        Pedido pedido = repo.findById(idPedido).orElseThrow(NoSuchElementException::new);
        EstadoPedido nuevoEstado = estadoPedidoService.getOne(nuevoEstadoId).getBody();

        // Actualizar el estado del pedido
        pedido.setEstado(nuevoEstado);
        repo.save(pedido);

        // Enviar notificación al usuario
        String mensaje = "Su pedido ha cambiado a " + nuevoEstado.getNombre();
        // Aquí puedes implementar la lógica para enviar la notificación al usuario

        return pedido;
    }
}
