/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ajedrez;

/**
 *
 * @author paco
 */
public abstract class Pieza implements IPieza {
    public static Posicion posicion;
    public Color color;
    
    //implementacion del constructor de la clase Pieza
    /* El contructor va a recibir la posicion
     * de la pieza al crearla y su color
     */
    public Pieza(Posicion pos, Color col){
        this.posicion = pos;
        this.color = col;
    }
}
