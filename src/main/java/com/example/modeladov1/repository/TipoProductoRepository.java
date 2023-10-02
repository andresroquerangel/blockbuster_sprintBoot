package com.example.modeladov1.repository;

import com.example.modeladov1.model.TipoProducto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoProductoRepository extends CrudRepository<TipoProducto, Integer>{

}
