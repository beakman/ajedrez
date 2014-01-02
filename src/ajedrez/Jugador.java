package ajedrez;

import ajedrez.IPartidaAjedrez.Color;

/**
 *
 * @author paco
 */
public abstract class Jugador implements IJugador {
    private String nombre;
    private Color color;
    
    @Override
    public void preguntarNombre() {
    
    }
    
    @Override
    public void preguntarColorPiezas() {
    
    }
    
    @Override
    public Movimientos pedirMovimiento(){
        
    }
    
    @Override
    public boolean puedeMover(){
        
    }
    
    @Override
    public void anotarPiezaPerdida(Pieza pieza){
        
    }
}
