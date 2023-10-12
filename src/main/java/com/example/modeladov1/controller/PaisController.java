package com.example.modeladov1.controller;

import java.util.List;

import com.example.modeladov1.model.Categoria;
import com.example.modeladov1.model.Pais;
import com.example.modeladov1.service.PaisService;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paises")
public class PaisController {
    private final PaisService ser;

    @Autowired
    public PaisController(PaisService paisService) {
        this.ser = paisService;
    }

    @GetMapping("/getAll")
    public List<Pais> getPaises() {
        return ser.getPaises();
    }

    @GetMapping("/{id}")
    public Pais getPaisById(@PathVariable int id) {
        return ser.getPaisById(id);
    }

    @PostMapping("/add")
    public Pais savePais(@RequestBody Pais pais) {
        return ser.savePais(pais);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pais> actualizarCategoria(
            @RequestBody Pais body,
            @PathVariable Integer id) {
        Pais pais = ser.actualizarPais(id, body);
        return ResponseEntity.ok(pais);
    }

    @DeleteMapping("/{id}")
    public void deletePais(@PathVariable int id) {
        ser.deletePais(id);
    }
}
