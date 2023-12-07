package com.example.modeladov1.service;

import com.example.modeladov1.model.Tienda;
import com.example.modeladov1.model.TipoProducto;
import com.example.modeladov1.repository.VentaDetalleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.example.modeladov1.model.VentaDetalle;
import com.example.modeladov1.model.Venta;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class VentaDetalleServiceTest {
    @Mock
    private VentaDetalleRepository repo;

    @InjectMocks
    private VentaDetalleService service;

    private VentaDetalle ventaDetalle;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        ventaDetalle = new VentaDetalle();
        ventaDetalle.setVenta(new Venta());
        ventaDetalle.setCantidad(20);
        ventaDetalle.setId_venta_detalle(1);
    }

    @Test
    void getAll(){
        when(repo.findAll()).thenReturn(Collections.singletonList(new VentaDetalle()));
        ResponseEntity<List<VentaDetalle>> responseEntity = service.getAll();

        assertEquals(200, responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
    }

    @Test
    void newVentaDetalle(){
        when(repo.save(any(VentaDetalle.class))).thenReturn(ventaDetalle);
        ResponseEntity<VentaDetalle> response = service.add(ventaDetalle);

        assertNotNull(response.getBody());
        assertEquals(200,response.getStatusCodeValue());
    }

    @Test
    void updateVentaDetalle(){
        when(repo.findById(1)).thenReturn(Optional.of(ventaDetalle));
        when(repo.save(any(VentaDetalle.class))).thenReturn(ventaDetalle);
        ResponseEntity<VentaDetalle> response = service.actualizarVentaDetalle(1,ventaDetalle);

        assertNotNull(response);
        assertEquals(200,response.getStatusCodeValue());
    }

    @Test
    void deleteVentaDetalle(){
        when(repo.findById(1)).thenReturn(Optional.of(ventaDetalle));
        ResponseEntity<VentaDetalle> response = service.eliminarVentaDetalle(1);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
    }
}