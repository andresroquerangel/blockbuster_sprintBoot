package com.example.modeladov1.service;
import java.util.ArrayList;
import java.util.List;

import java.util.Optional;
import java.util.NoSuchElementException;

import com.example.modeladov1.model.Categoria;
import com.example.modeladov1.model.Rol;
import com.example.modeladov1.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolService {
    @Autowired
    RolRepository repo;

    public List<Rol> getAll(){
        List<Rol> roles = new ArrayList<>();
        for(Rol rol : repo.findAll()){
            roles.add(rol);
        }
        return roles;
    }

    public Rol getOne(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public void add(Rol rol){
        repo.save(rol);
    }

    public void eliminarRol(int id) {
        repo.deleteById(id);
    }

    public Rol actualizarRol(Integer id_rol, Rol rolActualizado) {
        Optional<Rol> rolExistente = repo.findById(id_rol);

        if (rolExistente.isPresent()) {
            Rol rol = rolExistente.get();
            rol.setRol(rolActualizado.getRol());
            // Actualiza otros campos según sea necesario

            // Guarda el rol actualizado en la base de datos
            return repo.save(rol);
        } else {
            throw new NoSuchElementException("Rol no encontrado");
        }
    }

}

