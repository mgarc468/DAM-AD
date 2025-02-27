package com.example.LibreriaAPI.service;

import com.example.LibreriaAPI.model.Autor;
import com.example.LibreriaAPI.model.Editorial;

import java.util.List;

public interface EditorialService {

    public Editorial agregarEditorial(Editorial editorial);
    List<Editorial> getAllEditoriales();

}
