package com.pucmm.sistemaalquilerspringboot.sistemaalquiler.entidades;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Equipo implements Serializable {
    @Id
    @GeneratedValue
    private long idEquipo;

    @NotNull
    private String nombre;

    @NotNull
    private int inventario;

    @OneToMany(mappedBy = "equipo",fetch = FetchType.EAGER, cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Alquiler> alquileres;

    @ManyToOne
    @JoinColumn(name = "idSubFamilia")
    private SubFamilia subfamilia;

    private String rutaImagen;

    @Temporal(TemporalType.DATE)
    private Date softDelete;

    public Equipo() {
    }

    public Equipo(@NotNull String nombre, @NotNull int inventario, List<Alquiler> alquileres, SubFamilia subfamilia, String rutaImagen, Date softDelete) {
        this.nombre = nombre;
        this.inventario = inventario;
        this.alquileres = alquileres;
        this.subfamilia = subfamilia;
        this.rutaImagen = rutaImagen;
        this.softDelete = softDelete;
    }

    public long getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(long idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getInventario() {
        return inventario;
    }

    public void setInventario(int inventario) {
        this.inventario = inventario;
    }

    public List<Alquiler> getAlquileres() {
        return alquileres;
    }

    public void setAlquileres(List<Alquiler> alquileres) {
        this.alquileres = alquileres;
    }

    public SubFamilia getSubfamilia() {
        return subfamilia;
    }

    public void setSubfamilia(SubFamilia subfamilia) {
        this.subfamilia = subfamilia;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
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
