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
import ajedrez.Tablero;
/**
 *
 * @author betico
 */
public class Alfil extends Pieza {

    Movimientos mov = new Movimientos();
    //Posicion pos;
    int fila_actual;
    int columna_actual;
    char[] filas = {'0', '1', '2', '3', '4', '5', '6', '7'};
    char[] columnas = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
    Posicion[] result = new Posicion[64];
    ArrayList<Posicion> resultado = new ArrayList<>();
    Color col;
    /**
     *
     */
    public Alfil(Posicion pos, Color c) {
        super(pos, c);
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
        //Al ser un alfil tenemos 4 posibles caminos que comprobar (las 4 esquinas)
        //Esquina superior derecha
        int f_aux = posicion.getFila();
        int c_aux = posicion.getColumna(); //Obtenemos la posición dentro del array
        
        while ((f_aux > 0) && (c_aux < columnas.length-1)) {
            f_aux--;
            c_aux++;
            resultado.add(new Posicion(f_aux, c_aux));
            mov.anadirMovimiento("alfil", "a", "1");
            
        }
        //Esquina inferior derecha
        //Partimos del punto inicial para volver a mirar
        f_aux = posicion.getFila();
        c_aux = posicion.getColumna();
        System.out.println("mala: " + "f_aux= "+ f_aux + "c_aux= " + c_aux);
        while ((f_aux < filas.length-1) && (c_aux < columnas.length-1)) {
            f_aux++;
            c_aux++;
            
            resultado.add(new Posicion(f_aux, c_aux));
            mov.anadirMovimiento("alfil", "a", "1");
        }
        f_aux = posicion.getFila();
        c_aux = posicion.getColumna();
        System.out.println("puta: " + "f_aux= "+ f_aux + "c_aux= " + c_aux);
        while ((f_aux > 0) && (c_aux > 0)) {
            //Esquina superior izquierda
            f_aux--;
            c_aux--;
            resultado.add(new Posicion(f_aux, c_aux));
            mov.anadirMovimiento("alfil", "a", "1");
        }
        f_aux = posicion.getFila();
        c_aux = posicion.getColumna();
        System.out.println("joder: " + "f_aux= "+ f_aux + "c_aux= " + c_aux);
        while ((f_aux < filas.length-1) && (c_aux > 0)) {
            //Esquina inferior izquierda
            f_aux++;
            c_aux--;
            resultado.add(new Posicion(f_aux, c_aux));
            mov.anadirMovimiento("alfil", "a", "1");
            System.out.println("me cago en to: " + "f_aux= "+ f_aux + "c_aux= " + c_aux);
        }
        //Aquí tenemos que devolver el arr ay result pero ¿De qué tipo?       
        return mov;

    }

    @Override
    public boolean esMovimientoPosible(Posicion nuevoDestino) {
        //Aquí la idea es en primer lugar mirar en el array que nos ha devuelto 
        //el método anterior si nuevoDestino está dentro de el y por tanto
        //sería candidato a moverse si no hay otra ficha o alguna por medio
        //System.out.println("resultado0= "+resultado.toString());
        Movimientos movimientos = this.getMovimientosPosibles();
        boolean esposible = false;
        System.out.println("nuevoDestino.fila= "+nuevoDestino.fila);
        System.out.println("nuevoDestino.columna= "+nuevoDestino.columna);
        System.out.println("resultado= "+resultado);
        System.out.println("nuevoDestino= "+nuevoDestino);

        Iterator<Posicion> iterador = resultado.iterator();
        while (iterador.hasNext()){
            Posicion pal = iterador.next();
            if (pal.columna==nuevoDestino.columna && pal.fila==nuevoDestino.fila){
                esposible=true;
            }
        }
        resultado.clear();
        System.out.println("resultadoSIPOTE= "+resultado);
        //Habría que comprobar aquí que hay fichas por medio o eso se haría en otro sitio?
        return esposible;

    }

    @Override
    public void actualizarPosicion(Posicion nuevaPosicion) {
        posicion.setColumna(nuevaPosicion.columna);
        posicion.setFila(nuevaPosicion.fila);
    }

    @Override
    public String toString() {
        return "Alfil " + color.name();
    }
}
