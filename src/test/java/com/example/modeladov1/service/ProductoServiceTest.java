package com.example.modeladov1.service;

import com.example.modeladov1.model.Producto;
import com.example.modeladov1.model.Tienda;
import com.example.modeladov1.repository.ProductoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


class ProductoServiceTest {

    @Mock
    private ProductoRepository repo;

    @InjectMocks
    private ProductoService service;
    private Producto producto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        producto = new Producto();
        producto.setNombre("Producto prueba");
        producto.setDescripcion("Esto es una descripcion");
        producto.setCantidad(2);
        producto.setPrecio(2);
        Tienda t = new Tienda();
        t.setId_tienda(5);
        t.setNombre("ToyLand");
        t.setDescripcion("Juguetes y juegos");
        producto.setTienda(t);
    }

    @Test
    void getProducto() {
        when(repo.findAll()).thenReturn(Arrays.asList(producto));
        assertNotNull(service.getProductos());
    }

    @Test
    void newProducto() {
        when(repo.save(any(Producto.class))).thenReturn(producto);
        assertNotNull(service.saveProducto(producto));
    }

    @Test
    void getOne() {
        producto.setId_producto(1);
        Optional<Producto> optionalProducto = Optional.of(producto);
    }
}