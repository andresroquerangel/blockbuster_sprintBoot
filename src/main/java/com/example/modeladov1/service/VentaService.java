package com.example.modeladov1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.example.modeladov1.model.Categoria;
import com.example.modeladov1.model.Venta;
import com.example.modeladov1.model.Usuario;
import com.example.modeladov1.model.TipoPago;
import com.example.modeladov1.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService {
    @Autowired
    VentaRepository repo;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    TipoPagoService tipoPagoService;

    public List<Venta> getAll(){
        List<Venta> ventas = new ArrayList<>();
        for(Venta venta : repo.findAll()){
            ventas.add(venta);
        }
        return ventas;
    }

    public Venta getOne(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public void add(Venta venta){
        Usuario usuario = usuarioService.getOne(venta.getUsuario().getId_usuario());
        TipoPago tipoPago = tipoPagoService.getOne(venta.getTipoPago().getId_tipo_pago());
        venta.setUsuario(usuario);
        venta.setTipoPago(tipoPago);
        repo.save(venta);
    }

    public void eliminarVenta(int id) {
        repo.deleteById(id);
    }

    public Venta actualizarVenta(Integer id_venta, Venta ventaActualizada) {
        Optional<Venta> ventaExistente = repo.findById(id_venta);

        if (ventaExistente.isPresent()) {
            Venta venta = ventaExistente.get();
            venta.setUsuario(usuarioService.getOne(ventaActualizada.getUsuario().getId_usuario()));
            venta.setTipoPago(tipoPagoService.getOne(ventaActualizada.getTipoPago().getId_tipo_pago()));
            return repo.save(venta);
        } else {
            throw new NoSuchElementException("Venta no encontrada");
        }
    }

}
