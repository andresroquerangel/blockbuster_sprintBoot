package com.example.modeladov1.controller;

import java.util.List;

import com.example.modeladov1.model.NotificacionesPedido;
import com.example.modeladov1.service.NotificacionesPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
