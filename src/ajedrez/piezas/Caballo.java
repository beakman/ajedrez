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
public class Caballo extends Pieza{
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
    
    public Caballo(Posicion pos, Color c)
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
    }
        
    @Override
    public Movimientos getMovimientosPosibles() 
    {
        // Hay que comprobar las 8 casillas a la que puede acceder el caballo
        int f_aux = posicion.getFila();
        int c_aux = posicion.getColumna(); //Obtenemos la posición dentro del array
        // Primera posicion posible
        if ((f_aux - 1 > 0)&&(c_aux + 2 < columnas.length-1))
        {
            f_aux = f_aux - 1;
            c_aux = c_aux + 2;
            resultado.add(new Posicion(f_aux, c_aux));
            mov.anadirMovimiento("caballo", Integer.toString(f_aux), Integer.toString(c_aux));
        }
 
        f_aux = posicion.getFila();
        c_aux = posicion.getColumna(); //Obtenemos la posición dentro del array
        // Segunda posiciones posibles
        if ((f_aux + 1 < filas.length - 1)&&(c_aux + 2 < columnas.length-1))
        {        
            f_aux = f_aux + 1;
            c_aux = c_aux + 2;
            resultado.add(new Posicion(f_aux, c_aux));
            mov.anadirMovimiento("caballo", Integer.toString(f_aux), Integer.toString(c_aux));
        }
        f_aux = posicion.getFila();
        c_aux = posicion.getColumna(); //Obtenemos la posición dentro del array
        // Tercera posiciones posibles
        if ((f_aux - 1 > 0)&&(c_aux - 2 > 0))
        {
            f_aux = f_aux - 1;
            c_aux = c_aux - 2;
            resultado.add(new Posicion(f_aux, c_aux));
            mov.anadirMovimiento("caballo", Integer.toString(f_aux), Integer.toString(c_aux));
        }
        f_aux = posicion.getFila();
        c_aux = posicion.getColumna(); //Obtenemos la posición dentro del array
        
        // Cuarta posicion posible
        if ((f_aux + 1 < filas.length - 1)&&(c_aux - 2 > 0))
        {        
            f_aux = f_aux + 1;
            c_aux = c_aux - 2;
            resultado.add(new Posicion(f_aux, c_aux));
            mov.anadirMovimiento("caballo", Integer.toString(f_aux), Integer.toString(c_aux));
        }
        f_aux = posicion.getFila();
        c_aux = posicion.getColumna(); //Obtenemos la posición dentro del array
        
        // Quinta posicion posible
        if ((f_aux + 2 < filas.length - 1)&&(c_aux + 1 < columnas.length-1))
        {        
            f_aux = f_aux + 2;
            c_aux = c_aux + 1;
            resultado.add(new Posicion(f_aux, c_aux));
            mov.anadirMovimiento("caballo", Integer.toString(f_aux), Integer.toString(c_aux));
        }
        
        f_aux = posicion.getFila();
        c_aux = posicion.getColumna(); //Obtenemos la posición dentro del array
        // Sexta posiciones posibles
        if ((f_aux + 2 < filas.length - 1)&&(c_aux - 1 > 0))
        {        
            f_aux = f_aux + 2;
            c_aux = c_aux - 1;
            resultado.add(new Posicion(f_aux, c_aux));
            mov.anadirMovimiento("caballo", Integer.toString(f_aux), Integer.toString(c_aux));
        }
        
        f_aux = posicion.getFila();
        c_aux = posicion.getColumna(); //Obtenemos la posición dentro del array
        
        // Septima posiciones posibles
        if ((f_aux - 2 > 0)&&(c_aux + 1 < columnas.length-1))
        {        
            f_aux = f_aux - 2;
            c_aux = c_aux + 1;
            resultado.add(new Posicion(f_aux, c_aux));
            mov.anadirMovimiento("caballo", Integer.toString(f_aux), Integer.toString(c_aux));
        }
        
        f_aux = posicion.getFila();
        c_aux = posicion.getColumna(); //Obtenemos la posición dentro del array
        // Octava posiciones posibles
        if ((f_aux - 2 > 0)&&(c_aux - 1 > 0))
        {        
            f_aux = f_aux - 2;
            c_aux = c_aux - 1;
            resultado.add(new Posicion(f_aux, c_aux));
            mov.anadirMovimiento("caballo", Integer.toString(f_aux), Integer.toString(c_aux));
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
    public String toString(){
        return "Caballo"+color.name();
    }
    
}
