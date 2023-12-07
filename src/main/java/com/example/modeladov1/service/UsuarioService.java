package com.example.modeladov1.service;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.example.modeladov1.model.Categoria;
import com.example.modeladov1.model.Municipio;
import com.example.modeladov1.model.Usuario;
import com.example.modeladov1.model.Ciudad;
import com.example.modeladov1.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository repo;

    @Autowired
    CiudadService ciudadService; // Inyecta ciudadService

    public List<Usuario> getAll(){
        List<Usuario> usuarios = new ArrayList<>();
        for(Usuario usuario : repo.findAll()){
            usuarios.add(usuario);
        }
        return usuarios;
    }

    public Usuario getOne(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public Usuario add(Usuario usuario){
        return repo.save(usuario);
    }

    public void eliminarUsuario(int id) {
        repo.deleteById(id);
    }

    public Usuario actualizarUsuario(Integer id_usuario, Usuario usuarioActualizado) {Optional<Usuario> usuarioExistente = repo.findById(id_usuario);

        if (usuarioExistente.isPresent()) {
            Usuario usuario = usuarioExistente.get();
            usuario.setNombre(usuarioActualizado.getNombre());
            usuario.setEmail(usuarioActualizado.getEmail());
            usuario.setContraseña(usuarioActualizado.getContraseña());
            usuario.setDireccion(usuarioActualizado.getDireccion());
            usuario.setTelefono(usuarioActualizado.getTelefono());
            usuario.setToken(usuarioActualizado.getToken());

            // Guarda el usuario actualizado en la base de datos
            return repo.save(usuario);
        } else {
            throw new NoSuchElementException("Usuario no encontrado");
        }
    }

}
