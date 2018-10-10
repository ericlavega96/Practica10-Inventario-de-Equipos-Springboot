package com.pucmm.sistemaalquilerspringboot.sistemaalquiler.encapsulacion;

public class SubFamiliaEncapsulacion {
    private String familia;
    private double promedio;

    public SubFamiliaEncapsulacion() {
    }

    public SubFamiliaEncapsulacion(String familia, double promedio) {
        this.familia = familia;
        this.promedio = promedio;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }
}
