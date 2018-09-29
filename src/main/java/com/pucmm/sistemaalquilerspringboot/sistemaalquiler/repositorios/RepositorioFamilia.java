package com.pucmm.sistemaalquilerspringboot.sistemaalquiler.repositorios;

import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.entidades.Familia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioFamilia extends JpaRepository<Familia,Long> {
}
