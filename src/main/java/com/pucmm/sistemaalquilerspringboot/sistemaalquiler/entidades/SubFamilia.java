package com.pucmm.sistemaalquilerspringboot.sistemaalquiler.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class SubFamilia implements Serializable {
    @Id
    @GeneratedValue
    private Long idSubFamilia;

    private String nombre;

    private String ingles;

    @ManyToOne
    @JoinColumn(name = "idFamilia")
    private Familia familia;

    private boolean borrado = false;

    public SubFamilia() {
    }

    public SubFamilia(String nombre, String ingles, Familia familia) {
        this.nombre = nombre;
        this.ingles = ingles;
        this.familia = familia;
    }

    public Long getIdSubFamilia() {
        return idSubFamilia;
    }

    public void setIdSubFamilia(Long idSubFamilia) {
        this.idSubFamilia = idSubFamilia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIngles() {
        return ingles;
    }

    public void setIngles(String ingles) {
        this.ingles = ingles;
    }

    public Familia getFamilia() {
        return familia;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
    }

    public boolean isBorrado() {
        return borrado;
    }

    public void setBorrado(boolean borrado) {
        this.borrado = borrado;
    }
}
