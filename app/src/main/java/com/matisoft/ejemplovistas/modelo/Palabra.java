package com.matisoft.ejemplovistas.modelo;


public class Palabra {
    private String palabra;
    private String traduccion;
    private int foto;

    public Palabra(String palabra, String traduccion, int foto) {
        this.palabra = palabra;
        this.traduccion = traduccion;
        this.foto = foto;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public String getTraduccion() {
        return traduccion;
    }

    public void setTraduccion(String traduccion) {
        this.traduccion = traduccion;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    //public String Traduccion(String palabra){}
}
