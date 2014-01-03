/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez;
// No sabemos por que esta aqui asi que lo comento para poder compilar
 // Object obj = new Object();

public interface IJugador {
    void preguntarNombre();
    void preguntarColorPiezas();
    
    Movimientos pedirMovimiento();
    boolean puedeMover();
    void anotarPiezaPerdida(Pieza pieza);
}
