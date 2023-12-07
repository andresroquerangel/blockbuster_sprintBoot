package com.example.modeladov1.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.example.modeladov1.model.Pais;
import com.example.modeladov1.model.Tienda;
import com.example.modeladov1.model.TipoProducto;
import com.example.modeladov1.repository.TipoProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TipoProductoService {
    private final TipoProductoRepository repo;

    @Autowired
    public TipoProductoService(TipoProductoRepository tipoProductoRepository) {
        this.repo = tipoProductoRepository;
    }

    public ResponseEntity<List<TipoProducto>> getTiposProducto() {
        List<TipoProducto> lista= repo.findAll();
        if (!lista.isEmpty()) {
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    public ResponseEntity<TipoProducto> getTipoProductoById(int id) {
        TipoProducto objeto = repo.findById(id).orElse(null);
        if(objeto!=null){
            return new ResponseEntity<>(objeto, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    public ResponseEntity<TipoProducto> saveTipoProducto(TipoProducto tipoProducto) {
        TipoProducto objeto = repo.save(tipoProducto);
        return new ResponseEntity<>(objeto, HttpStatus.OK);
    }

    public ResponseEntity<TipoProducto> actualizarTipoProducto(Integer id_pais, TipoProducto tipoProductoActualizada) {
        Optional<TipoProducto> tipoProductoExistente = repo.findById(id_pais);
        if (tipoProductoExistente.isPresent()) {
            TipoProducto tipoProducto = tipoProductoExistente.get();
            tipoProducto.setNombre(tipoProductoActualizada.getNombre());
            TipoProducto objeto = repo.save(tipoProducto);
            return new ResponseEntity<>(objeto,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    public ResponseEntity<TipoProducto> deleteTipoProducto(int id) {
        if(repo.findById(id).isPresent()){
            repo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
