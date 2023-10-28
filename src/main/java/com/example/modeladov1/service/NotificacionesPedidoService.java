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
        Pedido pedido = pedidoService.getOne(notificacionesPedido.getPedido().getId_pedido()); // Usa pedidoService para llamar a getOne
        Usuario usuario = usuarioService.getOne(notificacionesPedido.getUsuario().getId_usuario()); // Usa usuarioService para llamar a getOne
        EstadoPedido estadoPedido = estadoPedidoService.getOne(notificacionesPedido.getEstadoPedido().getId_estado_pedido()); // Usa estadoPedidoService para llamar a getOne
        notificacionesPedido.setPedido(pedido); // Establece el Pedido en la NotificacionesPedido
        notificacionesPedido.setUsuario(usuario); // Establece el Usuario en la NotificacionesPedido
        notificacionesPedido.setEstadoPedido(estadoPedido); // Establece el EstadoPedido en la NotificacionesPedido
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

            Pedido pedido = pedidoService.getOne(notificacionesPedidoActualizado.getPedido().getId_pedido());
            notificacionesPedido.setPedido(pedido);

            Usuario usuario = usuarioService.getOne(notificacionesPedidoActualizado.getUsuario().getId_usuario());
            notificacionesPedido.setUsuario(usuario);

            EstadoPedido estadoPedido = estadoPedidoService.getOne(notificacionesPedidoActualizado.getEstadoPedido().getId_estado_pedido());
            notificacionesPedido.setEstadoPedido(estadoPedido);

            repo.save(notificacionesPedido);
            return notificacionesPedido;
        } else {
            throw new NoSuchElementException("NotificacionesPedido con id " + id_notificacionesPedido + " no encontrado");
        }
    }
}
