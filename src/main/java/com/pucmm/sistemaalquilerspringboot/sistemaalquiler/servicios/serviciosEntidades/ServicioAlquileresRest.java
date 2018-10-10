package com.pucmm.sistemaalquilerspringboot.sistemaalquiler.servicios.serviciosEntidades;

import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.encapsulacion.FamiliaEncapsulacion;
import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.encapsulacion.SubFamiliaEncapsulacion;
import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.entidades.Alquiler;
import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.entidades.Familia;
import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.entidades.SubFamilia;
import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.repositorios.RepositorioAlquiler;
import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.repositorios.RepositorioFamilia;
import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.repositorios.RepositorioSubFamilia;
import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.servicios.JsonTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioAlquileresRest {
    @Autowired
    RepositorioAlquiler repositorioAlquiler;

    @Autowired
    RepositorioFamilia repositorioFamilia;

    @Autowired
    RepositorioSubFamilia repositorioSubFamilia;


    public List<FamiliaEncapsulacion> getPromedioFamilias(){
        List<FamiliaEncapsulacion> familiaEncapsulaciones = new ArrayList<>();
        int cantidadDiasAlquilados;
        int cantidadAlquilados;
        double promedio;
        for (Familia familia: repositorioFamilia.findAll()) {
            cantidadAlquilados=0;
            cantidadDiasAlquilados=0;
            for (Alquiler alquiler:repositorioAlquiler.findAll()) {
                if(alquiler.getEquipo().getSubfamilia().getFamilia().getIdFamilia() == familia.getIdFamilia()){
                    cantidadDiasAlquilados+=alquiler.diasDeAlquiler()* alquiler.getCantidad();
                    cantidadAlquilados+=alquiler.getCantidad();
                }
            }
            if (cantidadAlquilados > 0){
                promedio = cantidadDiasAlquilados/cantidadAlquilados;
                familiaEncapsulaciones.add(new FamiliaEncapsulacion(familia.getNombre(),promedio));
            }
        }
        return familiaEncapsulaciones;
    }

    public List<SubFamiliaEncapsulacion> getPromedioSubFamilias(){
        List<SubFamiliaEncapsulacion> subFamiliaEncapsulaciones = new ArrayList<>();
        int cantidadDiasAlquilados;
        int cantidadAlquilados;
        double promedio;
        for (SubFamilia subFamilia: repositorioSubFamilia.findAll()) {
            cantidadAlquilados=0;
            cantidadDiasAlquilados=0;
            for (Alquiler alquiler:repositorioAlquiler.findAll()) {
                if(alquiler.getEquipo().getSubfamilia().getIdSubFamilia() == subFamilia.getIdSubFamilia()){
                    cantidadDiasAlquilados+=alquiler.diasDeAlquiler()* alquiler.getCantidad();
                    cantidadAlquilados+=alquiler.getCantidad();
                }
            }
            if (cantidadAlquilados > 0){
                promedio = cantidadDiasAlquilados/cantidadAlquilados;
                subFamiliaEncapsulaciones.add(new SubFamiliaEncapsulacion(subFamilia.getNombre(),promedio));
            }
        }
        return subFamiliaEncapsulaciones;
    }

}
