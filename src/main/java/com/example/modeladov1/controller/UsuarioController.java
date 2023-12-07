package com.example.modeladov1.controller;

import java.util.List;

import com.example.modeladov1.model.Usuario;
import com.example.modeladov1.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/usuarios")

public class UsuarioController {
    @Autowired
    UsuarioService ser;

    @PostMapping("/add")
    public ResponseEntity<Usuario> add(@RequestBody Usuario body){
        return ser.add(body);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Usuario>> getAll(){
        return ser.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getOne(@PathVariable int id){
        return ser.getOne(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> eliminarUsuario(@PathVariable int id) {
        return ser.eliminarUsuario(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(
            @RequestBody Usuario body,
            @PathVariable Integer id) {
        return ser.actualizarUsuario(id, body);
    }

}
