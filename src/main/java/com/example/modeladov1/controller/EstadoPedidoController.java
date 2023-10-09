package com.example.modeladov1.controller;
import java.util.List;

import com.example.modeladov1.model.Categoria;
import com.example.modeladov1.model.EstadoPedido;
import com.example.modeladov1.service.EstadoPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estadospedidos")

public class EstadoPedidoController {
    @Autowired
    EstadoPedidoService ser;

    @PostMapping("/add")
    public void add(@RequestBody EstadoPedido body){
        ser.add(body);
    }

    @GetMapping("/getAll")
    public List<EstadoPedido> getAll(){
        return ser.getAll();
    }

    @GetMapping("/{id}")
    public EstadoPedido getOne(@PathVariable int id){
        return ser.getOne(id);
    }
}
