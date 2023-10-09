package com.example.modeladov1.repository;

import com.example.modeladov1.model.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Integer>{
    Producto findById(int id);
}