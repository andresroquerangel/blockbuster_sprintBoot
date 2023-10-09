package com.example.modeladov1.controller;

import java.util.List;

import com.example.modeladov1.model.Categoria;
import com.example.modeladov1.model.Rol_Usuario;
import com.example.modeladov1.service.Rol_UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rol_usuarios")
public class Rol_UsuarioController {
    @Autowired
    Rol_UsuarioService ser;

    @PostMapping("/add")
    public void add(@RequestBody Rol_Usuario body){
        ser.add(body);
    }

    @GetMapping("/getAll")
    public List<Rol_Usuario> getAll(){
        return ser.getAll();
    }

    @GetMapping("/{id}")
    public Rol_Usuario getOne(@PathVariable int id){
        return ser.getOne(id);
    }
}
