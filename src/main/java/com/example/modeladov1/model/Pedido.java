package com.example.modeladov1.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private int id_pedido;

    @Column(name="fecha_pedido")
    private Date fecha_pedido;

    @ManyToOne
    @JoinColumn(name="id_tienda", referencedColumnName = "id_tienda")
    private Tienda tienda; // Agrega la relación ManyToOne con Municipio


    @ManyToOne
    @JoinColumn(name="id_venta", referencedColumnName = "id_venta")
    private Venta venta; // Agrega la relación ManyToOne con Municipio


    @ManyToOne
    @JoinColumn(name="id_usuario", referencedColumnName = "id_usuario")
    private Usuario usuario; // Agrega la relación ManyToOne con Municipio


    // Getters y setters

}