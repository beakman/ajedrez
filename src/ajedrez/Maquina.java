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
        Posicion posible;
        Movimiento movimiento = new Movimiento();
        ArrayList<Movimiento> resultado=new ArrayList<>();
        boolean encontrado = false;
        /*1. - Vamos a buscar la primera ficha que encontremos
         * en el tablero y que puede moverse.
         * 2. - Una vez confirmado que esa ficha puede moverse
         * vamos a moverla de manera aleatoria entre los movimientos
         * posibles que tiene
         */
        
        for(int x=0; (x< 7) && (!encontrado);x++){
            for(int y=0;y<7;y++ ){
                pos.fila = x;
                pos.columna = y;
                System.out.println("En tab.estado.get(pos hay): "+tab.estado.get(new Posicion(x,y).toString()));
                if((tab.estado.get(pos.toString()) != null) && (tab.estado.get(pos.toString()).color == ajedrez.Color.negra)){
                    posible = pos;
                   
                    /*tenemos una posición del tablero con una pieza
                     * Ahora vemos si esa pieza tiene algún movimiento
                     * posible para realizar
                     */
                    //resultado será un arraylist con los posibles movimientos
                    //de la ficha seleccionada
                     //System.out.println("CUAL ES LA MADRE DEL TOPPPOOO"+tab.estado.get(pos.toString()));
                    resultado = tab.getMovimientosPosibles(tab.estado.get(pos.toString()));
                     System.out.println("RESULTADO"+resultado);
                    //ahora entre esos movimientos posibles, vamos a seleccionar uno
                    Iterator<Movimiento> iterador = resultado.iterator();
                    if(resultado !=null)
                    {
                        
                        while (iterador.hasNext()){
                            System.out.println("hallo hijoputa");
                            Movimiento m = iterador.next();
                            if (tab.esMovimientoPosible(m, tab.estado.get(pos.toString()))){
                                System.out.println("JODERRRRRRRR");
                                movimiento =new Movimiento(m.color,m.posActual,m.posDestino);
                                encontrado =true;
                                break;
                            }

                        }
                    }
               }
        }
        }
        
        return movimiento;
        
    }
    
    @Override
    public void guardarMovimiento(String nombre, Movimientos mov) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
