package com.example.modeladov1.service;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.example.modeladov1.model.Categoria;
import com.example.modeladov1.model.Rol;
import com.example.modeladov1.model.Usuario;
import com.example.modeladov1.model.Rol_Usuario;
import com.example.modeladov1.repository.Rol_UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Rol_UsuarioService {
    @Autowired
    Rol_UsuarioRepository repo;

    @Autowired
    RolService rolService; // Inyecta rolService

    @Autowired
    UsuarioService usuarioService; // Inyecta usuarioService

    public List<Rol_Usuario> getAll(){
        List<Rol_Usuario> rolesUsuarios = new ArrayList<>();
        for(Rol_Usuario rolUsuario : repo.findAll()){
            rolesUsuarios.add(rolUsuario);
        }
        return rolesUsuarios;
    }

    public Rol_Usuario getOne(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public void add(Rol_Usuario rolUsuario){
        repo.save(rolUsuario);
    }

    public void eliminarRolUsuario(int id) {
        repo.deleteById(id);
    }

    public Rol_Usuario actualizarRolUsuario(Integer id_rol_usuario, Rol_Usuario rolUsuarioActualizado) {
        Optional<Rol_Usuario> rolUsuarioExistente = repo.findById(id_rol_usuario);

        if (rolUsuarioExistente.isPresent()) {
            return repo.save(rolUsuarioActualizado);
        } else {
            throw new NoSuchElementException("Rol_Usuario no encontrado");
        }
    }

}
