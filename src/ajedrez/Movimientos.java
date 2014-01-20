package ajedrez;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author paco
 */

public class Movimientos 
{
    //private Pieza pieza;    
    public final HashMap<Pieza, Movimiento> movimientos = new HashMap<>();
    public ArrayList<String> listado_movimientos = new ArrayList<>();
    
    // Una lista con el color y las 2 posiciones
    // Ejemplo; (blanca, a1, b1) 
//    private ArrayList<String[]> movimientos = new ArrayList<>();
//    String[] mov = new String[3];
    
    public Movimientos()
    {
        
    }
    
    public String getUltimoMovimiento()
    {
        return listado_movimientos.get(listado_movimientos.size()-1);
    }
    
    public void anadirMovimiento(Pieza pieza, Movimiento movimiento)
    {
        listado_movimientos.add(pieza+" "+movimiento);
    }
    
    
/* 
    Método que nos va a devolver si en la posición a la que queremos 
    * movernos hay ya una pieza. Si es de color contrario, tendría que 
    * comérsela si la posición es la misma destino es la misma que ese pieza
    * Si es del mismo color, no se podría mover
    * Si no hay pieza por medio, se puede mover si la posición es permitida
*/
    
   public static EstadoCasilla comprobarEstadoCasilla(Posicion pos, Map dic, Pieza origen){       
       //Recuperamos la pieza que hay en esa posición
       Pieza p = (Pieza) dic.get(pos.toString());;
       Pieza o = origen;
       
       EstadoCasilla resultado;
              
       if(origen == null)
       {
           //Está pinchando una casilla vacía
           resultado = EstadoCasilla.vacia;
           System.out.println("No ha seleccionado ninguna ficha");
       }
       else if((p != null) && (p.color != origen.color))
       {
           // Tienen la misma posición y distinto color -> La mata
           // matarPieza(Pieza o, Pieza p);
           resultado = EstadoCasilla.matar;
           System.out.println("Se puede matar esa pieza");
       }
       else if((p != null) && (p.color == origen.color))
       {
           /* Tienen el mismo color, luego no puede ocupar 
            * esa posición
            */
           resultado = EstadoCasilla.prohibido;
           System.out.println("Tienen el mismo color -> No se puede mover");
       }
       else{
           /* No hay pieza en el destino
            * -> puede moverse el origen
            */
           resultado = EstadoCasilla.mover;
           System.out.println("No hay pieza en el destino ->Puedes moverla");
       }
       
       return resultado;
       
   }
}
