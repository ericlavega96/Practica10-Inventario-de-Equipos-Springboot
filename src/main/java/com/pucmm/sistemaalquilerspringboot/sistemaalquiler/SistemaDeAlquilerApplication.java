package com.pucmm.sistemaalquilerspringboot.sistemaalquiler;

import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.servicios.serviciosEntidades.ServiciosFamilia;
import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.servicios.serviciosEntidades.seguridad.ServiciosUsuario;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.File;

@SpringBootApplication
public class SistemaDeAlquilerApplication {

	public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(SistemaDeAlquilerApplication.class, args);

        File file = new File("images");
        if (!file.exists()) {
            if (file.mkdir())
                System.out.println("Directorio de imagenes creado");
        }

        ServiciosUsuario serviciosUsuario = (ServiciosUsuario) applicationContext.getBean("serviciosUsuario");
        serviciosUsuario.crearUsuarioAdmin();
        ServiciosFamilia serviciosFamilia = (ServiciosFamilia) applicationContext.getBean("serviciosFamilia");
        serviciosFamilia.generarFamilias();
	}
}
