package com.example.modeladov1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.example.modeladov1.model.Categoria;
import com.example.modeladov1.model.Estado;
import com.example.modeladov1.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadoService {
    @Autowired
    EstadoRepository repo;

    public List<Estado> getAll(){
        List<Estado> estados = new ArrayList<>();
        for(Estado estado : repo.findAll()){
            estados.add(estado);
        }
        return estados;
    }

    public Estado getOne(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public void add(Estado estado){
        repo.save(estado);
    }

    public void eliminarEstado(int id) {
        repo.deleteById(id);
    }

    public Estado actualizarEstado(Integer id_estado, Estado estadoActualizado) {
        Optional<Estado> estadoExistente = repo.findById(id_estado);

        if (estadoExistente.isPresent()) {
            Estado estado = estadoExistente.get();
            estado.setNombre(estadoActualizado.getNombre());
            // Actualiza otros campos según sea necesario

            // Guarda el estado actualizado en la base de datos
            return repo.save(estado);
        } else {
            throw new NoSuchElementException("Estado no encontrado");
        }
    }
}

