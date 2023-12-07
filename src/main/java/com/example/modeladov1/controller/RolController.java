package com.example.modeladov1.controller;

import java.util.List;

import com.example.modeladov1.model.Categoria;
import com.example.modeladov1.model.Rol;
import com.example.modeladov1.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/roles")
public class RolController {
    @Autowired
    RolService ser;

    @PostMapping("/add")
    public ResponseEntity<Rol> add(@RequestBody Rol body){
        return ser.add(body);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Rol>> getAll(){
        return ser.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rol> getOne(@PathVariable int id){
        return ser.getOne(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Rol> eliminarRol(@PathVariable int id) {
        return ser.eliminarRol(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rol> actualizarRol(
            @RequestBody Rol body,
            @PathVariable Integer id) {
        return ser.actualizarRol(id, body);
    }

}
