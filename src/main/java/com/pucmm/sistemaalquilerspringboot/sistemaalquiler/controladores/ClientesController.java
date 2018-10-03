package com.pucmm.sistemaalquilerspringboot.sistemaalquiler.controladores;

import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.entidades.Cliente;
import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.repositorios.RepositorioCliente;
import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.servicios.serviciosEntidades.ServiciosPais;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ClientesController {
    @Autowired
    ServiciosPais serviciosPais;

    @Autowired
    RepositorioCliente repositorioCliente;

    @RequestMapping(value = "/clientes",method = RequestMethod.GET)
    public String getClientesView(Model model){
        model.addAttribute("paises",serviciosPais.getPaises());
        return "clientes";
    }

    @RequestMapping(value = "/registrarCliente",method = RequestMethod.POST)
    public String registrarCliente(@Valid Cliente cliente, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "error";
        }
        repositorioCliente.save(cliente);
        System.out.println("El cliente ha sido almacenado con éxito");
        System.out.println(cliente.toString());
        model.addAttribute("paises",serviciosPais.getPaises());
        return "clientes";
    }
}
