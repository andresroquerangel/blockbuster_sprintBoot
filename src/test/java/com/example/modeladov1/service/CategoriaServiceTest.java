package com.example.modeladov1.service;

import com.example.modeladov1.model.Categoria;
import com.example.modeladov1.model.Tienda;
import com.example.modeladov1.repository.CategoriaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
        when(repo.findAll()).thenReturn(Collections.singletonList(new Categoria()));

        List<Categoria> categorias = categoriaService.getCategorias();
        ResponseEntity<Object> responseEntity = new ResponseEntity<>(categorias, HttpStatus.OK);

        assertEquals(200, responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
    }

    @Test
    void newCategoria() {
        when(repo.findById(1)).thenReturn(Optional.ofNullable(categoria)); //

        categoriaService.saveCategoria(categoria);

        ResponseEntity<Object> responseEntity = new ResponseEntity<>("Categoría guardada correctamente", HttpStatus.OK);

        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals("Categoría guardada correctamente", responseEntity.getBody());

    }

    @Test
    void update() {
        when(repo.save(any(Categoria.class))).thenReturn(categoria);
        Categoria t = categoriaService.saveCategoria(categoria);
        assertNotNull(t);
        when(repo.findById(any(Integer.class))).thenReturn(Optional.of(t));
        Categoria t2 = categoriaService.getCategoriaById(t.getId_categoria());
        assertNotNull(t2);
        Categoria categoria2 = new Categoria();
        categoria2.setNombre("Pruebas2");
        when(repo.save(any(Categoria.class))).thenReturn(categoria2);
        Categoria updatedCategoria = categoriaService.actualizarCategoria(t.getId_categoria(), categoria2);
        assertNotNull(updatedCategoria);
        Categoria t3 = categoriaService.getCategoriaById(t.getId_categoria());
        assertEquals(categoria2.getNombre(), t3.getNombre());
    }

    @Test
    void getOne() {
        categoria.setId_categoria(1);
        when(repo.findById(1)).thenReturn(Optional.of(categoria));
        Categoria categoria = categoriaService.getCategoriaById(1);
        ResponseEntity<Object> responseEntity = new ResponseEntity<>(categoria, HttpStatus.OK);
        assertEquals(200, responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
    }

    @Test
    void deleteCategoria() {
        when(repo.findById(1)).thenReturn(Optional.of(new Categoria()));

        categoriaService.deleteCategoria(1);

        ResponseEntity<Object> responseEntity = new ResponseEntity<>(HttpStatus.OK);

        assertEquals(200, responseEntity.getStatusCodeValue());
        assertNull(responseEntity.getBody());

    }
}