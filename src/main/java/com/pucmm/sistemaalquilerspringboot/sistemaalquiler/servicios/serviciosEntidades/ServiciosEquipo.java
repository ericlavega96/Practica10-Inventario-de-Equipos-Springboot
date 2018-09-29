package com.pucmm.sistemaalquilerspringboot.sistemaalquiler.servicios.serviciosEntidades;

import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.repositorios.RepositorioEquipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosEquipo {
    @Autowired
    private RepositorioEquipo repositorioEquipo;
}
