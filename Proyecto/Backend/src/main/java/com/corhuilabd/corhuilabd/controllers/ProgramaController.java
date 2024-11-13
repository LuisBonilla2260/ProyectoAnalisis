package com.corhuilabd.corhuilabd.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.corhuilabd.corhuilabd.services.IProgramaService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.corhuilabd.corhuilabd.models.Programa;

@CrossOrigin(origins = {"http://localhost:4200"})//el puerto del frontend
@RestController
@RequestMapping("/api/programas")
public class ProgramaController {

    @Autowired
    private IProgramaService service;

    @GetMapping("")
    public List<Programa> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Programa> getById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping("")
    public Programa create(@RequestBody Programa prog) {
        return service.save(prog);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Programa update(@RequestBody Programa programa, @PathVariable Integer id){
        service.update(programa, id);
        return  programa;
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

    @GetMapping("/byFacultad")
    public List<Programa> getByFacultad(@RequestParam String facultad) {
        return service.findByFacultad(facultad);
    }
}
