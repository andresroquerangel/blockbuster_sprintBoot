package com.example.modeladov1.controller;

import java.util.List;

import com.example.modeladov1.model.Pais;
import com.example.modeladov1.model.Tienda;
import com.example.modeladov1.service.TiendaService;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/tiendas")
public class TiendaController {
    private final TiendaService ser;

    @Autowired
    public TiendaController(TiendaService tiendaService) {
        this.ser = tiendaService;
    }

    @GetMapping("/getAll")
    public List<Tienda> getTiendas() {
        return ser.getTiendas();
    }

    @GetMapping("/{id}")
    public Tienda getTiendaById(@PathVariable int id) {
        return ser.getTiendaById(id);
    }

    @PostMapping("/add")
    public Tienda saveTienda(@RequestBody Tienda tienda) {
        return ser.saveTienda(tienda);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tienda> tiendaCategoria(
            @RequestBody Tienda body,
            @PathVariable Integer id) {
        Tienda tienda = ser.actualizarTienda(id, body);
        return ResponseEntity.ok(tienda);
    }

    @DeleteMapping("/{id}")
    public void deleteTienda(@PathVariable int id) {
        ser.deleteTienda(id);
    }
}
