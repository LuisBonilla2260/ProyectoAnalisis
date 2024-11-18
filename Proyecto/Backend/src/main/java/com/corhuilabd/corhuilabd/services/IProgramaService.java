package com.corhuilabd.corhuilabd.services;

import java.util.List;
import java.util.Optional;

import com.corhuilabd.corhuilabd.models.Estudiante;
import com.corhuilabd.corhuilabd.models.Programa;

public interface IProgramaService {
    List<Programa> findAll();

    Optional<Programa> findById(Long id);

    Programa save(Programa prog);

    void delete(Long id);
    void update(Programa prog, Long id);
    List<Programa> findByFacultad(String facultad);
}
