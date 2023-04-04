package org.example;

import com.opencsv.bean.CsvBindByPosition;

public class Partido {
    @CsvBindByPosition(position = 0)
    private Integer id;
    @CsvBindByPosition(position = 1)

    private String equipo1;
    @CsvBindByPosition(position = 2)

    private Integer goles1;
    @CsvBindByPosition(position = 3)

    private Integer goles2;
    @CsvBindByPosition(position = 4)

    private String equipo2;

    public Integer getId(){
        return id;
    }
    public void setId(Integer id){
        this.id = id;
    }
    public String getEquipo1(){
        return equipo1;
    }
    public void setEquipo1(){
        this.equipo1 = equipo1;
    }
    public Integer getGoles1(){
        return goles1;
    }
    public void setGoles1(Integer goles1){
        this.goles1 = goles1;
    }
    public Integer getGoles2(){
        return goles2;
    }
    public void setGoles2(Integer goles2){
        this.goles2 = goles2;
    }
    public String getEquipo2(){
        return equipo2;
    }
    public void setEquipo2(String equipo2){
        this.equipo2 = equipo2;
    }

    public ResultadoEnum resultado(String equipo){
        ResultadoEnum resultadoReal = null;
        if(equipo1.equals(equipo)) {
            if (this.goles1 > this.goles2) {
                resultadoReal = ResultadoEnum.GANADOR;
            } else if (this.goles1.equals(this.goles2)) {
                resultadoReal = ResultadoEnum.EMPATE;
            } else {
                resultadoReal = ResultadoEnum.PERDEDOR;
            }
        }

        if(equipo2.equals(equipo)) {
            if (this.goles2 > this.goles1) {
                resultadoReal = ResultadoEnum.GANADOR;
            } else if (this.goles2.equals(this.goles1)) {
                resultadoReal = ResultadoEnum.EMPATE;
            } else {
                resultadoReal = ResultadoEnum.PERDEDOR;
            }
        }
        return resultadoReal;
    }

}
