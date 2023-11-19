package com.example.modeladov1.service;

import com.example.modeladov1.model.Usuario;
import com.example.modeladov1.repository.UsuarioRepository;
import com.example.modeladov1.model.Ciudad;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


class UsuarioServiceTest {

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
        usuario.setEmail("andres.q@gmail.com");
        usuario.setContraseña("1234");
        usuario.setDireccion("Siempre viva 123");
        usuario.setTelefono("1234567890");
        Ciudad c = new Ciudad();
        c.setId_ciudad(1);
        c.setNombre("La Plata");
        usuario.setCiudad(c);
    }

    @Test
    void getUsuario() {
        when(repo.findAll()).thenReturn(Arrays.asList(usuario));
        assertNotNull(service.getAll());
    }

    @Test
    void newUsuario() {
        when(repo.save(any(Usuario.class))).thenReturn(usuario);
        assertNotNull(service.add(new Usuario()));
    }

    @Test
    void getOne() {
        usuario.setId_usuario(1);
        Optional<Usuario> optionalTienda = Optional.of(usuario);
    }

}