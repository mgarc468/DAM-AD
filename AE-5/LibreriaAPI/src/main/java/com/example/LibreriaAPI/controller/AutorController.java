package com.example.LibreriaAPI.controller;
import com.example.LibreriaAPI.model.Autor;
import com.example.LibreriaAPI.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping("error")
    public String getError(){
        return "Error en la app";
    }

    @PostMapping("add")
    public String addAutor(@RequestBody Autor autor){
        autorService.agregarAutor(autor);
        return "Autor agregado correctamente con nombre "+autor.getNombre();
    }

    @GetMapping("getAll")
    public ResponseEntity<List<Autor>> getAutores(){
        return new ResponseEntity<>(autorService.getAllAutores(), HttpStatus.OK);
    }
}
