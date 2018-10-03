package com.pucmm.sistemaalquilerspringboot.sistemaalquiler.servicios.serviciosEntidades;

import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.entidades.Familia;
import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.entidades.SubFamilia;
import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.repositorios.RepositorioFamilia;
import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.repositorios.RepositorioSubFamilia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ServiciosFamilia {
    @Autowired
    private RepositorioFamilia repositorioFamilia;
    @Autowired
    private RepositorioSubFamilia repositorioSubFamilia;


    public boolean generarFamilias(){
        if(repositorioFamilia.findAll().size()<=0){
            String dbIngles=
                    "Augmented Reality:Video glasses,The glasses of augmented reality,Helmets of virtual reality,Other-" +
                    "3D printers:3D printers,Other-" +
                    "Spy gadgets:Devices of Video Surveillance,Binoculars,Dictaphones,Lie Detectors,Motion Sensors,Others-" +
                    "Smart Watches:Smart Watches,Other-" +
                    "Gaming Gadgets:Console,Game,Peripheric,Other-Smart phones:Phone,Accesory,Other-" +
                    "Medical Gadgets:Medical gadget,Other-" +
                    "Fitness trackers:Fitness tracker,Other";
            String dbEspanol=
                    "Realidad aumentada: Gafas de video,Las gafas de realidad aumentada,Cascos de realidad virtual,Otros-" +
                    "Impresoras 3D: impresoras 3D,Otros-" +
                    "Dispositivos de espionaje: dispositivos de vigilancia por video,binoculares,dictáfonos,detectores de mentiras,sensores de movimiento,otros-" +
                    "Relojes inteligentes: Relojes inteligentes,Otros-" +
                    "Dispositivos de juego: Consola,Juegos,Periféricos,Otros-" +
                    "Teléfonos inteligentes: Teléfono,Accesorios,Otros-" +
                    "Aparatos médicos: Aparato médico,Otros-" +
                    "Fitness trackers: Fitness tracker,Otros";

            List<String> listEsp = Arrays.asList(dbEspanol.split("-"));
            List<String> listEng = Arrays.asList(dbIngles.split("-"));
            List<SubFamilia> Aux;
            List<String> auxEsp;
            List<String> auxEng;
            for(int i = 0; i<listEsp.size(); i++)
            {
                Aux = new ArrayList<>();
                auxEsp = Arrays.asList(listEsp.get(i).split(":")[1].split(","));
                auxEng = Arrays.asList(listEng.get(i).split(":")[1].split(","));
                Familia auxFamilia = new Familia();
                for(int j = 0; j < auxEsp.size();j++)
                    Aux.add(new SubFamilia(auxEsp.get(j).trim(),auxEng.get(j).trim(),auxFamilia));
                auxFamilia.setNombre(listEsp.get(i).split(":")[0].trim());
                auxFamilia.setIngles(listEng.get(i).split(":")[0].trim());
                auxFamilia.setSubfamilias(Aux);
                repositorioFamilia.save(auxFamilia);

            }

            return true;
        }
        else
            return false;
    }

    public List<Familia> findAll(){
        //if(repositorioFamilia.findAll().isEmpty())
        //    return new ArrayList<>();
        //else
            return repositorioFamilia.findAll();
    }
}
