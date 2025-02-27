package com.example.LibreriaAPI.service;


import com.example.LibreriaAPI.model.Autor;

import java.util.List;

public interface AutorService {

    public Autor agregarAutor(Autor autor);
    List<Autor> getAllAutores();

}
