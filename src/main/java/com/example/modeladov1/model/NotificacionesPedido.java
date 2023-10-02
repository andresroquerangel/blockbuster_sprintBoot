package com.example.modeladov1.model;

import javax.persistence.*;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "Notificaciones_Pedido")
public class NotificacionesPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_notificaciones_pedido")
    private Long id_notificaciones_pedido;

    @Column(name = "mensaje")
    private String mensaje;
    @Column(name = "fecha_hora_creacion")
    private Time fecha_hora_creacion;

    @ManyToOne
    @JoinColumn(name = "id_pedido")
    @Column(name = "pedido")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "id_estado_pedido")
    @Column(name = "estadoPedido")
    private EstadoPedido estadoPedido;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    @Column(name = "usuario")
    private Usuario usuario;

    // Getters y setters

    public Long getId_notificaciones_pedido() {
        return id_notificaciones_pedido;
    }

    public void setId_notificaciones_pedido(Long id_notificaciones_pedido) {
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