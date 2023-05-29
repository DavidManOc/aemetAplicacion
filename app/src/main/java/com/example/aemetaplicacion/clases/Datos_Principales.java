package com.example.aemetaplicacion.clases;

public class Datos_Principales {//es una coleccion de objetos, en este caso es un array
    private Clase_Origen origen;
    private String elaborado;
    private String nombre;
    private String provincia;
    private Datos_Prediccion prediccion;
    private String id;
    private String version;
    //----------------------------------------------
    public Datos_Principales(Clase_Origen origen, String elaborado, String nombre, String provincia, Datos_Prediccion prediccion, String id, String version) {
        this.origen = origen;
        this.elaborado = elaborado;
        this.nombre = nombre;
        this.provincia = provincia;
        this.prediccion = prediccion;
        this.id = id;
        this.version = version;
    }

    public Datos_Principales() {
    }

    //----------------------------------------------
    public Clase_Origen getOrigen() {
        return origen;
    }
    public String getElaborado() { return elaborado; }
    public String getNombre() {
        return nombre;
    }
    public String getProvincia() {
        return provincia;
    }
    public Datos_Prediccion getPrediccion() {
        return prediccion;
    }
    public String getId() {
        return id;
    }
    public String getVersion() {
        return version;
    }
    //----------------------------------------------


    public void setOrigen(Clase_Origen origen) {
        this.origen = origen;
    }

    public void setElaborado(String elaborado) {
        this.elaborado = elaborado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    public void setPrediccion(Datos_Prediccion prediccion) {
        this.prediccion = prediccion;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Datos_Prediccion{" +
                "origen='" + origen + '\'' +
                ", elaborado='" + elaborado + '\'' +
                ", nombre='" + nombre + '\'' +
                ", provincia='" + provincia + '\'' +
                ", prediccion='" + prediccion + '\'' +
                ", id='" + id + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}
