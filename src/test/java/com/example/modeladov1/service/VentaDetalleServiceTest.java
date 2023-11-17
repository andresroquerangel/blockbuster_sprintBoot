package com.example.modeladov1.service;

import com.example.modeladov1.model.TipoProducto;
import com.example.modeladov1.repository.VentaDetalleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.example.modeladov1.model.VentaDetalle;
import com.example.modeladov1.model.Venta;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class VentaDetalleServiceTest {
    @Mock
    private VentaDetalleRepository repo;

    @InjectMocks
    private VentaDetalleService ventaDetalleService;

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
    void getAll() {
        when(repo.findAll()).thenReturn(Arrays.asList(ventaDetalle));
        assertNotNull(ventaDetalleService.getAll());
    }

    @Test
    void getOne() {
        ventaDetalle.setId_venta_detalle(1);
        Optional<VentaDetalle> optionalVentaDetalle = Optional.of(ventaDetalle);
    }
}