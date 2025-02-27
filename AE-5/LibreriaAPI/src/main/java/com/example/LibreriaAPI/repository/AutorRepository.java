package com.example.LibreriaAPI.repository;

import com.example.LibreriaAPI.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Integer> {
}
