package com.example.modeladov1.controller;

import java.util.List;

import com.example.modeladov1.model.Categoria;
import com.example.modeladov1.model.Pais;
import com.example.modeladov1.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paises")
public class PaisController {
    @Autowired
    PaisService ser;

    @PostMapping("/add")
    public void add(@RequestBody Pais body){
        ser.add(body);
    }

    @GetMapping("/getAll")
    public List<Pais> getAll(){
        return ser.getAll();
    }

    @GetMapping("/{id}")
    public Pais getOne(@PathVariable int id){
        return ser.getOne(id);
    }
}
