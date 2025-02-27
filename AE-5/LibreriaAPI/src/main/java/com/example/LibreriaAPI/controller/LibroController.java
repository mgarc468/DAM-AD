package com.example.LibreriaAPI.controller;

import com.example.LibreriaAPI.model.Libro;
import com.example.LibreriaAPI.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping("error")
    public String getError(){
        return "Error en la app";
    }

    @PostMapping("add")
    public String addLibros(@RequestBody Libro libros){
        libroService.agregarLibro(libros);
        return "Libreria agregada correctamente con nombre "+libros.getTitulo();
    }

    @GetMapping("getAll")
    public ResponseEntity<List<Libro>> getAllLibros(){
        return new ResponseEntity<>(libroService.getAllLibros(), HttpStatus.OK);
    }


}
