package com.example.modeladov1.service;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.example.modeladov1.model.Categoria;
import com.example.modeladov1.model.Pais;
import com.example.modeladov1.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaisService {
    private final PaisRepository repo;

    @Autowired
    public PaisService(PaisRepository paisRepository) {
        this.repo = paisRepository;
    }

    public List<Pais> getPaises() {
        return repo.findAll();
    }

    public Pais getPaisById(int id) {
        return repo.findById(id).orElse(null);
    }

    public Pais savePais(Pais pais) {
        return repo.save(pais);
    }

    public Pais actualizarPais(Integer id_pais, Pais paisActualizada) {
        Optional<Pais> paisExistente = repo.findById(id_pais);
        if (paisExistente.isPresent()) {
            Pais pais = paisExistente.get();
            pais.setNombre(paisActualizada.getNombre());
            return repo.save(pais);
        } else {
            throw new NoSuchElementException("Pais no encontrado");
        }
    }
    public void deletePais(int id) {
        repo.deleteById(id);
    }
}

