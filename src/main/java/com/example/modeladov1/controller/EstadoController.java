package com.example.modeladov1.controller;

import java.util.List;

import com.example.modeladov1.model.Categoria;
import com.example.modeladov1.model.Estado;
import com.example.modeladov1.service.EstadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/estados")
public class EstadoController {
    @Autowired
    EstadoService ser;

    @PostMapping("/add")
    public ResponseEntity<Estado> add(@RequestBody Estado body){
        return ser.add(body);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Estado>> getAll(){
        return ser.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estado> getOne(@PathVariable int id){
        return ser.getOne(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Estado> eliminarEstado(@PathVariable int id) {
        return ser.eliminarEstado(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estado> actualizarEstado(
            @RequestBody Estado body,
            @PathVariable Integer id) {
        return ser.actualizarEstado(id, body);
    }
}
