package com.pucmm.sistemaalquilerspringboot.sistemaalquiler.servicios.serviciosEntidades;

import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.entidades.Pais;
import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.repositorios.RepositorioPais;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiciosPais {
    @Autowired
    private RepositorioPais repositorioPais;

    public List<Pais> getPaises(){
        return repositorioPais.findAll();
    }

    public Pais findPais(Long  id){
        return repositorioPais.getOne(id);
    }


}
