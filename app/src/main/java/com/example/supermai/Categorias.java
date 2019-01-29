package com.example.supermai;

public class Categorias {

    private String Nombre;
    private String Descripcion;
    private int Thumbnail;

    public Categorias(){
    }

    public Categorias(String nombre, String descripcion, int thumbnail){
        Nombre = nombre;
        Descripcion = descripcion;
        Thumbnail = thumbnail;
    }

    public String getNombre(){
        return Nombre;
    }

    public String getDescripcion(){
        return Descripcion;
    }

    public int getThumbnail(){
        return Thumbnail;
    }

    public void setNombre(String nombre){
        Nombre = nombre;
    }

    public void setDescripcion(String descripcion){
        Descripcion = descripcion;
    }

    public void setThumbnail(int thumbnail){
        Thumbnail = thumbnail;
    }

}
