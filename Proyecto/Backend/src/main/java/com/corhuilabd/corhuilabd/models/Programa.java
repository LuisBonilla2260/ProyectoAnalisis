package com.corhuilabd.corhuilabd.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "programa")
public class Programa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String nomPrograma;

    @Column(length = 100)
    private String facultad;

    @Column(name = "num_semestre")
    private Integer numSemestre;

    @Column(name = "num_credito")
    private Integer numCredito;



    private static final long serialVersionUID = 1L;

    // Getters y setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomPrograma() {
        return nomPrograma;
    }

    public void setNomPrograma(String nomPrograma) {
        this.nomPrograma = nomPrograma;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public Integer getNumSemestre() {
        return numSemestre;
    }

    public void setNumSemestre(Integer numSemestre) {
        this.numSemestre = numSemestre;
    }

    public Integer getNumCredito() {
        return numCredito;
    }

    public void setNumCredito(Integer numCredito) {
        this.numCredito = numCredito;
    }
}
