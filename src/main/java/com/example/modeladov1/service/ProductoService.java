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
import com.example.modeladov1.security.JWTAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
    private final ProductoRepository repo;

    private static final Logger logger = LoggerFactory.getLogger(JWTAuthenticationFilter.class);

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
        try {
            return repo.findAll();
        }catch (javax.persistence.EntityNotFoundException e){
            logger.error("Error, fetch con id no existente",e.getCause());
        }
        return null;
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
