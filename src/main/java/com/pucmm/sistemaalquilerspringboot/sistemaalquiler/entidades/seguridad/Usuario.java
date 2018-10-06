package com.pucmm.sistemaalquilerspringboot.sistemaalquiler.entidades.seguridad;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class Usuario implements Serializable {
    @Id
    private String username;
    private String password;
    private String nombre;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Rol> roles = new HashSet<>();

    private Date softDelete;

    public Usuario() {
    }

    public Usuario(String username, String password, String nombre) {
        this.username = username;
        this.password = password;
        this.nombre = nombre;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }

    public Date getSoftDelete() {
        return softDelete;
    }

    public void setSoftDelete(Date softDelete) {
        this.softDelete = softDelete;
    }

    public boolean isDeleted(){
        boolean borrado = false;
        if (softDelete == null)
            borrado = false;
        else if(softDelete.after(new Date()))
            borrado = true;
        else
            borrado = false;
        return borrado;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nombre='" + nombre + '\'' +
                ", roles=" + roles.toString() +
                '}';
    }
}
