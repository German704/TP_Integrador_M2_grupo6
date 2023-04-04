package org.example;

public class Equipo {
    private Integer id;
    private String nombre;
    private String descripcion;

    public Equipo(String nombre, Integer id, String descripcion){
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    public void setId(Integer id){
        this.id = id;
    }
    public Integer getId(){
        return this.id;
    }
    public void setDescription(String descripcion){
        this.descripcion = descripcion;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public String getNombre(){
        return this.nombre;
    }
}
