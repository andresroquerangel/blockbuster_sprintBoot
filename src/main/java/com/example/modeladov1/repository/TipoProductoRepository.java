package com.example.modeladov1.repository;

import com.example.modeladov1.model.Categoria;
import com.example.modeladov1.model.TipoProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoProductoRepository extends JpaRepository<TipoProducto, Integer>{

}
