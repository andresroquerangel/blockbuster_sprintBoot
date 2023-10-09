package com.example.modeladov1.service;
import java.util.ArrayList;
import java.util.List;

import com.example.modeladov1.model.Categoria;
import com.example.modeladov1.model.Pedido;
import com.example.modeladov1.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
    @Autowired
    PedidoRepository repo;

    public List<Pedido> getAll(){
        List<Pedido> pedidos = new ArrayList<>();
        for(Pedido pedido : repo.findAll()){
            pedidos.add(pedido);
        }
        return pedidos;
    }

    public Pedido getOne(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public void add(Pedido pedido){
        repo.save(pedido);
    }
}

