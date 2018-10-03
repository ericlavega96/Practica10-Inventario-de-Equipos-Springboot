package com.pucmm.sistemaalquilerspringboot.sistemaalquiler.repositorios;

import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.entidades.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositorioPais extends JpaRepository<Pais,Long> {

    @Override
    List<Pais> findAll();
}
