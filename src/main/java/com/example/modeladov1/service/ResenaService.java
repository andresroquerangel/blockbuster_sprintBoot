package com.example.modeladov1.service;
import java.util.ArrayList;
import java.util.List;
import com.example.modeladov1.model.Resena;
import com.example.modeladov1.repository.ResenaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResenaService {
    @Autowired
    ResenaRepository repo;

    public List<Resena> getAll(){
        List<Resena> resenas = new ArrayList<>();
        for(Resena resena : repo.findAll()){
            resenas.add(resena);
        }
        return resenas;
    }

    public void add(Resena resena){
        repo.save(resena);
    }
}

