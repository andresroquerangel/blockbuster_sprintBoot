package com.example.modeladov1.controller;

import java.util.List;

import com.example.modeladov1.model.Categoria;
import com.example.modeladov1.model.Producto;
import com.example.modeladov1.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    ProductoService ser;

    @PostMapping("/add")
    public void add(@RequestBody Producto body){
        ser.add(body);
    }

    @GetMapping("/getAll")
    public List<Producto> getAll(){
        return ser.getAll();
    }

    @GetMapping("/{id}")
    public Producto getOne(@PathVariable int id){
        return ser.getOne(id);
    }
}
