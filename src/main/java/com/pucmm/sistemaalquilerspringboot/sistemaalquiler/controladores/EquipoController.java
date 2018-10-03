package com.pucmm.sistemaalquilerspringboot.sistemaalquiler.controladores;

import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.repositorios.RepositorioFamilia;
import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.servicios.serviciosEntidades.ServiciosFamilia;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class EquipoController {

    @RequestMapping(value = "/equipos/registrar", method = RequestMethod.GET)
    public ModelAndView getLoginView(Map<String, Object> model){
        ServiciosFamilia serviciosFamilia = new ServiciosFamilia();
        model.put("listaFamilias", serviciosFamilia.findAll());
        return new ModelAndView("registrarEquipo");
    }
}
