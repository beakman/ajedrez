package ajedrez;

/**
 *
 * @author paco
 */
public class Posicion {
    //Los cambio de private a public
    public int fila;
    public char columna;
    
    
    //Getters
    public int getFila() {
        return fila;
    }

    public char getColumna() {
        return columna;
    }

    //Setters
    public void setFila(int fila) {
        this.fila = fila;
    }

    public void setColumna(char columna) {
        this.columna = columna;
    }
    
}
