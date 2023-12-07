package com.example.modeladov1.controller;

import java.util.List;
import com.example.modeladov1.model.Categoria;
import com.example.modeladov1.model.Pedido;
import com.example.modeladov1.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
@RestController
@RequestMapping("/admin/categorias")
public class CategoriaController {
    private final CategoriaService ser;

    @Autowired
    public CategoriaController(CategoriaService categoriaService) {
        this.ser = categoriaService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Categoria>> getCategorias() {
        return ser.getCategorias();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> getCategoriaById(@PathVariable int id) {
        return ser.getCategoriaById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<Categoria> saveCategoria(@RequestBody Categoria categoria) {
        return ser.saveCategoria(categoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> actualizarCategoria(
            @RequestBody Categoria body,
            @PathVariable Integer id) {
        return ser.actualizarCategoria(id, body);
    }

    @DeleteMapping("/{id}")
    public void deleteCategoria(@PathVariable int id) {
        ser.deleteCategoria(id);
    }
}

