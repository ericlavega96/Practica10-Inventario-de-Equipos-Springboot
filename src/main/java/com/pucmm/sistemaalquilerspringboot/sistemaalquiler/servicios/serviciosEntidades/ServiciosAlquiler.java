package com.pucmm.sistemaalquilerspringboot.sistemaalquiler.servicios.serviciosEntidades;

import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.repositorios.RepositorioAlquiler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosAlquiler {
    @Autowired
    private RepositorioAlquiler repositorioAlquiler;
}
