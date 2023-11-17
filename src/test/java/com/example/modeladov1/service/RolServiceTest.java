package com.example.modeladov1.service;

import com.example.modeladov1.model.Categoria;
import com.example.modeladov1.model.Rol;
import com.example.modeladov1.repository.RolRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

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

        when(repo.findAll()).thenReturn(Arrays.asList(rol));
        assertNotNull(rolService.getAll());
    }


}