package com.pucmm.sistemaalquilerspringboot.sistemaalquiler.repositorios;

import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.entidades.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioFactura extends JpaRepository<Factura, Long> {
}
