package com.example.modeladov1.service;

import java.util.ArrayList;
import java.util.List;
import com.example.modeladov1.model.VentaDetalle;
import com.example.modeladov1.repository.VentaDetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaDetalleService {
    @Autowired
    VentaDetalleRepository repo;

    public List<VentaDetalle> getAll(){
        List<VentaDetalle> ventasdetalles = new ArrayList<>();
        for(VentaDetalle ventadetalle : repo.findAll()){
            ventasdetalles.add(ventadetalle);
        }
        return ventasdetalles;
    }

    public void add(VentaDetalle ventadetalle){
        repo.save(ventadetalle);
    }
}
