package com.example.LibreriaAPI.service;

import com.example.LibreriaAPI.model.Libreria;

import java.util.List;

public interface LibreriaService {
    // escribo todos los metodos que quiero llamar desde el controller. Solo se escribe la firma
    // aportan la logica del negocio

    public Libreria agregarLibreria(Libreria libreria);
    List<Libreria> getAllLibrerias();
}
