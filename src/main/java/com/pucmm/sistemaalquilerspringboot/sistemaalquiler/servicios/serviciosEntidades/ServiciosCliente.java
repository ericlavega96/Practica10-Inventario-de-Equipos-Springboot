package com.pucmm.sistemaalquilerspringboot.sistemaalquiler.servicios.serviciosEntidades;

import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.repositorios.RepositorioCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosCliente {
    @Autowired
    private RepositorioCliente repositorioCliente;
}
