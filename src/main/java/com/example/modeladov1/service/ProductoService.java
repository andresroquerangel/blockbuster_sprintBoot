package com.example.modeladov1.service;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.example.modeladov1.model.Producto;
import com.example.modeladov1.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
    @Autowired
    ProductoRepository repo;

    public List<Producto> getAll(){
        List<Producto> productos = new ArrayList<>();
        for(Producto producto : repo.findAll()){
            productos.add(producto);
        }
        return productos;
    }

    public Producto getOne(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public void add(Producto producto){
        repo.save(producto);
    }

    public void eliminarProducto(int id) {
        repo.deleteById(id);
    }

    public Producto actualizarProducto(Integer id_producto, Producto productoActualizado) {
        Optional<Producto> productoExistente = repo.findById(id_producto);

        if (productoExistente.isPresent()) {
            Producto producto = productoExistente.get();
            producto.setNombre(productoActualizado.getNombre());
            producto.setDescripcion(productoActualizado.getDescripcion());
            producto.setPrecio(productoActualizado.getPrecio());
            producto.setCantidad(productoActualizado.getCantidad());
            producto.setPhoto(productoActualizado.getPhoto());
            producto.setId_tienda(productoActualizado.getId_tienda());
            producto.setId_tipo(productoActualizado.getId_tipo());
            producto.setId_categoria(producto.getId_categoria());
            return repo.save(producto);
        } else {
            throw new NoSuchElementException("Producto no encontrado");
        }
    }
}
