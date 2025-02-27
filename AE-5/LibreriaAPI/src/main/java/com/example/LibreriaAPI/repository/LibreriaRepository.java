package com.example.LibreriaAPI.repository;

// metodos que van contra base de datos
// tantos metodos "adicionale" como necesitemos
// los metodos por defecto me los da el JPA repository
    //persist
    //save
    //merge
    //list
import com.example.LibreriaAPI.model.Libreria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibreriaRepository  extends JpaRepository<Libreria, Integer>{


}
