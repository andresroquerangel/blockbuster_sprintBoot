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
        tienda.setId_tienda(100);
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

    @Test
    void update() {
        when(repo.save(any(Tienda.class))).thenReturn(tienda);
        Tienda t = tiendaService.saveTienda(tienda);
        assertNotNull(t);
        when(repo.findById(any(Integer.class))).thenReturn(Optional.of(t));
        Tienda t2 = tiendaService.getTiendaById(t.getId_tienda());
        assertNotNull(t2);
        Tienda tienda2 = new Tienda();
        tienda2.setDescripcion("Prueba de mi primera tienda2");
        tienda2.setNombre("Pruebas2");
        when(repo.save(any(Tienda.class))).thenReturn(tienda2);
        Tienda updatedTienda = tiendaService.actualizarTienda(t.getId_tienda(), tienda2);
        assertNotNull(updatedTienda);
        Tienda t3 = tiendaService.getTiendaById(t.getId_tienda());
        assertEquals(tienda2.getNombre(), t3.getNombre());
        assertEquals(tienda2.getDescripcion(), t3.getDescripcion());
    }

}