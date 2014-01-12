package ajedrez;

import java.util.ArrayList;

/**
 *
 * @author paco
 */
public class Movimientos 
{
    private Pieza pieza;
    
    // Una lista con el colos y las 2 posicion
    // Ejemplo; (blanca, a1, b1) 
    private ArrayList<String[]> movimientos = new ArrayList<>();
    String[] mov;
    
    public Movimientos()
    {
        mov[0] = "Blanca";
        mov[1] = "a1";
        mov[2] = "b2";
        movimientos.add(mov);
    }
    
    public String[] getUltimoMovimiento()
    {
        return movimientos.get(movimientos.size()-1);
    }
    
    public void anadirMovimiento(String color, String posicionActual, String posicionAnterior )
    {
        mov[0] = color;
        mov[1] = posicionActual;
        mov[2] = posicionAnterior;
        movimientos.add(mov);
    }
}
