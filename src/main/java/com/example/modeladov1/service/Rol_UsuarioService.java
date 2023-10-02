package com.example.modeladov1.service;
import java.util.ArrayList;
import java.util.List;
import com.example.modeladov1.model.Rol_Usuario;
import com.example.modeladov1.repository.Rol_UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Rol_UsuarioService {
    @Autowired
    Rol_UsuarioRepository repo;

    public List<Rol_Usuario> getAll(){
        List<Rol_Usuario> rolesUsuarios = new ArrayList<>();
        for(Rol_Usuario rolUsuario : repo.findAll()){
            rolesUsuarios.add(rolUsuario);
        }
        return rolesUsuarios;
    }

    public void add(Rol_Usuario rolUsuario){
        repo.save(rolUsuario);
    }
}
