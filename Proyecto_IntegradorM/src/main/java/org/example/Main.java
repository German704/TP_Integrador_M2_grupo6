package org.example;

import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, CsvValidationException {
        if (args.length == 0) {
            System.out.println("ERROR: debe ngresar un nombre de archivo");
            System.exit(88);
        }

        ReadAndWriteCsv readCsv = new ReadAndWriteCsv(args[0], args[1]);
        readCsv.csvParse();

        System.out.println("----------------------------------------------\n"
                + "id| Equipo1 | goles1 | goles2 | Equipo2\n"
                + "----------------------------------------------");
        for (Partido partido : readCsv.getLineasPartido()) {
            System.out.println(partido.getId() + " | " + partido.getEquipo1() + " | " + partido.getGoles1() + " | " + partido.getGoles2() + " | " + partido.getEquipo2());
        }
        System.out.println("----------------------------------------------");


        System.out.println("los puntos de pronosticos____");
        readCsv.ronda.puntosPronostico(readCsv.getLineasPartido(), args[1]);
    }
}