package com.example.modeladov1.repository;

import com.example.modeladov1.model.Categoria;
import com.example.modeladov1.model.Venta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepository extends CrudRepository<Venta, Integer> {
    Venta findById(int id);

}
