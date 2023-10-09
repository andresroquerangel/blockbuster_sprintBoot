package com.example.modeladov1.service;
import java.util.ArrayList;
import java.util.List;

import com.example.modeladov1.model.Categoria;
import com.example.modeladov1.model.Ciudad;
import com.example.modeladov1.repository.CiudadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CiudadService {
    @Autowired
    CiudadRepository repo;

    public List<Ciudad> getAll(){
        List<Ciudad> ciudades = new ArrayList<>();
        for(Ciudad ciudad : repo.findAll()){
            ciudades.add(ciudad);
        }
        return ciudades;
    }

    public Ciudad getOne(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public void add(Ciudad ciudad){
        repo.save(ciudad);
    }
}
