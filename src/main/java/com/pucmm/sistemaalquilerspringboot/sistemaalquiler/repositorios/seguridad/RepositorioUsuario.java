package com.pucmm.sistemaalquilerspringboot.sistemaalquiler.repositorios.seguridad;

import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.entidades.seguridad.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioUsuario extends JpaRepository<Usuario,String> {
    Usuario findByUsernameAndPassword(String username, String password);
}
