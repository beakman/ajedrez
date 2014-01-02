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
    
    public CtrlAjedrez()
    {

    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String botonPulsado = e.getActionCommand();
        switch (botonPulsado)
        {
            
        }
    }
}
