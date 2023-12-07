package com.example.modeladov1.service;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.example.modeladov1.model.*;
import com.example.modeladov1.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository repo;

    @Autowired
    CiudadService ciudadService; // Inyecta ciudadService

    public ResponseEntity<List<Usuario>> getAll(){
        List<Usuario> usuarios = new ArrayList<>();
        for(Usuario usuario : repo.findAll()){
            usuarios.add(usuario);
        }
        return new ResponseEntity<>(usuarios,HttpStatus.OK);
    }

    public ResponseEntity<Usuario> getOne(Integer id) {
        Usuario objeto = repo.findById(id).orElse(null);
        if(objeto!=null){
            return new ResponseEntity<>(objeto, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    public ResponseEntity<Usuario> add(Usuario usuario){
        Usuario objeto = repo.save(usuario);
        return new ResponseEntity<>(objeto, HttpStatus.OK);
    }

    public ResponseEntity<Usuario> eliminarUsuario(int id) {
        if(repo.findById(id).isPresent()){
            repo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    public ResponseEntity<Usuario> actualizarUsuario(Integer id_usuario, Usuario usuarioActualizado) {Optional<Usuario> usuarioExistente = repo.findById(id_usuario);

        if (usuarioExistente.isPresent()) {
            Usuario usuario = usuarioExistente.get();
            usuario.setNombre(usuarioActualizado.getNombre());
            usuario.setEmail(usuarioActualizado.getEmail());
            usuario.setContraseña(usuarioActualizado.getContraseña());
            usuario.setDireccion(usuarioActualizado.getDireccion());
            usuario.setTelefono(usuarioActualizado.getTelefono());
            usuario.setToken(usuarioActualizado.getToken());

            // Guarda el usuario actualizado en la base de datos
            Usuario objeto = repo.save(usuario);
            return new ResponseEntity<>(objeto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

}
