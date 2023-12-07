package com.example.modeladov1.service;
import java.util.ArrayList;
import java.util.List;

import java.util.Optional;
import java.util.NoSuchElementException;

import com.example.modeladov1.model.Categoria;
import com.example.modeladov1.model.Municipio;
import com.example.modeladov1.model.Estado;
import com.example.modeladov1.repository.MunicipioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MunicipioService {
    @Autowired
    MunicipioRepository repo;

    @Autowired
    EstadoService estadoService; // Inyecta estadoService

    public ResponseEntity<List<Municipio>> getAll(){
        List<Municipio> municipios = new ArrayList<>();
        for(Municipio municipio : repo.findAll()){
            municipios.add(municipio);
        }
        return new ResponseEntity<>(municipios, HttpStatus.OK);
    }

    public ResponseEntity<Municipio> getOne(Integer id) {
        Municipio objeto = repo.findById(id).orElse(null);
        if(objeto!=null){
            return new ResponseEntity<>(objeto, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    public ResponseEntity<Municipio> add(Municipio municipio){
        Municipio objeto = repo.save(municipio);
        return new ResponseEntity<>(objeto, HttpStatus.OK);
    }


    public ResponseEntity<Municipio> eliminarMunicipio(int id) {
        if(repo.findById(id).isPresent()){
            repo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    public ResponseEntity<Municipio> actualizarMunicipio(Integer id_municipio, Municipio municipioActualizado) {
        Optional<Municipio> municipioExistente = repo.findById(id_municipio);

        if (municipioExistente.isPresent()) {
            Municipio municipio = municipioExistente.get();
            municipio.setNombre(municipioActualizado.getNombre());
            Municipio objeto = repo.save(municipio);
            return new ResponseEntity<>(objeto,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}

