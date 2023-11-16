package com.example.modeladov1.controller;

import java.util.List;

import com.example.modeladov1.model.Categoria;
import com.example.modeladov1.model.VentaDetalle;
import com.example.modeladov1.service.VentaDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/ventasdetalles")

public class VentaDetalleController {
    @Autowired
    VentaDetalleService ser;

    @PostMapping("/add")
    public void add(@RequestBody VentaDetalle body){
        ser.add(body);
    }

    @GetMapping("/getAll")
    public List<VentaDetalle> getAll(){
        return ser.getAll();
    }

    @GetMapping("/{id}")
    public VentaDetalle getOne(@PathVariable int id){
        return ser.getOne(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarVentaDetalle(@PathVariable int id) {
        ser.eliminarVentaDetalle(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VentaDetalle> actualizarVentaDetalle(
            @RequestBody VentaDetalle body,
            @PathVariable Integer id) {
        System.out.println(body);
        VentaDetalle ventaDetalle = ser.actualizarVentaDetalle(id, body);
        return ResponseEntity.ok(ventaDetalle);
    }
}
