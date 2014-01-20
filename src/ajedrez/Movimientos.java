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
     
}
