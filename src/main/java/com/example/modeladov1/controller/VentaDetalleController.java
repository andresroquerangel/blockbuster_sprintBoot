package com.example.modeladov1.controller;

import java.util.List;
import com.example.modeladov1.model.VentaDetalle;
import com.example.modeladov1.service.VentaDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ventasdetalles")

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
}
