package com.example.modeladov1.service;

import com.example.modeladov1.model.Categoria;
import com.example.modeladov1.repository.CategoriaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;



import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


class CategoriaServiceTest {

    @Mock
    private CategoriaRepository repo;

    @InjectMocks
    private CategoriaService categoriaService;

    private Categoria categoria;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        categoria = new Categoria();
        categoria.setNombre("Prueba");
        categoria.setId_categoria(1);
    }

    @Test
    void getCategorias() {
        when(repo.findAll()).thenReturn(Arrays.asList(categoria));
        assertNotNull(categoriaService.getCategorias());
    }

    @Test
    void newCategoria() {
        when(repo.save(any(Categoria.class))).thenReturn(categoria);
        assertNotNull(categoriaService.saveCategoria(new Categoria()));
    }

    /*@Test
    void updateCategoria() {
        Categoria existCategoria = new Categoria();
        existCategoria.setId_categoria(1);

        when(repo.findById(1)).thenReturn(Optional.of(existCategoria));

        Categoria updCategoria = new Categoria();
        updCategoria.setNombre("Nueva categoria");

        ResponseEntity<Object> responseEntity = categoriaService.actualizarCategoria(1,updCategoria);

        assertEquals(200, responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());

    }*/

    @Test
    void getOne() {
        categoria.setId_categoria(1);
        Optional<Categoria> optionalCategoria = Optional.of(categoria);
    }
}