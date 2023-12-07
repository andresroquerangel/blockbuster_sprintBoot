package com.example.modeladov1.service;

import com.example.modeladov1.model.Estado;
import com.example.modeladov1.model.Municipio;
import com.example.modeladov1.model.Pais;
import com.example.modeladov1.repository.EstadoRepository;
import com.example.modeladov1.repository.MunicipioRepository;
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

public class MunicipioServiceTest {
    @Mock
    private MunicipioRepository repo;

    @InjectMocks
    private MunicipioService service;

    private Municipio municipio;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        Estado estado = new Estado();
        Pais pais = new Pais();
        pais.setNombre("Mi pais");
        estado.setNombre("Mi estado");
        estado.setPais(pais);
        municipio = new Municipio();
        municipio.setNombre("Mi municipio");
        municipio.setEstado(estado);
    }

    @Test
    void getAll(){
        when(repo.findAll()).thenReturn(Collections.singletonList(new Municipio()));
        ResponseEntity<List<Municipio>> responseEntity = service.getAll();

        assertEquals(200, responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
    }

    @Test
    void newMunicipio(){
        when(repo.save(any(Municipio.class))).thenReturn(municipio);
        ResponseEntity<Municipio> response = service.add(municipio);

        assertNotNull(response.getBody());
        assertEquals(200,response.getStatusCodeValue());
    }

    @Test
    void updateMunicipio(){
        when(repo.findById(1)).thenReturn(Optional.of(municipio));
        when(repo.save(any(Municipio.class))).thenReturn(municipio);
        ResponseEntity<Municipio> response = service.actualizarMunicipio(1,municipio);


        assertNotNull(response);
        assertEquals(200,response.getStatusCodeValue());
    }

    @Test
    void deleteMunicipio(){
        when(repo.findById(1)).thenReturn(Optional.of(municipio));
        ResponseEntity<Municipio> response = service.eliminarMunicipio(1);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
    }
}
