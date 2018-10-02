package com.pucmm.sistemaalquilerspringboot.sistemaalquiler.controladores;

import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.servicios.serviciosEntidades.seguridad.ServiciosUsuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class IndexController {


    @RequestMapping(path = "/")
    public RedirectView indexView(){
        return new RedirectView("/login");
    }

    @RequestMapping("/index")
    public ModelAndView getIndexView(){
        ModelAndView modelAndView = new ModelAndView("base");
        modelAndView.addObject("username", "admin");
        return modelAndView;
    }




}
