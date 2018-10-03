package com.pucmm.sistemaalquilerspringboot.sistemaalquiler;

import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.servicios.serviciosEntidades.ServiciosFamilia;
import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.servicios.serviciosEntidades.seguridad.ServiciosUsuario;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SistemaDeAlquilerApplication {

	public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(SistemaDeAlquilerApplication.class, args);

        ServiciosUsuario serviciosUsuario = (ServiciosUsuario) applicationContext.getBean("serviciosUsuario");
        serviciosUsuario.crearUsuarioAdmin();
        ServiciosFamilia serviciosFamilia = (ServiciosFamilia) applicationContext.getBean("serviciosFamilia");
        serviciosFamilia.generarFamilias();
	}
}
