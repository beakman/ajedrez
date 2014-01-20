package ajedrez;

import ajedrez.Color;

/**
 *
 * @author paco
 */
public abstract class Jugador implements IJugador{
    private String nombre;
    private Color color;
    private Movimientos movimiento;
    

    
    public Jugador(String nombre, Color color){
        this.nombre = nombre;
        this.color = color;
    }
    
//    @Override
//    public Jugador empezar(){
//        return jugador;
//    }
    
    @Override
    public void preguntarNombre() {
        
    }
    
    @Override
    public void preguntarColorPiezas() {
    
    }
    
    @Override
    public Movimientos pedirMovimiento()
    {
        // Devuelvo un movimiento dummy para poder compilar
        return movimiento;
    }
    
    @Override
    public boolean puedeMover()
    {
        // Devuelve verdadero para poder compilar
        return true;
    }
    
    @Override
    public void anotarPiezaPerdida(Pieza pieza){
        
    }
}
