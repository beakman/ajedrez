/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import vista.VistaTablero;
import ajedrez.*;
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
    
    public CtrlAjedrez()
    {
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        // ficha seleccionada sera la posicion y ficha del boton pulsado
        boolean fichaSeleccionada = false;
        String botonPulsado = e.getActionCommand();
        // Paco tiene que pasar la posicion de la pieza mirando el boton
        // El boton que se pulsa tiene una pieza y ademas el boton no estaba pulsado antes
        if (fichaSeleccionada.existe && !fichaSeleccionada.posicion.equals(botonPulsado))
        {
            if (pieza.esMovimientoPosible(fichaSeleccionada.posicion))
            {
                pieza.actualizarPosicion(fichaSeleccionada.posicion);
            }
        }
        // El boton que se pulsa es el mismo que se habia pulsado antes
        else if (fichaSeleccionada)
        {
        
        }
    }
    
    
}
