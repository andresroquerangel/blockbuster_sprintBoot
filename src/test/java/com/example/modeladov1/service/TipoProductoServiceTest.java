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
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class TipoProductoServiceTest {

    @Mock
    private TipoProductoRepository repo;

    @InjectMocks
    private TipoProductoService service;

    private TipoProducto tipoProducto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        tipoProducto = new TipoProducto();
        tipoProducto.setNombre("Electronico 2");
        tipoProducto.setId_tipo(1);
    }

    @Test
    void getAll(){
        when(repo.findAll()).thenReturn(Collections.singletonList(new TipoProducto()));
        ResponseEntity<List<TipoProducto>> responseEntity = service.getTiposProducto();

        assertEquals(200, responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
    }

    @Test
    void newTipoProducto(){
        when(repo.save(any(TipoProducto.class))).thenReturn(tipoProducto);
        ResponseEntity<TipoProducto> response = service.saveTipoProducto(tipoProducto);

        assertNotNull(response.getBody());
        assertEquals(200,response.getStatusCodeValue());
    }

    @Test
    void updateTipoProducto(){
        when(repo.findById(1)).thenReturn(Optional.of(tipoProducto));
        when(repo.save(any(TipoProducto.class))).thenReturn(tipoProducto);
        ResponseEntity<TipoProducto> response = service.actualizarTipoProducto(1,tipoProducto);

        assertNotNull(response);
        assertEquals(200,response.getStatusCodeValue());
    }

    @Test
    void deleteTipoProducto(){
        when(repo.findById(1)).thenReturn(Optional.of(tipoProducto));
        ResponseEntity<TipoProducto> response = service.deleteTipoProducto(1);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
    }
}