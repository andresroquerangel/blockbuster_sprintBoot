package com.example.modeladov1.service;
import java.util.ArrayList;
import java.util.List;

import java.util.Optional;
import java.util.NoSuchElementException;

import com.example.modeladov1.model.Categoria;
import com.example.modeladov1.model.Rol;
import com.example.modeladov1.model.VentaDetalle;
import com.example.modeladov1.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RolService {
    @Autowired
    RolRepository repo;

    public ResponseEntity<List<Rol>> getAll(){
        List<Rol> roles = new ArrayList<>();
        for(Rol rol : repo.findAll()){
            roles.add(rol);
        }
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    public ResponseEntity<Rol> getOne(Integer id) {
        Rol objeto = repo.findById(id).orElse(null);
        if(objeto!=null){
            return new ResponseEntity<>(objeto, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    public ResponseEntity<Rol> add(Rol rol){
        Rol objeto = repo.save(rol);
        return new ResponseEntity<>(objeto, HttpStatus.OK);
    }

    public ResponseEntity<Rol> eliminarRol(int id) {
        if(repo.findById(id).isPresent()){
            repo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    public ResponseEntity<Rol> actualizarRol(Integer id_rol, Rol rolActualizado) {
        Optional<Rol> rolExistente = repo.findById(id_rol);

        if (rolExistente.isPresent()) {
            Rol rol = rolExistente.get();
            rol.setRol(rolActualizado.getRol());
            // Actualiza otros campos según sea necesario

            // Guarda el rol actualizado en la base de datos
            Rol objeto = repo.save(rol);
            return new ResponseEntity<>(objeto,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

}

