package org.example;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteCsv {

    String fileResultado;
    String filePronostico;

    List<Partido> lineasPartido;
    Partido[] partidos = null;
    public Ronda ronda = null;
    public ReadAndWriteCsv(String fileResultado, String filePronostico){
        this.fileResultado = fileResultado;
        this.filePronostico = filePronostico;
        lineasPartido = new ArrayList<>();
    }


    /*public void csvWriter() throws IOException {

        CSVWriter writer = new CSVWriter(new FileWriter(this.file),
                ';', '"', '\\', CSVWriter.DEFAULT_LINE_END);

        List<String[]> theRaws = new ArrayList<>();
        String[] header = new String[]{"id", "equipo1", "goles1", "goles2", "equipo2"};
        theRaws.add(header);

        String[] raw1 = new String[]{"1", "argen", "2", "2", "arabia"};
        String[] raw2 = new String[]{"2", "argen1", "22", "22", "arabia1"};
        String[] raw3 = new String[]{"3", "argen2", "2", "21", "arabia2"};

        theRaws.add(raw1);
        theRaws.add(raw2);
        theRaws.add(raw3);


        writer.writeAll(theRaws);
        writer.close();
    }*/

    public void csvParse() throws IOException {
        List<Partido> partidoList = null;
        //List<Partido> pronosticoList = null;
        try{
            partidoList = new CsvToBeanBuilder(new FileReader(this.fileResultado))
                    .withSkipLines(1)
                    .withSeparator(';')
                    .withType(Partido.class)
                    .build()
                    .parse();

        }catch (IOException e){
            e.printStackTrace();
        }
        this.lineasPartido = partidoList;
        partidos = new Partido[this.lineasPartido.size()];
        if (!lineasPartido.isEmpty()){
            for (int i = 0; i < this.lineasPartido.size(); i++){
            this.partidos[i] = this.lineasPartido.get(i);
          }
            ronda = new Ronda("1", this.partidos);
        }
    }

    public List<Partido> getLineasPartido(){
        return lineasPartido;
    }
    public ArrayList<Equipo> listaEquipos(){
        boolean equiposSeleccionados = false;
        ArrayList<Equipo> equipos = new ArrayList<>();

        for (Partido lineaPartido : this.lineasPartido) {
            equiposSeleccionados = false;
            Equipo equipo1 = new Equipo(lineaPartido.getEquipo1(), 1, "seleccionado");
            Equipo equipo2 = new Equipo(lineaPartido.getEquipo2(), 2, "seleccionado");

            for (Equipo equipoGuardado : equipos) {
                if (equipo1.getNombre().equals(equipoGuardado.getNombre()) && equipo2.getNombre().equals(equipoGuardado.getNombre())){
                    equiposSeleccionados = true;
                    break;
                }
            }
            if (equiposSeleccionados == false){
                equipos.add(equipo1);
                equipos.add(equipo2);
            }
        }
        return equipos;
    }

    /*public void pronostico() throws IOException, CsvValidationException {
        Pronostico pronostico = null;
        String[] lineasPronostico = null;
        try {
            CSVReader reader = new CSVReaderBuilder(new FileReader(this.filePronostico))
                    .withSkipLines(1)
                    .build();
            String[] nextLine;
            if ((nextLine = reader.readNext()) != null){
                //System.out.println(nextLine[0]);
                lineasPronostico = nextLine;
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        for (String lineaPronostico: lineasPronostico) {

                String[] campos = lineaPronostico.split(";");
                //System.out.println(campos);
                Equipo equipo1 = new Equipo(campos[1], 1, "seleccionado");
                Equipo equipo2 = new Equipo(campos[5], 2, "seleccionado");
                Partido partido = null;

                for (Partido partidoCol : this.lineasPartido){
                    if (partidoCol.getEquipo1().equals(equipo1.getNombre())
                            && partidoCol.getEquipo2().equals(equipo2.getNombre())) {

                        partido = partidoCol;
                    }
                }
                Equipo equipo = null;
                ResultadoEnum resultado = null;
                if ("X".equals(campos[2])){
                    equipo = equipo1;
                    resultado = ResultadoEnum.GANADOR;
                } else if ("X".equals(campos[3])) {
                    equipo = equipo1;
                    resultado = ResultadoEnum.EMPATE;
                }else if ("X".equals(campos[4])) {
                    equipo = equipo1;
                    resultado = ResultadoEnum.PERDEDOR;
                }
                pronostico = new Pronostico(1, "Mariana", partido, equipo.getNombre(), resultado);

        }
        int puntos = pronostico.puntos();
        System.out.println("Puntos que gano " + pronostico.getNombre() + ": " + puntos);

    }*/
}
