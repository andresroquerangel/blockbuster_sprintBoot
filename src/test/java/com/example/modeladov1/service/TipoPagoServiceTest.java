package com.example.modeladov1.service;

import com.example.modeladov1.model.TipoPago;
import com.example.modeladov1.repository.TipoPagoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class TipoPagoServiceTest {

    @Mock
    private TipoPagoRepository repo;

    @InjectMocks
    private TipoPagoService tipoPagoService;

    private TipoPago tipoPago;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.initMocks(this);

        tipoPago = new TipoPago();
        tipoPago.setNombre("Pago reciente");
        tipoPago.setDescripcion("Prueba de mi primer pago");
        tipoPago.setId_tipo_pago(2);
    }

    @Test
    void getAll() {
        when(repo.findAll()).thenReturn(Arrays.asList(tipoPago));
        assertNotNull(tipoPagoService.getAll());
    }
}