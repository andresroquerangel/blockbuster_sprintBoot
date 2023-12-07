package com.example.modeladov1.service;

import com.example.modeladov1.model.*;
import com.example.modeladov1.repository.CiudadRepository;
import com.example.modeladov1.repository.ResenaRepository;
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

public class ResenaServiceTest {
    @Mock
    private ResenaRepository repo;

    @InjectMocks
    private ResenaService service;

    private Resena resena;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        resena = new Resena();
        resena.setResena("Esta es mi reseña");
        resena.setCalificacion(10);
    }

    @Test
    void getAll(){
        when(repo.findAll()).thenReturn(Collections.singletonList(new Resena()));
        ResponseEntity<List<Resena>> responseEntity = service.getAll();

        assertEquals(200, responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
    }

    @Test
    void newResena(){
        when(repo.save(any(Resena.class))).thenReturn(resena);
        ResponseEntity<Resena> response = service.add(resena);

        assertNotNull(response.getBody());
        assertEquals(200,response.getStatusCodeValue());
    }

    @Test
    void updateResena(){
        when(repo.findById(1)).thenReturn(Optional.of(resena));
        when(repo.save(any(Resena.class))).thenReturn(resena);
        ResponseEntity<Resena> response = service.actualizarResena(1,resena);

        assertNotNull(response);
        assertEquals(200,response.getStatusCodeValue());
    }

    @Test
    void deleteResena(){
        when(repo.findById(1)).thenReturn(Optional.of(resena));
        ResponseEntity<Resena> response = service.eliminarResena(1);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
    }
}
