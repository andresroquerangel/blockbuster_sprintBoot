package com.example.modeladov1.service;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.example.modeladov1.model.Resena;
import com.example.modeladov1.repository.ResenaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResenaService {
    @Autowired
    ResenaRepository repo;

    public List<Resena> getAll(){
        List<Resena> resenas = new ArrayList<>();
        for(Resena resena : repo.findAll()){
            resenas.add(resena);
        }
        return resenas;
    }

    public Resena getOne(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public void add(Resena resena){
        repo.save(resena);
    }

    public void eliminarResena(int id) {
        repo.deleteById(id);
    }

    public Resena actualizarResena(Integer id_resena, Resena resenaActualizada) {
        Optional<Resena> resenaExistente = repo.findById(id_resena);

        if (resenaExistente.isPresent()) {
            Resena resena = resenaExistente.get();
            resena.setResena(resenaActualizada.getResena());
            resena.setCalificacion(resenaActualizada.getCalificacion());
            // Actualiza otros campos según sea necesario

            // Guarda la reseña actualizada en la base de datos
            return repo.save(resena);
        } else {
            throw new NoSuchElementException("Reseña no encontrada");
        }
    }
}
