package com.example.modeladov1.service;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.example.modeladov1.model.NotificacionesPedido;
import com.example.modeladov1.repository.NotificacionesPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificacionesPedidoService {
    @Autowired
    NotificacionesPedidoRepository repo;

    public List<NotificacionesPedido> getAll(){
        List<NotificacionesPedido> notificacionesPedidos = new ArrayList<>();
        for(NotificacionesPedido notificacionesPedido : repo.findAll()){
            notificacionesPedidos.add(notificacionesPedido);
        }
        return notificacionesPedidos;
    }

    public NotificacionesPedido getOne(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public void add(NotificacionesPedido notificacionesPedido){
        repo.save(notificacionesPedido);
    }

    public void eliminarNotificacionesPedido(int id) {
        repo.deleteById(id);
    }

    public NotificacionesPedido actualizarNotificacionesPedido(Integer id_notificacionesPedido, NotificacionesPedido notificacionesPedidoActualizado) {
        Optional<NotificacionesPedido> notificacionesPedidoExistente = repo.findById(id_notificacionesPedido);

        if (notificacionesPedidoExistente.isPresent()) {
            NotificacionesPedido notificacionesPedido = notificacionesPedidoExistente.get();
            notificacionesPedido.setMensaje(notificacionesPedidoActualizado.getMensaje());
            notificacionesPedido.setFecha_hora_creacion(notificacionesPedidoActualizado.getFecha_hora_creacion());
            notificacionesPedido.setId_estado_pedido(notificacionesPedidoActualizado.getId_estado_pedido());
            notificacionesPedido.setId_pedido(notificacionesPedidoActualizado.getId_pedido());
            notificacionesPedido.setId_usuario(notificacionesPedidoActualizado.getId_usuario());
            // Actualiza otros campos según sea necesario

            // Guarda las notificaciones del pedido actualizadas en la base de datos
            return repo.save(notificacionesPedido);
        } else {
            throw new NoSuchElementException("Notificaciones del pedido no encontradas");
        }
    }
}
