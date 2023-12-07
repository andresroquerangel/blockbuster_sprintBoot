package com.example.modeladov1.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.example.modeladov1.model.Pais;
import com.example.modeladov1.model.Tienda;
import com.example.modeladov1.repository.TiendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TiendaService {
    private final TiendaRepository repo;

    @Autowired
    public TiendaService(TiendaRepository tiendaRepository) {
        this.repo = tiendaRepository;
    }

    public ResponseEntity<List<Tienda>> getTiendas() {
        List<Tienda> lista= repo.findAll();
        if (!lista.isEmpty()) {
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    public ResponseEntity<Tienda> getTiendaById(int id) {
        Tienda objeto = repo.findById(id).orElse(null);
        if(objeto!=null){
            return new ResponseEntity<>(objeto, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    public ResponseEntity<Tienda> saveTienda(Tienda tienda) {
        Tienda objeto = repo.save(tienda);
        return new ResponseEntity<>(objeto, HttpStatus.OK);
    }

    public ResponseEntity<Tienda> actualizarTienda(Integer id_tienda, Tienda tiendaActualizada) {
        Optional<Tienda> tiendaExistente = repo.findById(id_tienda);
        if (tiendaExistente.isPresent()) {
            Tienda tienda = tiendaExistente.get();
            tienda.setNombre(tiendaActualizada.getNombre());
            tienda.setDescripcion(tiendaActualizada.getDescripcion());
            Tienda objeto = repo.save(tienda);
            return new ResponseEntity<>(objeto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    public ResponseEntity<Tienda> deleteTienda(int id) {
        if(repo.findById(id).isPresent()){
            repo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
