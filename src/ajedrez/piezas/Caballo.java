/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez.piezas;

import ajedrez.Color;
import ajedrez.Movimientos;
import ajedrez.Pieza;
import static ajedrez.Pieza.posicion;
import ajedrez.Posicion;

/**
 *
 * @author betico
 */
public class Caballo extends Pieza{
    Movimientos mov;
    //Posicion pos;
    int fila_actual;
    char columna_actual;
    char[] filas = {'0','1','2','3','4','5','6','7','8'};
    char[] columnas = {'a','b','c','d','e','f','g','h'};
    Posicion[] result;
    /**
     *
     */
    
    public Caballo(Posicion pos, Color c)
    {
        super(pos,c);
        this.fila_actual = pos.getFila();
        this.columna_actual = pos.getColumna();
        this.color = c; 
    }
        
    @Override
    public Movimientos getMovimientosPosibles() 
    {
        int indice = 0;
        // Hay que comprobar las 8 casillas a la que puede acceder el caballo
        int f_aux = fila_actual;
        int c_aux = new String(columnas).indexOf(columna_actual); //Obtenemos la posición dentro del array
        // Primera posicion posible
        f_aux = f_aux - 1;
        c_aux = c_aux + 2;
        mov.anadirMovimiento("caballo", Integer.toString(f_aux), Integer.toString(c_aux));
        // Segunda posiciones posibles
        f_aux = f_aux + 1;
        c_aux = c_aux + 2;
        mov.anadirMovimiento("caballo", Integer.toString(f_aux), Integer.toString(c_aux));
        // Tercera posiciones posibles
        f_aux = f_aux - 1;
        c_aux = c_aux - 2;
        mov.anadirMovimiento("caballo", Integer.toString(f_aux), Integer.toString(c_aux));
        // Cuarta posicion posible
        f_aux = f_aux + 1;
        c_aux = c_aux - 2;
        mov.anadirMovimiento("caballo", Integer.toString(f_aux), Integer.toString(c_aux));
        // Quinta posicion posible
        f_aux = f_aux + 2;
        c_aux = c_aux + 1;
        mov.anadirMovimiento("caballo", Integer.toString(f_aux), Integer.toString(c_aux));
        // Sexta posiciones posibles
        f_aux = f_aux + 2;
        c_aux = c_aux - 1;
        mov.anadirMovimiento("caballo", Integer.toString(f_aux), Integer.toString(c_aux));
        // Septima posiciones posibles
        f_aux = f_aux - 2;
        c_auxpiez = c_aux + 1;
        mov.anadirMovimiento("caballo", Integer.toString(f_aux), Integer.toString(c_aux));
        // Octava posiciones posibles
        f_aux = f_aux - 2;
        c_aux = c_aux - 1;
        mov.anadirMovimiento("caballo", Integer.toString(f_aux), Integer.toString(c_aux));
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
    
}
