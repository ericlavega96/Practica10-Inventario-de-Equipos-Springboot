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

    @Temporal(TemporalType.DATE)
    private Date softDelete;

    public SubFamilia() {
    }

    public SubFamilia(String nombre, String ingles, Date softDelete) {
        this.nombre = nombre;
        this.ingles = ingles;
        this.softDelete = softDelete;
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

    public Date getSoftDelete() {
        return softDelete;
    }

    public void setSoftDelete(Date softDelete) {
        this.softDelete = softDelete;
    }

    public boolean isDeleted(){
        if(softDelete.after(new Date()))
            return true;
        else
            return false;
    }
}
