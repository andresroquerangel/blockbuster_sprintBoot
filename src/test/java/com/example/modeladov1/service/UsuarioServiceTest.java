package com.example.modeladov1.service;

import com.example.modeladov1.model.*;
import com.example.modeladov1.repository.CiudadRepository;
import com.example.modeladov1.repository.UsuarioRepository;
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

public class UsuarioServiceTest {
    @Mock
    private UsuarioRepository repo;

    @InjectMocks
    private UsuarioService service;

    private Usuario usuario;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        usuario = new Usuario();
        usuario.setNombre("Andres");
        usuario.setDireccion("Granada");
        usuario.setEmail("andres@gmail.com");
        usuario.setTelefono("123456789");
    }

    @Test
    void getAll(){
        when(repo.findAll()).thenReturn(Collections.singletonList(new Usuario()));
        ResponseEntity<List<Usuario>> responseEntity = service.getAll();

        assertEquals(200, responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
    }

    @Test
    void newUsuario(){
        when(repo.save(any(Usuario.class))).thenReturn(usuario);
        ResponseEntity<Usuario> response = service.add(usuario);

        assertNotNull(response.getBody());
        assertEquals(200,response.getStatusCodeValue());
    }

    @Test
    void updateUsuario(){
        when(repo.findById(1)).thenReturn(Optional.of(usuario));
        when(repo.save(any(Usuario.class))).thenReturn(usuario);
        ResponseEntity<Usuario> response = service.actualizarUsuario(1,usuario);

        assertNotNull(response);
        assertEquals(200,response.getStatusCodeValue());
    }

    @Test
    void deleteUsuario(){
        when(repo.findById(1)).thenReturn(Optional.of(usuario));
        ResponseEntity<Usuario> response = service.eliminarUsuario(1);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
    }
}
