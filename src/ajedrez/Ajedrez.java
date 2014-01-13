package ajedrez;

import vista.VistaTablero;

/**
 *
 * @author Francisco Salido Ruiz
 */

public class Ajedrez {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Tablero tablero = new Tablero();
        VistaTablero juego = new VistaTablero(tablero);
        juego.setVisible(true);        
    }
    
}
