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

    @Column(name = "id_venta")
    private int id_venta;

    @Column(name = "id_producto")
    private int id_producto;


    // Getters y setters

}
