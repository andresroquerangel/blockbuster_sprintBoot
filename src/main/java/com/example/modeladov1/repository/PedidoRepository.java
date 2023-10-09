package com.example.modeladov1.repository;

import com.example.modeladov1.model.Pedido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Integer>{
    Pedido findById(int id);
}