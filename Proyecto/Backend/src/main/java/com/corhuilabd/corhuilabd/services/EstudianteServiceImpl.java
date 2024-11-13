package com.corhuilabd.corhuilabd.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corhuilabd.corhuilabd.models.Estudiante;
import com.corhuilabd.corhuilabd.dto.EstudianteInfoDTO;
import com.corhuilabd.corhuilabd.repositories.IEstudianteRepository;

@Service
public class EstudianteServiceImpl implements IEstudianteService {
    @Autowired
    private IEstudianteRepository repository;

    @Override
    public List<Estudiante> findAll() {
        return (List<Estudiante>) repository.findAll();
    }

    @Override
    public Optional<Estudiante> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Estudiante save(Estudiante est) {
        return repository.save(est);
    }

    @Override
    public void update(Estudiante est, Integer id) {
        Optional<Estudiante> estudiante = repository.findById(id);

        if(!estudiante.isEmpty()){
            Estudiante estActual = estudiante.get();
            estActual.setDocumento(est.getDocumento());
            estActual.setNombreEstudiante(est.getNombreEstudiante());
            repository.save(estActual);
        }else{
            System.out.println("Dato no encontrado");
        }


    }

    @Override
    public  void delete(Integer id) {
       repository.deleteById(id);
    }

    @Override
    public Estudiante findByDocumento(String documento) {
        return repository.findByDocumento(documento);
    }

    /*@Override
    public List<EstudianteInfoDTO> findEstudianteInfoByProgramaId(Integer programaId) {
        return repository.findEstudianteInfoByProgramaId(programaId);
    }*/
}