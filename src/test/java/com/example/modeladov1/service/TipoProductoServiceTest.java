package com.example.modeladov1.service;

import com.example.modeladov1.model.Categoria;
import com.example.modeladov1.model.Tienda;
import com.example.modeladov1.model.TipoProducto;
import com.example.modeladov1.repository.TipoProductoRepository;
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

    @Test
    void newTipoProducto() {
        when(repo.save(any(TipoProducto.class))).thenReturn(tipoProducto);
        assertNotNull(tipoProductoService.saveTipoProducto(new TipoProducto()));
    }

    @Test
    void update() {
        when(repo.save(any(TipoProducto.class))).thenReturn(tipoProducto);
        TipoProducto t = tipoProductoService.saveTipoProducto(tipoProducto);
        assertNotNull(t);
        when(repo.findById(any(Integer.class))).thenReturn(Optional.of(t));
        TipoProducto t2 = tipoProductoService.getTipoProductoById(t.getId_tipo());
        assertNotNull(t2);
        TipoProducto TipoProducto2 = new TipoProducto();
        TipoProducto2.setNombre("Pruebas2");
        when(repo.save(any(TipoProducto.class))).thenReturn(TipoProducto2);
        TipoProducto updatedTipoProducto = tipoProductoService.actualizarTipoProducto(t.getId_tipo(), TipoProducto2);
        assertNotNull(updatedTipoProducto);
        TipoProducto t3 = tipoProductoService.getTipoProductoById(t.getId_tipo());
        assertEquals(TipoProducto2.getNombre(), t3.getNombre());
    }

    @Test
    void getOne() {
        tipoProducto.setId_tipo(1);
        Optional<TipoProducto> optionalTipoProducto = Optional.of(tipoProducto);
    }
}