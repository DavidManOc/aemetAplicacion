package com.example.aemetaplicacion.clases_prediccion;

public class Prediccion_Temperatura {
    private String maxima;
    private String minima;

    public Prediccion_Temperatura(String maxima, String minima) {
        this.maxima = maxima;
        this.minima = minima;
    }

    //------------------------------------------------------------
    public String getMaxima() {
        return maxima;
    }

    public String getMinima() {
        return minima;
    }

    public void setMaxima(String maxima) {
        this.maxima = maxima;
    }

    public void setMinima(String minima) {
        this.minima = minima;
    }

    //------------------------------------------------------------
    @Override
    public String toString() {
        return "Prediccion_Temperatura{" +
                ", maxima='" + maxima + '\'' +
                ", minima='" + minima + '\'' +
                '}';
    }
}
