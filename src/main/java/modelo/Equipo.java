package modelo;

//import com.opencsv.bean.CsvBindByPosition;
//import com.opencsv.bean.CsvDate;
public class Equipo {
    public Equipo(Integer id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    //@CsvBindByPosition(position = 0)
    private Integer id;
    //@CsvBindByPosition(position = 1)
    private String nombre;
    //@CsvBindByPosition(position = 2)
    private String descripcion;

    public String getData() {
        String equipoInfo = "Equipo: " + id +
                "\nNombre: " + nombre +
                "\nDescripcion: " + descripcion +
                "\n-------------------------------";

        System.out.println(equipoInfo);
        return equipoInfo;
    }

    public Integer id(){
        return id;
    }
    public String getNombre(){
        return nombre;
    }
}