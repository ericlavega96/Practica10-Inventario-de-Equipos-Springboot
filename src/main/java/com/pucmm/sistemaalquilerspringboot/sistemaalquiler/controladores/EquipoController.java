package com.pucmm.sistemaalquilerspringboot.sistemaalquiler.controladores;

import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.entidades.Equipo;
import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.entidades.Familia;
import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.entidades.SubFamilia;
import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.repositorios.RepositorioEquipo;
import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.repositorios.RepositorioFamilia;
import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.servicios.serviciosEntidades.ServiciosFamilia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.IOException;


@Controller
public class EquipoController {

    @Autowired
    private ServiciosFamilia serviciosFamilia;

    @Autowired
    private RepositorioEquipo repositorioEquipo;

    @RequestMapping(value = "/equipos/registrar", method = RequestMethod.GET)
    public String getRegistrarView(Model model)  throws IOException {
        model.addAttribute("listaFamilias", serviciosFamilia.findAll());
        model.addAttribute("hola","holamundo");
        System.out.println("Entró a registrar equipos");
        for(Familia f:serviciosFamilia.findAll()) {
            System.out.println("Nombre: " + f.getNombre() + " Inglés:" + f.getNombre() + " Subfamilias:");
            for(SubFamilia s : f.getSubfamilias())
                System.out.println("    - Nombre:" + s.getNombre());

        }
        return "registrarEquipo";
    }

    @RequestMapping(value = "/registrarEquipo",method = RequestMethod.POST)
    public String registrarCliente(@Valid Equipo equipo, BindingResult result, Model model)  throws IOException {
        if (result.hasErrors()) {
            return "error";
        }
        repositorioEquipo.save(equipo);
        System.out.println("El equipo ha sido almacenado con éxito");
        System.out.println(equipo.toString());
        model.addAttribute("listaFamilias", serviciosFamilia.findAll());
        return "/equipos/registrar";
    }
}
