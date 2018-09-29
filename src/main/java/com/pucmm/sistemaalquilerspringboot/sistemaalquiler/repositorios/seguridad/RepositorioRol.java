package com.pucmm.sistemaalquilerspringboot.sistemaalquiler.repositorios.seguridad;

import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.entidades.seguridad.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioRol  extends JpaRepository<Rol,String> {
}
