package com.corhuilabd.corhuilabd.services;

import java.util.List;
import java.util.Optional;

import com.corhuilabd.corhuilabd.models.Programa;

public interface IProgramaService {
    List<Programa> findAll();
    Optional<Programa> findById(Integer id);
    Programa save(Programa prog);
    void update(Programa program, Integer id); // Guarda un estudiante (crea o actualiza)
    void delete(Integer id);
    List<Programa> findByFacultad(String facultad);
}
