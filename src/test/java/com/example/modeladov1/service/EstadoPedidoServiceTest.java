package com.example.modeladov1.service;

import com.example.modeladov1.model.*;
import com.example.modeladov1.repository.CiudadRepository;
import com.example.modeladov1.repository.EstadoPedidoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class EstadoPedidoServiceTest {
    @Mock
    private EstadoPedidoRepository repo;

    @InjectMocks
    private EstadoPedidoService service;

    private EstadoPedido estadoPedido;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        estadoPedido = new EstadoPedido();
        estadoPedido.setNombre("Terminado");
    }

    @Test
    void getAll(){
        when(repo.findAll()).thenReturn(Collections.singletonList(new EstadoPedido()));
        ResponseEntity<List<EstadoPedido>> responseEntity = service.getAll();

        assertEquals(200, responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
    }

    @Test
    void newEstadoPedido(){
        when(repo.save(any(EstadoPedido.class))).thenReturn(estadoPedido);
        ResponseEntity<EstadoPedido> response = service.add(estadoPedido);

        assertNotNull(response.getBody());
        assertEquals(200,response.getStatusCodeValue());
    }

    @Test
    void updateEstadoPedido(){
        when(repo.findById(1)).thenReturn(Optional.of(estadoPedido));
        when(repo.save(any(EstadoPedido.class))).thenReturn(estadoPedido);
        ResponseEntity<EstadoPedido> response = service.actualizarEstadoPedido(1,estadoPedido);

        assertNotNull(response);
        assertEquals(200,response.getStatusCodeValue());
    }

    @Test
    void deleteEstadoPedido(){
        when(repo.findById(1)).thenReturn(Optional.of(estadoPedido));
        ResponseEntity<EstadoPedido> response = service.eliminarEstadoPedido(1);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
    }
}
