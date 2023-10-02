package com.example.modeladov1.controller;

import java.util.List;
import com.example.modeladov1.model.TipoProducto;
import com.example.modeladov1.service.TipoProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
