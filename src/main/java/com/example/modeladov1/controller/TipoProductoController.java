package com.example.modeladov1.controller;

import java.util.List;

import com.example.modeladov1.model.Categoria;
import com.example.modeladov1.model.TipoProducto;
import com.example.modeladov1.service.TipoProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tiposproductos")

public class TipoProductoController {
    private final TipoProductoService tipoProductoService;

    @Autowired
    public TipoProductoController(TipoProductoService tipoProductoService) {
        this.tipoProductoService = tipoProductoService;
    }

    @GetMapping("/all")
    public List<TipoProducto> getTiposProducto() {
        return tipoProductoService.getTiposProducto();
    }

    @GetMapping("/getOne/{id}")
    public TipoProducto getTipoProductoById(@PathVariable int id) {
        return tipoProductoService.getTipoProductoById(id);
    }

    @PostMapping("/add")
    public TipoProducto saveTipoProducto(@RequestBody TipoProducto tipoProducto) {
        return tipoProductoService.saveTipoProducto(tipoProducto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTipoProducto(@PathVariable int id) {
        tipoProductoService.deleteTipoProducto(id);
    }
}
