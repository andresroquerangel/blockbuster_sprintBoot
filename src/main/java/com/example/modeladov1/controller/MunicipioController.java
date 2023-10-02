package com.example.modeladov1.controller;

import java.util.List;

import com.example.modeladov1.model.Municipio;
import com.example.modeladov1.service.MunicipioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/municipios")
public class MunicipioController {
    @Autowired
    MunicipioService ser;

    @PostMapping("/add")
    public void add(@RequestBody Municipio body){
        ser.add(body);
    }

    @GetMapping("/getAll")
    public List<Municipio> getAll(){
        return ser.getAll();
    }
}
