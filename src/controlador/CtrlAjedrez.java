/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import vista.VistaTablero;
import ajedrez.*;
import ajedrez.piezas.Alfil;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author paco
 */
public class CtrlAjedrez implements java.awt.event.ActionListener
{
    private VistaTablero tablero;
    private IPieza pieza;
    private IJugador jugador;
    private Posicion posicion;
    private Alfil[] alfil;
    
    public CtrlAjedrez(VistaTablero tablero, Alfil[] alfil, IJugador jugador)
    {
        this.tablero = tablero;
        this.alfil = alfil;
        this.jugador = jugador;
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        // ficha seleccionada sera la posicion y ficha del boton pulsado
        String pos = e.getActionCommand();
        if (!pos.equals(VistaTablero.seleccionAnterior))
        {
            System.out.println(pos);
            System.out.println(VistaTablero.seleccionAnterior);
            
            this.posicion.setFila(Character.getNumericValue(pos.charAt(1)));
            this.posicion.setColumna(pos.charAt(0));
            if (pieza.esMovimientoPosible(this.posicion))
            {
                alfil[0].actualizarPosicion(posicion);
                alfil[1].actualizarPosicion(posicion);
                alfil[2].actualizarPosicion(posicion);
                alfil[3].actualizarPosicion(posicion);
            }
        }
        // El boton que se pulsa tiene una pieza y ademas el boton no estaba pulsado antes
//        if (fichaSeleccionada && posicion.equals())
//        {
//            if (pieza.esMovimientoPosible(posicion))
//            {
//                movimientoFicha(posicion);
//            }
//        }
        // El boton que se pulsa es el mismo que se habia pulsado antes
//        else if (fichaSeleccionada)
//        {
//        
//        }
    }
    
    public void movimientoFicha(Posicion posicion)
    {
        pieza.actualizarPosicion(posicion);
    }
}
