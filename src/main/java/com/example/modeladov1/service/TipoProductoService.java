package com.example.modeladov1.service;

import java.util.List;

import com.example.modeladov1.model.TipoProducto;
import com.example.modeladov1.repository.TipoProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoProductoService {
    private final TipoProductoRepository tipoProductoRepository;

    @Autowired
    public TipoProductoService(TipoProductoRepository tipoProductoRepository) {
        this.tipoProductoRepository = tipoProductoRepository;
    }

    public List<TipoProducto> getTiposProducto() {
        return tipoProductoRepository.findAll();
    }

    public TipoProducto getTipoProductoById(int id) {
        return tipoProductoRepository.findById(id).orElse(null);
    }

    public TipoProducto saveTipoProducto(TipoProducto tipoProducto) {
        return tipoProductoRepository.save(tipoProducto);
    }

    public void deleteTipoProducto(int id) {
        tipoProductoRepository.deleteById(id);
    }
}
