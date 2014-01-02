/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez;

/**
 *
 */
public interface IPieza 
{
    Movimiento[] getMovimientosPosibles();
    boolean esMovimientoPosible(Posicion nuevoDestino);
    void actualizarPosicion(Posicion nuevaPosicion);
}
