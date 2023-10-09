package com.example.modeladov1.repository;

import com.example.modeladov1.model.Ciudad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CiudadRepository extends CrudRepository<Ciudad, Integer>{
    Ciudad findById(int id);
}