package com.example.modeladov1.controller;

import java.util.List;

import com.example.modeladov1.model.Tienda;
import com.example.modeladov1.service.TiendaService;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tiendas")
public class TiendaController {
    private final TiendaService tiendaService;

    @Autowired
    public TiendaController(TiendaService tiendaService) {
        this.tiendaService = tiendaService;
    }

    @GetMapping("/all")
    public List<Tienda> getTiendas() {
        return tiendaService.getTiendas();
    }

    @GetMapping("/getOne/{id}")
    public Tienda getTiendaById(@PathVariable int id) {
        return tiendaService.getTiendaById(id);
    }

    @PostMapping("/add")
    public Tienda saveTienda(@RequestBody Tienda tienda) {
        return tiendaService.saveTienda(tienda);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTienda(@PathVariable int id) {
        tiendaService.deleteTienda(id);
    }
}
