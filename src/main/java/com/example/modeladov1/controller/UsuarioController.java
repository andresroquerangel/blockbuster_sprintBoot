package com.example.modeladov1.controller;

import java.util.List;

import com.example.modeladov1.model.Categoria;
import com.example.modeladov1.model.Usuario;
import com.example.modeladov1.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")

public class UsuarioController {
    @Autowired
    UsuarioService ser;

    @PostMapping("/add")
    public void add(@RequestBody Usuario body){
        ser.add(body);
    }

    @GetMapping("/getAll")
    public List<Usuario> getAll(){
        return ser.getAll();
    }

    @GetMapping("/{id}")
    public Usuario getOne(@PathVariable int id){
        return ser.getOne(id);
    }
}
