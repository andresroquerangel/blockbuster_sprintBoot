package com.example.modeladov1.service;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.example.modeladov1.model.NotificacionesPedido;
import com.example.modeladov1.model.Usuario;
import com.example.modeladov1.model.Pedido;
import com.example.modeladov1.model.EstadoPedido;
import com.example.modeladov1.repository.NotificacionesPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class NotificacionesPedidoService {
    @Autowired
    NotificacionesPedidoRepository repo;

    @Autowired
    PedidoService pedidoService;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    EstadoPedidoService estadoPedidoService;

    public ResponseEntity<List<NotificacionesPedido>> getAll(){
        List<NotificacionesPedido> notificacionesPedidos = new ArrayList<>();
        for(NotificacionesPedido notificacionesPedido : repo.findAll()){
            notificacionesPedidos.add(notificacionesPedido);
        }
        return new ResponseEntity<>(notificacionesPedidos,HttpStatus.OK);
    }

    public ResponseEntity<NotificacionesPedido> getOne(Integer id) {
        NotificacionesPedido objeto = repo.findById(id).orElse(null);
        if(objeto!=null){
            return new ResponseEntity<>(objeto, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    public ResponseEntity<NotificacionesPedido> add(NotificacionesPedido notificacionesPedido){
        NotificacionesPedido objeto = repo.save(notificacionesPedido);
        return new ResponseEntity<>(objeto, HttpStatus.OK);
    }

    public ResponseEntity<NotificacionesPedido> eliminarNotificacionesPedido(int id) {
        if(repo.findById(id).isPresent()){
            repo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    public ResponseEntity<NotificacionesPedido> actualizarNotificacionesPedido(Integer id_notificacionesPedido, NotificacionesPedido notificacionesPedidoActualizado) {
        Optional<NotificacionesPedido> notificacionesPedidoExistente = repo.findById(id_notificacionesPedido);

        if (notificacionesPedidoExistente.isPresent()) {
            NotificacionesPedido notificacionesPedido = notificacionesPedidoExistente.get();
            notificacionesPedido.setMensaje(notificacionesPedidoActualizado.getMensaje());
            notificacionesPedido.setFecha_hora_creacion(notificacionesPedidoActualizado.getFecha_hora_creacion());
            NotificacionesPedido objeto = repo.save(notificacionesPedido);
            return new ResponseEntity<>(objeto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
