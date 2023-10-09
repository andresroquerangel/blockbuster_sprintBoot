package com.example.modeladov1.service;
import java.util.ArrayList;
import java.util.List;

import com.example.modeladov1.model.Categoria;
import com.example.modeladov1.model.Usuario;
import com.example.modeladov1.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository repo;

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

    public void add(Usuario usuario){
        repo.save(usuario);
    }
}
