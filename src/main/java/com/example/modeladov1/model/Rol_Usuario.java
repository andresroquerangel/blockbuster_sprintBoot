package com.example.modeladov1.model;

import javax.persistence.*;

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
@Table(name = "Rol_Usuario")
public class Rol_Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rol_usuario")
    private Long rol_usuario;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    @Column(name="usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_rol")
    @Column(name="rol")
    private Rol rol;

    // Getters y setters

    public Long getRol_usuario() {
        return rol_usuario;
    }

    public void setRol_usuario(Long rol_usuario) {
        this.rol_usuario = rol_usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}