package com.example.modeladov1.service;


import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.example.modeladov1.model.Categoria;
import com.example.modeladov1.model.Pedido;
import com.example.modeladov1.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    private final CategoriaRepository repo;


    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.repo = categoriaRepository;
    }

    public List<Categoria> getCategorias() {
        return repo.findAll();
    }

    public Categoria getCategoriaById(int id) {
        return repo.findById(id).orElse(null);
    }

    public Categoria saveCategoria(Categoria categoria) {
        return repo.save(categoria);
    }

    public Categoria actualizarCategoria(Integer id_categoria, Categoria categoriaActualizada) {
        Optional<Categoria> categoriaExistente = repo.findById(id_categoria);
        if (categoriaExistente.isPresent()) {
            Categoria categoria = categoriaExistente.get();
            categoria.setNombre(categoriaActualizada.getNombre());
            return repo.save(categoria);
        } else {
            throw new NoSuchElementException("Categoria no encontrado");
        }
    }

    public void deleteCategoria(int id) {
        repo.deleteById(id);
    }
}