package com.example.modeladov1.controller;

import java.util.List;

import com.example.modeladov1.model.Categoria;
import com.example.modeladov1.model.Tienda;
import com.example.modeladov1.service.TiendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tiendas")
public class TiendaController {
    @Autowired
    TiendaService ser;

    @PostMapping("/add")
    public void add(@RequestBody Tienda body){
        ser.add(body);
    }

    @GetMapping("/getAll")
    public List<Tienda> getAll(){
        return ser.getAll();
    }

    @GetMapping("/{id}")
    public Tienda getOne(@PathVariable int id){
        return ser.getOne(id);
    }
}
