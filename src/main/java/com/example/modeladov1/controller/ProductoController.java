package com.example.modeladov1.controller;

import java.util.List;

import com.example.modeladov1.model.Pais;
import com.example.modeladov1.model.Producto;
import com.example.modeladov1.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/productos")
public class ProductoController {
    private final ProductoService ser;

    @Autowired
    public ProductoController(ProductoService productoService) {
        this.ser = productoService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Producto>> getProductos() {
        return ser.getProductos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable int id) {
        return ser.getProductoById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<Producto> saveProducto(@RequestBody Producto producto) {
        return ser.saveProducto(producto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(
            @RequestBody Producto body,
            @PathVariable Integer id) {
        return ser.actualizarProducto(id, body);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Producto> deleteProducto(@PathVariable int id) {
        return ser.deleteProducto(id);
    }

}
