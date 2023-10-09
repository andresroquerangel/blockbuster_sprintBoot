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

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    @JsonIgnoreProperties({"nombre","email","contraseña","direccion","telefono","token","ciudad"})
    private Usuario usuario;

    @JsonManagedReference
    @ManyToOne
    @JsonIgnoreProperties({"descripcion","nombre"})
    @JoinColumn(name = "id_tienda")
    private Tienda tienda;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "id_venta")
    @JsonIgnoreProperties({"usuario","tipopago"})
    private Venta venta;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    @JsonIgnore
    private List<NotificacionesPedido> notificaciones;

    // Getters y setters

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public Date getFecha_pedido() {
        return fecha_pedido;
    }

    public void setFecha_pedido(Date fecha_pedido) {
        this.fecha_pedido = fecha_pedido;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }
}