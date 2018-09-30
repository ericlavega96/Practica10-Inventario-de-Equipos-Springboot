package com.pucmm.sistemaalquilerspringboot.sistemaalquiler.servicios;

import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.servicios.serviciosEntidades.ServiciosCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class CargaData {
    @Autowired
    ServiciosCliente serviciosCliente;

    @PostConstruct
    public void cargarInformacionInicio(){
        System.out.println("Simulando la carga de información.....");
    }

}
