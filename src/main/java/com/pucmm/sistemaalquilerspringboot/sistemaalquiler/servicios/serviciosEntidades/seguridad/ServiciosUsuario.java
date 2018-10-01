package com.pucmm.sistemaalquilerspringboot.sistemaalquiler.servicios.serviciosEntidades.seguridad;

import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.entidades.seguridad.Rol;
import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.entidades.seguridad.Usuario;
import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.repositorios.seguridad.RepositorioRol;
import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.repositorios.seguridad.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ServiciosUsuario implements UserDetailsService {

    @Autowired
    private RepositorioUsuario repositorioUsuario;
    @Autowired
    private RepositorioRol repositorioRol;

    private BCryptPasswordEncoder bCryptPasswordEncoder= new BCryptPasswordEncoder();
    /**
     * Creando el usuario por defecto y su rol.
     */
    public void crearUsuarioAdmin(){
        System.out.println("Creando el usuario administrador y  su rol en la BD");
        Rol rolAdmin = new Rol("ROLE_ADMIN");
        repositorioRol.save(rolAdmin);

        Usuario admin = new Usuario();
        admin.setUsername("admin");
        admin.setPassword(bCryptPasswordEncoder.encode("1234"));
        admin.setNombre("Administrador");
        admin.getRoles().add(new Rol("ROLE_ADMIN"));
        repositorioUsuario.save(admin);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = repositorioUsuario.findByUsername(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Rol rol : usuario.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(rol.getRol()));
        }

        return new org.springframework.security.core.userdetails.User(usuario.getUsername(), usuario.getPassword(),!usuario.isDeleted(),true, true, true, grantedAuthorities);
    }
}
