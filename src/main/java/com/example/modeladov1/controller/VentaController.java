package com.example.modeladov1.controller;

import java.util.List;

import com.example.modeladov1.model.Rol;
import com.example.modeladov1.model.Venta;
import com.example.modeladov1.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/admin/ventas")

public class VentaController {
    @Autowired
    VentaService ser;

    @GetMapping("/getAll")
    public List<Venta> getAll(){
        return ser.getAll();
    }

    @GetMapping("/{id}")
    public Venta getOne(@PathVariable int id){
        return ser.getOne(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarVenta(@PathVariable int id) {
        ser.eliminarVenta(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody Venta body){
        ser.add(body);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Venta> actualizarVenta(
            @RequestBody Venta body,
            @PathVariable Integer id) {
        System.out.println(body);
        Venta venta = ser.actualizarVenta(id, body);
        return ResponseEntity.ok(venta);
    }
}
