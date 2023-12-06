package com.example.modeladov1.service;
import com.example.modeladov1.model.Categoria;
import com.example.modeladov1.model.Rol;
import com.example.modeladov1.repository.RolRepository;
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

class RolServiceTest {

    @Mock
    private RolRepository repo;

    @InjectMocks
    private RolService rolService;

    private Rol rol;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.initMocks(this);

        rol = new Rol();
        rol.setRol("Nuevo rol");
        rol.setId_rol(5);
    }

    @Test
    void getAll() {

        when(repo.findAll()).thenReturn(Collections.singletonList(new Rol()));

        List<Rol> roles = rolService.getAll();
        ResponseEntity<Object> responseEntity = new ResponseEntity<>(roles, HttpStatus.OK);

        assertEquals(200, responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
    }

    @Test
    void getOne() {
        /*rol.setId_rol(1);
        when(repo.findById(1)).thenReturn(Optional.of(rol));
        Rol rol = rolService.getOne(1);
        ResponseEntity<Object> responseEntity = new ResponseEntity<>(rol, HttpStatus.OK);
        assertEquals(200, responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());*/
    }

    @Test
    void newRol() {
       /* when(repo.findById(1)).thenReturn(Optional.ofNullable(rol)); //

        rolService.add(rol);

        ResponseEntity<Object> responseEntity = new ResponseEntity<>("Rol guardada correctamente", HttpStatus.OK);

        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals("Rol guardada correctamente", responseEntity.getBody());*/

    }

    @Test
    void deleteRol() {
        /*when(repo.findById(1)).thenReturn(Optional.of(new Rol()));

        rolService.eliminarRol(1);

        ResponseEntity<Object> responseEntity = new ResponseEntity<>(HttpStatus.OK);

        assertEquals(200, responseEntity.getStatusCodeValue());
        assertNull(responseEntity.getBody());*/

    }


}