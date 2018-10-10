package com.pucmm.sistemaalquilerspringboot.sistemaalquiler.controladores;

import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.entidades.Alquiler;
import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.entidades.Cliente;
import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.entidades.Factura;
import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.repositorios.RepositorioAlquiler;
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
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    @Autowired
    RepositorioAlquiler repositorioAlquiler;

    @RequestMapping(value = "/alquiler/registrar",method = RequestMethod.GET)
    public String getFacturaView(Model model){
        System.out.println("Entro a alquiler");
        for(Cliente cliente:repositorioCliente.findAll())
            System.out.println("Nombre: " + cliente.getNombres() +" "+ cliente.getApellidos());
        model.addAttribute("listaClientes",repositorioCliente.findAll());
        return "registrarFacturacion";
    }

    @RequestMapping(value = "/registrarFactura",method = RequestMethod.POST)
    public String registrarFactura(@Valid Factura factura, @RequestParam("fecha") String fecha, BindingResult result) throws IOException {
        if (result.hasErrors()) {
            return "error";
        }
        try {
            Date fechaEntrega = (new SimpleDateFormat("dd-mm-yyyy").parse(fecha));
            factura.setFechaEntregaEquipo(fechaEntrega);
        } catch (ParseException e) {
            System.out.println("Error al almacenar la fecha");
            factura.setFechaEntregaEquipo(new Date());
        }

        repositorioFactura.save(factura);
        System.out.println("La factura se ha guardado con éxito");
        return "redirect:/alquiler/tablaFactura/"+factura.getIdFactura();
    }

    @RequestMapping(value = "/alquiler/tablaFactura/{idFactura}",method = RequestMethod.GET)
    public String getFacturaTable(@PathVariable long idFactura, Model model){
        System.out.println("    Id de la Factura: "+idFactura);
        Factura factura = repositorioFactura.getOne(idFactura);
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

    @RequestMapping(value = "/alquiler/tablaFactura/alquilerParametros/{idFactura}",method = RequestMethod.GET)
    public String getParametrosAlquiler(@PathVariable long idFactura,Model model){
        model.addAttribute("factura",repositorioFactura.getOne(idFactura));
        return "parametrosFactura";
    }

    @RequestMapping(value = "/registrarAlquiler",method = RequestMethod.POST)
    public String registrarAlquiler(@Valid Alquiler alquiler, @RequestParam("facturaID") long facturaID,
                                    @RequestParam("fechaAl") String fechaAl,
                                    @RequestParam("fechaProm") String fechaProm,
                                    BindingResult result) throws IOException {
        if (result.hasErrors()) {
            return "error";
        }

        try {
            alquiler.setFactura(repositorioFactura.getOne(facturaID));
        } catch (Exception e) {
            System.out.println("Error al enlazar con factura");
            return "redirect:/alquiler/tablaFactura/alquilerParametros/"+alquiler.getIdAlquiler();
        }
        try {
            Date fechaEntrega = (new SimpleDateFormat("dd-mm-yyyy").parse(fechaAl));
            alquiler.setFechaAlquiler(fechaEntrega);
        } catch (ParseException e) {
            System.out.println("Error al almacenar la fecha");
            alquiler.setFechaAlquiler(new Date());
        }

        try {
            Date fechaEntrega = (new SimpleDateFormat("dd-mm-yyyy").parse(fechaProm));
            alquiler.setFechaPromesaEntrega(fechaEntrega);
        } catch (ParseException e) {
            System.out.println("Error al almacenar la fecha");
            alquiler.setFechaPromesaEntrega(new Date());
        }

        repositorioAlquiler.save(alquiler);
        System.out.println("El alquiler se ha guardado con éxito");
        return "redirect:/alquiler/tablaFactura/alquilerEquipo/"+alquiler.getIdAlquiler();
    }

    @RequestMapping(value = "/alquiler/tablaFactura/alquilerEquipo/{idAlquiler}",method = RequestMethod.GET)
    public String getEquipoAlquiler(@PathVariable long idAlquiler,Model model){
        model.addAttribute("alquiler",repositorioAlquiler.getOne(idAlquiler));
        model.addAttribute("listaEquipos", repositorioEquipo.findAll());
        return "catalogoAlquiler";
    }

    @RequestMapping(value = "/alquilarEquipo/{idAlquiler}/{idEquipo}",method = RequestMethod.GET)
    public String alquilarEquipo(@PathVariable(value = "idAlquiler") long idAlquiler,
                                 @PathVariable(value = "idEquipo") long idEquipo,Model model){
        Alquiler alquiler = repositorioAlquiler.getOne(idAlquiler);
        alquiler.setEquipo(repositorioEquipo.getOne(idEquipo));
        repositorioAlquiler.save(alquiler);
        model.addAttribute("listaEquipos", repositorioEquipo.findAll());
        return "redirect:/alquiler/tablaFactura/"+alquiler.getFactura().getIdFactura();
    }
}
