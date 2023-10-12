package com.example.modeladov1.controller;

import java.util.List;

import com.example.modeladov1.model.Pais;
import com.example.modeladov1.model.Producto;
import com.example.modeladov1.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    private final ProductoService ser;

    @Autowired
    public ProductoController(ProductoService productoService) {
        this.ser = productoService;
    }

    @GetMapping("/getAll")
    public List<Producto> getProductos() {
        return ser.getProductos();
    }

    @GetMapping("/{id}")
    public Producto getProductoById(@PathVariable int id) {
        return ser.getProductoById(id);
    }

    @PostMapping("/add")
    public Producto saveProducto(@RequestBody Producto producto) {
        return ser.saveProducto(producto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(
            @RequestBody Producto body,
            @PathVariable Integer id) {
        Producto producto = ser.actualizarProducto(id, body);
        return ResponseEntity.ok(producto);
    }

    @DeleteMapping("/{id}")
    public void deleteProducto(@PathVariable int id) {
        ser.deleteProducto(id);
    }

}
