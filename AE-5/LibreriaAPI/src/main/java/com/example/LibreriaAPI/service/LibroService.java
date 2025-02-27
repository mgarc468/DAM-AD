package com.example.LibreriaAPI.service;

import com.example.LibreriaAPI.model.Libreria;
import com.example.LibreriaAPI.model.Libro;

import java.util.List;

public interface LibroService {
    public Libro agregarLibro(Libro libro);
    List<Libro> getAllLibros();
}
