package com.pucmm.sistemaalquilerspringboot.sistemaalquiler.repositorios;

import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioCliente extends JpaRepository<Cliente,Long> {



}
