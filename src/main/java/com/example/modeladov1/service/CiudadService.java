package com.example.modeladov1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.NoSuchElementException;

import com.example.modeladov1.model.Categoria;
import com.example.modeladov1.model.Ciudad;
import com.example.modeladov1.repository.CiudadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CiudadService {
    @Autowired
    CiudadRepository repo;

    public List<Ciudad> getAll(){
        List<Ciudad> ciudades = new ArrayList<>();
        for(Ciudad ciudad : repo.findAll()){
            ciudades.add(ciudad);
        }
        return ciudades;
    }

    public Ciudad getOne(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public void add(Ciudad ciudad){
        repo.save(ciudad);
    }

    public void eliminarCiudad(int id) {
        repo.deleteById(id);
    }

    public Ciudad actualizarCiudad(Integer id_ciudad, Ciudad ciudadActualizada) {
        Optional<Ciudad> ciudadExistente = repo.findById(id_ciudad);

        if (ciudadExistente.isPresent()) {
            Ciudad ciudad = ciudadExistente.get();
            ciudad.setNombre(ciudadActualizada.getNombre());
            ciudad.setId_municipio(ciudadActualizada.getId_municipio());
            return repo.save(ciudad);
        } else {
            throw new NoSuchElementException("Ciudad no encontrada");
        }
    }
}
