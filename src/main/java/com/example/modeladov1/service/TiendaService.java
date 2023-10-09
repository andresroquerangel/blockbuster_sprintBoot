package com.example.modeladov1.service;

import java.util.ArrayList;
import java.util.List;

import java.util.NoSuchElementException;
import java.util.Optional;

import com.example.modeladov1.model.Categoria;
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

    public Tienda getOne(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public void add(Tienda tienda){
        repo.save(tienda);
    }

    public void eliminarTienda(int id) {
        repo.deleteById(id);
    }

    public Tienda actualizarTienda(Integer id_tienda, Tienda tiendaActualizada) {
        Optional<Tienda> tiendaExistente = repo.findById(id_tienda);

        if (tiendaExistente.isPresent()) {
            Tienda tienda = tiendaExistente.get();
            tienda.setNombre(tiendaActualizada.getNombre());
            tienda.setDescripcion(tiendaActualizada.getDescripcion());
            // Actualiza otros campos según sea necesario

            // Guarda la tienda actualizada en la base de datos
            return repo.save(tienda);
        } else {
            throw new NoSuchElementException("Tienda no encontrada");
        }
    }
}
