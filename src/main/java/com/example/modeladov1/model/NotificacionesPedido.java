package com.example.modeladov1.model;

import javax.persistence.*;
import java.sql.Time;

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
@Table(name = "notificaciones_pedido")
public class NotificacionesPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_notificaciones_pedido")
    private int id_notificaciones_pedido;

    @Column(name = "mensaje")
    private String mensaje;
    @Column(name = "fecha_hora_creacion")
    private Time fecha_hora_creacion;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "id_pedido")
    @JsonIgnoreProperties({"fecha_pedido","usuario","tienda","venta"})
    private Pedido pedido;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "id_estado_pedido")
    @JsonIgnoreProperties({"nombre"})
    private EstadoPedido estadoPedido;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    @JsonIgnoreProperties({"nombre","email","contraseña","direccion","telefono","token","ciudad"})
    private Usuario usuario;

    // Getters y setters

    public int getId_notificaciones_pedido() {
        return id_notificaciones_pedido;
    }

    public void setId_notificaciones_pedido(int id_notificaciones_pedido) {
        this.id_notificaciones_pedido = id_notificaciones_pedido;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Time getFecha_hora_creacion() {
        return fecha_hora_creacion;
    }

    public void setFecha_hora_creacion(Time fecha_hora_creacion) {
        this.fecha_hora_creacion = fecha_hora_creacion;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public EstadoPedido getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(EstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}