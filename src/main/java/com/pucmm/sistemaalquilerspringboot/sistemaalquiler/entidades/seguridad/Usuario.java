package com.pucmm.sistemaalquilerspringboot.sistemaalquiler.entidades.seguridad;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Usuario implements Serializable {
    @Id
    private long username;

    private String nombre;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Rol> roles;

    private Date softDelete;

    public Usuario() {
    }

    public Usuario(long username, String nombre, List<Rol> roles, Date softDelete) {
        this.username = username;
        this.nombre = nombre;
        this.roles = roles;
        this.softDelete = softDelete;
    }

    public long getUsername() {
        return username;
    }

    public void setUsername(long username) {
        this.username = username;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
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
