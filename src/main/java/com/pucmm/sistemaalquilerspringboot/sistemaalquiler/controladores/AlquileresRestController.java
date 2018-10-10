package com.pucmm.sistemaalquilerspringboot.sistemaalquiler.controladores;

import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.encapsulacion.FamiliaEncapsulacion;
import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.encapsulacion.SubFamiliaEncapsulacion;
import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.servicios.serviciosEntidades.ServicioAlquileresRest;
import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.servicios.serviciosEntidades.ServiciosAlquiler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class AlquileresRestController {

    @Autowired
    ServicioAlquileresRest servicioAlquileresRest;


    @GetMapping("/rest/familias")
    public List<FamiliaEncapsulacion> getFamiliasAlquileres(){
        return servicioAlquileresRest.getPromedioFamilias();
    }

    @GetMapping("/rest/subfamilias")
    public List<SubFamiliaEncapsulacion> getSubFamiliasAlquileres(){
        return servicioAlquileresRest.getPromedioSubFamilias();
    }


}
