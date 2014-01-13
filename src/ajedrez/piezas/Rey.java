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
public class Rey extends Pieza{
    Movimientos mov;
    int fila_actual;
    int columna_actual;
    char[] filas = {'0','1','2','3','4','5','6','7','8'};
    char[] columnas = {'a','b','c','d','e','f','g','h'};
    Posicion[] result;
    
    public Rey(Posicion pos, Color c){
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
        
        if((f_aux > 0) && (f_aux < filas.length-1) && (c_aux > 0) && (c_aux < columnas.length-1)){
        //posicion media
            result[indice].columna = c_aux + 1 ;
            result[indice].fila = f_aux;
            indice++;
            result[indice].columna = c_aux;
            result[indice].fila = f_aux + 1;
            indice++;
            result[indice].columna = c_aux;
            result[indice].fila = f_aux - 1;
            indice++;
            result[indice].columna = c_aux - 1 ;
            result[indice].fila = f_aux - 1;
            indice++;
            result[indice].columna =c_aux - 1 ;
            result[indice].fila = f_aux;
            indice++;
            result[indice].columna =c_aux - 1 ;
            result[indice].fila = f_aux +1;
            indice++;
            result[indice].columna =c_aux + 1 ;
            result[indice].fila = f_aux +1;
            indice++;
            result[indice].columna = c_aux + 1 ;
            result[indice].fila = f_aux -1;
        }
        else if((c_aux -1 < 0) && (f_aux-1 <0)){
         //esquina inferior izquierda
            result[indice].columna = c_aux + 1 ;
            result[indice].fila = f_aux;
            indice++;
            result[indice].columna = c_aux + 1 ;
            result[indice].fila = f_aux + 1;
            indice++;
            result[indice].columna = c_aux ;
            result[indice].fila = f_aux+1;
        }
        else if((c_aux - 1 < 0) && (f_aux + 1 > filas.length)){
         //esquina superior izquierda
            result[indice].columna = c_aux + 1 ;
            result[indice].fila = f_aux;
            indice++;
            result[indice].columna = c_aux + 1 ;
            result[indice].fila = f_aux - 1;
            indice++;
            result[indice].columna = c_aux ;
            result[indice].fila = f_aux-1;
        }
        else if((c_aux +1 > columnas.length) && (f_aux +1 > filas.length))
        {
            //esquina superior derecha
            result[indice].columna = c_aux - 1;
            result[indice].fila = f_aux;
            indice++;
            result[indice].columna = c_aux - 1;
            result[indice].fila = f_aux - 1;
            indice++;
            result[indice].columna = c_aux ;
            result[indice].fila = f_aux - 1;
        }
        else if((c_aux +1 > columnas.length) && (f_aux -1 < 0)){
            //esquina inferior derecha
            result[indice].columna = c_aux;
            result[indice].fila = f_aux + 1;
            indice++;
            result[indice].columna = c_aux - 1;
            result[indice].fila = f_aux;
            indice++;
            result[indice].columna = c_aux - 1;
            result[indice].fila = f_aux + 1;
        }
        else if(c_aux - 1 < 0 ){
            //Lateral izquierdo
            result[indice].columna = c_aux;
            result[indice].fila = f_aux + 1;
            indice++;
            result[indice].columna = c_aux;
            result[indice].fila = f_aux - 1;
            indice++;
            result[indice].columna = c_aux + 1;
            result[indice].fila = f_aux + 1;
            indice++;
            result[indice].columna = c_aux + 1;
            result[indice].fila = f_aux;
            indice++;
            result[indice].columna = c_aux + 1;
            result[indice].fila = f_aux -1;
        }
        else if(c_aux + 1 > columnas.length ){
            //Lateral derecho
            result[indice].columna = c_aux;
            result[indice].fila = f_aux + 1;
            indice++;
            result[indice].columna = c_aux;
            result[indice].fila = f_aux - 1;
            indice++;
            result[indice].columna = c_aux - 1;
            result[indice].fila = f_aux + 1;
            indice++;
            result[indice].columna = c_aux - 1;
            result[indice].fila = f_aux;
            indice++;
            result[indice].columna = c_aux - 1;
            result[indice].fila = f_aux -1;
        }
        else if(f_aux + 1 > filas.length ){
            //Superior
            result[indice].columna = c_aux;
            result[indice].fila = f_aux - 1;
            indice++;
            result[indice].columna = c_aux + 1;
            result[indice].fila = f_aux - 1;
            indice++;
            result[indice].columna = c_aux + 1;
            result[indice].fila = f_aux;
            indice++;
            result[indice].columna = c_aux - 1;
            result[indice].fila = f_aux -1;
            indice++;
            result[indice].columna = c_aux - 1;
            result[indice].fila = f_aux;
        }
        else if(f_aux - 1 < 0){
            //Inferior
            result[indice].columna = c_aux;
            result[indice].fila = f_aux + 1;
            indice++;
            result[indice].columna = c_aux - 1;
            result[indice].fila = f_aux;
            indice++;
            result[indice].columna = c_aux + 1;
            result[indice].fila = f_aux;
            indice++;
            result[indice].columna = c_aux - 1;
            result[indice].fila = f_aux +1;
            indice++;
            result[indice].columna = c_aux + 1;
            result[indice].fila = f_aux +1;
        }
            
       
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
    
    @Override
    public String toString(){
        return "Rey "+color.name();
    }
}
