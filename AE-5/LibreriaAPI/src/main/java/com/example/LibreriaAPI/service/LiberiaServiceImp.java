package com.example.LibreriaAPI.service;

import com.example.LibreriaAPI.model.Libreria;
import com.example.LibreriaAPI.repository.LibreriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LiberiaServiceImp implements LibreriaService{

    @Autowired
    private LibreriaRepository libreriaRepository;

    @Override
    public Libreria agregarLibreria(Libreria libreria) {
        return libreriaRepository.save(libreria);
    }

    @Override
    public List<Libreria> getAllLibrerias() {
        return libreriaRepository.findAll();
    }

}
