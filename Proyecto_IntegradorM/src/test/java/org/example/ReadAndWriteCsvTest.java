package org.example;

import com.opencsv.exceptions.CsvValidationException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class ReadAndWriteCsvTest {

    @Test
    void csvWriter() throws IOException, CsvValidationException {
        ReadAndWriteCsv readAndWriteCsv = new ReadAndWriteCsv("resultado.csv", "pronostico.csv");
        readAndWriteCsv.csvParse();
        //ArrayList<Equipo> equipos = readAndWriteCsv.listaEquipos();

        //List<Partido> listaPartidos = readAndWriteCsv.getPartidos();
        //for (Partido partido: listaPartidos) {
         //   System.out.println(partido.resultado("arabia"));
        //}
        System.out.println("----------------------------------------------\n"
                + "id| Equipo1 | goles1 | goles2 | Equipo2\n" + "----------------------------------------------");
        for (Partido partido : readAndWriteCsv.getLineasPartido()) {
            System.out.println(partido.getId() + " | " + partido.getEquipo1() + " | " + partido.getGoles1() + " | " + partido.getGoles2() + " | " + partido.getEquipo2() );
        }
        System.out.println("----------------------------------------------");

        System.out.println("los puntos de pronosticos____");
        readAndWriteCsv.ronda.puntosPronostico(readAndWriteCsv.getLineasPartido(), "pronostico.csv");
    }
}