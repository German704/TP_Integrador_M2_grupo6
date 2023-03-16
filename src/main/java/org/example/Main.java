package org.example;
import java.io.IOException;
import java.io.FileReader;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

import modelo.Equipo;
import modelo.Partido;
public class Main {
    public static void main(String[] args) throws IOException {
        equipos();
        if (args.length == 0){
            System.out.println("ERROR: No ingresaste ningún archivo como argumento!");
            System.exit(88);
        }

        List<Partido> partidos;
        try{
            partidos = new CsvToBeanBuilder(new FileReader(args[0]))
                    .withType(Partido.class)
                    .build()
                    .parse();

            for (Partido partido : partidos) {
                System.out.println(partido.getData());
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void equipos(){
        Equipo argentina = new Equipo(
                1,
                "Argentina",
                "seleccionado"
        );
        Equipo arabiaS = new Equipo(
                2,
                "Arabia Saudita",
                "seleccionado"
        );

        Partido partido1 = new Partido();
        partido1.setEquipo1(argentina);
        partido1.setGoles_equipo1(1);
        partido1.setEquipo2(arabiaS);
        partido1.setGoles_equipo2(2);
        partido1.setId(1);


    }
}