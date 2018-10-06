package com.pucmm.sistemaalquilerspringboot.sistemaalquiler.entidades.seguridad;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Rol implements Serializable {
    @Id
    private String rol;

    public Rol() {
    }

    public Rol(String rol) {
        this.rol = rol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
