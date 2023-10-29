package com.example.modeladov1.repository;

import com.example.modeladov1.model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{
    Usuario findById(int id);

    Optional<Usuario> findOneByEmail(String email);
}