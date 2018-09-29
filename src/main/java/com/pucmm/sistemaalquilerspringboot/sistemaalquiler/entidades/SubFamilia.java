package com.pucmm.sistemaalquilerspringboot.sistemaalquiler.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class SubFamilia implements Serializable {
    @Id
    @GeneratedValue
    private long idSubFamilia;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "idFamilia")
    private Familia familia;

    @Temporal(TemporalType.DATE)
    private Date softDelete;

    public SubFamilia() {
    }

    public SubFamilia(String nombre, Familia familia, Date softDelete) {
        this.nombre = nombre;
        this.familia = familia;
        this.softDelete = softDelete;
    }

    public long getIdSubFamilia() {
        return idSubFamilia;
    }

    public void setIdSubFamilia(long idSubFamilia) {
        this.idSubFamilia = idSubFamilia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
