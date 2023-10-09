package com.example.modeladov1.service;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.example.modeladov1.model.Categoria;
import com.example.modeladov1.model.TipoPago;
import com.example.modeladov1.repository.TipoPagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoPagoService {
    @Autowired
    TipoPagoRepository repo;

    public List<TipoPago> getAll(){
        List<TipoPago> tiposPagos = new ArrayList<>();
        for(TipoPago tipoPago : repo.findAll()){
            tiposPagos.add(tipoPago);
        }
        return tiposPagos;
    }

    public TipoPago getOne(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public void add(TipoPago tipoPago){
        repo.save(tipoPago);
    }

    public void eliminarTipoPago(int id) {
        repo.deleteById(id);
    }

    public TipoPago actualizarTipoPago(Integer id_tipo_pago, TipoPago tipoPagoActualizada) {
        Optional<TipoPago> tipoPagoExistente = repo.findById(id_tipo_pago);

        if (tipoPagoExistente.isPresent()) {
            TipoPago tipoPago = tipoPagoExistente.get();
            tipoPago.setNombre(tipoPagoActualizada.getNombre());
            // Actualiza otros campos según sea necesario

            // Guarda la categoría actualizada en la base de datos
            return repo.save(tipoPago);
        } else {
            throw new NoSuchElementException("El tipo de pago no encontrado");
        }
    }
}
