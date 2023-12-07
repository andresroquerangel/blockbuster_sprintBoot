package com.example.modeladov1.service;

import com.example.modeladov1.model.Tienda;
import com.example.modeladov1.model.TipoPago;
import com.example.modeladov1.repository.TipoPagoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class TipoPagoServiceTest {

    @Mock
    private TipoPagoRepository repo;

    @InjectMocks
    private TipoPagoService service;

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
    void getAll(){
        when(repo.findAll()).thenReturn(Collections.singletonList(new TipoPago()));
        ResponseEntity<List<TipoPago>> responseEntity = service.getAll();

        assertEquals(200, responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
    }

    @Test
    void newTienda(){
        when(repo.save(any(TipoPago.class))).thenReturn(tipoPago);
        ResponseEntity<TipoPago> response = service.add(tipoPago);

        assertNotNull(response.getBody());
        assertEquals(200,response.getStatusCodeValue());
    }

    @Test
    void updateTienda(){
        when(repo.findById(1)).thenReturn(Optional.of(tipoPago));
        when(repo.save(any(TipoPago.class))).thenReturn(tipoPago);
        ResponseEntity<TipoPago> response = service.actualizarTipoPago(1,tipoPago);

        assertNotNull(response);
        assertEquals(200,response.getStatusCodeValue());
    }

    @Test
    void deleteTienda(){
        when(repo.findById(1)).thenReturn(Optional.of(tipoPago));
        ResponseEntity<TipoPago> response = service.eliminarTipoPago(1);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
    }
}