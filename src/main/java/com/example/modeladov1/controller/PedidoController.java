package com.example.modeladov1.controller;

import java.util.List;
import com.example.modeladov1.model.Pedido;
import com.example.modeladov1.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    @Autowired
    PedidoService ser;

    @PostMapping("/add")
    public void add(@RequestBody Pedido body){
        ser.add(body);
    }

    @GetMapping("/getAll")
    public List<Pedido> getAll(){
        return ser.getAll();
    }

}
