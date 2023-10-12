package com.example.modeladov1.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.example.modeladov1.model.Pais;
import com.example.modeladov1.model.TipoProducto;
import com.example.modeladov1.repository.TipoProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoProductoService {
    private final TipoProductoRepository repo;

    @Autowired
    public TipoProductoService(TipoProductoRepository tipoProductoRepository) {
        this.repo = tipoProductoRepository;
    }

    public List<TipoProducto> getTiposProducto() {
        return repo.findAll();
    }

    public TipoProducto getTipoProductoById(int id) {
        return repo.findById(id).orElse(null);
    }

    public TipoProducto saveTipoProducto(TipoProducto tipoProducto) {
        return repo.save(tipoProducto);
    }

    public TipoProducto actualizarTipoProducto(Integer id_pais, TipoProducto tipoProductoActualizada) {
        Optional<TipoProducto> tipoProductoExistente = repo.findById(id_pais);
        if (tipoProductoExistente.isPresent()) {
            TipoProducto tipoProducto = tipoProductoExistente.get();
            tipoProducto.setNombre(tipoProductoActualizada.getNombre());
            return repo.save(tipoProducto);
        } else {
            throw new NoSuchElementException("Tipo de producto no encontrado");
        }
    }

    public void deleteTipoProducto(int id) {
        repo.deleteById(id);
    }
}
