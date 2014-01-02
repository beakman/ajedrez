/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez;

/**
 *
 * @author Edu
 */
public interface IPartidaAjedrez {
    static enum Color {Blancas, Negras};

    Jugador empezar();
    void guardarMovimiento(String nombre, Movimientos mov);
}
