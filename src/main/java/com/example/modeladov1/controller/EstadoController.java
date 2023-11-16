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
    public void add(@RequestBody Estado body){
        ser.add(body);
    }

    @GetMapping("/getAll")
    public List<Estado> getAll(){
        return ser.getAll();
    }

    @GetMapping("/{id}")
    public Estado getOne(@PathVariable int id){
        return ser.getOne(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarEstado(@PathVariable int id) {
        ser.eliminarEstado(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estado> actualizarEstado(
            @RequestBody Estado body,
            @PathVariable Integer id) {
        Estado estado = ser.actualizarEstado(id, body);
        return ResponseEntity.ok(estado);
    }
}
