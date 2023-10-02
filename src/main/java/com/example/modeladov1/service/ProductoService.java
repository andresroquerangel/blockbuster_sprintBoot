package com.example.modeladov1.service;
import java.util.ArrayList;
import java.util.List;
import com.example.modeladov1.model.Producto;
import com.example.modeladov1.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
    @Autowired
    ProductoRepository repo;

    public List<Producto> getAll(){
        List<Producto> productos = new ArrayList<>();
        for(Producto producto : repo.findAll()){
            productos.add(producto);
        }
        return productos;
    }

    public void add(Producto producto){
        repo.save(producto);
    }
}

