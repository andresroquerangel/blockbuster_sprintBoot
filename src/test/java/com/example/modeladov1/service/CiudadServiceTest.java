package com.example.modeladov1.service;

import com.example.modeladov1.model.*;
import com.example.modeladov1.repository.CiudadRepository;
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

public class CiudadServiceTest {
    @Mock
    private CiudadRepository repo;

    @InjectMocks
    private CiudadService service;

    private Ciudad ciudad;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        Pais pais = new Pais();
        pais.setNombre("Mi pais");
        Estado est = new Estado();
        est.setNombre("Mi estado");
        est.setPais(pais);
        Municipio muni = new Municipio();
        muni.setNombre("Mi municipio");
        muni.setEstado(est);

        ciudad = new Ciudad();
        ciudad.setNombre("Mi ciudad");
        ciudad.setMunicipio(muni);
    }

    @Test
    void getAll(){
        when(repo.findAll()).thenReturn(Collections.singletonList(new Ciudad()));
        ResponseEntity<List<Ciudad>> responseEntity = service.getAll();

        assertEquals(200, responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
    }

    @Test
    void newTienda(){
        when(repo.save(any(Ciudad.class))).thenReturn(ciudad);
        ResponseEntity<Ciudad> response = service.add(ciudad);

        assertNotNull(response.getBody());
        assertEquals(200,response.getStatusCodeValue());
    }

    @Test
    void updateTienda(){
        when(repo.findById(1)).thenReturn(Optional.of(ciudad));
        when(repo.save(any(Ciudad.class))).thenReturn(ciudad);
        ResponseEntity<Ciudad> response = service.actualizarCiudad(1,ciudad);

        assertNotNull(response);
        assertEquals(200,response.getStatusCodeValue());
    }

    @Test
    void deleteTienda(){
        when(repo.findById(1)).thenReturn(Optional.of(ciudad));
        ResponseEntity<Ciudad> response = service.eliminarCiudad(1);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
    }
}
