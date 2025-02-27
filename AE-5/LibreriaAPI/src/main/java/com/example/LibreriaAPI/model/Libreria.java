package com.example.LibreriaAPI.model;

// anotaciones de JPA para el mapeo con la base de datos

import jakarta.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "Librerias")
public class Libreria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nombre;

    @Column
    private String nombre_dueno;

    @Column
    private String direccion;

    public Libreria(String nombre, String nombre_dueno, String direccion) {
        this.nombre = nombre;
        this.nombre_dueno = nombre_dueno;
        this.direccion = direccion;
    }

    public Libreria() {
    }

    public Libreria(int id, String nombre, String nombre_dueno, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.nombre_dueno = nombre_dueno;
        this.direccion = direccion;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNombre_dueno() {
        return nombre_dueno;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNombre_dueno(String nombre_dueno) {
        this.nombre_dueno = nombre_dueno;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}
