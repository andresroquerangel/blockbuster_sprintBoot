package com.example.modeladov1.service;
import java.util.ArrayList;
import java.util.List;
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

    public void add(Rol rol){
        repo.save(rol);
    }
}

