package ajedrez;

import ajedrez.piezas.Alfil;
import java.util.HashMap;

/**
 *
 * @author paco
 * Tablero de ajedrez
 */

public class Tablero implements ITablero 
{
    private Pieza pieza;
    private final Posicion posicion = new Posicion(0,0);
    private final Alfil[] alfil = new Alfil[4];
    public HashMap<String, Pieza> estado = new HashMap<>();

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
    
    @Override
    public void colocarPiezas()
    {
        // Colocamos los alfiles
        estado.put((new Posicion(0,2)).toString(), alfil[0]);
        System.out.println("colocando " + alfil[0] + " en " + estado);
        estado.put((new Posicion(0,5)).toString(), alfil[1]);
        System.out.println("colocando " + alfil[1] + " en " + estado);
        estado.put((new Posicion(7,2)).toString(), alfil[2]);
        System.out.println("colocando " + alfil[2] + " en " + estado);
        estado.put((new Posicion(7,5)).toString(), alfil[3]);
        System.out.println("colocando " + alfil[3] + " en " + estado);
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
        System.out.println("hay " + estado.get(posicion.toString()));
        return estado.get(posicion.toString());
    }
    /* 
        actualizarEstado:
            actualiza el diccionario estado con la posicion nueva de la pieza 
            movida.
    */
    public void actualizarEstado(Posicion anterior, Posicion actual){
        estado.put(actual.toString(), estado.get(anterior.toString()));
        estado.put(anterior.toString(), null);
    }
}
