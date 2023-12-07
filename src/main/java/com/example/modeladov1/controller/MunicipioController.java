package com.example.modeladov1.controller;

import java.util.List;

import com.example.modeladov1.model.Categoria;
import com.example.modeladov1.model.Municipio;
import com.example.modeladov1.service.MunicipioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/municipios")
public class MunicipioController {
    @Autowired
    MunicipioService ser;

    @PostMapping("/add")
    public ResponseEntity<Municipio> add(@RequestBody Municipio body){
        return ser.add(body);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Municipio>> getAll(){
        return ser.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Municipio> getOne(@PathVariable int id){
        return ser.getOne(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Municipio> eliminarMunicipio(@PathVariable int id) {
        return ser.eliminarMunicipio(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Municipio> actualizarMunicipio(
            @RequestBody Municipio body,
            @PathVariable Integer id) {
        return ser.actualizarMunicipio(id, body);
    }
}
