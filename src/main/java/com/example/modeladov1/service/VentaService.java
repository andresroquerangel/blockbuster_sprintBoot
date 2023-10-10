package com.example.modeladov1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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

    public void eliminarVenta(int id) {
        repo.deleteById(id);
    }

    public Venta actualizarVenta(Integer id_venta, Venta ventaActualizada) {
        Optional<Venta> ventaExistente = repo.findById(id_venta);

        if (ventaExistente.isPresent()) {
            Venta venta = ventaExistente.get();
            venta.setId_usuario(ventaActualizada.getId_usuario());
            venta.setId_tipo_pago(ventaActualizada.getId_tipo_pago());
            // Actualiza otros campos según sea necesario

            // Guarda la categoría actualizada en la base de datos
            return repo.save(venta);
        } else {
            throw new NoSuchElementException("Venta no encontrada");
        }
    }

}
