package com.example.modeladov1.service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.example.modeladov1.model.Pais;
import com.example.modeladov1.model.Producto;
import com.example.modeladov1.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
    private final ProductoRepository repo;

    @Autowired
    public ProductoService(ProductoRepository productoRepository) {
        this.repo = productoRepository;
    }

    public List<Producto> getProductos() {
        return repo.findAll();
    }

    public Producto getProductoById(int id) {
        return repo.findById(id);
    }

    public Producto saveProducto(Producto producto) {
        return repo.save(producto);
    }

    public Producto actualizarProducto(Integer id_pais, Producto productoActualizada) {
        Optional<Producto> productoExistente = repo.findById(id_pais);
        if (productoExistente.isPresent()) {
            Producto producto = productoExistente.get();
            producto.setNombre(productoActualizada.getNombre());
            producto.setDescripcion(productoActualizada.getDescripcion());
            producto.setPrecio(productoActualizada.getPrecio());
            producto.setCantidad(productoActualizada.getCantidad());
            producto.setPhoto(productoActualizada.getPhoto());
            producto.setId_categoria(productoActualizada.getId_categoria());
            producto.setId_tipo(productoActualizada.getId_tipo());
            producto.setId_tienda(productoActualizada.getId_tienda());
            return repo.save(producto);
        } else {
            throw new NoSuchElementException("Producto no encontrado");
        }
    }
    public void deleteProducto(int id) {
        repo.deleteById(id);
    }
}
