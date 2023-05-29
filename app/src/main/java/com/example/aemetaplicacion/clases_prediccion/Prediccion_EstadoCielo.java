package com.example.aemetaplicacion.clases_prediccion;

public class Prediccion_EstadoCielo {//aqui debo coger la descripcion
    private String value;
    private String periodo;
    //------------------------------------------
    public String getValue() {
        if(this.value.isEmpty()){
            return "0";
        }
        else {
            return value;
        }
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setValue(String value) {
        if(value == ""){
            this.value = "0";
        }
        else{
            this.value = value;
        }

    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    //------------------------------------------

}
