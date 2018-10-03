package com.pucmm.sistemaalquilerspringboot.sistemaalquiler.controladores;

import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.repositorios.RepositorioEquipo;
import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.servicios.serviciosEntidades.ServiciosAlquiler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AlquilerController {
    @Autowired
    ServiciosAlquiler serviciosAlquiler;

    @Autowired
    RepositorioEquipo repositorioEquipo;

    @RequestMapping(value = "/alquiler/registrar",method = RequestMethod.GET)
    public String getClientesView(Model model){
        //model.addAttribute("paises",serviciosPais.getPaises());
        return "registrarFacturacion";
    }
}
