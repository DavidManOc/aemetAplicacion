package com.example.aemetaplicacion.clases_prediccion;

public class Prediccion_Fecha {
    private String fecha;
    //---------------------------------------------
    public Prediccion_Fecha(String fecha) {
        this.fecha = fecha;
    }
    //---------------------------------------------
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) { this.fecha = fecha; }
    //---------------------------------------------
    @Override
    public String toString() {
        return "Prediccion_Fecha{" +
                "fecha='" + fecha + '\'' +
                '}';
    }
}
