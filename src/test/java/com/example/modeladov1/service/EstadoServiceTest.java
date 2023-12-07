package com.example.modeladov1.service;

import com.example.modeladov1.model.Estado;
import com.example.modeladov1.model.Pais;
import com.example.modeladov1.repository.EstadoRepository;
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

public class EstadoServiceTest {
    @Mock
    private EstadoRepository repo;

    @InjectMocks
    private EstadoService service;

    private Estado estado;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        estado = new Estado();
        Pais pais = new Pais();
        pais.setNombre("Mi pais");
        estado.setNombre("Mi estado");
        estado.setPais(pais);
    }

    @Test
    void getAll(){
        when(repo.findAll()).thenReturn(Collections.singletonList(new Estado()));
        ResponseEntity<List<Estado>> responseEntity = service.getAll();

        assertEquals(200, responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
    }

    @Test
    void newTienda(){
        when(repo.save(any(Estado.class))).thenReturn(estado);
        ResponseEntity<Estado> response = service.add(estado);

        assertNotNull(response.getBody());
        assertEquals(200,response.getStatusCodeValue());
    }

    @Test
    void updateTienda(){
        when(repo.findById(1)).thenReturn(Optional.of(estado));
        when(repo.save(any(Estado.class))).thenReturn(estado);
        ResponseEntity<Estado> response = service.actualizarEstado(1,estado);


        assertNotNull(response);
        assertEquals(200,response.getStatusCodeValue());
    }

    @Test
    void deleteTienda(){
        when(repo.findById(1)).thenReturn(Optional.of(estado));
        ResponseEntity<Estado> response = service.eliminarEstado(1);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
    }
}
