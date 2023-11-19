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

    @DeleteMapping("/{id}")
    public void eliminarNotificacionesPedido(@PathVariable int id) {
        ser.eliminarNotificacionesPedido(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NotificacionesPedido> actualizarNotificacionesPedido(
            @RequestBody NotificacionesPedido body,
            @PathVariable Integer id) {
        NotificacionesPedido notificacionesPedido = ser.actualizarNotificacionesPedido(id, body);
        return ResponseEntity.ok(notificacionesPedido);
    }
}
