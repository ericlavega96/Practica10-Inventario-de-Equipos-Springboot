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
    private long idAlquiler;

    @ManyToOne
    @JoinColumn(name = "idEquipo")
    private List<Equipo> equipo;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date fechaAlquiler;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date fechaPromesaEntrega;

    @ManyToOne
    @JoinColumn(name = "idFactura")
    private Factura factura;

    @NotNull
    private double costoDiario;

    @Temporal(TemporalType.DATE)
    private Date softDelete;

    public Alquiler() {
    }

    public Alquiler(List<Equipo> equipo, Date fechaAlquiler, Date fechaPromesaEntrega, Factura factura, double costoDiario, Date softDelete) {
        this.equipo = equipo;
        this.fechaAlquiler = fechaAlquiler;
        this.fechaPromesaEntrega = fechaPromesaEntrega;
        this.factura = factura;
        this.costoDiario = costoDiario;
        this.softDelete = softDelete;
    }

    public long getIdAlquiler() {
        return idAlquiler;
    }

    public void setIdAlquiler(long idAlquiler) {
        this.idAlquiler = idAlquiler;
    }

    public List<Equipo> getEquipo() {
        return equipo;
    }

    public void setEquipo(List<Equipo> equipo) {
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

    public double getCostoDiario() {
        return costoDiario;
    }

    public void setCostoDiario(double costoDiario) {
        this.costoDiario = costoDiario;
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

    //nota: Validar existencia.
}
