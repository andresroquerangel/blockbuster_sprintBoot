package com.example.modeladov1.service;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.example.modeladov1.model.Categoria;
import com.example.modeladov1.model.Pais;
import com.example.modeladov1.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaisService {
    @Autowired
    PaisRepository repo;

    public List<Pais> getAll(){
        List<Pais> paises = new ArrayList<>();
        for(Pais pais : repo.findAll()){
            paises.add(pais);
        }
        return paises;
    }

    public Pais getOne(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public void add(Pais pais){
        repo.save(pais);
    }

    public void eliminarPais(int id) {
        repo.deleteById(id);
    }

    public Pais actualizarPais(Integer id_pais, Pais paisActualizado) {
        Optional<Pais> paisExistente = repo.findById(id_pais);

        if (paisExistente.isPresent()) {
            Pais pais = paisExistente.get();
            pais.setNombre(paisActualizado.getNombre());
            // Actualiza otros campos según sea necesario

            // Guarda el país actualizado en la base de datos
            return repo.save(pais);
        } else {
            throw new NoSuchElementException("Pais no encontrado");
        }
    }
}

