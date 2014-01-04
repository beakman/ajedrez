/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez.piezas;

import ajedrez.Movimientos;
import ajedrez.Pieza;
import ajedrez.Posicion;

/**
 *
 * @author betico
 */
public class Alfil extends Pieza{
    Posicion pos;
    int fila_actual;
    char columna_actual;
    public Alfil(){
        this.fila_actual = pos.getFila();
        this.columna_actual = pos.getColumna();
    }
    
    @Override
    public Movimientos[] getMovimientosPosibles() {
        
        return null;
        
    }

    @Override
    public boolean esMovimientoPosible(Posicion nuevoDestino) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizarPosicion(Posicion nuevaPosicion) {
        pos.setColumna(nuevaPosicion.columna);
        pos.setFila(nuevaPosicion.fila);
    }
    
    
}
