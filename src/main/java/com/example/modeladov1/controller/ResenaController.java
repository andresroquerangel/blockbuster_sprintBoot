package com.example.modeladov1.controller;

import java.util.List;
import com.example.modeladov1.model.Resena;
import com.example.modeladov1.service.ResenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public/resenas")
public class ResenaController {

    @Autowired
    ResenaService ser;

    @PostMapping("/add")
    public ResponseEntity<Resena> add(@RequestBody Resena body){
        return ser.add(body);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Resena>> getAll(){
        return ser.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resena> getOne(@PathVariable int id){
        return ser.getOne(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Resena> eliminarResena(@PathVariable int id) {
        return ser.eliminarResena(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resena> actualizarResena(
            @RequestBody Resena body,
            @PathVariable Integer id) {
        System.out.println(body);
        return ser.actualizarResena(id, body);
    }
}
