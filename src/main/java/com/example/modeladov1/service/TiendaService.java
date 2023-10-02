package com.example.modeladov1.service;
import java.util.ArrayList;
import java.util.List;
import com.example.modeladov1.model.Tienda;
import com.example.modeladov1.repository.TiendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TiendaService {
    @Autowired
    TiendaRepository repo;

    public List<Tienda> getAll(){
        List<Tienda> tiendas = new ArrayList<>();
        for(Tienda tienda : repo.findAll()){
            tiendas.add(tienda);
        }
        return tiendas;
    }

    public void add(Tienda tienda){
        repo.save(tienda);
    }
}
