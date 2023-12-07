package com.example.modeladov1.controller;

import java.util.List;
import com.example.modeladov1.model.NotificacionesPedido;
import com.example.modeladov1.service.NotificacionesPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public/notificaciones-pedido")
public class NotificacionesPedidoController {

    @Autowired
    NotificacionesPedidoService ser;

    @PostMapping("/add")
    public ResponseEntity<NotificacionesPedido> add(@RequestBody NotificacionesPedido body){
        return ser.add(body);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<NotificacionesPedido>> getAll(){
        return ser.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotificacionesPedido> getOne(@PathVariable int id){
        return ser.getOne(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<NotificacionesPedido> eliminarNotificacionesPedido(@PathVariable int id) {
        return ser.eliminarNotificacionesPedido(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NotificacionesPedido> actualizarNotificacionesPedido(
            @RequestBody NotificacionesPedido body,
            @PathVariable Integer id) {
        return ser.actualizarNotificacionesPedido(id, body);
    }
}
