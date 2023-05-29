package com.example.aemetaplicacion.clases;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Prediccion {
    //----------1º NIVEL----------
    private String elaborado;
    private String nombre;
    private String prediccion;
    //----------2º NIVEL----------
    private String dia;
    //----------3º NIVEL----------
    private String probPrecipitacion;
    private String cotaNieveProv;
    private String estadoCielo;
    private String viento;
    private String temperatura;
    private String sensTermica;
    private String humedadRelativa;
    private String fecha;
    //----------------------------------------------------
    public Prediccion(String elaborado, String nombre, String prediccion, String dia, String probPrecipitacion, String cotaNieveProv, String estadoCielo, String viento, String temperatura, String sensTermica, String humedadRelativa, String fecha) {
        this.elaborado = elaborado;
        this.nombre = nombre;
        this.prediccion = prediccion;
        this.dia = dia;
        this.probPrecipitacion = probPrecipitacion;
        this.cotaNieveProv = cotaNieveProv;
        this.estadoCielo = estadoCielo;
        this.viento = viento;
        this.temperatura = temperatura;
        this.sensTermica = sensTermica;
        this.humedadRelativa = humedadRelativa;
        this.fecha = fecha;
    }
    //----------------------------------------------------
    public String getElaborado() {
        return elaborado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPrediccion() {
        return prediccion;
    }

    public String getDia() {
        return dia;
    }

    public String getProbPrecipitacion() {
        return probPrecipitacion;
    }

    public String getCotaNieveProv() {
        return cotaNieveProv;
    }

    public String getEstadoCielo() {
        return estadoCielo;
    }

    public String getViento() {
        return viento;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public String getSensTermica() {
        return sensTermica;
    }

    public String getHumedadRelativa() {
        return humedadRelativa;
    }

    public String getFecha() {
        return fecha;
    }
    //----------------------------------------------------

    @Override
    public String toString() {
        return "Prediccion{" +
                "elaborado='" + elaborado + '\'' +
                ", nombre='" + nombre + '\'' +
                ", prediccion='" + prediccion + '\'' +
                ", dia='" + dia + '\'' +
                ", probPrecipitacion='" + probPrecipitacion + '\'' +
                ", cotaNieveProv='" + cotaNieveProv + '\'' +
                ", estadoCielo='" + estadoCielo + '\'' +
                ", viento='" + viento + '\'' +
                ", temperatura='" + temperatura + '\'' +
                ", sensTermica='" + sensTermica + '\'' +
                ", humedadRelativa='" + humedadRelativa + '\'' +
                ", fecha='" + fecha + '\'' +
                '}';
    }
    //-------------METODO PARA QUE LA FECHA ACTUAL COINCIDA CON LA GENERADA CON EL .json----------------
    //-----.json GENERA 7 DIAS, YO SOLO NECESITO EL ACTUAL--------------------


    //-------------METODO PARA CAMBIAR EL FORMATO DE FECHA-------------------------------
    //SimpleDateFormat formatoSalida = new SimpleDateFormat("dd/MM/yyyy");
    //Date date = format.parse(TuFecha);

}
