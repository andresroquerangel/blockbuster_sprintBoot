package com.example.modeladov1.service;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import com.example.modeladov1.model.Pedido;
import com.example.modeladov1.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
    @Autowired
    PedidoRepository repo;

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
            Pedido pedido = pedidoExistente.get();
            pedido.setFecha_pedido(pedidoActualizado.getFecha_pedido());
            // Actualiza otros campos según sea necesario

            // Guarda el pedido actualizado en la base de datos
            return repo.save(pedido);
        } else {
            throw new NoSuchElementException("Pedido no encontrado");
        }
    }
}
