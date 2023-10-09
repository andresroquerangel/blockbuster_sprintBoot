package com.example.modeladov1.controller;

import java.util.List;

import com.example.modeladov1.model.Categoria;
import com.example.modeladov1.model.Ciudad;
import com.example.modeladov1.service.CiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ciudades")
public class CiudadController {
    @Autowired
    CiudadService ser;

    @PostMapping("/add")
    public void add(@RequestBody Ciudad body){
        ser.add(body);
    }

    @GetMapping("/getAll")
    public List<Ciudad> getAll(){
        return ser.getAll();
    }

    @GetMapping("/{id}")
    public Ciudad getOne(@PathVariable int id){
        return ser.getOne(id);
    }
}
