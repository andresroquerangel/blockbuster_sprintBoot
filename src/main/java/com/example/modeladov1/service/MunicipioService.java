package com.example.modeladov1.service;
import java.util.ArrayList;
import java.util.List;

import java.util.Optional;
import java.util.NoSuchElementException;

import com.example.modeladov1.model.Categoria;
import com.example.modeladov1.model.Municipio;
import com.example.modeladov1.repository.MunicipioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MunicipioService {
    @Autowired
    MunicipioRepository repo;

    public List<Municipio> getAll(){
        List<Municipio> municipios = new ArrayList<>();
        for(Municipio municipio : repo.findAll()){
            municipios.add(municipio);
        }
        return municipios;
    }

    public Municipio getOne(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public void add(Municipio municipio){
        repo.save(municipio);
    }

    public void eliminarMunicipio(int id) {
        repo.deleteById(id);
    }

    public Municipio actualizarMunicipio(Integer id_municipio, Municipio municipioActualizado) {
        Optional<Municipio> municipioExistente = repo.findById(id_municipio);

        if (municipioExistente.isPresent()) {
            Municipio municipio = municipioExistente.get();
            municipio.setNombre(municipioActualizado.getNombre());
            // Actualiza otros campos según sea necesario

            // Guarda el municipio actualizado en la base de datos
            return repo.save(municipio);
        } else {
            throw new NoSuchElementException("Municipio no encontrado");
        }
    }
}

