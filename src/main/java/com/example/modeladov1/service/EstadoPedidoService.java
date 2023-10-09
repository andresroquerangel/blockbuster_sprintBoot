package com.example.modeladov1.service;
import java.util.ArrayList;
import java.util.List;

import com.example.modeladov1.model.Categoria;
import com.example.modeladov1.model.EstadoPedido;
import com.example.modeladov1.repository.EstadoPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadoPedidoService {
    @Autowired
    EstadoPedidoRepository repo;

    public List<EstadoPedido> getAll(){
        List<EstadoPedido> estadosPedidos = new ArrayList<>();
        for(EstadoPedido estadoPedido : repo.findAll()){
            estadosPedidos.add(estadoPedido);
        }
        return estadosPedidos;
    }

    public EstadoPedido getOne(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public void add(EstadoPedido estadoPedido){
        repo.save(estadoPedido);
    }
}

