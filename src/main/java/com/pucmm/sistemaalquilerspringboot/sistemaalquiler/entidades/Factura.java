package com.pucmm.sistemaalquilerspringboot.sistemaalquiler.entidades;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Factura implements Serializable {
    @Id
    @GeneratedValue
    private Long idFactura;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date fechaEntregaEquipo;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

    @OneToMany(mappedBy = "factura",fetch = FetchType.EAGER, cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Alquiler> alquileres;

    @Temporal(TemporalType.DATE)
    private Date softDelete;

    public Factura() {
    }

    public Factura(@NotNull Date fechaEntregaEquipo, Cliente cliente, List<Alquiler> alquileres, Date softDelete) {
        this.fechaEntregaEquipo = fechaEntregaEquipo;
        this.cliente = cliente;
        this.alquileres = alquileres;
        this.softDelete = softDelete;
    }

    public Long getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Long idFactura) {
        this.idFactura = idFactura;
    }

    public Date getFechaEntregaEquipo() {
        return fechaEntregaEquipo;
    }

    public void setFechaEntregaEquipo(Date fechaEntregaEquipo) {
        this.fechaEntregaEquipo = fechaEntregaEquipo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Alquiler> getAlquileres() {
        return alquileres;
    }

    public void setAlquileres(List<Alquiler> alquileres) {
        this.alquileres = alquileres;
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
