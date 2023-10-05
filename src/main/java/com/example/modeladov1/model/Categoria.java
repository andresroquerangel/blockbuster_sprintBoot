package com.example.modeladov1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import java.util.List;

//Holaaa
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Data
@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private int id_categoria;

    @Column(name="nombre")
    private String nombre;

//    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, orphanRemoval = true)
 //   private List<Producto> productos;
//@OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY)
//private List<Producto> productos;
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private List<Producto> productos;


    // Getters y setters

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}