package com.example.modeladov1.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

class PedidoServiceTest {

    private PedidoService pedidoService;
    private PedidoRepository pedidoRepository;
    private EstadoPedidoService estadoPedidoService;

    @BeforeEach
    void setUp() {
        pedidoRepository = mock(PedidoRepository.class);
        estadoPedidoService = mock(EstadoPedidoService.class);
        pedidoService = new PedidoService(pedidoRepository, estadoPedidoService);
    }

    @Test
    void actualizarEstadoPedido_CuandoPedidoNoExiste_DebeLanzarExcepcion() {
        // Configuración del escenario
        when(pedidoRepository.findById(anyInt())).thenReturn(Optional.empty());

        // Verificación de la excepción cuando el pedido no existe
        assertThrows(NoSuchElementException.class, () ->
                pedidoService.actualizarEstadoPedido(1, 1));
    }

    @Test
    void actualizarEstadoPedido_CuandoPedidoExiste_DebeActualizarEstado() {
        // Configuración del escenario
        Pedido pedidoExistente = new Pedido();
        EstadoPedido nuevoEstado = new EstadoPedido(); // Reemplazar con la clase real de EstadoPedido de tu aplicación
        when(pedidoRepository.findById(anyInt())).thenReturn(Optional.of(pedidoExistente));
        when(estadoPedidoService.getOne(anyInt())).thenReturn(nuevoEstado);

        // Ejecutar el método
        Pedido pedidoActualizado = pedidoService.actualizarEstadoPedido(1, 2);

        // Verificación de que se actualice el estado del pedido
        assertEquals(nuevoEstado, pedidoActualizado.getEstado());
        verify(pedidoRepository, times(1)).save(pedidoExistente);
    }
}
