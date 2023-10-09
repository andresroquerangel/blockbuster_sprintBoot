package com.example.modeladov1.repository;

import com.example.modeladov1.model.NotificacionesPedido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificacionesPedidoRepository extends CrudRepository<NotificacionesPedido, Integer>{
    NotificacionesPedido findById(int id);
}