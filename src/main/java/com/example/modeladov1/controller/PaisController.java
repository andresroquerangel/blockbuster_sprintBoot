package com.example.modeladov1.controller;

import java.util.List;

import com.example.modeladov1.model.Categoria;
import com.example.modeladov1.model.Pais;
import com.example.modeladov1.service.PaisService;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/paises")
public class PaisController {
    private final PaisService ser;

    @Autowired
    public PaisController(PaisService paisService) {
        this.ser = paisService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Pais>> getPaises() {
        return ser.getPaises();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pais> getPaisById(@PathVariable int id) {
        return ser.getPaisById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<Pais> savePais(@RequestBody Pais pais) {
        return ser.savePais(pais);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pais> actualizarCategoria(
            @RequestBody Pais body,
            @PathVariable Integer id) {
        return ser.actualizarPais(id, body);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pais> deletePais(@PathVariable int id) {
        return ser.deletePais(id);
    }
}
