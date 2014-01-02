/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez;

public interface ITablero {
    boolean esMovimientoPosible(Movimiento mov);
    Pieza ejecutarMovimiento(Movimiento mov);
    void colocarPiezas();
    boolean jugadorHaceJaqueMate(Jugador jug);
    
    /**
     * Muestra por pantalla el tablero y las fichas de ajedrez
     */
    void mostrarTablero();
}
