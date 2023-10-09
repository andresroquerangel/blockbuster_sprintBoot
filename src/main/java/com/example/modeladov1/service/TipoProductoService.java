package com.example.modeladov1.service;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.example.modeladov1.model.Categoria;
import com.example.modeladov1.model.TipoProducto;
import com.example.modeladov1.repository.TipoProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoProductoService {
    @Autowired
    TipoProductoRepository repo;

    public List<TipoProducto> getAll(){
        List<TipoProducto> tiposProductos = new ArrayList<>();
        for(TipoProducto tipoProducto : repo.findAll()){
            tiposProductos.add(tipoProducto);
        }
        return tiposProductos;
    }

    public TipoProducto getOne(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public void add(TipoProducto tipoProducto){
        repo.save(tipoProducto);
    }

    public void eliminarTipoProducto(int id) {
        repo.deleteById(id);
    }

    public TipoProducto actualizarTipoProducto(Integer id_tipo, TipoProducto tipoProductoActualizada) {
        Optional<TipoProducto> tipoProductoExistente = repo.findById(id_tipo);

        if (tipoProductoExistente.isPresent()) {
            TipoProducto tipoProducto = tipoProductoExistente.get();
            tipoProducto.setNombre(tipoProductoActualizada.getNombre());
            // Actualiza otros campos según sea necesario

            // Guarda la categoría actualizada en la base de datos
            return repo.save(tipoProducto);
        } else {
            throw new NoSuchElementException("Tipo Producto no encontrado");
        }
    }
}
