package com.example.modeladov1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.example.modeladov1.model.Categoria;
import com.example.modeladov1.model.Estado;
import com.example.modeladov1.model.Pais;
import com.example.modeladov1.repository.EstadoRepository;
import com.example.modeladov1.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EstadoService {
    @Autowired
    EstadoRepository repo;

    @Autowired
    PaisService paisService; // Inyecta PaisService


    public ResponseEntity<List<Estado>> getAll(){
        List<Estado> estados = new ArrayList<>();
        for(Estado estado : repo.findAll()){
            estados.add(estado);
        }
        return new ResponseEntity<>(estados, HttpStatus.OK);
    }

    public ResponseEntity<Estado> getOne(Integer id) {
        Estado objeto = repo.findById(id).orElse(null);
        if(objeto!=null){
            return new ResponseEntity<>(objeto, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    public ResponseEntity<Estado> add(Estado estado){
        Estado objeto = repo.save(estado);
        return new ResponseEntity<>(objeto, HttpStatus.OK);
    }



    public ResponseEntity<Estado> eliminarEstado(int id) {
        if(repo.findById(id).isPresent()){
            repo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    public ResponseEntity<Estado> actualizarEstado(Integer id_estado, Estado estadoActualizado) {
        Optional<Estado> estadoExistente = repo.findById(id_estado);

        if (estadoExistente.isPresent()) {
            Estado estado = estadoExistente.get();
            estado.setNombre(estadoActualizado.getNombre());
            Estado objeto = repo.save(estado);
            return new ResponseEntity<>(objeto,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

}

