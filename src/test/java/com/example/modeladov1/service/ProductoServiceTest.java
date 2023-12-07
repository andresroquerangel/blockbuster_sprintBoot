package com.example.modeladov1.service;

import com.example.modeladov1.model.Producto;
import com.example.modeladov1.model.Tienda;
import com.example.modeladov1.repository.ProductoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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
    void getAll(){
        when(repo.findAll()).thenReturn(Collections.singletonList(new Producto()));
        ResponseEntity<List<Producto>> responseEntity = service.getProductos();

        assertEquals(200, responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
    }

    @Test
    void newProducto(){
        when(repo.save(any(Producto.class))).thenReturn(producto);
        ResponseEntity<Producto> response = service.saveProducto(producto);

        assertNotNull(response.getBody());
        assertEquals(200,response.getStatusCodeValue());
    }

    @Test
    void updateProducto(){
        when(repo.findById(1)).thenReturn(Optional.of(producto));
        when(repo.save(any(Producto.class))).thenReturn(producto);
        ResponseEntity<Producto> response = service.actualizarProducto(1,producto);

        assertNotNull(response);
        assertEquals(200,response.getStatusCodeValue());
    }

    @Test
    void deleteProducto(){
        when(repo.findById(1)).thenReturn(Optional.of(producto));
        ResponseEntity<Producto> response = service.deleteProducto(1);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
    }
}