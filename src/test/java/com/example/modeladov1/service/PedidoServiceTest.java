package com.example.modeladov1.service;

import com.example.modeladov1.model.EstadoPedido;
import com.example.modeladov1.model.Pedido;
import com.example.modeladov1.repository.PedidoRepository;
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
    Pedido pedido;

    @BeforeEach
    void setUp() {
        pedidoRepository = mock(PedidoRepository.class);
        estadoPedidoService = mock(EstadoPedidoService.class);
        pedidoService = new PedidoService();
    }
}
