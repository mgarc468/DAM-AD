package com.example.LibreriaAPI.service;

import com.example.LibreriaAPI.model.Autor;
import com.example.LibreriaAPI.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorServiceImp implements AutorService {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public Autor agregarAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    @Override
    public List<Autor> getAllAutores() {
        return autorRepository.findAll();
    }
}
