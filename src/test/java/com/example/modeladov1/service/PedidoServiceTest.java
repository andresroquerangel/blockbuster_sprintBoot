package com.example.modeladov1.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;
import java.util.Optional;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import com.example.modeladov1.model.EstadoPedido;
import com.example.modeladov1.model.Pedido;
import com.example.modeladov1.repository.PedidoRepository;
import static org.junit.jupiter.api.Assertions.*;
import com.example.modeladov1.service.PedidoService;

class PedidoServiceTest {


    private PedidoRepository pedidoRepository;


    private EstadoPedidoService estadoPedidoService;


    private PedidoService pedidoService;

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
        Pedido pedidoExistente = new Pedido(); // Crear un pedido existente
        EstadoPedido nuevoEstado = new EstadoPedido(); // Crear un nuevo estado
        when(pedidoRepository.findById(anyInt())).thenReturn(Optional.of(pedidoExistente));
        when(estadoPedidoService.getOne(anyInt())).thenReturn(nuevoEstado);

        // Ejecutar el método
        Pedido pedidoActualizado = pedidoService.actualizarEstadoPedido(1, 2);

        // Verificación de que se actualice el estado del pedido
        assertEquals(nuevoEstado, pedidoActualizado.getEstado());
        verify(pedidoRepository, times(1)).save(pedidoExistente);
    }

}


