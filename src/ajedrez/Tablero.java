package ajedrez;

import ajedrez.piezas.Alfil;

/**
 *
 * @author paco
 * Tablero de ajedrez
 */

// Convertido a abstract para poder compilar
public abstract class Tablero implements ITablero 
{
    private Pieza pieza;
    private Posicion posicion;
    private Alfil[] alfil;
    
    @Override
    public boolean esMovimientoPosible(Movimientos mov)
    {
        return pieza.esMovimientoPosible(posicion);
    }
    
    @Override
    public Pieza ejecutarMovimiento(Movimientos mov)
    {
        //pieza.actualizarPosicion();
        if (esMovimientoPosible(mov))
                pieza.actualizarPosicion(posicion);
        return pieza;
    }
    
    @Override
    public void colocarPiezas()
    {
        // Posicion del primer alfil
        posicion.setColumna('c');
        posicion.setFila(8);
        alfil[0].actualizarPosicion(posicion);
        // Posicion del segundo alfil
        posicion.setColumna('f');
        posicion.setFila(8);       
        alfil[1].actualizarPosicion(posicion);
        // Posicion del tercer alfil
        posicion.setColumna('c');
        posicion.setFila(0);
        alfil[2].actualizarPosicion(posicion);    
        // Posicion del cuarto alfil
        posicion.setColumna('f');
        posicion.setFila(0);
        alfil[3].actualizarPosicion(posicion);  
    }
    
    @Override
    public boolean jugadorHaceJaqueMate(Jugador jug)
    {
        return true;
    }
    
}