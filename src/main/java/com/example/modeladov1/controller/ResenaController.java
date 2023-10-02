package com.example.modeladov1.controller;

import java.util.List;
import com.example.modeladov1.model.Resena;
import com.example.modeladov1.service.ResenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resenas")
public class ResenaController {
    @Autowired
    ResenaService ser;

    @PostMapping("/add")
    public void add(@RequestBody Resena body){
        ser.add(body);
    }

    @GetMapping("/getAll")
    public List<Resena> getAll(){
        return ser.getAll();
    }
}
