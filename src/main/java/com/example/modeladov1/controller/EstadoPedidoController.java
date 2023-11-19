package com.example.modeladov1.controller;
import java.util.List;
import com.example.modeladov1.model.EstadoPedido;
import com.example.modeladov1.service.EstadoPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/estadospedidos")

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

    @DeleteMapping("/{id}")
    public void eliminarEstadoPedido(@PathVariable int id) {
        ser.eliminarEstadoPedido(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadoPedido> actualizarEstadoPedido(
            @RequestBody EstadoPedido body,
            @PathVariable Integer id) {
        EstadoPedido estadoPedido = ser.actualizarEstadoPedido(id, body);
        return ResponseEntity.ok(estadoPedido);
    }
}
