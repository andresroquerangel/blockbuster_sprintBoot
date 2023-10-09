package com.example.modeladov1.service;

import java.util.ArrayList;
import java.util.List;

import com.example.modeladov1.model.Categoria;
import com.example.modeladov1.model.Venta;
import com.example.modeladov1.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService {
    @Autowired
    VentaRepository repo;

    public List<Venta> getAll(){
        List<Venta> ventas = new ArrayList<>();
        for(Venta venta : repo.findAll()){
            ventas.add(venta);
        }
        return ventas;
    }

    public Venta getOne(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public void add(Venta venta){
        repo.save(venta);
    }

}
