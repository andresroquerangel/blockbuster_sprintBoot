package com.example.modeladov1.repository;

import com.example.modeladov1.model.Pais;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends CrudRepository<Pais, Integer>{
    Pais findById(int id);
}