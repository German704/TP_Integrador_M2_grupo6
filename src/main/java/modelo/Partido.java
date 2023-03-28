package modelo;
import modelo.Equipo;
import com.opencsv.bean.CsvBindByPosition;

public class Partido {
    public Partido(Integer id, Equipo equipo1, Equipo equipo2, Integer goles_equipo1, Integer goles_equipo2){
        this.id = id;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.goles_equipo1 = goles_equipo1;
        this.goles_equipo2 = goles_equipo2;
    }
    //private Equipo equipoA;
    //private Equipo equipoB;

    //@CsvBindByPosition(position = 0)
    private Integer id;
    //@CsvBindByPosition(position = 1)
    private Equipo equipo1;
    //@CsvBindByPosition(position = 2)
    private Integer goles_equipo1;
    //@CsvBindByPosition(position = 3)
    private Integer goles_equipo2;
    //@CsvBindByPosition(position = 4)
    private Equipo equipo2;


    public void setId(Integer id){
        this.id = id;
    }
    public void setEquipo1(Equipo equipoA){
        this.equipo1 = equipoA;
        //this.equipo1 = equipoA.getNombre();
    }
    public void setEquipo2(Equipo equipoB){
        this.equipo2 = equipoB;
        //this.equipo2 = equipoB.getNombre();
    }
    public void setGoles_equipo1(Integer goles){
        this.goles_equipo1 = goles;
    }
    public void setGoles_equipo2(Integer goles){
        this.goles_equipo2 = goles;
    }

    /*public String getEquipo1(){
        return equipo1;
    }
    public String getEquipo2(){

        return equipo2;
    }*/
    public Integer getGoles_equipo1(){
        return goles_equipo1;
    }
    public Integer getGoles_equipo2(){
        return goles_equipo2;
    }

    public ResultadoEnum resultado(Integer equipo){
        ResultadoEnum resultadoReal = null;
        if(equipo == equipo1.id()) {
            if (goles_equipo1 > goles_equipo2) {
                resultadoReal = ResultadoEnum.GANADOR;
            } else if (goles_equipo1 == goles_equipo2) {
                resultadoReal = ResultadoEnum.EMPATE;
            } else {
                resultadoReal = ResultadoEnum.PERDEDOR;
            }
        }

        if(equipo == equipo2.id()) {
            if (goles_equipo2 > goles_equipo1) {
                resultadoReal = ResultadoEnum.GANADOR;
            } else if (goles_equipo2 == goles_equipo1) {
                resultadoReal = ResultadoEnum.EMPATE;
            } else {
                resultadoReal = ResultadoEnum.PERDEDOR;
            }
        }
        return resultadoReal;
    }

    public Integer id(){
        System.out.println(id);
        return id;
    }

    public String getData(){
        String info = this.id + ";" + equipo1 + ";" + goles_equipo1 + ";" + goles_equipo2 + ";"+ equipo2;
        System.out.println(info);
        return info;
    }
}
