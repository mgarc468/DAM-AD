package com.example.LibreriaAPI.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table (name = "editoriales")
public class Editorial implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nombre;

    @Column
    private String direccion;

    @OneToMany(mappedBy = "editorial")
    private List<Libro> libros;

    public Editorial(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public Editorial(int id, String nombre, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public Editorial(int id) {
        this.id = id;
    }

    public Editorial() {
    }

    public Editorial(int id, String nombre, String direccion, List<Libro> libros) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.libros = libros;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }
}
