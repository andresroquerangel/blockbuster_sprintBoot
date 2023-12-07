package com.example.modeladov1.service;


import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.example.modeladov1.model.Categoria;
import com.example.modeladov1.model.Pedido;
import com.example.modeladov1.model.Tienda;
import com.example.modeladov1.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    private final CategoriaRepository repo;


    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.repo = categoriaRepository;
    }

    public ResponseEntity<List<Categoria>> getCategorias() {
        List<Categoria> lista= repo.findAll();
        if (!lista.isEmpty()) {
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    public ResponseEntity<Categoria> getCategoriaById(int id) {
        Categoria objeto = repo.findById(id).orElse(null);
        if(objeto!=null){
            return new ResponseEntity<>(objeto, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    public ResponseEntity<Categoria> saveCategoria(Categoria categoria) {
        Categoria objeto = repo.save(categoria);
        return new ResponseEntity<>(objeto, HttpStatus.OK);
    }

    public ResponseEntity<Categoria> actualizarCategoria(Integer id_categoria, Categoria categoriaActualizada) {
        Optional<Categoria> categoriaExistente = repo.findById(id_categoria);
        if (categoriaExistente.isPresent()) {
            Categoria categoria = categoriaExistente.get();
            categoria.setNombre(categoriaActualizada.getNombre());
            Categoria objeto = repo.save(categoria);
            return new ResponseEntity<>(objeto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    public ResponseEntity<Categoria> deleteCategoria(int id) {
        if(repo.findById(id).isPresent()){
            repo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}