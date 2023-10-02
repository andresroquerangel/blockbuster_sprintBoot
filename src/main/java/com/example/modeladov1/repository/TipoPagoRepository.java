package com.example.modeladov1.repository;

import com.example.modeladov1.model.TipoPago;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPagoRepository extends CrudRepository<TipoPago, Integer>{

}
