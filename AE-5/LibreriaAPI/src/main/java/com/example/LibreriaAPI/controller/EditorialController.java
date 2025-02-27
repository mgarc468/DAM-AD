package com.example.LibreriaAPI.controller;

import com.example.LibreriaAPI.model.Editorial;
import com.example.LibreriaAPI.service.EditorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("editoriales")
public class EditorialController {

    @Autowired
    private EditorialService editorialService;

    @GetMapping("error")
    public String getError(){
        return "Error en la app";
    }

    @PostMapping("add")
    public String addAutor(@RequestBody Editorial editorial){
        editorialService.agregarEditorial(editorial);
        return "Autor agregado correctamente con nombre "+editorial.getNombre();
    }

    @GetMapping("getAll")
    public ResponseEntity<List<Editorial>> getEditoriales(){
        return new ResponseEntity<>(editorialService.getAllEditoriales(), HttpStatus.OK);
    }
}
