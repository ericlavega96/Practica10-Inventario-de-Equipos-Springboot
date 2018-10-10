package com.pucmm.sistemaalquilerspringboot.sistemaalquiler.entidades;

import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.entidades.Cliente;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Alquiler implements Serializable {
    @Id
    @GeneratedValue
    private Long idAlquiler;

    @ManyToOne
    @JoinColumn(name = "idEquipo")
    private Equipo equipo;

    @Temporal(TemporalType.DATE)
    private Date fechaAlquiler;

    @Temporal(TemporalType.DATE)
    private Date fechaPromesaEntrega;

    @ManyToOne
    @JoinColumn(name = "idFactura")
    private Factura factura;

    @NotNull
    private double costoDiarioUnitario;

    @NotNull
    private long cantidad;

    private boolean borrado = false;

    public Alquiler() {
    }

    public Alquiler(Equipo equipo, Date fechaAlquiler, Date fechaPromesaEntrega, Factura factura, @NotNull double costoDiarioUnitario, @NotNull long cantidad) {
        this.equipo = equipo;
        this.fechaAlquiler = fechaAlquiler;
        this.fechaPromesaEntrega = fechaPromesaEntrega;
        this.factura = factura;
        this.costoDiarioUnitario = costoDiarioUnitario;
        this.cantidad = cantidad;
    }

    public Long getIdAlquiler() {
        return idAlquiler;
    }

    public void setIdAlquiler(Long idAlquiler) {
        this.idAlquiler = idAlquiler;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Date getFechaAlquiler() {
        return fechaAlquiler;
    }

    public void setFechaAlquiler(Date fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    public Date getFechaPromesaEntrega() {
        return fechaPromesaEntrega;
    }

    public void setFechaPromesaEntrega(Date fechaPromesaEntrega) {
        this.fechaPromesaEntrega = fechaPromesaEntrega;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public double getCostoDiarioUnitario() {
        return costoDiarioUnitario;
    }

    public void setCostoDiarioUnitario(double costoDiarioUnitario) {
        this.costoDiarioUnitario = costoDiarioUnitario;
    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }

    public boolean isBorrado() {
        return borrado;
    }

    public void setBorrado(boolean borrado) {
        this.borrado = borrado;
    }

    public String equipoString(){
        return equipo.getIdEquipo()+" - "+equipo.getNombre();
    }

    public String fechaAlquilerString(){
        return fechaAlquiler.toString();
    }

    public String fechaEntregaString(){
        return fechaPromesaEntrega.toString();
    }

}
