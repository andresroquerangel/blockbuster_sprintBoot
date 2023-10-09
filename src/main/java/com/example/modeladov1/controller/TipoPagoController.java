package com.example.modeladov1.controller;

import java.util.List;

import com.example.modeladov1.model.Categoria;
import com.example.modeladov1.model.TipoPago;
import com.example.modeladov1.service.TipoPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tipospagos")

public class TipoPagoController {
    @Autowired
    TipoPagoService ser;

    @PostMapping("/add")
    public void add(@RequestBody TipoPago body){
        ser.add(body);
    }

    @GetMapping("/getAll")
    public List<TipoPago> getAll(){
        return ser.getAll();
    }

    @GetMapping("/{id}")
    public TipoPago getOne(@PathVariable int id){
        return ser.getOne(id);
    }
}
