package com.example.modeladov1.service;

import java.util.List;
import com.example.modeladov1.model.Tienda;
import com.example.modeladov1.repository.TiendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TiendaService {
    private final TiendaRepository tiendaRepository;

    @Autowired
    public TiendaService(TiendaRepository tiendaRepository) {
        this.tiendaRepository = tiendaRepository;
    }

    public List<Tienda> getTiendas() {
        return tiendaRepository.findAll();
    }

    public Tienda getTiendaById(int id) {
        return tiendaRepository.findById(id).orElse(null);
    }

    public Tienda saveTienda(Tienda tienda) {
        return tiendaRepository.save(tienda);
    }

    public void deleteTienda(int id) {
        tiendaRepository.deleteById(id);
    }
}
