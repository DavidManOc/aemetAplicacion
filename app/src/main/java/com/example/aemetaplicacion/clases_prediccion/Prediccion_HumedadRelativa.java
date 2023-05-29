package com.example.aemetaplicacion.clases_prediccion;

public class Prediccion_HumedadRelativa {
    private String maxima;
    private String minima;
    //--------------------------------------------------
    public String getMaxima() {
        return maxima;
    }

    public String getMinima() { return minima; }

    public void setMaxima(String maxima) {
        this.maxima = maxima;
    }

    public void setMinima(String minima) {
        this.minima = minima;
    }

    //--------------------------------------------------
    @Override
    public String toString() {
        return "Prediccion_HumedadRelativa{" +
                "maxima='" + maxima + '\'' +
                ", minima='" + minima + '\'' +
                '}';
    }
}
