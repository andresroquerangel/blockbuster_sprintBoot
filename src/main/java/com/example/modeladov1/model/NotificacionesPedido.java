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

    @Column(name="id_pedido")
    private int id_pedido;

    @Column(name="id_estado_pedido")
    private int id_estado_pedido;

    @Column(name="id_usuario")
    private int id_usuario;

    // Getters y setters
}