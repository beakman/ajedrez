/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
               // pos.setFila(rd.nextInt(7));
                //pos.setColumna(rd.nextInt(7));
                
//                if((tab.estado.get(pos.toString()) != null) && (tab.estado.get(pos.toString()).color == ajedrez.Color.negra)){
                    /*tenemos una posición del tablero con una pieza
                     * Ahora vemos si esa pieza tiene algún movimiento
                     * posible para realizar
                     */
                    //resultado será un arraylist con los posibles movimientos
                    //de la ficha seleccionada
                    List<Pieza> valuesList = new ArrayList<Pieza>(tab.piezas_negras.values());
                    int randomIndex = new Random().nextInt(valuesList.size());
                    Pieza randomValue = valuesList.get(randomIndex);
                    resultado = tab.getMovimientosPosibles(randomValue);
                    if (randomValue.tipoPieza().equals("Torre"))
                        System.out.println("Movimientos torre: "+resultado);
                    //ahora entre esos movimientos posibles, vamos a seleccionar uno
                    
                    if(resultado !=null)
                    {
                        Iterator<Movimiento> iterador = resultado.iterator();
                        Movimiento m = null;
                        System.out.println("size= " + resultado.size());
                        int aleatorio;
                        if (resultado.size()>0)
                            aleatorio = rd.nextInt(resultado.size())+1;
                        else
                            aleatorio = 0;
                        System.out.println("aleatorio= " + aleatorio);
                        
                        for(int i=0; i <= aleatorio-1; i++){
                            m = iterador.next();
                        }
                        System.out.println("m= " + m);
                            if (tab.esMovimientoPosible(m, tab.piezas_negras.get(randomValue.posicion.toString()))){
                                movimiento =new Movimiento(m.color,m.posActual,m.posDestino);
                                encontrado =true;
//                                break;
                            }

                        }
                    }               
//                }
             return movimiento;
            }

       
    
    
    @Override
    public void guardarMovimiento(String nombre, Movimientos mov) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
