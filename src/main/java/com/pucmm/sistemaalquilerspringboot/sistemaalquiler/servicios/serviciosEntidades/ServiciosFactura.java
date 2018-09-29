package com.pucmm.sistemaalquilerspringboot.sistemaalquiler.servicios.serviciosEntidades;

import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.repositorios.RepositorioFactura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosFactura {
    @Autowired
    private RepositorioFactura repositorioFactura;
}
