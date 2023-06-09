package com.example.aemetaplicacion.clases;

public class Clase_Origen { //objeto

    private String productor;
    private String web;
    private String enlace;
    private String language;
    private String copyright;
    private String notaLegal;

    public Clase_Origen(String productor, String web, String enlace, String language, String copyright, String notaLegal) {
        this.productor = productor;
        this.web = web;
        this.enlace = enlace;
        this.language = language;
        this.copyright = copyright;
        this.notaLegal = notaLegal;
    }

    public String getProductor() {
        return productor;
    }

    public void setProductor(String productor) {
        this.productor = productor;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getNotaLegal() {
        return notaLegal;
    }

    public void setNotaLegal(String notaLegal) {
        this.notaLegal = notaLegal;
    }

    @Override
    public String toString() {
        return "Clase_Origen{" +
                "productor='" + productor + '\'' +
                ", web='" + web + '\'' +
                ", enlace='" + enlace + '\'' +
                ", language='" + language + '\'' +
                ", copyright='" + copyright + '\'' +
                ", notaLegal='" + notaLegal + '\'' +
                '}';
    }
}
