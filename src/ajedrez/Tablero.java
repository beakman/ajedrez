package ajedrez;

import ajedrez.piezas.*;
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
    private final Peon[] peon = new Peon[16];
    private final Alfil[] alfil = new Alfil[4];
    private final Torre[] torre = new Torre[4];
    private final Caballo[] caballo = new Caballo[4];
    private final Rey[] rey = new Rey[2];
    private final Reyna[] reyna = new Reyna[2];
    public final HashMap<String, Pieza> estado = new HashMap<>();

    public Tablero() 
    {
        // Declaramos los peones
        for(int i=0; i<8; i++){
            peon[i] = new Peon(new Posicion(1,i), ajedrez.Color.negra);
            peon[i+8] = new Peon(new Posicion(6,i), ajedrez.Color.blanca);
        }        
        // Declaramos los caballos
        caballo[0] = new Caballo(new Posicion(0,1), ajedrez.Color.negra);
        caballo[1] = new Caballo(new Posicion(0,6), ajedrez.Color.negra);
        caballo[2] = new Caballo(new Posicion(7,1), ajedrez.Color.blanca);
        caballo[3] = new Caballo(new Posicion(7,6), ajedrez.Color.blanca);
        
        // Declaramos los alfiles
        alfil[0] = new Alfil(new Posicion(0,2), ajedrez.Color.negra);
        alfil[1] = new Alfil(new Posicion(0,5), ajedrez.Color.negra);
        alfil[2] = new Alfil(new Posicion(7,2), ajedrez.Color.blanca);
        alfil[3] = new Alfil(new Posicion(7,5), ajedrez.Color.blanca);
        
        // Declaramos las torres
        torre[0] = new Torre(new Posicion(0,0), ajedrez.Color.negra);
        torre[1] = new Torre(new Posicion(0,7), ajedrez.Color.negra);
        torre[2] = new Torre(new Posicion(7,0), ajedrez.Color.blanca);
        torre[3] = new Torre(new Posicion(7,7), ajedrez.Color.blanca);
        
        // Declaramos las reynas
        rey[0] = new Rey(new Posicion(0,4), ajedrez.Color.negra);
        rey[1] = new Rey(new Posicion(7,4), ajedrez.Color.blanca);
        
        // Declaramos los reyes
        reyna[0] = new Reyna(new Posicion(0,3), ajedrez.Color.negra);
        reyna[1] = new Reyna(new Posicion(7,3), ajedrez.Color.blanca);
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
        // Colocamos los peones
        for(int i=0; i<8; i++){
            estado.put(new Posicion(1,i).toString(), peon[i]);
            estado.put(new Posicion(6,i).toString(), peon[i+8]);
        }
        // Colocamos los caballos
        estado.put((new Posicion(0,1)).toString(), caballo[0]);
        estado.put((new Posicion(0,6)).toString(), caballo[1]);
        estado.put((new Posicion(7,1)).toString(), caballo[2]);       
        estado.put((new Posicion(7,6)).toString(), caballo[3]);
        
        // Colocamos los alfiles
        estado.put((new Posicion(0,2)).toString(), alfil[0]);
        estado.put((new Posicion(0,5)).toString(), alfil[1]);
        estado.put((new Posicion(7,2)).toString(), alfil[2]);       
        estado.put((new Posicion(7,5)).toString(), alfil[3]);
        
        // Colocamos las torres
        estado.put((new Posicion(0,0)).toString(), torre[0]);
        estado.put((new Posicion(0,7)).toString(), torre[1]);
        estado.put((new Posicion(7,0)).toString(), torre[2]);       
        estado.put((new Posicion(7,7)).toString(), torre[3]);
        
        // Colocamos lo reyes
        estado.put((new Posicion(0,4)).toString(), rey[0]);
        estado.put((new Posicion(7,4)).toString(), rey[1]);
        
        // Colocamos las reynas
        estado.put((new Posicion(0,3)).toString(), reyna[0]);
        estado.put((new Posicion(7,3)).toString(), reyna[1]);
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
