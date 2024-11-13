package com.corhuilabd.corhuilabd.models;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "programa")
public class Programa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100, name = "nombre")
    private String nomPrograma;

    @Column(length = 100, name = "facultad")
    private String facultad;

    private Integer num_semestre;

    private Integer num_credito;



    private static final long serialVersionUID=1L;


    // Getters y setters


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getNum_semestre() {
        return num_semestre;
    }

    public void setNum_semestre(Integer num_semestre) {
        this.num_semestre = num_semestre;
    }

    public Integer getNum_credito() {
        return num_credito;
    }

    public void setNum_credito(Integer num_credito) {
        this.num_credito = num_credito;
    }
}
