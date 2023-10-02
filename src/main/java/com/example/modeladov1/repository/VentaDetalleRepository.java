package com.example.modeladov1.repository;

import com.example.modeladov1.model.VentaDetalle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaDetalleRepository extends CrudRepository<VentaDetalle, Integer>{

}