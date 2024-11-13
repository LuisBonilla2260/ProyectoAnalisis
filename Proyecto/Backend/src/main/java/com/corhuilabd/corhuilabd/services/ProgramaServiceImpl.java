package com.corhuilabd.corhuilabd.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corhuilabd.corhuilabd.models.Programa;
import com.corhuilabd.corhuilabd.repositories.IProgramaRepository;

@Service
public class ProgramaServiceImpl implements IProgramaService {
    @Autowired
    private IProgramaRepository repository;

    @Override
    public List<Programa> findAll() {
        return (List<Programa>) repository.findAll();
    }

    @Override
    public Optional<Programa> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Programa save(Programa prog) {
        return repository.save(prog);
    }

    @Override
    public void update(Programa programa, Integer id) {
        Optional<Programa> program = repository.findById(id);

        if(!program.isEmpty()){
            Programa proActual = program.get();
            proActual.setNomPrograma(programa.getNomPrograma());
            proActual.setFacultad(programa.getFacultad());
            proActual.setNum_credito(programa.getNum_credito());
            proActual.setNum_semestre(programa.getNum_semestre());
            repository.save(proActual);
        }else{
            System.out.println("Dato no encontrado");
        }
    }

    @Override
    public void delete(Integer id) {
            repository.deleteById(id);
    }

    @Override
    public List<Programa> findByFacultad(String facultad) {
        return repository.findByFacultad(facultad);
    }
}