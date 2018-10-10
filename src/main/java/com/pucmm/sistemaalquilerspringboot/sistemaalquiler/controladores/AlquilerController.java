package com.pucmm.sistemaalquilerspringboot.sistemaalquiler.controladores;

import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.entidades.Cliente;
import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.entidades.Factura;
import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.repositorios.RepositorioCliente;
import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.repositorios.RepositorioEquipo;
import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.repositorios.RepositorioFactura;
import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.servicios.serviciosEntidades.ServiciosAlquiler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.io.IOException;

@Controller
public class AlquilerController {
    @Autowired
    ServiciosAlquiler serviciosAlquiler;

    @Autowired
    RepositorioEquipo repositorioEquipo;
    @Autowired
    RepositorioCliente repositorioCliente;
    @Autowired
    RepositorioFactura repositorioFactura;

    @RequestMapping(value = "/alquiler/registrar",method = RequestMethod.GET)
    public String getFacturaView(Model model){
        System.out.println("Entro a alquiler");
        for(Cliente cliente:repositorioCliente.findAll())
            System.out.println("Nombre: " + cliente.getNombres() +" "+ cliente.getApellidos());
        model.addAttribute("listaClientes",repositorioCliente.findAll());
        return "registrarFacturacion";
    }

    @RequestMapping(value = "/registrarFactura",method = RequestMethod.POST)
    public String registrarFactura(@Valid Factura factura, BindingResult result) throws IOException {
        if (result.hasErrors()) {
            return "error";
        }
        System.out.println("Factura: "+factura.toString());
        repositorioFactura.save(factura);
        System.out.println("La factura se ha guardado con éxito");
        return "redirect:/alquiler/tablaFactura/"+factura.getIdFactura();
    }

    @RequestMapping(value = "/alquiler/tablaFactura/{idFactura}",method = RequestMethod.GET)
    public String getFacturaTable(@PathVariable long idFactura, Model model){
        System.out.println("    Id de la Factura: "+idFactura);
        Object aux = repositorioFactura.findById(idFactura);
        Factura factura = (Factura)aux;
        model.addAttribute("factura",factura);
        model.addAttribute("alquileres", factura.getAlquileres());
        return "tablaFactura";
    }

    @RequestMapping(value = "/alquiler/listasFacturas",method = RequestMethod.GET)
    public String getFacturaListas(Model model){
        model.addAttribute("facturas",repositorioFactura.findAll());
        return "blank";
    }

    @RequestMapping(value = "/alquiler/equiposRentados",method = RequestMethod.GET)
    public String getEquiposAlquilados(Model model){
        model.addAttribute("facturas",repositorioFactura.findAll());
        return "blank";
    }
}
