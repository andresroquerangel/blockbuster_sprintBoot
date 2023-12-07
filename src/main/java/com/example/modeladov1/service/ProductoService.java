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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ProductoService {
    private static final Logger logger = LoggerFactory.getLogger(UsuarioService.class);
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

    public ResponseEntity<List<Producto>> getProductos() {
        try {
            List<Producto> lista = repo.findAll();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        }catch (javax.persistence.EntityNotFoundException e){
            logger.error("Error, fetch con id no existente",e.getCause());
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<Producto> getProductoById(int id) {
        Producto objeto = repo.findById(id).orElse(null);
        if(objeto!=null){
            return new ResponseEntity<>(objeto, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    public ResponseEntity<Producto> saveProducto(Producto producto) {
        Producto objeto = repo.save(producto);
        return new ResponseEntity<>(objeto, HttpStatus.OK);
    }

    public ResponseEntity<Producto> actualizarProducto(Integer id_pais, Producto productoActualizada) {
        Optional<Producto> productoExistente = repo.findById(id_pais);
        if (productoExistente.isPresent()) {
            Producto producto = productoExistente.get();
            producto.setNombre(productoActualizada.getNombre());
            producto.setDescripcion(productoActualizada.getDescripcion());
            producto.setPrecio(productoActualizada.getPrecio());
            producto.setCantidad(productoActualizada.getCantidad());
            producto.setPhoto(productoActualizada.getPhoto());
            Producto objeto = repo.save(producto);
            return new ResponseEntity<>(objeto,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    public ResponseEntity<Producto> deleteProducto(int id) {
        if(repo.findById(id).isPresent()){
            repo.deleteById(id);
            logger.info("Se borro el producto con la id: {}", id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
