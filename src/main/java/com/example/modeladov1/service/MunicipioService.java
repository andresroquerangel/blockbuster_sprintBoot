package com.example.modeladov1.service;
import java.util.ArrayList;
import java.util.List;
import com.example.modeladov1.model.Municipio;
import com.example.modeladov1.repository.MunicipioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MunicipioService {
    @Autowired
    MunicipioRepository repo;

    public List<Municipio> getAll(){
        List<Municipio> municipios = new ArrayList<>();
        for(Municipio municipio : repo.findAll()){
            municipios.add(municipio);
        }
        return municipios;
    }

    public void add(Municipio municipio){
        repo.save(municipio);
    }
}

