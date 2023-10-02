package com.example.modeladov1.controller;

import java.util.List;
import com.example.modeladov1.model.Estado;
import com.example.modeladov1.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estados")
public class EstadoController {
    @Autowired
    EstadoService ser;

    @PostMapping("/add")
    public void add(@RequestBody Estado body){
        ser.add(body);
    }

    @GetMapping("/getAll")
    public List<Estado> getAll(){
        return ser.getAll();
    }
}
