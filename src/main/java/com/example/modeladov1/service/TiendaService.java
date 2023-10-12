package com.example.modeladov1.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.example.modeladov1.model.Pais;
import com.example.modeladov1.model.Tienda;
import com.example.modeladov1.repository.TiendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TiendaService {
    private final TiendaRepository repo;

    @Autowired
    public TiendaService(TiendaRepository tiendaRepository) {
        this.repo = tiendaRepository;
    }

    public List<Tienda> getTiendas() {
        return repo.findAll();
    }

    public Tienda getTiendaById(int id) {
        return repo.findById(id).orElse(null);
    }

    public Tienda saveTienda(Tienda tienda) {
        return repo.save(tienda);
    }

    public Tienda actualizarTienda(Integer id_tienda, Tienda tiendaActualizada) {
        Optional<Tienda> tiendaExistente = repo.findById(id_tienda);
        if (tiendaExistente.isPresent()) {
            Tienda tienda = tiendaExistente.get();
            tienda.setNombre(tiendaActualizada.getNombre());
            tienda.setDescripcion(tiendaActualizada.getDescripcion());
            return repo.save(tienda);
        } else {
            throw new NoSuchElementException("Tienda no encontrada");
        }
    }

    public void deleteTienda(int id) {
        repo.deleteById(id);
    }
}
