package com.example.modeladov1.service;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.example.modeladov1.model.Categoria;
import com.example.modeladov1.model.Municipio;
import com.example.modeladov1.model.Pais;
import com.example.modeladov1.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PaisService {
    private final PaisRepository repo;

    @Autowired
    public PaisService(PaisRepository paisRepository) {
        this.repo = paisRepository;
    }

    public ResponseEntity<List<Pais>> getPaises() {
        List<Pais> lista= repo.findAll();
        if (!lista.isEmpty()) {
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    public ResponseEntity<Pais> getPaisById(int id) {
        Pais objeto = repo.findById(id).orElse(null);
        if(objeto!=null){
            return new ResponseEntity<>(objeto, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    public ResponseEntity<Pais> savePais(Pais pais) {
        Pais objeto = repo.save(pais);
        return new ResponseEntity<>(objeto, HttpStatus.OK);
    }

    public ResponseEntity<Pais> actualizarPais(Integer id_pais, Pais paisActualizada) {
        Optional<Pais> paisExistente = repo.findById(id_pais);
        if (paisExistente.isPresent()) {
            Pais pais = paisExistente.get();
            pais.setNombre(paisActualizada.getNombre());
            Pais objeto = repo.save(pais);
            return new ResponseEntity<>(objeto,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    public ResponseEntity<Pais> deletePais(int id) {
        if(repo.findById(id).isPresent()){
            repo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}

