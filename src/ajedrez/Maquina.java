/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 *
 * @author betico
 */
public class Maquina extends Jugador{
    Tablero tab;
    public Maquina(Tablero t)
    {
        this.tab = t;
        //System.out.println("En tab.estado: "+tab.estado);
    }
    
    public Movimiento hacerMovimiento(){
        Random rd = new Random();
        Posicion pos = new Posicion(1,1);
        Movimiento movimiento = new Movimiento();
        ArrayList<Movimiento> resultado=new ArrayList<>();
        boolean encontrado = false;
        
        /*1. - Vamos a buscar la primera ficha que encontremos
         * en el tablero y que puede moverse.
         * 2. - Una vez confirmado que esa ficha puede moverse
         * vamos a moverla de manera aleatoria entre los movimientos
         * posibles que tiene
         */
        

            while (!encontrado)
                {
                pos.setFila(rd.nextInt(7));
                pos.setColumna(rd.nextInt(7));
                System.out.println("* En tab.estado.get(pos hay): "+tab.estado.get(pos.toString()));
                if((tab.estado.get(pos.toString()) != null) && (tab.estado.get(pos.toString()).color == ajedrez.Color.negra)){
                    /*tenemos una posición del tablero con una pieza
                     * Ahora vemos si esa pieza tiene algún movimiento
                     * posible para realizar
                     */
                    //resultado será un arraylist con los posibles movimientos
                    //de la ficha seleccionada
                     
                    resultado = tab.getMovimientosPosibles(tab.estado.get(pos.toString()));
                    System.out.println("resultado= "+resultado);
                    //ahora entre esos movimientos posibles, vamos a seleccionar uno
                    
                    if(resultado !=null)
                    {
                        Iterator<Movimiento> iterador = resultado.iterator();
                        while (iterador.hasNext()){
                            Movimiento m = iterador.next();
                            if (tab.esMovimientoPosible(m, tab.estado.get(pos.toString()))){
                                movimiento =new Movimiento(m.color,m.posActual,m.posDestino);
                                encontrado =true;
                                
                            }

                        }
                    }               
                }
            }

        System.out.println("Cabrona, eres un BLANCA??: "+movimiento);
        return movimiento;
    }
    
    @Override
    public void guardarMovimiento(String nombre, Movimientos mov) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
