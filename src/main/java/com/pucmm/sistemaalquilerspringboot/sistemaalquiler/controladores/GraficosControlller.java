package com.pucmm.sistemaalquilerspringboot.sistemaalquiler.controladores;


import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

@Controller
public class GraficosControlller {

    @RequestMapping(value = "/graficos/familias", method = RequestMethod.GET)
    public String getFamiliaGrafico(Model model, Authentication authentication)  throws IOException {
        model.addAttribute("username",authentication.getName());
        System.out.println("Entró a gráficos de promedio de familias.");
        return "graficoFamilia";
    }

    @RequestMapping(value = "/graficos/subfamilias", method = RequestMethod.GET)
    public String getSubFamiliaGrafico(Model model)  throws IOException {
        System.out.println("Entró a gráficos de promedio de sub-familias.");
        return "graficoSubFamilia";
    }
}
