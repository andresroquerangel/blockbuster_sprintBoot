package com.example.modeladov1.controller;

import java.util.List;
import com.example.modeladov1.model.Categoria;
import com.example.modeladov1.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    CategoriaService ser;

    @PostMapping("/add")
    public void add(@RequestBody Categoria body){
        ser.add(body);
    }

    @GetMapping("/getAll")
    public List<Categoria> getAll(){
        return ser.getAll();
    }

    @GetMapping("/{id}")
    public Categoria getOne(@PathVariable int id){
        return ser.getOne(id);
    }
    @DeleteMapping("/{id}")
    public void eliminarCategoria(@PathVariable int id) {
        ser.eliminarCategoria(id);
    }
}

