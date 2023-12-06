package com.example.modeladov1.service;

import com.example.modeladov1.model.Categoria;
import com.example.modeladov1.model.Producto;
import com.example.modeladov1.model.Tienda;
import com.example.modeladov1.repository.ProductoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
    void getProducto() {
        when(repo.findAll()).thenReturn(Collections.singletonList(new Producto()));


        List<Producto> productos = service.getProductos();
        ResponseEntity<Object> responseEntity = new ResponseEntity<>(productos, HttpStatus.OK);

        assertEquals(200, responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
    }

    @Test
    void newProducto() {
        /*when(repo.findById(1)).thenReturn(Optional.ofNullable(producto));

        service.saveProducto(producto);

        ResponseEntity<Object> responseEntity = new ResponseEntity<>("Producto guardada correctamente", HttpStatus.OK);

        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals("Producto guardada correctamente", responseEntity.getBody());*/
    }

    @Test
    void getOne() {
        /*producto.setId_producto(1);
        when(repo.findById(1)).thenReturn(Optional.of(producto));
        Producto producto = service.getProductoById(1);
        ResponseEntity<Object> responseEntity = new ResponseEntity<>(producto, HttpStatus.OK);
        assertEquals(200, responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());*/
    }

}