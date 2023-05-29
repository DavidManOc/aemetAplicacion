package com.example.aemetaplicacion.clases;

import java.util.ArrayList;

public class Datos_Prediccion {
    private ArrayList<Clase_Dia> dia; // es una coleccion de objetos
    //---------------------------------------------
    public Datos_Prediccion(ArrayList<Clase_Dia> dia) {
        this.dia = dia;
    }

    public Datos_Prediccion() {
    }

    //---------------------------------------------
    public ArrayList<Clase_Dia> getDia() {
        return dia;
    }

    public void setDia(ArrayList<Clase_Dia> dia) {
        this.dia = dia;
    }
    //---------------------------------------------
    @Override
    public String toString() {
        return "Datos_Prediccion{" +
                "dia='" + dia + '\'' +
                '}';
    }
}
