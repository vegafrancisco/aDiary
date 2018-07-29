package aDiary_data;

public class Dato {
    private String contenido;
    private int fila;
    private int columna;
    
    public Dato(){
        this.contenido = "";
        this.fila = 0;
        this.columna = 0;
    }
    
    public Dato(String contenido, int fila, int columna){
        this.contenido = contenido;
        this.fila = fila;
        this.columna = columna;
    }

    public String getContenido() {
        return contenido;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
    
    @Override
    public String toString(){
        return "Dato: " + this.contenido + "; fila: " + this.fila + "; columna" + this.columna;
    }
 
    
    
    
    
    
}
