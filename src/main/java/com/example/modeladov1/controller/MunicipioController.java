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
    public void add(@RequestBody Municipio body){
        ser.add(body);
    }

    @GetMapping("/getAll")
    public List<Municipio> getAll(){
        return ser.getAll();
    }

    @GetMapping("/{id}")
    public Municipio getOne(@PathVariable int id){
        return ser.getOne(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarMunicipio(@PathVariable int id) {
        ser.eliminarMunicipio(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Municipio> actualizarMunicipio(
            @RequestBody Municipio body,
            @PathVariable Integer id) {
        Municipio municipio = ser.actualizarMunicipio(id, body);
        return ResponseEntity.ok(municipio);
    }
}
