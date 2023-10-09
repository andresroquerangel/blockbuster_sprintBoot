package com.example.modeladov1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.example.modeladov1.model.Categoria;
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

    public VentaDetalle getOne(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public void add(VentaDetalle ventadetalle){
        repo.save(ventadetalle);
    }

    public void eliminarVentaDetalle(int id) {
        repo.deleteById(id);
    }

    public VentaDetalle actualizarVentaDetalle(Integer id_venta_detalle, VentaDetalle ventaDetalleActualizada) {
        Optional<VentaDetalle> ventaDetalleExistente = repo.findById(id_venta_detalle);

        if (ventaDetalleExistente.isPresent()) {
            VentaDetalle ventaDetalle = ventaDetalleExistente.get();
            ventaDetalle.setPrecio(ventaDetalleActualizada.getPrecio());
            ventaDetalle.setSubtotal(ventaDetalleActualizada.getSubtotal());
            ventaDetalle.setCantidad(ventaDetalleActualizada.getCantidad());
            // Actualiza otros campos según sea necesario

            // Guarda la categoría actualizada en la base de datos
            return repo.save(ventaDetalle);
        } else {
            throw new NoSuchElementException("Venta Detalle no encontrada");
        }
    }
}
