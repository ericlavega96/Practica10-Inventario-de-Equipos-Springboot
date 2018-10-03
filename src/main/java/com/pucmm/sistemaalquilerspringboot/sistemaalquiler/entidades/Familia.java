package com.pucmm.sistemaalquilerspringboot.sistemaalquiler.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Familia implements Serializable {
    @Id
    @GeneratedValue
    private Long idFamilia;

    private String nombre;

    private String ingles;

    @OneToMany(mappedBy = "familia",fetch = FetchType.EAGER, cascade = CascadeType.ALL,orphanRemoval = true)
    private List<SubFamilia> subfamilias;

    @Temporal(TemporalType.DATE)
    private Date softDelete;

    public Familia() {
    }

    public Familia(String nombre,String ingles, List<SubFamilia> subfamilias) {
        this.nombre = nombre;
        this.ingles = ingles;
        this.subfamilias = subfamilias;
    }

    public Long getIdFamilia() {
        return idFamilia;
    }

    public void setIdFamilia(Long idFamilia) {
        this.idFamilia = idFamilia;
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

    public List<SubFamilia> getSubfamilias() {
        return subfamilias;
    }

    public void setSubfamilias(List<SubFamilia> subfamilias) {
        this.subfamilias = subfamilias;
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
