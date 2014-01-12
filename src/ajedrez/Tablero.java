package ajedrez;

import ajedrez.piezas.Alfil;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author paco
 * Tablero de ajedrez
 */

public class Tablero implements ITablero 
{
    private Pieza pieza;
    private Posicion posicion = new Posicion(0,0);
    private Alfil[] alfil = new Alfil[4];
    public Map<Posicion, Pieza> estado = new HashMap<>();

    public Tablero() 
    {
        alfil[0] = new Alfil(new Posicion(0,2), ajedrez.Color.negra);
        alfil[1] = new Alfil(new Posicion(0,5), ajedrez.Color.negra);
        alfil[2] = new Alfil(new Posicion(7,2), ajedrez.Color.blanca);
        alfil[3] = new Alfil(new Posicion(7,5), ajedrez.Color.blanca);
    }
    
    @Override
    public boolean esMovimientoPosible(Movimientos mov)
    {
        //return pieza.esMovimientoPosible(posicion);
        return true;
    }
    
    @Override
    public Pieza ejecutarMovimiento(Movimientos mov)
    {
        //pieza.actualizarPosicion();
//        if (esMovimientoPosible(mov))
//                pieza.actualizarPosicion(posicion);
        return pieza;
    }
    
    /**
     *
     */
    @Override
    public void colocarPiezas()
    {
//        // Posicion del primer alfil
//        posicion.setColumna('c');
//        posicion.setFila(8);
////        pieza.actualizarPosicion(posicion);
//        alfil[0].actualizarPosicion(posicion);
        estado.put(new Posicion(0,2), alfil[0]);
        System.out.println("colocando " + alfil[0] + " en " + estado);
//        // Posicion del segundo alfil
//        posicion.setColumna('f');
//        posicion.setFila(8);       
//        alfil[1].actualizarPosicion(posicion);
        estado.put(new Posicion(0,5), alfil[1]);
        System.out.println("colocando " + alfil[0] + " en " + estado);
//        // Posicion del tercer alfil
//        posicion.setColumna('c');
//        posicion.setFila(0);
//        alfil[2].actualizarPosicion(posicion);
        estado.put(new Posicion(7,2), alfil[2]);
//        // Posicion del cuarto alfil
//        posicion.setColumna('f');
//        posicion.setFila(0);
//        alfil[3].actualizarPosicion(posicion);
        estado.put(new Posicion(7,5), alfil[3]);
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
    
    public Pieza comprobarPosicion(Posicion posicion)
    {
        System.out.println("En... " + posicion);
        System.out.println("hay " + estado.get(posicion));
        return estado.get(posicion);
    }
}