package com.pucmm.sistemaalquilerspringboot.sistemaalquiler.servicios.serviciosEntidades;

import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.repositorios.RepositorioFamilia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosFamilia {
    @Autowired
    private RepositorioFamilia repositorioFamilia;
}
