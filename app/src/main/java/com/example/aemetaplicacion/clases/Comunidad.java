package com.example.aemetaplicacion.clases;

public class Comunidad {

    private String nombre_Comunidad;
    private String codigo_Comunidad;
    //-----------------
    public Comunidad(String nombre_Comunidad, String codigo_Comunidad) {
        this.nombre_Comunidad = nombre_Comunidad;
        this.codigo_Comunidad = codigo_Comunidad;
    }
    //-----------------
    public String getNombre_Comunidad() {
        return nombre_Comunidad;
    }

    public void setNombre_Comunidad(String nombre_Comunidad) {
        this.nombre_Comunidad = nombre_Comunidad;
    }

    public String getCodigo_Comunidad() {
        return codigo_Comunidad;
    }

    public void setCodigo_Comunidad(String codigo_Comunidad) {
        this.codigo_Comunidad = codigo_Comunidad;
    }
    //-----------------
    @Override
    public String toString() { return nombre_Comunidad; }
}
