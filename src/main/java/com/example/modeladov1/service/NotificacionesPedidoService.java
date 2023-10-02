package com.example.modeladov1.service;
import java.util.ArrayList;
import java.util.List;
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
        for(NotificacionesPedido notificacionPedido : repo.findAll()){
            notificacionesPedidos.add(notificacionPedido);
        }
        return notificacionesPedidos;
    }

    public void add(NotificacionesPedido notificacionPedido){
        repo.save(notificacionPedido);
    }
}

