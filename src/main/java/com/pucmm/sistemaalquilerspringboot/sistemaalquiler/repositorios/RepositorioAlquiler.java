package com.pucmm.sistemaalquilerspringboot.sistemaalquiler.repositorios;

import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.entidades.Alquiler;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioAlquiler extends JpaRepository<Alquiler,Long> {
}
