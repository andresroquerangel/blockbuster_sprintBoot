package com.example.modeladov1.controller;

import java.util.List;
import com.example.modeladov1.model.TipoPago;
import com.example.modeladov1.service.TipoPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
