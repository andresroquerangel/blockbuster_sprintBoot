package com.example.modeladov1.model;

import javax.persistence.*;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Data
@Entity
@Table(name = "venta_detalle")
public class VentaDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_venta_detalle")
    private int id_venta_detalle;

    @Column(name="precio")
    private BigDecimal precio;
    @Column(name="subtotal")
    private BigDecimal subtotal;
    @Column(name = "cantidad")
    private int cantidad;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "id_venta")
    @JsonIgnoreProperties({"usuario","tipoPago"})
    private Venta venta;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "id_producto")
    @JsonIgnoreProperties({"nombre","descripcion","precio","cantidad","photo","tienda","tipoProducto","categoria"})
    private Producto producto;

    // Getters y setters

    public int getId_venta_detalle() {
        return id_venta_detalle;
    }

    public void setId_venta_detalle(int id_venta_detalle) {
        this.id_venta_detalle = id_venta_detalle;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
