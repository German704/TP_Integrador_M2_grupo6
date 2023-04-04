package org.example;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ronda {
    private String nro;
    private Partido[] partidos;
    private List<Pronostico> pronosticos;

    public Ronda(String nro, Partido[] partidos){
        this.nro = nro;
        this.partidos = partidos;
    }
    public void setPronosticos(List<Pronostico> pronosticos){
        this.pronosticos = pronosticos;
    }

    public void puntosPronostico(List<Partido> lineasPartido, String file){
        int puntos = 0;

        this.pronosticos = new ArrayList<>();

        Pronostico pronostico = null;
        List<String[]> lineasPronostico = null;
        List<String> nombresParticipantes = new ArrayList<>();
        try {
            CSVReader reader = new CSVReaderBuilder(new FileReader(file))
                    .withSkipLines(1)
                    .build();
            List<String[]> nextLine;

            if ((nextLine = reader.readAll()) != null){

                lineasPronostico = nextLine;
            }
        } catch (IOException | CsvValidationException e){
            e.printStackTrace();
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }

        for (String[] lineas : lineasPronostico) {
            for (String lienaPronostico: lineas) {

                String[] campos = lienaPronostico.split(";");

                Equipo equipo1 = new Equipo(campos[1], 1, "seleccionado");
                Equipo equipo2 = new Equipo(campos[5], 2, "seleccionado");
                Partido partido = null;

                for (Partido partidoCol : lineasPartido) {
                    if (partidoCol.getEquipo1().equals(equipo1.getNombre())
                            && partidoCol.getEquipo2().equals(equipo2.getNombre())) {

                        partido = partidoCol;
                    }
                }
                Equipo equipo = null;
                ResultadoEnum resultado = null;
                if ("X".equals(campos[2])) {
                    equipo = equipo1;
                    resultado = ResultadoEnum.GANADOR;
                } else if ("X".equals(campos[3])) {
                    equipo = equipo1;
                    resultado = ResultadoEnum.EMPATE;
                } else if ("X".equals(campos[4])) {
                    equipo = equipo1;
                    resultado = ResultadoEnum.PERDEDOR;
                }

                pronostico = new Pronostico(1, campos[0], partido, equipo.getNombre(), resultado);
                pronosticos.add(pronostico);
               if (!nombresParticipantes.contains(campos[0])) {
                    nombresParticipantes.add(campos[0]);
                }
            }
        }

        System.out.println("nombres participantes: " + nombresParticipantes);

        for (String nombreParticipante : nombresParticipantes){

            for(int x = 0; x < pronosticos.size(); x++){

                if (pronosticos.get(x).getNombre().equals(nombreParticipante)){
                    puntos += pronosticos.get(x).puntos();
                }
            }
            System.out.println("Puntos que gano " + nombreParticipante + ": " + puntos);
            puntos = 0;
        }

    }

}
