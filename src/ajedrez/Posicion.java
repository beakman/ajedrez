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
    
    @Override
    public String toString(){
        char[] c = {'a','b','c','d','e','f','g','h'};
        char[] f = {'8','7','6','5','4','3','2','1'};
        String s = new StringBuilder().append(c[columna]).append(f[fila]).toString();
        return s;
    }
    
}
