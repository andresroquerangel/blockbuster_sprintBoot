package com.example.modeladov1.controller;

import java.util.List;

import com.example.modeladov1.model.Usuario;
import com.example.modeladov1.service.UsuarioService;
import org.springframework.http.ResponseEntity;
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

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable int id) {
        ser.eliminarUsuario(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(
            @RequestBody Usuario body,
            @PathVariable Integer id) {
        Usuario usuario = ser.actualizarUsuario(id, body);
        return ResponseEntity.ok(usuario);
    }

}
