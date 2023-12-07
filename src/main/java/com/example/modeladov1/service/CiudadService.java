package com.example.modeladov1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.NoSuchElementException;

import com.example.modeladov1.model.Categoria;
import com.example.modeladov1.model.Ciudad;
import com.example.modeladov1.model.Municipio;
import com.example.modeladov1.model.TipoProducto;
import com.example.modeladov1.repository.CiudadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CiudadService {
    @Autowired
    CiudadRepository repo;

    @Autowired
    MunicipioService municipioService; // Inyecta municipioService



    public ResponseEntity<List<Ciudad>> getAll(){
        List<Ciudad> ciudades = new ArrayList<>();
        for(Ciudad ciudad : repo.findAll()){
            ciudades.add(ciudad);
        }
        return new ResponseEntity<>(ciudades, HttpStatus.OK);
    }

    public ResponseEntity<Ciudad> getOne(Integer id) {
        Ciudad objeto = repo.findById(id).orElse(null);
        if(objeto!=null){
            return new ResponseEntity<>(objeto, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    public ResponseEntity<Ciudad> add(Ciudad ciudad){
        Ciudad objeto = repo.save(ciudad);
        return new ResponseEntity<>(objeto, HttpStatus.OK);
    }

    public ResponseEntity<Ciudad> eliminarCiudad(int id) {
        if(repo.findById(id).isPresent()){
            repo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    public ResponseEntity<Ciudad> actualizarCiudad(Integer id_ciudad, Ciudad ciudadActualizada) {
        Optional<Ciudad> ciudadExistente = repo.findById(id_ciudad);

        if (ciudadExistente.isPresent()) {
            Ciudad ciudad = ciudadExistente.get();
            ciudad.setNombre(ciudadActualizada.getNombre());
            Ciudad objeto = repo.save(ciudad);
            return new ResponseEntity<>(objeto,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
