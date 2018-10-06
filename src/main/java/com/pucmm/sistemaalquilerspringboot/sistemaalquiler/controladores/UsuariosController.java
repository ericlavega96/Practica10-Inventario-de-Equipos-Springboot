package com.pucmm.sistemaalquilerspringboot.sistemaalquiler.controladores;

import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.entidades.Cliente;
import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.entidades.seguridad.Rol;
import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.entidades.seguridad.Usuario;
import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.repositorios.RepositorioCliente;
import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.repositorios.seguridad.RepositorioUsuario;
import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.servicios.serviciosEntidades.seguridad.ServiciosUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Date;

@Controller
public class UsuariosController {

    @Autowired
    private ServiciosUsuario serviciosUsuario;

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    @Autowired
    private RepositorioCliente repositorioCliente;

    @RequestMapping(value = "/usuarios",method = RequestMethod.GET)
    public String getClientesView(Model model){
        model.addAttribute("usuarios",repositorioUsuario.findAll());
        return "usuarios";
    }

    @RequestMapping(value = "/registrarUsuario",method = RequestMethod.POST)
    public String registrarCliente(@Valid Usuario usuario, BindingResult result, @RequestParam("rol") String rol ) {
        if (result.hasErrors()) {
            return "error";
        }
        if(rol == "user")
            serviciosUsuario.crearUsuario(usuario.getUsername(),usuario.getNombre(),usuario.getPassword());
        else
            serviciosUsuario.crearUsuarioAdmin(usuario.getUsername(),usuario.getNombre(),usuario.getPassword());
        return "redirect:/usuarios";
    }

    @RequestMapping(value = "/editarUsuario/{username}",method = RequestMethod.POST)
    public String editarUsuario(@Valid Usuario usuario, BindingResult result,@PathVariable(value = "username") String username,@RequestParam("rol") String rol,@RequestParam(name = "raw-password") String rawPassword) {
        if (result.hasErrors()) {
            return "error";
        }

        if(rol == "user")
            usuario.getRoles().add(new Rol("ROLE_USER"));
        else
            usuario.getRoles().add(new Rol("ROLE_ADMIN"));

        usuario.setPassword(serviciosUsuario.encryptPassword(rawPassword));
        repositorioUsuario.save(usuario);
        System.out.println("El usuario ha sido actualizado con éxito");
        return "redirect:/usuarios";
    }

    @RequestMapping(value = "/eliminarUsuario/?oldUsername={oldUsername}/{username}",method = RequestMethod.POST)
    public String eliminarCliente(@PathVariable(value = "username") String username) {
        Usuario usuarioSoftDelete = repositorioUsuario.getOne(username);
        usuarioSoftDelete.setSoftDelete(new Date());
        repositorioUsuario.save(usuarioSoftDelete);
        System.out.println("El usuario ha sido eliminado con éxito");
        System.out.println(usuarioSoftDelete.toString());
        return "redirect:/usuarios";
    }


}
