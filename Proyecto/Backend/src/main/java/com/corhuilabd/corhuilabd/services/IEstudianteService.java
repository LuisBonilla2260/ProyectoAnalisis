package com.corhuilabd.corhuilabd.services;

import java.util.List;
import java.util.Optional;

import com.corhuilabd.corhuilabd.models.Estudiante;
import com.corhuilabd.corhuilabd.dto.EstudianteInfoDTO;

public interface IEstudianteService {
    List<Estudiante> findAll(); // Retorna todos los estudiantes
    Optional<Estudiante> findById(Integer id); // Encuentra un estudiante por ID
    Estudiante save(Estudiante est); // Guarda un estudiante (crea o actualiza)
    void update(Estudiante est, Integer id); // Guarda un estudiante (crea o actualiza)
    void delete(Integer id); // Elimina un estudiante por ID
    Estudiante findByDocumento(String documento); // Busca un estudiante por su número de documento
    //List<EstudianteInfoDTO> findEstudianteInfoByProgramaId(Integer programaId); // Encuentra estudiantes por ID de programa y devuelve información específica usando un DTO

}