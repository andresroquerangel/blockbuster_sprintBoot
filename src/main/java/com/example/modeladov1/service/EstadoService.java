package com.example.modeladov1.service;
import java.util.ArrayList;
import java.util.List;
import com.example.modeladov1.model.Estado;
import com.example.modeladov1.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadoService {
    @Autowired
    EstadoRepository repo;

    public List<Estado> getAll(){
        List<Estado> estados = new ArrayList<>();
        for(Estado estado : repo.findAll()){
            estados.add(estado);
        }
        return estados;
    }

    public void add(Estado estado){
        repo.save(estado);
    }
}

