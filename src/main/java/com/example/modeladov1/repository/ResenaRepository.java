package com.example.modeladov1.repository;

import com.example.modeladov1.model.Resena;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResenaRepository extends CrudRepository<Resena, Integer>{

}