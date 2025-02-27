package com.example.LibreriaAPI.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table (name = "autores")
public class Autor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nombre;

    @Column
    private String apellidos;

    @Column
    private String fecha_nacimiento;

    @OneToMany(mappedBy = "autor", fetch = FetchType.EAGER)
    private List<Libro> libros;

    public Autor(String nombre, String apellidos, String fecha) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fecha_nacimiento = fecha;
    }

    public Autor(String fecha_nacimiento, String apellidos, String nombre, int id) {
        this.fecha_nacimiento = fecha_nacimiento;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.id = id;
    }

    public Autor(int id) {
        this.id = id;
    }

    public Autor() {
    }

    public Autor(int id, String nombre, String apellidos, String fecha_nacimiento, List<Libro> libros) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fecha_nacimiento = fecha_nacimiento;
        this.libros = libros;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
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

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }
}



