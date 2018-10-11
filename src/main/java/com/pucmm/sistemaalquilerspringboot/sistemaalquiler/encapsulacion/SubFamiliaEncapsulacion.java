package com.pucmm.sistemaalquilerspringboot.sistemaalquiler.encapsulacion;

public class SubFamiliaEncapsulacion {
    private String subfamilia;
    private double promedio;

    public SubFamiliaEncapsulacion() {
    }

    public SubFamiliaEncapsulacion(String subfamilia, double promedio) {
        this.subfamilia = subfamilia;
        this.promedio = promedio;
    }

    public String getSubfamilia() {
        return subfamilia;
    }

    public void setSubfamilia(String subfamilia) {
        this.subfamilia = subfamilia;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }
}
