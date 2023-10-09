package com.example.modeladov1.controller;

import java.util.List;

import com.example.modeladov1.model.Categoria;
import com.example.modeladov1.model.Resena;
import com.example.modeladov1.service.ResenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resenas")
public class ResenaController {
    @Autowired
    ResenaService ser;

    @PostMapping("/add")
    public void add(@RequestBody Resena body){
        ser.add(body);
    }

    @GetMapping("/getAll")
    public List<Resena> getAll(){
        return ser.getAll();
    }

    @GetMapping("/{id}")
    public Resena getOne(@PathVariable int id){
        return ser.getOne(id);
    }
}
