package com.example.modeladov1.controller;

import java.util.List;
import com.example.modeladov1.model.Usuario;
import com.example.modeladov1.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
