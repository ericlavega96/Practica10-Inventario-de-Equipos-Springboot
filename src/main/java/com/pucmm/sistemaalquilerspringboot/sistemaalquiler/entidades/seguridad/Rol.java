package com.pucmm.sistemaalquilerspringboot.sistemaalquiler.entidades.seguridad;

import javax.persistence.Id;
import java.io.Serializable;

public class Rol implements Serializable {
    @Id
    private String Rol;

    public Rol() {
    }

    public Rol(String rol) {
        Rol = rol;
    }

    public String getRol() {
        return Rol;
    }

    public void setRol(String rol) {
        Rol = rol;
    }
}
