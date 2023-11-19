package com.example.modeladov1.service;

import com.example.modeladov1.model.Tienda;
import com.example.modeladov1.repository.TiendaRepository;
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


class TiendaServiceTest {

    @Mock
    private TiendaRepository repo;

    @InjectMocks
    private TiendaService tiendaService;

    private Tienda tienda;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        tienda = new Tienda();
        tienda.setDescripcion("Prueba de mi primera tienda");
        tienda.setNombre("Pruebas");
        tienda.setId_tienda(3);
    }

    @Test
    void getTiendas() {
        when(repo.findAll()).thenReturn(Arrays.asList(tienda));
        assertNotNull(tiendaService.getTiendas());
    }

    @Test
    void newTienda() {
        when(repo.save(any(Tienda.class))).thenReturn(tienda);
        assertNotNull(tiendaService.saveTienda(new Tienda()));
    }

    @Test
    void getOne() {
        tienda.setId_tienda(1);
        Optional<Tienda> optionalTienda = Optional.of(tienda);
    }
}