package com.example.modeladov1.controller;

import java.util.List;

import com.example.modeladov1.model.Categoria;
import com.example.modeladov1.model.TipoProducto;
import com.example.modeladov1.service.TipoProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/tiposproductos")

public class TipoProductoController {
    private final TipoProductoService ser;

    @Autowired
    public TipoProductoController(TipoProductoService tipoProductoService) {
        this.ser = tipoProductoService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<TipoProducto>> getTiposProducto() {
        return ser.getTiposProducto();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoProducto> getTipoProductoById(@PathVariable int id) {
        return ser.getTipoProductoById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<TipoProducto> saveTipoProducto(@RequestBody TipoProducto tipoProducto) {
        return ser.saveTipoProducto(tipoProducto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoProducto> actualizarTipoProducto(
            @RequestBody TipoProducto body,
            @PathVariable Integer id) {
        return ser.actualizarTipoProducto(id, body);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TipoProducto> deleteTipoProducto(@PathVariable int id) {
        return ser.deleteTipoProducto(id);
    }
}
