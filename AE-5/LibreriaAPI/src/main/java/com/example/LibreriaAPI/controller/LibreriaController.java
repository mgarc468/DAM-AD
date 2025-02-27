package com.example.LibreriaAPI.controller;

import com.example.LibreriaAPI.model.Libreria;
import com.example.LibreriaAPI.service.LibreriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// se utiliza como punto de entrada de las peticiones REST

@RestController
@RequestMapping("librerias")
public class LibreriaController {
    //todos los metodos que quiero que se puedan ejecutar desde la URL

    @Autowired
    private LibreriaService libreriaService;

    @GetMapping("error")
    public String getError(){
        return "Error en la app";
    }

    @PostMapping("add")
    public String addLibreria(@RequestBody Libreria libreria){
        libreriaService.agregarLibreria(libreria);
        return "Libreria agregada correctamente con nombre "+libreria.getNombre();
    }

    @GetMapping("getAll")
    public ResponseEntity<List<Libreria>> getLibrerias(){
        return new ResponseEntity<>(libreriaService.getAllLibrerias(), HttpStatus.OK);
    }
}
