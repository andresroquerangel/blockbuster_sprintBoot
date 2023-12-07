package com.example.modeladov1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import com.example.modeladov1.model.*;
import com.example.modeladov1.repository.VentaDetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class VentaDetalleService {
    @Autowired
    VentaDetalleRepository repo;


    public ResponseEntity<List<VentaDetalle>> getAll(){
        List<VentaDetalle> ventasdetalles = new ArrayList<>();
        for(VentaDetalle ventadetalle : repo.findAll()){
            ventasdetalles.add(ventadetalle);
        }
        return new ResponseEntity<>(ventasdetalles, HttpStatus.OK);
    }

    public ResponseEntity<VentaDetalle> getOne(Integer id) {
        VentaDetalle objeto = repo.findById(id).orElse(null);
        if(objeto!=null){
            return new ResponseEntity<>(objeto, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    public ResponseEntity<VentaDetalle> add(VentaDetalle ventaDetalle){
        VentaDetalle objeto = repo.save(ventaDetalle);
        return new ResponseEntity<>(objeto,HttpStatus.OK);
    }

    public ResponseEntity<VentaDetalle> eliminarVentaDetalle(int id) {
        if(repo.findById(id).isPresent()){
            repo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    public ResponseEntity<VentaDetalle> actualizarVentaDetalle(Integer id_venta_detalle, VentaDetalle ventaDetalleActualizada) {
        Optional<VentaDetalle> ventaDetalleExistente = repo.findById(id_venta_detalle);

        if (ventaDetalleExistente.isPresent()) {
            VentaDetalle ventaDetalle = ventaDetalleExistente.get();
            ventaDetalle.setPrecio(ventaDetalleActualizada.getPrecio());
            ventaDetalle.setSubtotal(ventaDetalleActualizada.getSubtotal());
            ventaDetalle.setCantidad(ventaDetalleActualizada.getCantidad());
            VentaDetalle objeto = repo.save(ventaDetalle);
            return new ResponseEntity<>(objeto,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
