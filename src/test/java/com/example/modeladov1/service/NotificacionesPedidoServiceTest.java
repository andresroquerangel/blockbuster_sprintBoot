package com.example.modeladov1.service;

import com.example.modeladov1.model.NotificacionesPedido;
import com.example.modeladov1.model.Pais;
import com.example.modeladov1.model.Pedido;
import com.example.modeladov1.repository.NotificacionesPedidoRepository;
import com.example.modeladov1.repository.PaisRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class NotificacionesPedidoServiceTest {
    @Mock
    private NotificacionesPedidoRepository repo;

    @InjectMocks
    private NotificacionesPedidoService service;

    private NotificacionesPedido noti;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        noti = new NotificacionesPedido();
        Pedido pedido = new Pedido();
        pedido.setFecha_pedido(new Date());
        noti.setMensaje("Mensaje");
    }

    @Test
    void getAll(){
        when(repo.findAll()).thenReturn(Collections.singletonList(new NotificacionesPedido()));
        ResponseEntity<List<NotificacionesPedido>> responseEntity = service.getAll();

        assertEquals(200, responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
    }

    @Test
    void newNotificaciones(){
        when(repo.save(any(NotificacionesPedido.class))).thenReturn(noti);
        ResponseEntity<NotificacionesPedido> response = service.add(noti);

        assertNotNull(response.getBody());
        assertEquals(200,response.getStatusCodeValue());
    }

    @Test
    void updatePais(){
        when(repo.findById(1)).thenReturn(Optional.of(noti));
        when(repo.save(any(NotificacionesPedido.class))).thenReturn(noti);
        ResponseEntity<NotificacionesPedido> response = service.actualizarNotificacionesPedido(1,noti);


        assertNotNull(response);
        assertEquals(200,response.getStatusCodeValue());
    }

    @Test
    void deletePais(){
        when(repo.findById(1)).thenReturn(Optional.of(noti));
        ResponseEntity<NotificacionesPedido> response = service.eliminarNotificacionesPedido(1);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
    }
}
