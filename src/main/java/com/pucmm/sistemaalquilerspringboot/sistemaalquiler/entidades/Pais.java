package com.pucmm.sistemaalquilerspringboot.sistemaalquiler.entidades;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Set;


@Entity
public class Pais {
    @Id
    private Long id;

    private String codigo;

    @NotNull
    private String nombre;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "pais", cascade = CascadeType.ALL)
    private Set<Cliente> clientes;




    public Pais() {

    }

    public Pais(Long id, String codigo, @NotNull String nombre, Set<Cliente> clientes) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.clientes = clientes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(Set<Cliente> clientes) {
        this.clientes = clientes;
    }
}
