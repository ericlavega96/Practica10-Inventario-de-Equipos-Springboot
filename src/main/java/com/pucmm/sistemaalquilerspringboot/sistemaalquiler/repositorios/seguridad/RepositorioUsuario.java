package com.pucmm.sistemaalquilerspringboot.sistemaalquiler.repositorios.seguridad;

import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.entidades.seguridad.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositorioUsuario extends JpaRepository<Usuario,String> {

    @Override
    List<Usuario> findAll();

    Usuario findByUsernameAndPassword(String username, String password);

    Usuario findByUsername(String username);
}
