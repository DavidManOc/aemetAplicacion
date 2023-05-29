package com.example.aemetaplicacion.clases_prediccion;

public class Prediccion_Viento {
    private String direccion;
    private String velocidad;
    private String periodo;
    //--------------------------------------------------------

    public String getDireccion() {
        return direccion;
    }

    public String getVelocidad() {
        return velocidad;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setVelocidad(String velocidad) {
        this.velocidad = velocidad;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    //--------------------------------------------------------
    @Override
    public String toString() {
        return "Prediccion_Viento{" +
                ", direccion='" + direccion + '\'' +
                ", velocidad='" + velocidad + '\'' +
                ", periodo='" + periodo + '\'' +
                '}';
    }
}
