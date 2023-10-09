package com.example.modeladov1.controller;

import java.util.List;

import com.example.modeladov1.model.Categoria;
import com.example.modeladov1.model.Venta;
import com.example.modeladov1.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ventas")

public class VentaController {
    @Autowired
    VentaService ser;

    @PostMapping("/add")
    public void add(@RequestBody Venta body){
        ser.add(body);
    }

    @GetMapping("/getAll")
    public List<Venta> getAll(){
        return ser.getAll();
    }

    @GetMapping("/{id}")
    public Venta getOne(@PathVariable int id){
        return ser.getOne(id);
    }
}
