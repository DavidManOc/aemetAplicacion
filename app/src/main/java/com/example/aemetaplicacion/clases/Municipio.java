package com.example.aemetaplicacion.clases;

import java.util.Objects;

public class Municipio {
    // atributos
    private String codigo_provincia;
    private String codigo_pueblo;
    private String nombre_pueblo;

    // constructores

    public Municipio(String codigo_provincia, String codigo_pueblo, String nombre_pueblo) {
        this.codigo_provincia = codigo_provincia;
        this.codigo_pueblo = codigo_pueblo;
        this.nombre_pueblo = nombre_pueblo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Municipio)) return false;
        Municipio pueblo = (Municipio) o;
        return Objects.equals(codigo_provincia, pueblo.codigo_provincia) && Objects.equals(codigo_pueblo, pueblo.codigo_pueblo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo_provincia, codigo_pueblo);
    }

    public String getCodigo_provincia() {
        return codigo_provincia;
    }

    public void setCodigo_provincia(String codigo_provincia) {
        this.codigo_provincia = codigo_provincia;
    }

    public String getCodigo_pueblo() {
        return codigo_pueblo;
    }

    public void setCodigo_pueblo(String codigo_pueblo) {
        this.codigo_pueblo = codigo_pueblo;
    }

    public String getNombre_pueblo() {
        return nombre_pueblo;
    }

    public void setNombre_pueblo(String nombre_pueblo) {
        this.nombre_pueblo = nombre_pueblo;
    }

    @Override
    public String toString() {
        return nombre_pueblo;
    }
}
