package com.example.modeladov1.service;
import java.util.ArrayList;
import java.util.List;

import com.example.modeladov1.model.Categoria;
import com.example.modeladov1.model.Pais;
import com.example.modeladov1.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaisService {
    @Autowired
    PaisRepository repo;

    public List<Pais> getAll(){
        List<Pais> paises = new ArrayList<>();
        for(Pais pais : repo.findAll()){
            paises.add(pais);
        }
        return paises;
    }

    public Pais getOne(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public void add(Pais pais){
        repo.save(pais);
    }
}

