package com.example.aemetaplicacion.clases;

import com.example.aemetaplicacion.clases_prediccion.Prediccion_CotaNieve;
import com.example.aemetaplicacion.clases_prediccion.Prediccion_EstadoCielo;
import com.example.aemetaplicacion.clases_prediccion.Prediccion_Fecha;
import com.example.aemetaplicacion.clases_prediccion.Prediccion_HumedadRelativa;
import com.example.aemetaplicacion.clases_prediccion.Prediccion_Precipitacion;
import com.example.aemetaplicacion.clases_prediccion.Prediccion_SensacionTermica;
import com.example.aemetaplicacion.clases_prediccion.Prediccion_Temperatura;
import com.example.aemetaplicacion.clases_prediccion.Prediccion_Viento;

import java.util.ArrayList;

public class Clase_Dia {

    private ArrayList<Prediccion_Precipitacion> probPrecipitacion;
    private ArrayList<Prediccion_CotaNieve> cotaNieveProv;
    private ArrayList<Prediccion_EstadoCielo> estadoCielo;
    private ArrayList<Prediccion_Viento> viento;
    private Prediccion_Temperatura temperatura;
    private Prediccion_SensacionTermica sensTermica;
    private Prediccion_HumedadRelativa humedadRelativa;
    private String fecha;

    public Clase_Dia(ArrayList<Prediccion_Precipitacion> probPrecipitacion, ArrayList<Prediccion_CotaNieve> cotaNieveProv, ArrayList<Prediccion_EstadoCielo> estadoCielo, ArrayList<Prediccion_Viento> viento, Prediccion_Temperatura temperatura, Prediccion_SensacionTermica sensTermica, Prediccion_HumedadRelativa humedadRelativa, String fecha) {
        this.probPrecipitacion = probPrecipitacion;
        this.cotaNieveProv = cotaNieveProv;
        this.estadoCielo = estadoCielo;
        this.viento = viento;
        this.temperatura = temperatura;
        this.sensTermica = sensTermica;
        this.humedadRelativa = humedadRelativa;
        this.fecha = fecha;
    }

    public Clase_Dia() {
    }

    public ArrayList<Prediccion_Precipitacion> getProbPrecipitacion() {
        return probPrecipitacion;
    }

    public void setProbPrecipitacion(ArrayList<Prediccion_Precipitacion> probPrecipitacion) {
        this.probPrecipitacion = probPrecipitacion;
    }

    public ArrayList<Prediccion_CotaNieve> getCotaNieveProv() {
        return cotaNieveProv;
    }

    public void setCotaNieveProv(ArrayList<Prediccion_CotaNieve> cotaNieveProv) {
        this.cotaNieveProv = cotaNieveProv;
    }

    public ArrayList<Prediccion_EstadoCielo> getEstadoCielo() {
        return estadoCielo;
    }

    public void setEstadoCielo(ArrayList<Prediccion_EstadoCielo> estadoCielo) {
        this.estadoCielo = estadoCielo;
    }

    public ArrayList<Prediccion_Viento> getViento() {
        return viento;
    }

    public void setViento(ArrayList<Prediccion_Viento> viento) {
        this.viento = viento;
    }

    public Prediccion_Temperatura getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Prediccion_Temperatura temperatura) {
        this.temperatura = temperatura;
    }

    public Prediccion_SensacionTermica getSensTermica() {
        return sensTermica;
    }

    public void setSensTermica(Prediccion_SensacionTermica sensTermica) {
        this.sensTermica = sensTermica;
    }

    public Prediccion_HumedadRelativa getHumedadRelativa() {
        return humedadRelativa;
    }

    public void setHumedadRelativa(Prediccion_HumedadRelativa humedadRelativa) {
        this.humedadRelativa = humedadRelativa;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Clase_Dia{" +
                "probPrecipitacion=" + probPrecipitacion +
                ", cotaNieveProv=" + cotaNieveProv +
                ", estadoCielo=" + estadoCielo +
                ", viento=" + viento +
                ", temperatura=" + temperatura +
                ", sensTermica=" + sensTermica +
                ", humedadRelativa=" + humedadRelativa +
                ", fecha='" + fecha + '\'' +
                '}';
    }
}
