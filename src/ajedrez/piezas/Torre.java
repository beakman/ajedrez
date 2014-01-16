/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez.piezas;

import ajedrez.Color;
import ajedrez.Movimientos;
import ajedrez.Pieza;
import ajedrez.Posicion;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author betico
 */
public class Torre extends Pieza{
    Movimientos mov = new Movimientos();
    //Posicion pos;
    int fila_actual;
    int columna_actual;
    char[] filas = {'0','1','2','3','4','5','6','7','8'};
    char[] columnas = {'a','b','c','d','e','f','g','h'};
    Posicion[] result = new Posicion[64];
    ArrayList<Posicion> resultado = new ArrayList<>();
    Color col;
    /**
     *
     */
    
    public Torre(Posicion pos, Color c)
    {
        super(pos,c);
        this.fila_actual = pos.getFila();
        this.columna_actual = pos.getColumna();
        this.color = c; 
    }
    
    public void MostrarTodas()
    {
        this.getMovimientosPosibles();
        System.out.println("MOVIMIENTOS POSIBLES");
        for (Posicion palabra : resultado) {
            System.out.print(palabra+" ");
        }
        System.out.println();
        resultado.clear();
    }
    
    
    @Override
    public Movimientos getMovimientosPosibles() {
         //Al ser una torre tenemos 4 posibles caminos que comprobar 

        int f_aux = posicion.getFila();
        int c_aux = posicion.getColumna();
        
        System.out.println("mala: " + "f_aux= "+ f_aux + "c_aux= " + c_aux);
        
        while(f_aux > 0){
            //Hacia atras
            f_aux--;
            resultado.add(new Posicion(f_aux, c_aux));
            mov.anadirMovimiento("torre", "a", "a");
        }
        
        f_aux = posicion.getFila();
        c_aux = posicion.getColumna();
        while(f_aux < filas.length-2){
            //Hacia delante
            f_aux++;
            resultado.add(new Posicion(f_aux, c_aux));
            mov.anadirMovimiento("torre", "a", "a");
        }
        f_aux = posicion.getFila();
        c_aux = posicion.getColumna();
        while(c_aux > 0){
            // Hacia izquiera
            c_aux--;
            resultado.add(new Posicion(f_aux, c_aux));
            mov.anadirMovimiento("torre", "a", "a");
        }

        f_aux = posicion.getFila();
        c_aux = posicion.getColumna();
        while(c_aux < columnas.length-2){
            // Hacia derecha
            c_aux++;
            resultado.add(new Posicion(f_aux, c_aux));
            mov.anadirMovimiento("torre", "a", "a");
        } 
        return mov;
    }

    @Override
    public boolean esMovimientoPosible(Posicion nuevoDestino) {
        //Aquí la idea es en primer lugar mirar en el array que nos ha devuelto 
        //el método anterior si nuevoDestino está dentro de el y por tanto
        //sería candidato a moverse si no hay otra ficha o alguna por medio
        System.out.println("resultado0= "+resultado.toString());
        Movimientos movimientos = this.getMovimientosPosibles();
        ArrayList<Posicion> arrayLista = new ArrayList<>();
        boolean esposible = false;
        System.out.println("nuevoDestino.fila= "+nuevoDestino.fila);
        System.out.println("nuevoDestino.columna= "+nuevoDestino.columna);
        System.out.println("resultado= "+resultado.toString());
        System.out.println("nuevoDestino= "+nuevoDestino);

        Iterator<Posicion> iterador = resultado.iterator();
        while (iterador.hasNext()){
            Posicion pal = iterador.next();
            if (pal.columna==nuevoDestino.columna && pal.fila==nuevoDestino.fila){
                esposible=true;
            }
        }
        resultado.clear();
        //Habría que comprobar aquí que hay fichas por medio o eso se haría en otro sitio?
        return esposible;

    }

    @Override
    public void actualizarPosicion(Posicion nuevaPosicion) {
        posicion.setColumna(nuevaPosicion.columna);
        posicion.setFila(nuevaPosicion.fila);
    }
    @Override
    public String tipoPieza(){
        return "Torre";
    }
    
   
    @Override
    public String toString(){
        return "Torre "+color.name();
    }
}
