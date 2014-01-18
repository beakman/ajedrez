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
public class Movimiento {
    public ajedrez.Color color;
    public Posicion posActual;
    public Posicion posDestino;
    public Movimiento(){
        
    }
    public Movimiento(Color color, Posicion posicion, Posicion posicion0) {
        this.color=color;
        this.posActual=posicion;
        this.posDestino=posicion0;
    }
    
    @Override
    public String toString(){
        return "("+this.color+", "+this.posActual+", "+this.posDestino+")";
    }
}
