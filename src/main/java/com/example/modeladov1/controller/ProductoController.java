package com.example.modeladov1.controller;

import java.util.List;
import com.example.modeladov1.model.Producto;
import com.example.modeladov1.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    ProductoService ser;

    @PostMapping("/add")
    public void add(@RequestBody Producto body){
        ser.add(body);
    }

    @GetMapping("/getAll")
    public List<Producto> getAll(){
        return ser.getAll();
    }

    @GetMapping("/{id}")
    public Producto getOne(@PathVariable int id){
        return ser.getOne(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable int id) {
        ser.eliminarProducto(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(
            @RequestBody Producto body,
            @PathVariable Integer id) {
        System.out.println(body);
        Producto producto = ser.actualizarProducto(id, body);
        return ResponseEntity.ok(producto);
    }
}
