package com.example.LibreriaAPI.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table (name = "libros")
public class Libro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String titulo;

    @Column
    private double precio;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_autor")
    private Autor autor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_editorial")
    private Editorial editorial;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "librerias_libros", joinColumns = @JoinColumn(name = "id_libro")
            , inverseJoinColumns = @JoinColumn(name = "id_libreria"))
    private List<Libreria> librerias;

    public Libro(String titulo, double precio) {
        this.titulo = titulo;
        this.precio = precio;
    }

    public Libro(String titulo, double precio, Autor autor, Editorial editorial) {
        this.titulo = titulo;
        this.precio = precio;
        this.autor = autor;
        this.editorial = editorial;
    }

    public Libro(int id, String titulo, double precio, Autor autor, Editorial editorial) {
        this.id = id;
        this.titulo = titulo;
        this.precio = precio;
        this.autor = autor;
        this.editorial = editorial;
    }

    public Libro() {
    }

    public Libro(List<Libreria> librerias, Editorial editorial, Autor autor, double precio, String titulo, int id) {
        this.librerias = librerias;
        this.editorial = editorial;
        this.autor = autor;
        this.precio = precio;
        this.titulo = titulo;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getPrecio() {
        return precio;
    }

    public Autor getAutor() {
        return autor;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public List<Libreria> getLibrerias() {
        return librerias;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    public void setLibrerias(List<Libreria> librerias) {
        this.librerias = librerias;
    }
}

