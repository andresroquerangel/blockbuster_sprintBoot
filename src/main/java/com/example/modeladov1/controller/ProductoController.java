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
    private final ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/all")
    public List<Producto> getProductos() {
        return productoService.getProductos();
    }

    @GetMapping("/getOne/{id}")
    public Producto getProductoById(@PathVariable int id) {
        return productoService.getProductoById(id);
    }

    @PostMapping("/add")
    public Producto saveProducto(@RequestBody Producto producto) {
        return productoService.saveProducto(producto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProducto(@PathVariable int id) {
        productoService.deleteProducto(id);
    }

}
