package com.example.modeladov1.controller;

import java.util.List;
import com.example.modeladov1.model.Categoria;
import com.example.modeladov1.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    private final CategoriaService categoriaService;

    @Autowired
    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping("/all")
    public List<Categoria> getCategorias() {
        return categoriaService.getCategorias();
    }

    @GetMapping("/getOne/{id}")
    public Categoria getCategoriaById(@PathVariable int id) {
        return categoriaService.getCategoriaById(id);
    }

    @PostMapping("/create")
    public Categoria saveCategoria(@RequestBody Categoria categoria) {
        return categoriaService.saveCategoria(categoria);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCategoria(@PathVariable int id) {
        categoriaService.deleteCategoria(id);
    }
}

