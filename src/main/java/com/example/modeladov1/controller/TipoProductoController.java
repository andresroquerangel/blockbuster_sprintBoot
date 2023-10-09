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

    @Autowired
    TipoProductoService ser;

    @PostMapping("/add")
    public void add(@RequestBody TipoProducto body){
        ser.add(body);
    }

    @GetMapping("/getAll")
    public List<TipoProducto> getAll(){
        return ser.getAll();
    }

    @GetMapping("/{id}")
    public TipoProducto getOne(@PathVariable int id){
        return ser.getOne(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarTipoProducto(@PathVariable int id) {
        ser.eliminarTipoProducto(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoProducto> actualizarTipoProducto(
            @RequestBody TipoProducto body,
            @PathVariable Integer id) {
        System.out.println(body);
        TipoProducto tipoProducto = ser.actualizarTipoProducto(id, body);
        return ResponseEntity.ok(tipoProducto);
    }
}
