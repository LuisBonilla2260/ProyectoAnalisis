package com.corhuilabd.corhuilabd.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.corhuilabd.corhuilabd.models.Programa;

@Repository
public interface IProgramaRepository  extends CrudRepository<Programa, Long>{
    List<Programa> findByFacultad(String facultad);
}
