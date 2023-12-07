package com.example.modeladov1.service;

import com.example.modeladov1.model.Estado;
import com.example.modeladov1.model.Municipio;
import com.example.modeladov1.model.Pais;
import com.example.modeladov1.repository.MunicipioRepository;
import com.example.modeladov1.repository.PaisRepository;
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

public class PaisServiceTest {
    @Mock
    private PaisRepository repo;

    @InjectMocks
    private PaisService service;

    private Pais pais;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        pais = new Pais();
        pais.setNombre("Mi pais");
    }

    @Test
    void getAll(){
        when(repo.findAll()).thenReturn(Collections.singletonList(new Pais()));
        ResponseEntity<List<Pais>> responseEntity = service.getPaises();

        assertEquals(200, responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
    }

    @Test
    void newPais(){
        when(repo.save(any(Pais.class))).thenReturn(pais);
        ResponseEntity<Pais> response = service.savePais(pais);

        assertNotNull(response.getBody());
        assertEquals(200,response.getStatusCodeValue());
    }

    @Test
    void updatePais(){
        when(repo.findById(1)).thenReturn(Optional.of(pais));
        when(repo.save(any(Pais.class))).thenReturn(pais);
        ResponseEntity<Pais> response = service.actualizarPais(1,pais);


        assertNotNull(response);
        assertEquals(200,response.getStatusCodeValue());
    }

    @Test
    void deletePais(){
        when(repo.findById(1)).thenReturn(Optional.of(pais));
        ResponseEntity<Pais> response = service.deletePais(1);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
    }
}
