package ajedrez;

import ajedrez.piezas.Alfil;

/**
 *
 * @author paco
 * Tablero de ajedrez
 */

public class Tablero implements ITablero 
{
    private Pieza pieza;
    private Posicion posicion = new Posicion();
    private Alfil[] alfil = new Alfil[4];

    public Tablero() 
    {
        alfil[0] = new Alfil();
        alfil[1] = new Alfil();
        alfil[2] = new Alfil();
        alfil[3] = new Alfil();
    }
    
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
//        pieza.actualizarPosicion(posicion);
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

    @Override
    public void mostrarTablero() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}