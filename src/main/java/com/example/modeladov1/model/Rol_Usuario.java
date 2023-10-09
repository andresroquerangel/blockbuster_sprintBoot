package com.example.modeladov1.model;

import javax.persistence.*;

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
@Table(name = "rol_usuario")
public class Rol_Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rol_usuario")
    private int rol_usuario;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    @JsonIgnoreProperties({"nombre","email","contraseña","direccion","telefono","token","ciudad"})
    private Usuario usuario;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "id_rol")
    @JsonIgnoreProperties({"rol"})
    private Rol rol;

    // Getters y setters

    public int getRol_usuario() {
        return rol_usuario;
    }

    public void setRol_usuario(int rol_usuario) {
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