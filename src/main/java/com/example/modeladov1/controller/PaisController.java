package com.example.modeladov1.controller;

import java.util.List;

import com.example.modeladov1.model.Categoria;
import com.example.modeladov1.model.Pais;
import com.example.modeladov1.service.PaisService;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paises")
public class PaisController {
    private final PaisService paisService;

    @Autowired
    public PaisController(PaisService paisService) {
        this.paisService = paisService;
    }

    @GetMapping("/all")
    public List<Pais> getPaises() {
        return paisService.getPaises();
    }

    @GetMapping("/getOne/{id}")
    public Pais getPaisById(@PathVariable int id) {
        return paisService.getPaisById(id);
    }

    @PostMapping("/add")
    public Pais savePais(@RequestBody Pais pais) {
        return paisService.savePais(pais);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePais(@PathVariable int id) {
        paisService.deletePais(id);
    }
}
