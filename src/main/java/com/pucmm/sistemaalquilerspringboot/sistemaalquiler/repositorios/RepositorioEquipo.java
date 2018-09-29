package com.pucmm.sistemaalquilerspringboot.sistemaalquiler.repositorios;

import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.entidades.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioEquipo extends JpaRepository<Equipo,Long> {
}
