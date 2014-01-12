/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez.piezas;

import ajedrez.Color;
import ajedrez.Movimientos;
import ajedrez.Pieza;
import ajedrez.Posicion;

/**
 *
 * @author betico
 */
public class Alfil extends Pieza{
    Movimientos mov;
    //Posicion pos;
    int fila_actual;
    int columna_actual;
    char[] filas = {'0','1','2','3','4','5','6','7','8'};
    char[] columnas = {'a','b','c','d','e','f','g','h'};
    Posicion[] result;
    Color col;
    /**
     *
     */
    public Alfil(Posicion pos,Color c){
        super(pos,c);
        this.fila_actual = pos.getFila();
        this.columna_actual = pos.getColumna();
        this.color = c; 
    }
    
    @Override
    public Movimientos getMovimientosPosibles() {
        //Al ser un alfil tenemos 4 posibles caminos que comprobar (las 4 esquinas)
        int indice = 0;
        //Esquina superior derecha
        int f_aux = fila_actual;
        int c_aux = new String(columnas).indexOf(columna_actual); //Obtenemos la posición dentro del array
        while((f_aux < filas.length) && (c_aux < columnas.length)){
            
            f_aux++;
            c_aux++;
            result[indice].columna = columnas[c_aux];
            result[indice].fila = f_aux;
            mov.anadirMovimiento("alfil", Integer.toString(c_aux), Integer.toString(c_aux));
            indice++;
        }
        //Esquina inferior derecha
        //Partimos del punto inicial para volver a mirar
        f_aux = fila_actual;
        c_aux = new String(columnas).indexOf(columna_actual);
        while((f_aux > 0) && (c_aux < columnas.length)){       
            f_aux--;
            c_aux++;
            result[indice].columna = columnas[c_aux];
            result[indice].fila = f_aux;
            mov.anadirMovimiento("alfil", Integer.toString(c_aux), Integer.toString(c_aux));
            indice++;
        }
        f_aux = fila_actual;
        c_aux = new String(columnas).indexOf(columna_actual);
        while((f_aux < filas.length) && (c_aux > 0)){
            //Esquina superior izquierda
            f_aux++;
            c_aux--;
            result[indice].columna = columnas[c_aux];
            result[indice].fila = f_aux;
            mov.anadirMovimiento("alfil", Integer.toString(c_aux), Integer.toString(c_aux));
            indice++;
        }
        f_aux = fila_actual;
        c_aux = new String(columnas).indexOf(columna_actual);
        while((f_aux > 0) && (c_aux > 0)){
            //Esquina inferior izquierda
            f_aux--;
            c_aux--;
            result[indice].columna = columnas[c_aux];
            result[indice].fila = f_aux;
            mov.anadirMovimiento("alfil", Integer.toString(c_aux), Integer.toString(c_aux));
            indice++;
        }
        
        //Aquí tenemos que devolver el array result pero ¿De qué tipo?
        return mov;
        
    }

    @Override
    public boolean esMovimientoPosible(Posicion nuevoDestino) {
        //Aquí la idea es en primer lugar mirar en el array que nos ha devuelto 
        //el método anterior si nuevoDestino está dentro de el y por tanto
        //sería candidato a moverse si no hay otra ficha o alguna por medio
        
        Posicion[] array = null; // array de prueba 
        boolean esposible = false;
        int indice = 0; //indice para recorrer el array
        while ((array[indice].fila != nuevoDestino.fila) || (array[indice].columna != nuevoDestino.columna))
        {
            indice++;
        }
        if (indice < array.length)
        {
            esposible = true;
        }
        
        //Habría que comprobar aquí que hay fichas por medio o eso se haría en otro sitio?
        
        return esposible;
        
    }

    @Override
    public void actualizarPosicion(Posicion nuevaPosicion) {
        posicion.setColumna(nuevaPosicion.columna);
        posicion.setFila(nuevaPosicion.fila);
    }
    
    public String toString(){
        return "Alfil "+color.name();
    }
}
