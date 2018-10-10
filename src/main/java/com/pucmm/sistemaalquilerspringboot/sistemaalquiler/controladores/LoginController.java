package com.pucmm.sistemaalquilerspringboot.sistemaalquiler.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView getLoginView(@RequestParam(value = "error", required = false) String error,
                                     @RequestParam(value = "logout", required = false) String logout){
        ModelAndView modelAndView = new ModelAndView();
        if (error != null) {
            modelAndView.addObject("error", "Las credenciales insertadas no son válidas");
        }

        if (logout != null) {
            modelAndView.addObject("logout", "Sesión cerrada satisfactoriamente");
        }
        modelAndView.setViewName("login");
        return modelAndView;
    }
}
