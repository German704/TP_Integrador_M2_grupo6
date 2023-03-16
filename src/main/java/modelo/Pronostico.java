package modelo;

public class Pronostico{
    public Pronostico(Integer id, String nombre, Partido partido, Integer equipo, String resultado, Integer puntos){
        this.id= id;
        this.nombre = nombre;
        this.equipo = equipo;
        this.partido = partido;
        this.resultado = resultado;
    }

    private Integer id;
    private String nombre;
    private Partido partido;
    private Integer equipo;
    private String resultado;

    public int puntos(){
        int puntos = 0;
        ResultadoEnum resultadotrue = this.partido.resultado(equipo);
        if (resultadotrue.toString().equals(this.resultado.toUpperCase())){
            puntos = 1;
        }
        System.out.println("estos son los puntos que gana mariana: " + puntos);
        return puntos;
    }

    public String getData(){
        String info = "Pronostico: " + id +
                "\nDe: " + nombre +
                "\nEquipo: " + equipo +
                "\nPartido: " + partido.id() +
                "\nResultado: " + resultado +
                "\nPuntos_Obtenidos: " + this.puntos() +
                "\n-------------------------------";

        System.out.println(info);
        return info;
    }
}
