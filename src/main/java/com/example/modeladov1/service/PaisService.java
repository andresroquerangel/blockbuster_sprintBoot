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
    private final PaisRepository paisRepository;

    @Autowired
    public PaisService(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    public List<Pais> getPaises() {
        return paisRepository.findAll();
    }

    public Pais getPaisById(int id) {
        return paisRepository.findById(id).orElse(null);
    }

    public Pais savePais(Pais pais) {
        return paisRepository.save(pais);
    }

    public void deletePais(int id) {
        paisRepository.deleteById(id);
    }
}

