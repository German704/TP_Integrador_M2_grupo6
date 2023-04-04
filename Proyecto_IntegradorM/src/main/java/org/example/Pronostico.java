package org.example;

public class Pronostico {
    private Integer ronda;
    private String nombre;
    private Partido partido;
    private String equipo;
    private ResultadoEnum resultado;

    public Pronostico(Integer ronda, String nombre, Partido partido, String equipo, ResultadoEnum resultado){
        this.ronda = ronda;
        this.nombre = nombre;
        this.partido = partido;
        this.equipo = equipo;
        this.resultado = resultado;
    }

    public String getNombre(){
        return this.nombre;
    }
    public Partido getPartido(){
        return this.partido;
    }
    public String getEquipo() {
        return this.equipo;
    }
    public void setResultado(ResultadoEnum resultado){
        this.resultado = resultado;
    }
    public ResultadoEnum getResultado(){
        return this.resultado;
    }
    public int puntos(){
        int puntos = 0;
        ResultadoEnum resultadoReal = this.partido.resultado(this.equipo);
        if (resultadoReal.equals(this.resultado)){
            puntos = 1;
        }
        //System.out.println("estos son los puntos que gana mariana: " + puntos);
        return puntos;
    }
}
