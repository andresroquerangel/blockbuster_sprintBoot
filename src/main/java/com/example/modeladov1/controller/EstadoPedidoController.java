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
    public ResponseEntity<EstadoPedido> add(@RequestBody EstadoPedido body){
        return ser.add(body);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<EstadoPedido>> getAll(){
        return ser.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadoPedido> getOne(@PathVariable int id){
        return ser.getOne(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EstadoPedido> eliminarEstadoPedido(@PathVariable int id) {
        return ser.eliminarEstadoPedido(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadoPedido> actualizarEstadoPedido(
            @RequestBody EstadoPedido body,
            @PathVariable Integer id) {
        return ser.actualizarEstadoPedido(id, body);
    }
}
