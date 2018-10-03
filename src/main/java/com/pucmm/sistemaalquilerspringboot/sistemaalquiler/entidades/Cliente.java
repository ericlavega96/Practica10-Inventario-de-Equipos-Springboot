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
    private Long idCliente;

    private String foto;

    @NotNull
    private String cedula;

    @NotNull
    private String nombres;

    @NotNull
    private String apellidos;

    @NotNull
    @ManyToOne
    private Pais pais;

    @NotNull
    private String ciudad;

    @NotNull
    private String direccion;

    private String telefono;

    private String correo;

    @OneToMany(mappedBy = "cliente",fetch = FetchType.EAGER, cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Factura> alquileres;

    @Temporal(TemporalType.DATE)
    private Date softDelete;

    public Cliente() {

    }

    public Cliente(String foto, String cedula, String nombres, String apellidos, Pais pais, String ciudad, String direccion, String telefono, String correo, List<Factura> alquileres) {
        this.foto = foto;
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.pais = pais;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.alquileres = alquileres;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Date getSoftDelete() {
        return softDelete;
    }

    public void setSoftDelete(Date softDelete) {
        this.softDelete = softDelete;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<Factura> getAlquileres() {
        return alquileres;
    }

    public void setAlquileres(List<Factura> alquileres) {
        this.alquileres = alquileres;
    }

    public boolean isDeleted(){
        if(softDelete.after(new Date()))
            return true;
        else
            return false;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", cedula='" + cedula + '\'' +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", pais=" + pais +
                ", ciudad='" + ciudad + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                ", alquileres=" + alquileres +
                '}';
    }
}
