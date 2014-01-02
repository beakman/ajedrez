/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez;
 Object obj = new Object();

public interface IJugador {
    void preguntarNombre();
    void preguntarColorPiezas();
    
    Movimientos pedirMovimiento();
    boolean puedeMover();
    void anotarPiezaPerdida(Pieza pieza);
}
