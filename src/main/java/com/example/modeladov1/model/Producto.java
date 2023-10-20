package com.example.modeladov1.model;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Lob;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private int id_producto;

    @Column(name="nombre")
    private String nombre;
    @Column(name="descripcion")
    private String descripcion;
    @Column(name="precio")
    private double precio;
    @Column(name="cantidad")
    private int cantidad;

    @Lob
    @Column(name="photo")
    private byte[] photo;

    @ManyToOne
    @JoinColumn(name="id_tienda", referencedColumnName = "id_tienda")
    private Tienda tienda;

    @ManyToOne
    @JoinColumn(name="id_tipo", referencedColumnName = "id_tipo")
    private TipoProducto tipoProducto;

    @ManyToOne
    @JoinColumn(name="id_categoria", referencedColumnName = "id_categoria")
    private Categoria categoria;
}