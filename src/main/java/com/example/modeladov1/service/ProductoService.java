package com.example.modeladov1.service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.example.modeladov1.model.Pais;
import com.example.modeladov1.model.Producto;
import com.example.modeladov1.model.Tienda;
import com.example.modeladov1.model.TipoProducto;
import com.example.modeladov1.model.Categoria;
import com.example.modeladov1.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
    private final ProductoRepository repo;

    @Autowired
    TiendaService tiendaService;

    @Autowired
    TipoProductoService tipoProductoService;

    @Autowired
    CategoriaService categoriaService;

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
        Tienda tienda = tiendaService.getTiendaById(producto.getTienda().getId_tienda());
        TipoProducto tipoProducto = tipoProductoService.getTipoProductoById(producto.getTipoProducto().getId_tipo());
        Categoria categoria = categoriaService.getCategoriaById(producto.getCategoria().getId_categoria());
        producto.setTienda(tienda);
        producto.setTipoProducto(tipoProducto);
        producto.setCategoria(categoria);
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
            return repo.save(producto);
        } else {
            throw new NoSuchElementException("Producto no encontrado");
        }
    }
    public void deleteProducto(int id) {
        repo.deleteById(id);
    }
}
