package com.pucmm.sistemaalquilerspringboot.sistemaalquiler.controladores;

import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.entidades.Cliente;
import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.repositorios.RepositorioCliente;
import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.servicios.GestorImagenesServicio;
import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.servicios.serviciosEntidades.ServiciosPais;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Date;

@Controller
public class ClientesController {
    @Autowired
    ServiciosPais serviciosPais;

    @Autowired
    RepositorioCliente repositorioCliente;

    @Autowired
    GestorImagenesServicio gestorImagenesServicio;

    @RequestMapping(value = "/clientes",method = RequestMethod.GET)
    public String getClientesView(Model model/*, Authentication authentication*/){
        //model.addAttribute("username",authentication.getName());
        model.addAttribute("paises",serviciosPais.getPaises());
        model.addAttribute("clientes",repositorioCliente.findAll());
        return "clientes";
    }

    @RequestMapping(value = "/registrarCliente",method = RequestMethod.POST)
    public String registrarCliente(@Valid Cliente cliente, BindingResult result, @RequestParam("file")MultipartFile file) {
        if (result.hasErrors()) {
            return "error";
        }
        try {
            if(file != null)
                cliente.setFoto(gestorImagenesServicio.guardarFoto(file));
        } catch (IOException e) {
            System.out.println("Error al almacenar la imagen" + e.toString());
        }
        repositorioCliente.save(cliente);
        System.out.println("El cliente ha sido almacenado con éxito");
        System.out.println(cliente.toString());
        return "redirect:/clientes";
    }

    @RequestMapping(value = "/editarCliente/{id}",method = RequestMethod.POST)
    public String editarCliente(@Valid Cliente cliente, BindingResult result,@RequestParam("file")MultipartFile file,@PathVariable(value = "id") String id) {
        if (result.hasErrors()) {
            return "error";
        }
        try {
            if(file != null)
                cliente.setFoto(gestorImagenesServicio.guardarFoto(file));
        } catch (IOException e) {
            System.out.println("Error al almacenar la imagen" + e.toString());
        }

        cliente.setIdCliente(Long.valueOf(id));
        cliente.setAlquileres(repositorioCliente.getOne(Long.valueOf(id)).getAlquileres());
        cliente.toString();
        repositorioCliente.save(cliente);
        System.out.println("El cliente ha sido actualizado con éxito");
        return "redirect:/clientes";
    }

    @RequestMapping(value = "/eliminarCliente/{id}",method = RequestMethod.POST)
    public String eliminarCliente(@PathVariable(value = "id") String id) {
        Cliente clienteSoftDelete = repositorioCliente.getOne(Long.valueOf(id));
        clienteSoftDelete.setBorrado(true);
        repositorioCliente.save(clienteSoftDelete);
        System.out.println("El cliente ha sido eliminado con éxito");
        System.out.println(clienteSoftDelete.toString());
        return "redirect:/clientes";
    }
}
