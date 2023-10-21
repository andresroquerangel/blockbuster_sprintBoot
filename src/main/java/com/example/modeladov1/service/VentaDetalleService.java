package com.example.modeladov1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.example.modeladov1.model.Pedido;
import com.example.modeladov1.model.Venta;
import com.example.modeladov1.model.Producto;
import com.example.modeladov1.model.VentaDetalle;
import com.example.modeladov1.repository.VentaDetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaDetalleService {
    @Autowired
    VentaDetalleRepository repo;

    @Autowired
    VentaService ventaService; // Inyecta ventaService

    @Autowired
    ProductoService productoService;

    public List<VentaDetalle> getAll(){
        List<VentaDetalle> ventasdetalles = new ArrayList<>();
        for(VentaDetalle ventadetalle : repo.findAll()){
            ventasdetalles.add(ventadetalle);
        }
        return ventasdetalles;
    }

    public VentaDetalle getOne(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public void add(VentaDetalle ventaDetalle){
        Venta venta = ventaService.getOne(ventaDetalle.getVenta().getId_venta()); // Usa ventaService para llamar a getOne
        Producto producto = productoService.getProductoById(ventaDetalle.getProducto().getId_producto()); // Usa productoService para llamar a getOne
        ventaDetalle.setVenta(venta); // Establece la Venta en el VentaDetalle
        ventaDetalle.setProducto(producto); // Establece el Producto en el VentaDetalle
        repo.save(ventaDetalle);
    }

    public void eliminarVentaDetalle(int id) {
        repo.deleteById(id);
    }

    public VentaDetalle actualizarVentaDetalle(Integer id_venta_detalle, VentaDetalle ventaDetalleActualizada) {
        Optional<VentaDetalle> ventaDetalleExistente = repo.findById(id_venta_detalle);

        if (ventaDetalleExistente.isPresent()) {
            VentaDetalle ventaDetalle = ventaDetalleExistente.get();
            Venta venta = ventaService.getOne(ventaDetalleActualizada.getVenta().getId_venta()); // Usa ventaService para llamar a getOne
            Producto producto = productoService.getProductoById(ventaDetalleActualizada.getProducto().getId_producto()); // Usa productoService para llamar a getOne
            ventaDetalle.setVenta(venta); // Establece la Venta en el VentaDetalle
            ventaDetalle.setProducto(producto); // Establece el Producto en el VentaDetalle
            ventaDetalle.setPrecio(ventaDetalleActualizada.getPrecio());
            ventaDetalle.setSubtotal(ventaDetalleActualizada.getSubtotal());
            ventaDetalle.setCantidad(ventaDetalleActualizada.getCantidad());
            return repo.save(ventaDetalle);
        } else {
            throw new NoSuchElementException("Venta Detalle no encontrada");
        }
    }
}
