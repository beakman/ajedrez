package ajedrez;
 
import ajedrez.piezas.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
 
/**
 *
 * @author paco
 * Tablero de ajedrez
 */
 
public class Tablero implements ITablero
{
    private Pieza pieza;
    private final Posicion posicion = new Posicion(0,0);
    private final Peon[] peon = new Peon[16];
    private final Alfil[] alfil = new Alfil[4];
    private final Torre[] torre = new Torre[4];
    private final Caballo[] caballo = new Caballo[4];
    private final Rey[] rey = new Rey[2];
    private final Reyna[] reyna = new Reyna[2];
    public final HashMap<String, Pieza> estado = new HashMap<>();
    public final HashMap<String, Pieza> piezas_negras = new HashMap<>();
    public final HashMap<String, Pieza> piezas_blancas = new HashMap<>();
 
    public Tablero()
    {
        // Declaramos los peones
        for(int i=0; i<8; i++){
            peon[i] = new Peon(new Posicion(1,i), ajedrez.Color.negra);
            peon[i+8] = new Peon(new Posicion(6,i), ajedrez.Color.blanca);
        }        
        // Declaramos los caballos
        caballo[0] = new Caballo(new Posicion(0,1), ajedrez.Color.negra);
        caballo[1] = new Caballo(new Posicion(0,6), ajedrez.Color.negra);
        caballo[2] = new Caballo(new Posicion(7,1), ajedrez.Color.blanca);
        caballo[3] = new Caballo(new Posicion(7,6), ajedrez.Color.blanca);
       
        // Declaramos los alfiles
        alfil[0] = new Alfil(new Posicion(0,2), ajedrez.Color.negra);
        alfil[1] = new Alfil(new Posicion(0,5), ajedrez.Color.negra);
        alfil[2] = new Alfil(new Posicion(7,2), ajedrez.Color.blanca);
        alfil[3] = new Alfil(new Posicion(7,5), ajedrez.Color.blanca);
       
        // Declaramos las torres
        torre[0] = new Torre(new Posicion(0,0), ajedrez.Color.negra);
        torre[1] = new Torre(new Posicion(0,7), ajedrez.Color.negra);
        torre[2] = new Torre(new Posicion(7,0), ajedrez.Color.blanca);
        torre[3] = new Torre(new Posicion(7,7), ajedrez.Color.blanca);
       
        // Declaramos las reynas
        rey[0] = new Rey(new Posicion(0,4), ajedrez.Color.negra);
        rey[1] = new Rey(new Posicion(7,4), ajedrez.Color.blanca);
       
        // Declaramos los reyes
        reyna[0] = new Reyna(new Posicion(0,3), ajedrez.Color.negra);
        reyna[1] = new Reyna(new Posicion(7,3), ajedrez.Color.blanca);
    }
   
    @Override
    public boolean esMovimientoPosible(Movimiento mov, Pieza pieza)
    {
        boolean esposible=false;
        Iterator<Movimiento> iterador = this.getMovimientosPosibles(pieza).iterator();
        while (iterador.hasNext()){
            Movimiento m = iterador.next();
            if (m.posDestino.fila==mov.posDestino.fila && m.posDestino.columna==mov.posDestino.columna){
                esposible=true;
            }
        }
        return esposible;
    }
   
    public ArrayList<Movimiento> getMovimientosPosibles(Pieza pieza)
    {
        ArrayList<Movimiento> resultado=new ArrayList<>();
        resultado.clear();
       
        if (pieza.tipoPieza().equals("Peon")){
            resultado = getMovimientosPeon(pieza);
        }
       
        if (pieza.tipoPieza().equals("Torre"))
            resultado = getMovimientosTorre(pieza);
       
        if (pieza.tipoPieza().equals("Caballo"))
        {
            resultado = getMovimientosCaballo(pieza);
        }
       
        if (pieza.tipoPieza().equals("Reyna"))
        {
            resultado = getMovimientosReyna(pieza);
        }
       
        if (pieza.tipoPieza().equals("Alfil"))
        {
            resultado = getMovimientosAlfil(pieza);
        }
       
        if (pieza.tipoPieza().equals("Rey"))
        {
            resultado = getMovimientosRey(pieza);  
        }
 
        return resultado;
    }
    private boolean hayPieza(Posicion nueva)
    {
        return (estado.get(nueva.toString()) != null);
    }
    @Override
    public Pieza ejecutarMovimiento(Movimientos mov)
    {
        //pieza.actualizarPosicion();
//        if (esMovimientoPosible(mov))
//                pieza.actualizarPosicion(posicion);
        return pieza;
    }
   
    @Override
    public void colocarPiezas()
    {
        // Colocamos los peones
        for(int i=0; i<8; i++){
            estado.put(new Posicion(1,i).toString(), peon[i]);
            piezas_negras.put(new Posicion(1,i).toString(), peon[i]);
            estado.put(new Posicion(6,i).toString(), peon[i+8]);
            piezas_blancas.put(new Posicion(6,i).toString(), peon[i+8]);
        }
        // Colocamos los caballos
        estado.put((new Posicion(0,1)).toString(), caballo[0]);
        piezas_negras.put((new Posicion(0,1)).toString(), caballo[0]);
        estado.put((new Posicion(0,6)).toString(), caballo[1]);
        piezas_negras.put((new Posicion(0,6)).toString(), caballo[1]);
        estado.put((new Posicion(7,1)).toString(), caballo[2]);  
        piezas_blancas.put((new Posicion(7,1)).toString(), caballo[2]);  
        estado.put((new Posicion(7,6)).toString(), caballo[3]);
        piezas_blancas.put((new Posicion(7,6)).toString(), caballo[3]);
       
        // Colocamos los alfiles
        estado.put((new Posicion(0,2)).toString(), alfil[0]);
        piezas_negras.put((new Posicion(0,2)).toString(), alfil[0]);
        estado.put((new Posicion(0,5)).toString(), alfil[1]);
        piezas_negras.put((new Posicion(0,5)).toString(), alfil[1]);
        estado.put((new Posicion(7,2)).toString(), alfil[2]);
        piezas_blancas.put((new Posicion(7,2)).toString(), alfil[2]);
        estado.put((new Posicion(7,5)).toString(), alfil[3]);
        piezas_blancas.put((new Posicion(7,5)).toString(), alfil[3]);
               
        // Colocamos las torres
        estado.put((new Posicion(0,0)).toString(), torre[0]);
        piezas_negras.put((new Posicion(0,0)).toString(), torre[0]);
        estado.put((new Posicion(0,7)).toString(), torre[1]);
        piezas_negras.put((new Posicion(0,7)).toString(), torre[1]);
        estado.put((new Posicion(7,0)).toString(), torre[2]);  
        piezas_blancas.put((new Posicion(7,0)).toString(), torre[2]);  
        estado.put((new Posicion(7,7)).toString(), torre[3]);
        piezas_blancas.put((new Posicion(7,7)).toString(), torre[3]);
       
        // Colocamos lo reyes
        estado.put((new Posicion(0,4)).toString(), rey[0]);
        piezas_negras.put((new Posicion(0,4)).toString(), rey[0]);
        estado.put((new Posicion(7,4)).toString(), rey[1]);
        piezas_blancas.put((new Posicion(7,4)).toString(), rey[1]);
       
        // Colocamos las reynas
        estado.put((new Posicion(0,3)).toString(), reyna[0]);
        piezas_negras.put((new Posicion(0,3)).toString(), reyna[0]);
        estado.put((new Posicion(7,3)).toString(), reyna[1]);
        piezas_blancas.put((new Posicion(7,3)).toString(), reyna[1]);
    }
   
    @Override
    public boolean jugadorHaceJaqueMate(Jugador jug)
    {
        return true;
    }
   
    public Pieza comprobarPosicion(Posicion posicion)
    {
        return estado.get(posicion.toString());
    }
    /*
        actualizarEstado:
            actualiza el diccionario estado con la posicion nueva de la pieza
            movida.
    */
    public void actualizarEstado(Posicion anterior, Posicion actual){
       
        if(estado.get(anterior.toString()).color == ajedrez.Color.negra)
        {
            piezas_negras.put(actual.toString(), piezas_negras.get(anterior.toString()));
            piezas_negras.remove(anterior.toString());
        }
        else if(estado.get(anterior.toString()).color == ajedrez.Color.blanca)
        {
            piezas_blancas.put(actual.toString(), piezas_blancas.get(anterior.toString()));
            //piezas_blancas.put(anterior.toString(), null);
            piezas_blancas.remove(anterior.toString());
        }
        estado.put(actual.toString(), estado.get(anterior.toString()));
        estado.remove(anterior.toString());
    }
   
    public ArrayList<Movimiento> getMovimientosPosiblesBlancas()
    {
        ArrayList<Movimiento> resultado = new ArrayList<>();
       
        Pieza p;
        for (int i=0; i<7 ;i++)
        {
            for (int j=0; j<7; j++)
            {
                if (hayPieza((new Posicion(i,j))))
                {
                    p = this.estado.get(new Posicion(i,j).toString());
                    if(p.color == Color.blanca)
                    {
                        resultado.addAll(getMovimientosPosibles(p));
                    }
                }
            }
        }
        return resultado;
    }
   
    public ArrayList<Movimiento> getMovimientosPosiblesNegras()
    {
        ArrayList<Movimiento> resultado = new ArrayList<>();
       
        Pieza p;
        for (int i=0; i<7 ;i++)
        {
            for (int j=0; j<7; j++)
            {
                if (hayPieza((new Posicion(i,j))))
                {
                    p = this.estado.get(new Posicion(i,j).toString());
                    if(p.color == Color.blanca)
                    {
                        resultado.addAll(getMovimientosPosibles(p));
                    }
                }
            }
        }
        return resultado;
    }
   
    public boolean comprobarJaque(Pieza pieza)
    {
        boolean jaque = false;
        ArrayList<Movimiento> mov=new ArrayList<>();
       
        if (pieza.tipoPieza().equals("Torre"))
        {
            mov = getMovimientosTorre(pieza);
           
            for (int i=0; i<mov.size(); i++)
            {
                if (hayPieza(mov.get(i).posDestino))
                {
                    if ( (pieza.color != this.estado.get(mov.get(i).posDestino.toString()).color) && ( this.estado.get(mov.get(i).posDestino.toString()).tipoPieza().toString().equals("Rey") ) )
                    {
                        jaque = true;
                        // le paso como argumento el rey que esta en jaque
                        comprobarJaqueMate(this.estado.get(mov.get(i).posDestino.toString()));
                        System.out.println("El rey esta en JAQUE");
                    }
                }
            }
        }
       
        if (pieza.tipoPieza().equals("Alfil"))
        {
            mov = getMovimientosAlfil(pieza);
           
            for (int i=0; i<mov.size(); i++)
            {
                if (hayPieza(mov.get(i).posDestino))
                {
                    if ( (pieza.color != this.estado.get(mov.get(i).posDestino.toString()).color) && ( this.estado.get(mov.get(i).posDestino.toString()).tipoPieza().toString().equals("Rey") ) )
                    {
                        jaque = true;
                        // le paso como argumento el rey que esta en jaque
                        comprobarJaqueMate(this.estado.get(mov.get(i).posDestino.toString()));
                    }
                }
            }
        }
        if (pieza.tipoPieza().equals("Peon"))
        {
            mov = getMovimientosPeon(pieza);
           
            for (int i=0; i<mov.size(); i++)
            {
                if (hayPieza(mov.get(i).posDestino))
                {
                    if ( (pieza.color != this.estado.get(mov.get(i).posDestino.toString()).color) && ( this.estado.get(mov.get(i).posDestino.toString()).tipoPieza().toString().equals("Rey") ) )
                    {
                        jaque = true;
                        // le paso como argumento el rey que esta en jaque
                        comprobarJaqueMate(this.estado.get(mov.get(i).posDestino.toString()));
                    }
                }
            }
        }    
       
        if (pieza.tipoPieza().equals("Reyna"))
        {
            mov = getMovimientosReyna(pieza);
           
            for (int i=0; i<mov.size(); i++)
            {
                if (hayPieza(mov.get(i).posDestino))
                {
                    if ( (pieza.color != this.estado.get(mov.get(i).posDestino.toString()).color) && ( this.estado.get(mov.get(i).posDestino.toString()).tipoPieza().toString().equals("Rey") ) )
                    {
                        jaque = true;
                        // le paso como argumento el rey que esta en jaque
                        comprobarJaqueMate(this.estado.get(mov.get(i).posDestino.toString()));
                    }
                }
            }
        }
       
        if (pieza.tipoPieza().equals("Caballo"))
        {
            mov = getMovimientosCaballo(pieza);
           
            for (int i=0; i<mov.size(); i++)
            {
                if (hayPieza(mov.get(i).posDestino))
                {
                    if ( (pieza.color != this.estado.get(mov.get(i).posDestino.toString()).color) && ( this.estado.get(mov.get(i).posDestino.toString()).tipoPieza().toString().equals("Rey") ) )
                    {
                        jaque = true;
                        // le paso como argumento el rey que esta en jaque
                        comprobarJaqueMate(this.estado.get(mov.get(i).posDestino.toString()));
                    }
                }
            }
        }
       
        return jaque;
    }
   
    public boolean comprobarJaqueMate(Pieza pieza_en_jaque)
    {
        ArrayList<Movimiento> resultado = new ArrayList<>();
        ArrayList<Movimiento> movRey = new ArrayList<>();
       
        if (pieza_en_jaque.color == Color.negra)
        {
            resultado = getMovimientosPosiblesBlancas();
        }
        else
        {
            resultado = getMovimientosPosiblesNegras();            
        }
        // La posicion del rey amenazado se detecta bien
        int fila_aux = pieza_en_jaque.posicion.getFila();
        int col_aux = pieza_en_jaque.posicion.getColumna();
        System.out.println("fila " + fila_aux);
        System.out.println("columna " + col_aux);
        System.out.println(resultado);
        System.out.println(resultado.size());
       
       
        movRey = getMovimientosPosibles(pieza_en_jaque);
        System.out.println(movRey);
        int i = 0;
        int j = 0;
        boolean jaqueMate = true;
        boolean jaqueMateInt = false;
       
        while(i<movRey.size() && jaqueMate)
        {
            j = 0;
            jaqueMateInt = false;
            System.out.println("hola");
            while(j<resultado.size())
            {
                if (movRey.get(i) == resultado.get(j))
                    jaqueMateInt = true;
                j++;
            }
            if (jaqueMateInt == true)
                jaqueMate = true;
            else
                jaqueMate = false;
            i++;
        }
       
        if (jaqueMate)
            System.out.println("JAQUE MATEEEEEEEE ");
        return jaqueMate;
    }
   
    public ArrayList<Movimiento> getMovimientosPeon(Pieza pieza)
    {
         ArrayList<Movimiento> resultado=new ArrayList<>();
         resultado.clear();
         if (pieza.tipoPieza().equals("Peon")){
            // Hay que comprobar las 1 casilla
            //Color color = this.col;
           
            int f_aux = pieza.posicion.getFila();
            int c_aux = pieza.posicion.getColumna(); //Obtenemos la posición dentro del array
            // Primera posicion posible
            if((f_aux > 0)&& (pieza.color == Color.blanca))
            {
                if (f_aux == 6){
                    if(!hayPieza(new Posicion(f_aux - 2, c_aux))){
                        resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux - 2, c_aux)));
                    }
                }
                f_aux=f_aux-1;
                if(!hayPieza(new Posicion(f_aux, c_aux))){
                    resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux)));
                    if(c_aux<7 && c_aux>0){
                        if(hayPieza(new Posicion(f_aux, c_aux+1)) && (pieza.color != this.estado.get(new Posicion(f_aux, c_aux+1).toString()).color))
                            resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux+1)));
                        if(hayPieza(new Posicion(f_aux, c_aux-1)) && (pieza.color != this.estado.get(new Posicion(f_aux, c_aux-1).toString()).color))
                            resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux-1)));
                    }
                    else if(c_aux==7){                        
                        resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux-1)));
                    }
                    else if(c_aux==0){
                        resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux+1)));
                    }
                }
                System.out.println("Movimientos peón blanco: "+resultado);
            }
            else if((f_aux < 7) && (pieza.color == Color.negra))
            {
                if (f_aux == 1){
                    if(!hayPieza(new Posicion(f_aux + 2, c_aux)))
                        resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux + 2, c_aux)));
                }
                f_aux = f_aux + 1;
                if(!hayPieza(new Posicion(f_aux, c_aux)))
                    resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux)));
                if(c_aux<7 && c_aux>0){
                    if(hayPieza(new Posicion(f_aux, c_aux+1)) && (pieza.color != this.estado.get(new Posicion(f_aux, c_aux+1).toString()).color))
                        resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux+1)));
                    if(hayPieza(new Posicion(f_aux, c_aux-1)) && (pieza.color != this.estado.get(new Posicion(f_aux, c_aux-1).toString()).color))
                        resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux-1)));
                }
                else if(c_aux==7){                        
                    resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux-1)));
                }
                else if(c_aux==0){
                    resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux+1)));
                }
                System.out.println("Movimientos peón negro: "+resultado);
            }
        }
        return resultado;
    }
   
   
    public ArrayList<Movimiento> getMovimientosTorre(Pieza pieza)
    {
        ArrayList<Movimiento> resultado=new ArrayList<>();
        resultado.clear();
        if (pieza.tipoPieza().equals("Torre"))
        {
            // Hay que comprobar las 1 casilla
            //Color color = this.col;
            int f_aux = pieza.posicion.getFila();
            int c_aux = pieza.posicion.getColumna(); //Obtenemos la posición dentro del array
            boolean ficha = false;
            // Primera posicion posible
            while((f_aux > 0) && !ficha){
                //Hacia atras
                f_aux--;
                    if(!hayPieza(new Posicion(f_aux, c_aux)))
                    {
                        resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux)));
                       
                    }
                    else if(hayPieza(new Posicion(f_aux, c_aux)))
                    {
                        if((pieza.color != this.estado.get(new Posicion(f_aux, c_aux).toString()).color))
                            resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux)));
                        ficha=true;
                    }
                    else
                    {
                        ficha=true;
                    }
            }
            ficha=false;
           
            f_aux = pieza.posicion.getFila();
            c_aux = pieza.posicion.getColumna();
            while((f_aux < 7) && !ficha){
               
                //Hacia delante
                f_aux++;
                    if(!hayPieza(new Posicion(f_aux, c_aux)))
                    {
                        resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux)));
                    }                    
                    else if(hayPieza(new Posicion(f_aux, c_aux)))
                    {
                        if((pieza.color != this.estado.get(new Posicion(f_aux, c_aux).toString()).color))
                            resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux)));
                        ficha=true;
                    }
                    else
                    {
                        ficha=true;
                    }
            }
            ficha=false;
            f_aux = pieza.posicion.getFila();
            c_aux = pieza.posicion.getColumna();
            while((c_aux > 0) && !ficha){
                // Hacia izquiera
                c_aux--;
                if(!hayPieza(new Posicion(f_aux, c_aux)))
                    resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux)));
                else if(hayPieza(new Posicion(f_aux, c_aux)))
                    {
                        if((pieza.color != this.estado.get(new Posicion(f_aux, c_aux).toString()).color))
                            resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux)));
                        ficha=true;
                    }
                else
                {
                    ficha=true;
                }
            }
            ficha=false;
            f_aux = pieza.posicion.getFila();
            c_aux = pieza.posicion.getColumna();
            while((c_aux < 7) && !ficha){
                // Hacia derecha
                c_aux++;
                if(!hayPieza(new Posicion(f_aux, c_aux)))
                    resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux)));
                else if(hayPieza(new Posicion(f_aux, c_aux)))
                    {
                        if((pieza.color != this.estado.get(new Posicion(f_aux, c_aux).toString()).color))
                            resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux)));
                        ficha=true;
                    }
                else
                {
                    ficha=true;
                }
            }  
        }
        System.out.println("getMovimientosPosiblesTorre("+resultado+")");
        return resultado;
    }
   
    public ArrayList<Movimiento> getMovimientosCaballo(Pieza pieza)
    {
        ArrayList<Movimiento> resultado=new ArrayList<>();
        resultado.clear();
       if (pieza.tipoPieza().equals("Caballo"))
        {
            boolean ficha = false;
            int f_aux = pieza.posicion.getFila();
            int c_aux = pieza.posicion.getColumna(); //Obtenemos la posición dentro del array
            if ((f_aux - 1 >= 0)&&(c_aux + 2 <= 7))
            {
                f_aux = f_aux - 1;
                c_aux = c_aux + 2;
                    if(!hayPieza(new Posicion(f_aux, c_aux)))
                        resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux)));
                    else if(hayPieza(new Posicion(f_aux, c_aux)))
                    {
                        if((pieza.color != this.estado.get(new Posicion(f_aux, c_aux).toString()).color))
                            resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux)));
                    }
            }
 
            f_aux = pieza.posicion.getFila();
            c_aux = pieza.posicion.getColumna(); //Obtenemos la posición dentro del array
            // Segunda posiciones posibles
            if ((f_aux + 1 <= 7)&&(c_aux + 2 <= 7))
            {        
                f_aux = f_aux + 1;
                c_aux = c_aux + 2;
                    if(!hayPieza(new Posicion(f_aux, c_aux)))
                        resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux)));
                    else if(hayPieza(new Posicion(f_aux, c_aux)))
                    {
                        if((pieza.color != this.estado.get(new Posicion(f_aux, c_aux).toString()).color))
                            resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux)));
                    }
            }
            f_aux = pieza.posicion.getFila();
            c_aux = pieza.posicion.getColumna(); //Obtenemos la posición dentro del array
            // Tercera posiciones posibles
            if ((f_aux - 1 >= 0)&&(c_aux - 2 >= 0))
            {
                f_aux = f_aux - 1;
                c_aux = c_aux - 2;
                    if(!hayPieza(new Posicion(f_aux, c_aux)))
                        resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux)));
                    else if(hayPieza(new Posicion(f_aux, c_aux)))
                    {
                        if((pieza.color != this.estado.get(new Posicion(f_aux, c_aux).toString()).color))
                            resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux)));
                    }
            }
            f_aux = pieza.posicion.getFila();
            c_aux = pieza.posicion.getColumna(); //Obtenemos la posición dentro del array
       
            // Cuarta posicion posible
            if ((f_aux + 1 <= 7)&&(c_aux - 2 >= 0))
            {        
                f_aux = f_aux + 1;
                c_aux = c_aux - 2;
                    if(!hayPieza(new Posicion(f_aux, c_aux)))
                        resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux)));
                    else if(hayPieza(new Posicion(f_aux, c_aux)))
                    {
                        if((pieza.color != this.estado.get(new Posicion(f_aux, c_aux).toString()).color))
                            resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux)));
                    }
            }
            f_aux = pieza.posicion.getFila();
            c_aux = pieza.posicion.getColumna(); //Obtenemos la posición dentro del array
           
            // Quinta posicion posible
            if ((f_aux + 2 <= 7)&&(c_aux + 1 <= 7))
            {        
                f_aux = f_aux + 2;
                c_aux = c_aux + 1;
                    if(!hayPieza(new Posicion(f_aux, c_aux)))
                        resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux)));
                    else if(hayPieza(new Posicion(f_aux, c_aux)))
                    {
                        if((pieza.color != this.estado.get(new Posicion(f_aux, c_aux).toString()).color))
                            resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux)));
                    }
            }
            f_aux = pieza.posicion.getFila();
            c_aux = pieza.posicion.getColumna(); //Obtenemos la posición dentro del array
            // Sexta posiciones posibles
            if ((f_aux + 2 <= 7)&&(c_aux - 1 >= 0))
            {        
                f_aux = f_aux + 2;
                c_aux = c_aux - 1;
                    if(!hayPieza(new Posicion(f_aux, c_aux)))
                        resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux)));
                    else if(hayPieza(new Posicion(f_aux, c_aux)))
                    {
                        if((pieza.color != this.estado.get(new Posicion(f_aux, c_aux).toString()).color))
                            resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux)));
                    }
            }
       
            f_aux = pieza.posicion.getFila();
            c_aux = pieza.posicion.getColumna(); //Obtenemos la posición dentro del array
            // Septima posiciones posibles
            if ((f_aux - 2 >= 0)&&(c_aux + 1 <= 7))
            {        
                f_aux = f_aux - 2;
                c_aux = c_aux + 1;
                    if(!hayPieza(new Posicion(f_aux, c_aux)))
                        resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux)));
                    else if(hayPieza(new Posicion(f_aux, c_aux)))
                    {
                        if((pieza.color != this.estado.get(new Posicion(f_aux, c_aux).toString()).color))
                            resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux)));
                    }
            }
       
            f_aux = pieza.posicion.getFila();
            c_aux = pieza.posicion.getColumna(); //Obtenemos la posición dentro del array
            // Octava posiciones posibles
            if ((f_aux - 2 >= 0)&&(c_aux - 1 >= 0))
            {        
                f_aux = f_aux - 2;
                c_aux = c_aux - 1;
                    if(!hayPieza(new Posicion(f_aux, c_aux)))
                        resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux)));
                    else if(hayPieza(new Posicion(f_aux, c_aux)))
                    {
                        if((pieza.color != this.estado.get(new Posicion(f_aux, c_aux).toString()).color))
                            resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux)));
                    }
            }
        }
       return resultado;
    }
   
    public ArrayList<Movimiento> getMovimientosReyna(Pieza pieza)
    {
        ArrayList<Movimiento> resultado=new ArrayList<>();
        resultado.clear();
        if (pieza.tipoPieza().equals("Reyna"))
        {
            boolean ficha = false;
            int f_aux = pieza.posicion.getFila();
            int c_aux = pieza.posicion.getColumna();      
                while ((f_aux > 0) && (c_aux < 7) && !ficha) {
                f_aux--;
                c_aux++;
                    if(!hayPieza(new Posicion(f_aux, c_aux)))
                        resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux)));
                    else if(hayPieza(new Posicion(f_aux, c_aux)))
                    {
                        if((pieza.color != this.estado.get(new Posicion(f_aux, c_aux).toString()).color))
                            resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux)));
                        ficha=true;
                    }
                    else
                    {
                        ficha=true;
                    }
                }
            //Esquina inferior derecha
            //Partimos del punto inicial para volver a mirar
            f_aux = pieza.posicion.getFila();
            c_aux = pieza.posicion.getColumna();
            while ((f_aux < 7) && (c_aux < 7) && !ficha) {
                f_aux++;
                c_aux++;
                    if(!hayPieza(new Posicion(f_aux, c_aux)))
                        resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux)));
                    else if(hayPieza(new Posicion(f_aux, c_aux)))
                    {
                        if((pieza.color != this.estado.get(new Posicion(f_aux, c_aux).toString()).color))
                            resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux)));
                        ficha=true;
                    }
                    else
                    {
                        ficha=true;
                    }
            }
            f_aux = pieza.posicion.getFila();
            c_aux = pieza.posicion.getColumna();
            while((f_aux < 7) && (c_aux > 0) && !ficha){
                //Esquina superior izquierda
                f_aux++;
                c_aux--;
                    if(!hayPieza(new Posicion(f_aux, c_aux)))
                        resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux)));
                    else if(hayPieza(new Posicion(f_aux, c_aux)))
                    {
                        if((pieza.color != this.estado.get(new Posicion(f_aux, c_aux).toString()).color))
                            resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux)));
                        ficha=true;
                    }
                    else
                    {
                        ficha=true;
                    }
            }
            f_aux = pieza.posicion.getFila();
            c_aux = pieza.posicion.getColumna();
            while((f_aux > 0) && (c_aux > 0) && !ficha){
                //Esquina inferior izquierda
                f_aux--;
                c_aux--;
                    if(!hayPieza(new Posicion(f_aux, c_aux)))
                        resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux)));
                    else if(hayPieza(new Posicion(f_aux, c_aux)))
                    {
                        if((pieza.color != this.estado.get(new Posicion(f_aux, c_aux).toString()).color))
                            resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux)));
                        ficha=true;
                    }
                    else
                    {
                        ficha=true;
                    }
            }
       
            f_aux = pieza.posicion.getFila();
            c_aux = pieza.posicion.getColumna();
            while(f_aux > 0 && !ficha){
                //Hacia atras
                f_aux--;
                    if(!hayPieza(new Posicion(f_aux, c_aux)))
                        resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux)));
                    else if(hayPieza(new Posicion(f_aux, c_aux)))
                    {
                        if((pieza.color != this.estado.get(new Posicion(f_aux, c_aux).toString()).color))
                            resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux)));
                        ficha=true;
                    }
                    else
                    {
                        ficha=true;
                    }
            }
       
        f_aux = pieza.posicion.getFila();
        c_aux = pieza.posicion.getColumna();
        while(f_aux < 7 && !ficha){
            //Hacia delante
            f_aux++;
                    if(!hayPieza(new Posicion(f_aux, c_aux)))
                        resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux)));
                    else if(hayPieza(new Posicion(f_aux, c_aux)))
                    {
                        if((pieza.color != this.estado.get(new Posicion(f_aux, c_aux).toString()).color))
                            resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux)));
                        ficha=true;
                    }
                    else
                    {
                        ficha=true;
                    }
        }
        f_aux = pieza.posicion.getFila();
        c_aux = pieza.posicion.getColumna();
        while(c_aux > 0 && !ficha){
            // Hacia izquiera
            c_aux--;
                    if(!hayPieza(new Posicion(f_aux, c_aux)))
                        resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux)));
                    else if(hayPieza(new Posicion(f_aux, c_aux)))
                    {
                        if((pieza.color != this.estado.get(new Posicion(f_aux, c_aux).toString()).color))
                            resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux)));
                        ficha=true;
                    }
                    else
                    {
                        ficha=true;
                    }
        }
 
        f_aux = pieza.posicion.getFila();
        c_aux = pieza.posicion.getColumna();
        while(c_aux < 7 && !ficha){
            // Hacia derecha
            c_aux++;
                    if(!hayPieza(new Posicion(f_aux, c_aux)))
                        resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux)));
                    else if(hayPieza(new Posicion(f_aux, c_aux)))
                    {
                        if((pieza.color != this.estado.get(new Posicion(f_aux, c_aux).toString()).color))
                            resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux)));
                        ficha=true;
                    }
                    else
                    {
                        ficha=true;
                    }
        }
        }
        return resultado;
    }
   
    public ArrayList<Movimiento> getMovimientosRey(Pieza pieza)
    {
        ArrayList<Movimiento> resultado=new ArrayList<>();
        resultado.clear();
       
        if (pieza.tipoPieza().equals("Rey"))
        {
            int f_aux = pieza.posicion.getFila();
            int c_aux = pieza.posicion.getColumna();
            if((f_aux > 0) && (f_aux < 7) && (c_aux > 0) && (c_aux < 7)){
            //posicion media
                if(!hayPieza(new Posicion(f_aux, c_aux+1)))
                    resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux+1)));
                else if(hayPieza(new Posicion(f_aux, c_aux+1)))
                    {
                        if((pieza.color != this.estado.get(new Posicion(f_aux, c_aux+1).toString()).color))
                            resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux+1)));
                       
                    }
                if(!hayPieza(new Posicion(f_aux+1, c_aux)))
                    resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux+1, c_aux)));
                else if(hayPieza(new Posicion(f_aux+1, c_aux)))
                    {
                        if((pieza.color != this.estado.get(new Posicion(f_aux+1, c_aux).toString()).color))
                            resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux+1, c_aux)));
                       
                    }
                 if(!hayPieza(new Posicion(f_aux-1, c_aux)))
                    resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux-1, c_aux)));
                else if(hayPieza(new Posicion(f_aux-1, c_aux)))
                    {
                        if((pieza.color != this.estado.get(new Posicion(f_aux-1, c_aux).toString()).color))
                            resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux-1, c_aux)));
                       
                    }
                if(!hayPieza(new Posicion(f_aux-1, c_aux-1)))
                    resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux-1, c_aux-1)));
                else if(hayPieza(new Posicion(f_aux-1, c_aux-1)))
                    {
                        if((pieza.color != this.estado.get(new Posicion(f_aux-1, c_aux-1).toString()).color))
                            resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux-1, c_aux-1)));
                       
                    }
                if(!hayPieza(new Posicion(f_aux, c_aux-1)))
                    resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux-1)));
                else if(hayPieza(new Posicion(f_aux, c_aux-1)))
                    {
                        if((pieza.color != this.estado.get(new Posicion(f_aux, c_aux-1).toString()).color))
                            resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux-1)));
                       
                    }
                if(!hayPieza(new Posicion(f_aux+1, c_aux-1)))
                    resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux+1, c_aux-1)));
                else if(hayPieza(new Posicion(f_aux+1, c_aux-1)))
                    {
                        if((pieza.color != this.estado.get(new Posicion(f_aux+1, c_aux-1).toString()).color))
                            resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux+1, c_aux-1)));
                       
                    }
                if(!hayPieza(new Posicion(f_aux+1, c_aux+1)))
                    resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux+1, c_aux+1)));
                else if(hayPieza(new Posicion(f_aux+1, c_aux+1)))
                    {
                        if((pieza.color != this.estado.get(new Posicion(f_aux+1, c_aux+1).toString()).color))
                            resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux+1, c_aux+1)));
                       
                    }
               
                if(!hayPieza(new Posicion(f_aux-1, c_aux+1)))
                    resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux-1, c_aux+1)));
                else if(hayPieza(new Posicion(f_aux-1, c_aux+1)))
                    {
                        if((pieza.color != this.estado.get(new Posicion(f_aux-1, c_aux+1).toString()).color))
                            resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux-1, c_aux+1)));
                       
                    }
               
        }
        else if((c_aux -1 < 0) && (f_aux-1 <0)){
         //esquina superior izquierda
            if(!hayPieza(new Posicion(f_aux, c_aux+1)))
                    resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux+1)));
                else if(hayPieza(new Posicion(f_aux, c_aux+1)))
                    {
                        if((pieza.color != this.estado.get(new Posicion(f_aux, c_aux+1).toString()).color))
                           resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux+1)));
                       
                    }
            if(!hayPieza(new Posicion(f_aux+1, c_aux+1)))
                    resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux+1, c_aux+1)));
                else if(hayPieza(new Posicion(f_aux+1, c_aux+1)))
                    {
                        if((pieza.color != this.estado.get(new Posicion(f_aux+1, c_aux+1).toString()).color))
                           resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux+1)));
                       
                    }
            if(!hayPieza(new Posicion(f_aux+1, c_aux)))
                    resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux+1, c_aux)));
                else if(hayPieza(new Posicion(f_aux+1, c_aux)))
                    {
                        if((pieza.color != this.estado.get(new Posicion(f_aux+1, c_aux).toString()).color))
                           resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux+1, c_aux)));
                       
                    }
           
        }
        else if((c_aux - 1 < 0) && (f_aux + 1 > 7)){
         //esquina inferior izquierda
            if(!hayPieza(new Posicion(f_aux, c_aux+1)))
                    resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux+1)));
                else if(hayPieza(new Posicion(f_aux, c_aux+1)))
                    {
                        if((pieza.color != this.estado.get(new Posicion(f_aux, c_aux+1).toString()).color))
                           resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux+1)));
                       
                    }
            if(!hayPieza(new Posicion(f_aux-1, c_aux+1)))
                    resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux-1, c_aux+1)));
                else if(hayPieza(new Posicion(f_aux-1, c_aux+1)))
                    {
                        if((pieza.color != this.estado.get(new Posicion(f_aux-1, c_aux+1).toString()).color))
                           resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux-1, c_aux+1)));
                       
                    }
            if(!hayPieza(new Posicion(f_aux-1, c_aux)))
                    resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux-1, c_aux)));
                else if(hayPieza(new Posicion(f_aux-1, c_aux)))
                    {
                        if((pieza.color != this.estado.get(new Posicion(f_aux-1, c_aux).toString()).color))
                           resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux-1, c_aux)));
                       
                    }
           
        }
        else if((c_aux +1 > 7) && (f_aux +1 > 7))
        {
            //esquina inferior derecha
            if(!hayPieza(new Posicion(f_aux, c_aux-1)))
                    resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux-1)));
                else if(hayPieza(new Posicion(f_aux, c_aux-1)))
                    {
                        if((pieza.color != this.estado.get(new Posicion(f_aux, c_aux-1).toString()).color))
                           resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux-1)));
                       
                    }
            if(!hayPieza(new Posicion(f_aux-1, c_aux-1)))
                    resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux-1, c_aux-1)));
                else if(hayPieza(new Posicion(f_aux-1, c_aux-1)))
                    {
                        if((pieza.color != this.estado.get(new Posicion(f_aux-1, c_aux-1).toString()).color))
                           resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux-1, c_aux-1)));
                       
                    }
            if(!hayPieza(new Posicion(f_aux-1, c_aux)))
                    resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux -1, c_aux)));
                else if(hayPieza(new Posicion(f_aux-1, c_aux)))
                    {
                        if((pieza.color != this.estado.get(new Posicion(f_aux-1, c_aux).toString()).color))
                           resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux -1, c_aux)));
                       
                    }
           
           
        }
        else if((c_aux +1 > 7) && (f_aux -1 < 0)){
            //esquina superior derecha
            if(!hayPieza(new Posicion(f_aux+1, c_aux)))
                    resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux+1, c_aux)));
                else if(hayPieza(new Posicion(f_aux+1, c_aux)))
                    {
                        if((pieza.color != this.estado.get(new Posicion(f_aux+1, c_aux).toString()).color))
                           resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux+1, c_aux)));
                       
                    }
            if(!hayPieza(new Posicion(f_aux, c_aux-1)))
                    resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux-1)));
                else if(hayPieza(new Posicion(f_aux, c_aux-1)))
                    {
                        if((pieza.color != this.estado.get(new Posicion(f_aux, c_aux-1).toString()).color))
                           resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux-1)));
                       
                    }
            if(!hayPieza(new Posicion(f_aux+1, c_aux-1)))
                    resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux+1, c_aux-1)));
                else if(hayPieza(new Posicion(f_aux+1, c_aux-1)))
                    {
                        if((pieza.color != this.estado.get(new Posicion(f_aux+1, c_aux-1).toString()).color))
                           resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux+1, c_aux-1)));
                       
                    }
           
           
        }
        else if(c_aux - 1 < 0 ){
            //Lateral izquierdo
            if(!hayPieza(new Posicion(f_aux+1, c_aux)))
                    resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux+1, c_aux)));
                else if(hayPieza(new Posicion(f_aux+1, c_aux)))
                    {
                        if((pieza.color != this.estado.get(new Posicion(f_aux+1, c_aux).toString()).color))
                           resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux+1, c_aux)));
                       
                    }
            if(!hayPieza(new Posicion(f_aux-1, c_aux)))
                    resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux-1, c_aux)));
                else if(hayPieza(new Posicion(f_aux-1, c_aux)))
                    {
                        if((pieza.color != this.estado.get(new Posicion(f_aux-1, c_aux).toString()).color))
                           resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux-1, c_aux)));
                       
                    }
            if(!hayPieza(new Posicion(f_aux+1, c_aux+1)))
                    resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux+1, c_aux+1)));
                else if(hayPieza(new Posicion(f_aux+1, c_aux+1)))
                    {
                        if((pieza.color != this.estado.get(new Posicion(f_aux+1, c_aux+1).toString()).color))
                           resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux+1, c_aux+1)));
                       
                    }
            if(!hayPieza(new Posicion(f_aux, c_aux+1)))
                    resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux+1)));
                else if(hayPieza(new Posicion(f_aux, c_aux+1)))
                    {
                        if((pieza.color != this.estado.get(new Posicion(f_aux, c_aux+1).toString()).color))
                           resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux+1)));
                       
                    }
            if(!hayPieza(new Posicion(f_aux-1, c_aux+1)))
                    resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux-1, c_aux+1)));
                else if(hayPieza(new Posicion(f_aux-1, c_aux+1)))
                    {
                        if((pieza.color != this.estado.get(new Posicion(f_aux-1, c_aux+1).toString()).color))
                           resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux-1, c_aux+1)));
                       
                    }
           
           
        }
        else if(c_aux + 1 > 7){
            //Lateral derecho
            if(!hayPieza(new Posicion(f_aux+1, c_aux)))
                    resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux+1, c_aux)));
                else if(hayPieza(new Posicion(f_aux+1, c_aux)))
                    {
                        if((pieza.color != this.estado.get(new Posicion(f_aux+1, c_aux).toString()).color))
                           resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux-1, c_aux+1)));
                       
                    }
            if(!hayPieza(new Posicion(f_aux-1, c_aux)))
                    resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux-1, c_aux)));
                else if(hayPieza(new Posicion(f_aux-1, c_aux)))
                    {
                        if((pieza.color != this.estado.get(new Posicion(f_aux-1, c_aux).toString()).color))
                           resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux-1, c_aux)));
                       
                    }
            if(!hayPieza(new Posicion(f_aux+1, c_aux-1)))
                    resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux+1, c_aux-1)));
                else if(hayPieza(new Posicion(f_aux+1, c_aux-1)))
                    {
                        if((pieza.color != this.estado.get(new Posicion(f_aux+1, c_aux-1).toString()).color))
                           resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux+1, c_aux-1)));
                       
                    }
            if(!hayPieza(new Posicion(f_aux, c_aux-1)))
                    resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux-1)));
                else if(hayPieza(new Posicion(f_aux, c_aux-1)))
                    {
                        if((pieza.color != this.estado.get(new Posicion(f_aux, c_aux-1).toString()).color))
                           resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux-1)));
                       
                    }
            if(!hayPieza(new Posicion(f_aux-1, c_aux-1)))
                    resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux-1, c_aux-1)));
                else if(hayPieza(new Posicion(f_aux-1, c_aux-1)))
                    {
                        if((pieza.color != this.estado.get(new Posicion(f_aux-1, c_aux-1).toString()).color))
                           resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux-1, c_aux-1)));
                       
                    }
           
 
           
        }
        else if(f_aux + 1 > 7){
            //Inferior
            if(!hayPieza(new Posicion(f_aux-1, c_aux)))
                    resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux-1, c_aux)));
                else if(hayPieza(new Posicion(f_aux-1, c_aux)))
                    {
                        if((pieza.color != this.estado.get(new Posicion(f_aux-1, c_aux).toString()).color))
                           resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux-1, c_aux)));
                       
                    }
            if(!hayPieza(new Posicion(f_aux-1, c_aux+1)))
                    resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux-1, c_aux+1)));
                else if(hayPieza(new Posicion(f_aux-1, c_aux+1)))
                    {
                        if((pieza.color != this.estado.get(new Posicion(f_aux-1, c_aux+1).toString()).color))
                           resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux-1, c_aux+1)));
                       
                    }
            if(!hayPieza(new Posicion(f_aux, c_aux+1)))
                    resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux+1)));
                else if(hayPieza(new Posicion(f_aux, c_aux+1)))
                    {
                        if((pieza.color != this.estado.get(new Posicion(f_aux, c_aux+1).toString()).color))
                           resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux+1)));
                       
                    }
            if(!hayPieza(new Posicion(f_aux-1, c_aux-1)))
                    resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux-1, c_aux-1)));
                else if(hayPieza(new Posicion(f_aux-1, c_aux-1)))
                    {
                        if((pieza.color != this.estado.get(new Posicion(f_aux-1, c_aux-1).toString()).color))
                           resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux-1, c_aux-1)));
                       
                    }
            if(!hayPieza(new Posicion(f_aux, c_aux-1)))
                    resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux-1)));
                else if(hayPieza(new Posicion(f_aux, c_aux-1)))
                    {
                        if((pieza.color != this.estado.get(new Posicion(f_aux, c_aux-1).toString()).color))
                           resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux-1)));
                       
                    }
           
        }
        else if(f_aux - 1 < 0){
            //Superior
            if(!hayPieza(new Posicion(f_aux+1, c_aux)))
                    resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux+1, c_aux)));
                else if(hayPieza(new Posicion(f_aux+1, c_aux)))
                    {
                        if((pieza.color != this.estado.get(new Posicion(f_aux+1, c_aux).toString()).color))
                           resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux+1, c_aux)));
                       
                    }
            if(!hayPieza(new Posicion(f_aux, c_aux-1)))
                    resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux-1)));
                else if(hayPieza(new Posicion(f_aux, c_aux-1)))
                    {
                        if((pieza.color != this.estado.get(new Posicion(f_aux, c_aux-1).toString()).color))
                           resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux-1)));
                       
                    }
            if(!hayPieza(new Posicion(f_aux, c_aux+1)))
                    resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux+1)));
                else if(hayPieza(new Posicion(f_aux, c_aux+1)))
                    {
                        if((pieza.color != this.estado.get(new Posicion(f_aux, c_aux+1).toString()).color))
                           resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux+1)));
                       
                    }
            if(!hayPieza(new Posicion(f_aux+1, c_aux-1)))
                    resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux+1, c_aux-1)));
                else if(hayPieza(new Posicion(f_aux+1, c_aux-1)))
                    {
                        if((pieza.color != this.estado.get(new Posicion(f_aux+1, c_aux-1).toString()).color))
                           resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux+1, c_aux-1)));
                       
                    }
            if(!hayPieza(new Posicion(f_aux+1, c_aux+1)))
                    resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux+1, c_aux+1)));
                else if(hayPieza(new Posicion(f_aux+1, c_aux+1)))
                    {
                        if((pieza.color != this.estado.get(new Posicion(f_aux+1, c_aux+1).toString()).color))
                           resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux+1, c_aux+1)));
                       
                    }
           
           
        }        
        }
        return resultado;
    }
    public ArrayList<Movimiento> getMovimientosAlfil(Pieza pieza)
    {
        ArrayList<Movimiento> resultado=new ArrayList<>();
        resultado.clear();
            if (pieza.tipoPieza().equals("Alfil"))
        {
            boolean ficha = false;
                int f_aux = pieza.posicion.getFila();
                int c_aux = pieza.posicion.getColumna();      
                while ((f_aux >= 0) && (c_aux <= 7) && !ficha) {
                    
                    f_aux--;
                    c_aux++;
                    if (( !(f_aux < 0) )  && ( !(c_aux > 7) )) 
                        if(!hayPieza(new Posicion(f_aux, c_aux)))
                            resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux)));
                        else if(hayPieza(new Posicion(f_aux, c_aux)))
                        {
                            if((pieza.color != this.estado.get(new Posicion(f_aux, c_aux).toString()).color))
                                resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux)));
                            ficha=true;
                        }
                        else
                        {
                            ficha=true;
                        }
                    }
            //Esquina inferior derecha
            //Partimos del punto inicial para volver a mirar
            f_aux = pieza.posicion.getFila();
            c_aux = pieza.posicion.getColumna();
            while ((f_aux <= 7) && (c_aux <= 7) && !ficha) {
                f_aux++;
                c_aux++;
                if (( !(f_aux > 7) )  && ( !(c_aux > 7) )) 
                {
                    if(!hayPieza(new Posicion(f_aux, c_aux)))
                        resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux)));
                    else if(hayPieza(new Posicion(f_aux, c_aux)))
                    {
                        if((pieza.color != this.estado.get(new Posicion(f_aux, c_aux).toString()).color))
                            resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux)));
                        ficha=true;
                    }
                    else
                    {
                        ficha=true;
                    }
                }
            }
            f_aux = pieza.posicion.getFila();
            c_aux = pieza.posicion.getColumna();
            while((f_aux <= 7) && (c_aux >= 0) && !ficha){
                //Esquina superior izquierda
                f_aux++;
                c_aux--;
                if (( !(c_aux < 0) )  && ( !(f_aux > 7) )) 
                {
                    if(!hayPieza(new Posicion(f_aux, c_aux)))
                        resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux)));
                    else if(hayPieza(new Posicion(f_aux, c_aux)))
                    {
                        if((pieza.color != this.estado.get(new Posicion(f_aux, c_aux).toString()).color))
                            resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux)));
                        ficha=true;
                    }
                    else
                    {
                        ficha=true;
                    }
                }
            }
            f_aux = pieza.posicion.getFila();
            c_aux = pieza.posicion.getColumna();
            while((f_aux >= 0) && (c_aux >= 0) && !ficha){
                //Esquina inferior izquierda
                f_aux--;
                c_aux--;
                if (( !(f_aux < 0) )  && ( !(c_aux < 0) ))
                {
                    if(!hayPieza(new Posicion(f_aux, c_aux)))
                        resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux)));
                    else if(hayPieza(new Posicion(f_aux, c_aux)))
                    {
                        if((pieza.color != this.estado.get(new Posicion(f_aux, c_aux).toString()).color))
                            resultado.add(new Movimiento(pieza.color, pieza.posicion, new Posicion(f_aux, c_aux)));
                        ficha=true;
                    }
                    else
                    {
                        ficha=true;
                    }
                }
            }
        }
            return resultado;
    }
   
}
