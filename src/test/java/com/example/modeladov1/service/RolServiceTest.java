package com.example.modeladov1.service;

import com.example.modeladov1.model.Categoria;
import com.example.modeladov1.model.Rol;
import com.example.modeladov1.model.Tienda;
import com.example.modeladov1.repository.RolRepository;
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

class RolServiceTest {

    @Mock
    private RolRepository repo;

    @InjectMocks
    private RolService service;

    private Rol rol;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.initMocks(this);

        rol = new Rol();
        rol.setRol("Nuevo rol");
        rol.setId_rol(5);
    }

    @Test
    void getAll(){
        when(repo.findAll()).thenReturn(Collections.singletonList(new Rol()));
        ResponseEntity<List<Rol>> responseEntity = service.getAll();

        assertEquals(200, responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
    }

    @Test
    void newRol(){
        when(repo.save(any(Rol.class))).thenReturn(rol);
        ResponseEntity<Rol> response = service.add(rol);

        assertNotNull(response.getBody());
        assertEquals(200,response.getStatusCodeValue());
    }

    @Test
    void updateRol(){
        when(repo.findById(1)).thenReturn(Optional.of(rol));
        when(repo.save(any(Rol.class))).thenReturn(rol);
        ResponseEntity<Rol> response = service.actualizarRol(1,rol);

        assertNotNull(response);
        assertEquals(200,response.getStatusCodeValue());
    }

    @Test
    void deleteRol(){
        when(repo.findById(1)).thenReturn(Optional.of(rol));
        ResponseEntity<Rol> response = service.eliminarRol(1);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
    }


}