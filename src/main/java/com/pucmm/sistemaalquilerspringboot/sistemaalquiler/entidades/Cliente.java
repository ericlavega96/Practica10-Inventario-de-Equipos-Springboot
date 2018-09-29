package com.pucmm.sistemaalquilerspringboot.sistemaalquiler.entidades;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Cliente implements Serializable {
    @Id
    @GeneratedValue
    private long idCliente;

    @NotNull
    private String cedula;
    @NotNull
    private String nombre;

    private String rutaFoto;

    @OneToMany(mappedBy = "cliente",fetch = FetchType.EAGER, cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Factura> alquileres;

    @Temporal(TemporalType.DATE)
    private Date softDelete;

    public Cliente() {
    }

    public Cliente(String cedula, String nombre, String rutaFoto, Date softDelete) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.rutaFoto = rutaFoto;
        this.softDelete = softDelete;
        this.alquileres = new ArrayList<>();
        this.alquileres = new ArrayList<>();
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRutaFoto() {
        return rutaFoto;
    }

    public void setRutaFoto(String rutaFoto) {
        this.rutaFoto = rutaFoto;
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
