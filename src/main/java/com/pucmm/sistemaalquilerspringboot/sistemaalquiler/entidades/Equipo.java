package com.pucmm.sistemaalquilerspringboot.sistemaalquiler.entidades;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
public class Equipo implements Serializable {
    @Id
    @GeneratedValue
    private Long idEquipo;

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

    private boolean borrado = false;

    public Equipo() {
    }

    public Equipo(String nombre, int inventario, List<Alquiler> alquileres, SubFamilia subfamilia, String rutaImagen) {
        this.nombre = nombre;
        this.inventario = inventario;
        this.alquileres = alquileres;
        this.subfamilia = subfamilia;
        this.rutaImagen = rutaImagen;
    }

    public Long getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Long idEquipo) {
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

    public boolean isBorrado() {
        return borrado;
    }

    public void setBorrado(boolean borrado) {
        this.borrado = borrado;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "idEquipo=" + idEquipo +
                ", nombre='" + nombre + '\'' +
                ", inventario=" + inventario +
                ", alquileres=" + alquileres +
                ", subfamilia=" + subfamilia.getNombre() +'\'' +
                '}';
    }
}
