package com.example.aemetaplicacion.clases_prediccion;

public class Prediccion_Precipitacion {
    private String value;
    private String periodo;
    //---------------------------------------------

    public String getValue() {
        return value;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setValue(String value) {
        if(value == ""){
            this.value = "0% probabilidad";
        }
        else {
            this.value = value;
        }
    }

    public void setPeriodo(String periodo) { this.periodo = periodo;}
    //---------------------------------------------
    @Override
    public String toString() {
        return "Prediccion_Precipitacion{" +
                ", value='" + value + '\'' +
                ", periodo='" + periodo + '\'' +
                '}';
    }
    //---------------------------------------------

}
