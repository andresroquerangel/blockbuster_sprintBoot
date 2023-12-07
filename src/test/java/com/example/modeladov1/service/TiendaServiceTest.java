package com.example.modeladov1.service;

import com.example.modeladov1.model.Tienda;
import com.example.modeladov1.repository.TiendaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


class TiendaServiceTest {

    @Mock
    private TiendaRepository repo;

    @InjectMocks
    private TiendaService service;

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
    void getAll(){
        when(repo.findAll()).thenReturn(Collections.singletonList(new Tienda()));
        ResponseEntity<List<Tienda>> responseEntity = service.getTiendas();

        assertEquals(200, responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
    }

    @Test
    void newTienda(){
        when(repo.save(any(Tienda.class))).thenReturn(tienda);
        ResponseEntity<Tienda> response = service.saveTienda(tienda);
        assertNotNull(response.getBody());
        //Verificacion del mensaje de creado
        assertEquals(200,response.getStatusCodeValue());
    }

    @Test
    void updateTienda(){
        when(repo.findById(1)).thenReturn(Optional.of(tienda));
        when(repo.save(any(Tienda.class))).thenReturn(tienda);
        ResponseEntity<Tienda> response = service.actualizarTienda(1,tienda);
        assertNotNull(response);
        assertEquals(200,response.getStatusCodeValue());
    }

    @Test
    void deleteTienda(){
        when(repo.findById(1)).thenReturn(Optional.of(tienda));
        ResponseEntity<Tienda> response = service.deleteTienda(1);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
    }


}