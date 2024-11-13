package com.corhuilabd.corhuilabd.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.corhuilabd.corhuilabd.models.Programa;

@Repository
public interface IProgramaRepository  extends CrudRepository<Programa, Integer>{
    List<Programa> findByFacultad(String facultad);
    Optional<Programa> findById(Integer id);

    //void deleteById(Integer id);
}
