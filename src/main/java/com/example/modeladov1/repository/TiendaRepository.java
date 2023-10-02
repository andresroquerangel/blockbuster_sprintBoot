package com.example.modeladov1.repository;

import com.example.modeladov1.model.Tienda;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiendaRepository extends CrudRepository<Tienda, Integer>{

}