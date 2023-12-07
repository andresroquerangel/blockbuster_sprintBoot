package com.example.modeladov1.service;

import com.example.modeladov1.model.Categoria;
import com.example.modeladov1.model.Tienda;
import com.example.modeladov1.repository.CategoriaRepository;
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


class CategoriaServiceTest {

    @Mock
    private CategoriaRepository repo;

    @InjectMocks
    private CategoriaService service;

    private Categoria categoria;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        categoria = new Categoria();
        categoria.setNombre("Prueba");
        categoria.setId_categoria(1);
    }

    @Test
    void getAll(){
        when(repo.findAll()).thenReturn(Collections.singletonList(new Categoria()));
        ResponseEntity<List<Categoria>> responseEntity = service.getCategorias();

        assertEquals(200, responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
    }

    @Test
    void newCategoria(){
        when(repo.save(any(Categoria.class))).thenReturn(categoria);
        ResponseEntity<Categoria> response = service.saveCategoria(categoria);

        assertNotNull(response.getBody());
        assertEquals(200,response.getStatusCodeValue());
    }

    @Test
    void updateCategoria(){
        when(repo.findById(1)).thenReturn(Optional.of(categoria));
        when(repo.save(any(Categoria.class))).thenReturn(categoria);
        ResponseEntity<Categoria> response = service.actualizarCategoria(1,categoria);

        assertNotNull(response);
        assertEquals(200,response.getStatusCodeValue());
    }

    @Test
    void deleteCategoria(){
        when(repo.findById(1)).thenReturn(Optional.of(categoria));
        ResponseEntity<Categoria> response = service.deleteCategoria(1);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
    }
}