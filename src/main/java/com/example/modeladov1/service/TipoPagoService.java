package com.example.modeladov1.service;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.example.modeladov1.model.Categoria;
import com.example.modeladov1.model.Tienda;
import com.example.modeladov1.model.TipoPago;
import com.example.modeladov1.repository.TipoPagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TipoPagoService {
    @Autowired
    TipoPagoRepository repo;

    public ResponseEntity<List<TipoPago>> getAll(){
        List<TipoPago> tiposPagos = new ArrayList<>();
        for(TipoPago tipoPago : repo.findAll()){
            tiposPagos.add(tipoPago);
        }
        return new ResponseEntity<>(tiposPagos, HttpStatus.OK);
    }

    public ResponseEntity<TipoPago> getOne(Integer id) {
        TipoPago objeto = repo.findById(id).orElse(null);
        if(objeto!=null){
            return new ResponseEntity<>(objeto, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    public ResponseEntity<TipoPago> add(TipoPago tipoPago){
        TipoPago objeto = repo.save(tipoPago);
        return new ResponseEntity<>(objeto, HttpStatus.OK);
    }

    public ResponseEntity<TipoPago> eliminarTipoPago(int id) {
        if(repo.findById(id).isPresent()){
            repo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    public ResponseEntity<TipoPago> actualizarTipoPago(Integer id_tipo_pago, TipoPago tipoPagoActualizada) {
        Optional<TipoPago> tipoPagoExistente = repo.findById(id_tipo_pago);

        if (tipoPagoExistente.isPresent()) {
            TipoPago tipoPago = tipoPagoExistente.get();
            tipoPago.setNombre(tipoPagoActualizada.getNombre());
            tipoPago.setDescripcion(tipoPagoActualizada.getDescripcion());
            // Actualiza otros campos según sea necesario

            // Guarda la categoría actualizada en la base de datos
            TipoPago objeto = repo.save(tipoPago);
            return new ResponseEntity<>(objeto,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
