package com.example.modeladov1.controller;

import java.util.List;

import com.example.modeladov1.model.Categoria;
import com.example.modeladov1.model.TipoPago;
import com.example.modeladov1.service.TipoPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/tipospagos")

public class TipoPagoController {
    @Autowired
    TipoPagoService ser;

    @PostMapping("/add")
    public void add(@RequestBody TipoPago body){
        ser.add(body);
    }

    @GetMapping("/getAll")
    public List<TipoPago> getAll(){
        return ser.getAll();
    }

    @GetMapping("/{id}")
    public TipoPago getOne(@PathVariable int id){
        return ser.getOne(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarTipoPago(@PathVariable int id) {
        ser.eliminarTipoPago(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoPago> actualizarTipoPago(
            @RequestBody TipoPago body,
            @PathVariable Integer id) {
        System.out.println(body);
        TipoPago tipoPago = ser.actualizarTipoPago(id, body);
        return ResponseEntity.ok(tipoPago);
    }
}
