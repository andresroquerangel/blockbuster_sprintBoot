package com.example.modeladov1.repository;

import com.example.modeladov1.model.EstadoPedido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoPedidoRepository extends CrudRepository<EstadoPedido, Integer>{
}
