package com.corhuilabd.corhuilabd.services;

import java.util.List;
import java.util.Optional;

import com.corhuilabd.corhuilabd.models.Estudiante;
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
    public Optional<Programa> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Programa save(Programa prog) {
        return repository.save(prog);
    }

    @Override
    public void update(Programa prog, Long id) {
        Optional<Programa> programa = repository.findById(id);

        if(!programa.isEmpty()){
            Programa progAct = programa.get();
            progAct.setFacultad(prog.getFacultad());
            progAct.setNomPrograma(prog.getNomPrograma());
            progAct.setNumCredito(prog.getNumCredito());
            progAct.setNumSemestre(prog.getNumSemestre());
            repository.save(progAct);
        }else{
            System.out.println("Dato no encontrado");
        }


    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Programa> findByFacultad(String facultad) {
        return repository.findByFacultad(facultad);
    }
}