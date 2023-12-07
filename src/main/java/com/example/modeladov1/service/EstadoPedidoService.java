package com.example.modeladov1.service;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import com.example.modeladov1.model.EstadoPedido;
import com.example.modeladov1.repository.EstadoPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EstadoPedidoService {
    @Autowired
    EstadoPedidoRepository repo;

    public ResponseEntity<List<EstadoPedido> > getAll(){
        List<EstadoPedido> estadosPedidos = new ArrayList<>();
        for(EstadoPedido estadoPedido : repo.findAll()){
            estadosPedidos.add(estadoPedido);
        }
        return new ResponseEntity<>(estadosPedidos, HttpStatus.OK);
    }

    public ResponseEntity<EstadoPedido> getOne(Integer id) {
        EstadoPedido objeto = repo.findById(id).orElse(null);
        if(objeto!=null){
            return new ResponseEntity<>(objeto, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    public ResponseEntity<EstadoPedido> add(EstadoPedido estadoPedido){
        EstadoPedido objeto = repo.save(estadoPedido);
        return new ResponseEntity<>(objeto, HttpStatus.OK);
    }
    public ResponseEntity<EstadoPedido> eliminarEstadoPedido(int id) {
        if(repo.findById(id).isPresent()){
            repo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    public ResponseEntity<EstadoPedido> actualizarEstadoPedido(Integer id_estadoPedido, EstadoPedido estadoPedidoActualizado) {
        Optional<EstadoPedido> estadoPedidoExistente = repo.findById(id_estadoPedido);

        if (estadoPedidoExistente.isPresent()) {
            EstadoPedido estadoPedido = estadoPedidoExistente.get();
            estadoPedido.setNombre(estadoPedidoActualizado.getNombre());
            // Actualiza otros campos según sea necesario

            // Guarda el estadoPedido actualizado en la base de datos
            EstadoPedido objeto = repo.save(estadoPedido);
            return new ResponseEntity<>(objeto,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
