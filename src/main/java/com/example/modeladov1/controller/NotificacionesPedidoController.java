package com.example.modeladov1.controller;

import java.util.List;

import com.example.modeladov1.model.Categoria;
import com.example.modeladov1.model.NotificacionesPedido;
import com.example.modeladov1.service.NotificacionesPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notificacionespedido")
public class NotificacionesPedidoController {
    @Autowired
    NotificacionesPedidoService ser;

    @PostMapping("/add")
    public void add(@RequestBody NotificacionesPedido body){
        ser.add(body);
    }

    @GetMapping("/getAll")
    public List<NotificacionesPedido> getAll(){
        return ser.getAll();
    }

    @GetMapping("/{id}")
    public NotificacionesPedido getOne(@PathVariable int id){
        return ser.getOne(id);
    }
}
