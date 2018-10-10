package com.pucmm.sistemaalquilerspringboot.sistemaalquiler.controladores;

import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.entidades.Equipo;
import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.entidades.Familia;
import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.entidades.SubFamilia;
import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.repositorios.RepositorioEquipo;
import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.repositorios.RepositorioFamilia;
import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.servicios.GestorImagenesServicio;
import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.servicios.serviciosEntidades.ServiciosFamilia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.IOException;


@Controller
public class EquipoController {

    @Autowired
    private ServiciosFamilia serviciosFamilia;

    @Autowired
    private RepositorioEquipo repositorioEquipo;

    @Autowired
    GestorImagenesServicio gestorImagenesServicio;

    @RequestMapping(value = "/equipos/registrar", method = RequestMethod.GET)
    public String getRegistrarView(Model model)  throws IOException {
        model.addAttribute("listaFamilias", serviciosFamilia.findAll());
        System.out.println("Entró a registrar equipos");
        for(Familia f:serviciosFamilia.findAll()) {
            System.out.println("Nombre: " + f.getNombre() + " Inglés:" + f.getNombre() + " Subfamilias:");
            for(SubFamilia s : f.getSubfamilias())
                System.out.println("    - Nombre:" + s.getNombre());

        }
        return "registrarEquipo";
    }

    @RequestMapping(value = "/registrarEquipo",method = RequestMethod.POST)
    public String registrarEquipo(@Valid Equipo equipo, BindingResult result, @RequestParam("file")MultipartFile file)  throws IOException {
        if (result.hasErrors()) {
            return "error";
        }
        try {
            if(file != null)
                equipo.setRutaImagen(gestorImagenesServicio.guardarFoto(file));
        } catch (IOException e) {
            System.out.println("Error al almacenar la imagen" + e.toString());
        }
        System.out.println("Salida: " + equipo.toString());
        repositorioEquipo.save(equipo);
        System.out.println("El equipo ha sido almacenado con éxito");
        System.out.println(equipo.toString());
        return "redirect:/equipos/catalogo";
    }

    @RequestMapping(value = "/equipos/catalogo", method = RequestMethod.GET)
    public String getTableView(Model model)  throws IOException {
        model.addAttribute("listaEquipos", repositorioEquipo.findAll());
        System.out.println("Entró a ver equipos");
        return "catalogoEquipos";
    }
}
