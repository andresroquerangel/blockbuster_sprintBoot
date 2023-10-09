package com.example.modeladov1.repository;

import com.example.modeladov1.model.Municipio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MunicipioRepository extends CrudRepository<Municipio, Integer>{
    Municipio findById(int id);
}
