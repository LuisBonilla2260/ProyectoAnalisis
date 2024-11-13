package com.corhuilabd.corhuilabd.repositories;

import java.util.List;

import com.corhuilabd.corhuilabd.models.Programa;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.corhuilabd.corhuilabd.dto.EstudianteInfoDTO;
import com.corhuilabd.corhuilabd.models.Estudiante;

@Repository
public interface IEstudianteRepository extends CrudRepository<Estudiante, Integer> {
    Estudiante findByDocumento(String documento);


    /*@Query("SELECT new com.corhuilabd.corhuilabd.dto.EstudianteInfoDTO(e.documento, e.nombreEstudiante) FROM Estudiante e WHERE e.programa.id = ?1")
    List<EstudianteInfoDTO> findEstudianteInfoByProgramaId(Integer id);*/
}