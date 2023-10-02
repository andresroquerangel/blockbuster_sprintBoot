package com.example.modeladov1.controller;

import java.util.List;
import com.example.modeladov1.model.Venta;
import com.example.modeladov1.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
