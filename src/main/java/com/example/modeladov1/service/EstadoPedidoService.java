package com.example.modeladov1.service;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import com.example.modeladov1.model.EstadoPedido;
import com.example.modeladov1.repository.EstadoPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadoPedidoService {
    @Autowired
    EstadoPedidoRepository repo;

    public List<EstadoPedido> getAll(){
        List<EstadoPedido> estadosPedidos = new ArrayList<>();
        for(EstadoPedido estadoPedido : repo.findAll()){
            estadosPedidos.add(estadoPedido);
        }
        return estadosPedidos;
    }

    public EstadoPedido getOne(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public void add(EstadoPedido estadoPedido){
        repo.save(estadoPedido);
    }
    public void eliminarEstadoPedido(int id) {repo.deleteById(id);}

    public EstadoPedido actualizarEstadoPedido(Integer id_estadoPedido, EstadoPedido estadoPedidoActualizado) {
        Optional<EstadoPedido> estadoPedidoExistente = repo.findById(id_estadoPedido);

        if (estadoPedidoExistente.isPresent()) {
            EstadoPedido estadoPedido = estadoPedidoExistente.get();
            estadoPedido.setNombre(estadoPedidoActualizado.getNombre());
            // Actualiza otros campos según sea necesario

            // Guarda el estadoPedido actualizado en la base de datos
            return repo.save(estadoPedido);
        } else {
            throw new NoSuchElementException("EstadoPedido no encontrado");
        }
    }
}
