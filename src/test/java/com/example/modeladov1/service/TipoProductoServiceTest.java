package com.example.modeladov1.service;

import com.example.modeladov1.model.TipoProducto;
import com.example.modeladov1.repository.TipoProductoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class TipoProductoServiceTest {

    @Mock
    private TipoProductoRepository repo;

    @InjectMocks
    private TipoProductoService tipoProductoService;

    private TipoProducto tipoProducto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        tipoProducto = new TipoProducto();
        tipoProducto.setNombre("Electronico 2");
        tipoProducto.setId_tipo(1);
    }

    @Test
    void getTiposProducto() {
        when(repo.findAll()).thenReturn(Arrays.asList(tipoProducto));
        assertNotNull(tipoProductoService.getTiposProducto());
    }
}