package com.example.modeladov1.repository;

import com.example.modeladov1.model.Rol_Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Rol_UsuarioRepository extends CrudRepository<Rol_Usuario, Integer>{

}
