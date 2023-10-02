package com.example.modeladov1.controller;

import java.util.List;

import com.example.modeladov1.model.Pais;
import com.example.modeladov1.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paises")
public class PaisController {
    @Autowired
    PaisService ser;

    @PostMapping("/add")
    public void add(@RequestBody Pais body){
        ser.add(body);
    }

    @GetMapping("/getAll")
    public List<Pais> getAll(){
        return ser.getAll();
    }
}
