package com.corhuilabd.corhuilabd.controllers;

import com.corhuilabd.corhuilabd.models.Programa;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.corhuilabd.corhuilabd.models.Estudiante;
import com.corhuilabd.corhuilabd.services.IEstudianteService;
import com.corhuilabd.corhuilabd.dto.EstudianteInfoDTO;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:4200"})//el puerto del frontend
@RestController
@RequestMapping("/api/estudiante")
public class EstudianteController {
    @Autowired
    private IEstudianteService service;

    @GetMapping("")
    public List<Estudiante> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Estudiante> getById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping("")
    public Estudiante create(@RequestBody Estudiante est) {
        return service.save(est);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Estudiante update(@RequestBody Estudiante estudiante, @PathVariable Integer id){
        service.update(estudiante, id);
        return estudiante;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

    @GetMapping("findDocument/{documento}")
    public Estudiante getByDocumento(@PathVariable String documento) {
        return service.findByDocumento(documento);
    }

    /*@GetMapping("/infoByPrograma/{programaId}")
    public List<EstudianteInfoDTO> getInfoByProgramaId(@PathVariable Integer programaId) {
        return service.findEstudianteInfoByProgramaId(programaId);
    }*/
}