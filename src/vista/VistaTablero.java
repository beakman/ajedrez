/*
 * Detached HEAD??
 * and open the template in the editor.
 */
package vista;

import ajedrez.Movimientos;
import ajedrez.IPieza;
import ajedrez.IJugador;
import ajedrez.Maquina;
import ajedrez.Movimiento;
import ajedrez.Pieza;
import ajedrez.Posicion;
import ajedrez.Tablero;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

/**
 *
 * @author OneFranc
 */
public class VistaTablero extends javax.swing.JFrame {
    
    public static Tablero tablero;
    public static IPieza pieza;
    public static IJugador jugador;
    public Posicion posicion;
    public Movimientos movimientos = new Movimientos();
    
    public String jugador1;
    public String jugador2;
    public JTextArea informacion = new JTextArea();
    public static boolean piezaPulsada=false;
    public static String seleccionAnterior;
    public static Posicion posicionAnterior, posicionActual;
    
    public static JButton casilla[][] = new JButton[8][8];
    /**
     * Creates new form VistaTablero
     * @param tab
     */
    public VistaTablero(Tablero tab) 
    {        
        tablero = tab;
        initComponents();  
        setSize(600,500);
        tableroPanel.setLayout(new GridLayout(8, 8));
        seleccionAnterior = " ";
        posicionAnterior = new Posicion(0,0);
        posicionActual = new Posicion(0,0);
        
        // Dibujamos el tablero: cada casilla sera un JButton.
        for (int i = 0; i < 8; i++) {
            final int fila = i;
            for (int j = 0; j < 8; j++) {
                final int columna = j;
                casilla[i][j] = new JButton();
                casilla[i][j].setSize(new Dimension(50,50));
                casilla[fila][columna].setActionCommand("action"+i+j);
                casilla[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        posicionActual.setFila(fila);
                        posicionActual.setColumna(columna);
                        Pieza piezaAnterior, piezaActual;
                        /* 
                          = Casilla vacia, sin pieza pulsada previamente
                         */
                        if(casilla[fila][columna].getIcon()==null && !piezaPulsada){
                            // 1. actualizamos posicionAnterior
                            // 2. piezaPulsada=true                            
                            posicionAnterior.setFila(posicionActual.getFila());
                            posicionAnterior.setColumna(posicionActual.getColumna());
                            piezaPulsada=false;
                        }
                        /* 
                          = Casilla vacia, pieza pulsada previamente (movemos)
                         */
                        else if (casilla[fila][columna].getIcon()==null && piezaPulsada){
                            // 1. cogemos la pieza elegida previamente
                            // 2. actualizamos la informacion del panel
                            // 3. actualizamos el estado del tablero (el diccionario)
                            // 4. actualizamos la posicion de la pieza
                            // 5. actualizamos la visa
                            // 6. ponemos a false piezaPulsada                            
                            piezaAnterior = tablero.comprobarPosicion(posicionAnterior);
                            
//                            if (piezaAnterior.esMovimientoPosible(posicionActual) && hayFicha(posicionAnterior, posicionActual) == false)
                            if (tablero.esMovimientoPosible(new Movimiento(piezaAnterior.color, piezaAnterior.posicion, posicionActual), piezaAnterior))
                            {
                                System.out.println("NI DE COÑA");
                                setEstado(posicionAnterior.toString()+" "+posicionActual.toString(), piezaAnterior + ": " + posicionAnterior.toString()+" "+posicionActual.toString(), event.getActionCommand());
                                tablero.actualizarEstado(posicionAnterior, posicionActual);
                                piezaAnterior.actualizarPosicion(posicionActual);
                                casilla[fila][columna].setIcon(casilla[posicionAnterior.getFila()][posicionAnterior.getColumna()].getIcon());
                                casilla[posicionAnterior.getFila()][posicionAnterior.getColumna()].setIcon(null);                            
                                // actualizamos el color
                                if ((posicionAnterior.getFila() + posicionAnterior.getColumna()) % 2 == 0) {
                                    casilla[posicionAnterior.getFila()][posicionAnterior.getColumna()].setBackground(Color.white);
                                } else {                    
                                    casilla[posicionAnterior.getFila()][posicionAnterior.getColumna()].setBackground(new Color(0x00a6ac));
                                } 
                                posicionAnterior.setFila(posicionActual.getFila());
                                posicionAnterior.setColumna(posicionActual.getColumna());
                                piezaPulsada=false;
                                //prueba de concepto: generar movimiento de máquina
                                Maquina maq = new Maquina(tablero);
                                Pieza p;
                                Movimiento m = maq.hacerMovimiento();
                                System.out.println("EN M HAY"+m);
                                 p=  tablero.estado.get(m.posActual.toString());
                                 System.out.println("EN p HAY"+p);
                                if (tablero.esMovimientoPosible(m,p)) 
                                {
                                    
                                    posicionAnterior = m.posActual;
                                    System.out.println("El caballo se va a mover desde pos actual:"+posicionAnterior);
                                    posicionActual = m.posDestino;
                                    System.out.println("El caballo se va a mover desde pos actual a :"+posicionActual);
                                    setEstado(posicionAnterior.toString()+" "+posicionActual.toString(), piezaAnterior + ": " + posicionAnterior.toString()+" "+posicionActual.toString(), event.getActionCommand());
                                    tablero.actualizarEstado(posicionAnterior, posicionActual);
                                    piezaAnterior.actualizarPosicion(posicionActual);
                                    casilla[m.posDestino.fila][m.posDestino.columna].setIcon(casilla[posicionAnterior.getFila()][posicionAnterior.getColumna()].getIcon());
                                    casilla[posicionAnterior.getFila()][posicionAnterior.getColumna()].setIcon(null);                            
                                    // actualizamos el color
                                    if ((posicionAnterior.getFila() + posicionAnterior.getColumna()) % 2 == 0) {
                                        casilla[posicionAnterior.getFila()][posicionAnterior.getColumna()].setBackground(Color.white);
                                    } else {                    
                                        casilla[posicionAnterior.getFila()][posicionAnterior.getColumna()].setBackground(new Color(0x00a6ac));
                                    } 
                                    posicionAnterior.setFila(posicionActual.getFila());
                                    posicionAnterior.setColumna(posicionActual.getColumna());
                                    piezaPulsada=false;
                                }
                                
                            }
                            else {
                                System.out.println("No se puede actualizar la posicionAAAAA");
                                piezaPulsada=false;
                            }
                        }
                        
                        /* 
                          = Casilla llena, pieza no pulsada previamente
                         */
                        else if(casilla[fila][columna].getIcon()!=null && !piezaPulsada){
                            // 1. actualizamos posicionAnterior
                            // 2. piezaPulsada=true
                            // 3. coloreamos el fondo de la casilla
                            casilla[fila][columna].setBackground(Color.GRAY);
                            posicionAnterior.setFila(posicionActual.getFila());
                            posicionAnterior.setColumna(posicionActual.getColumna());
                            piezaPulsada=true;
//                            System.out.println("aqui esta el fallo");
//                            tablero.comprobarPosicion(posicionActual).MostrarTodas();
                        }
                        
                        /* 
                          = Casilla llena, pieza pulsada previamente (matar?)
                         */
                        else if(casilla[fila][columna].getIcon()!=null && piezaPulsada){
                            // 1. mismo color -> nada
                            // 2. distinto color -> matar
                            piezaAnterior = tablero.comprobarPosicion(posicionAnterior);
                            piezaActual = tablero.comprobarPosicion(posicionActual);
                            if (piezaAnterior.color != piezaActual.color){
                                
                                /*intento implementar aquí el matar del peon
                                 */
                               
                                if(piezaAnterior.tipoPieza().equals("Peon")) 
                                {// es un peon
                                     int f_aux, c_aux,x,y;
                                     f_aux = posicionAnterior.getFila();
                                     c_aux = posicionAnterior.getColumna();
                                     x = posicionActual.getFila();
                                     y = posicionActual.getColumna();
                                     System.out.println("??");
                                     /*También tengo que comprobar que el peón sólo mata hacia adelante,
                                      * es decir, dependiendo del color, tiene dos movimientos posibles
                                      * para matar
                                      */
                                     if(piezaAnterior.color == ajedrez.Color.blanca)
                                     {
                                         if((((x ==f_aux -1)&&( y==c_aux +1))) || ((( x== f_aux-1)&&(y ==c_aux -1))))
                                        {
                                            //Si se cumple ésta condición, el peón podrá matarlo
                                            matar(posicionAnterior, posicionActual,piezaAnterior,fila,columna);
                                       
                                        }
                                     }
                                     else if (piezaAnterior.color == ajedrez.Color.negra)
                                     {
                                         if((((x == f_aux+1)&&(y == c_aux-1))) || (((x == f_aux+1)&&(y == c_aux+1))))
                                         {
                                                //Si se cumple ésta condición, el peón podrá matarlo
                                             matar(posicionAnterior, posicionActual,piezaAnterior,fila,columna);
                                         }
                                     }                          
                                 }
                                if (piezaAnterior.tipoPieza().equals("Alfil"))
                                {
                                    int f_aux, c_aux,x,y;
                                     f_aux = posicionAnterior.getFila();
                                     c_aux = posicionAnterior.getColumna();
                                     x = posicionActual.getFila();
                                     y = posicionActual.getColumna();
                                     if (((x>= f_aux+1)&&(y>=c_aux+1)) || ((x>=f_aux+1)&&(y<=c_aux-1)) || ((x<=f_aux-1)&&(y<=c_aux-1)) || ((x<=f_aux-1)&&(y>=c_aux+1)))
                                     {
                                         
                                            if(Math.abs((y-c_aux)/(x-f_aux))==1)
                                            matar(posicionAnterior, posicionActual,piezaAnterior,fila,columna);
                                       
                                    }
                                     
                                }
                                
                                if(piezaAnterior.tipoPieza().equals("Torre"))
                                {
                                    int f_aux, c_aux,x,y;
                                     f_aux = posicionAnterior.getFila();
                                     c_aux = posicionAnterior.getColumna();
                                     x = posicionActual.getFila();
                                     y = posicionActual.getColumna();
                                     if((x==f_aux) || (y==c_aux))
                                     {
                                         matar(posicionAnterior, posicionActual,piezaAnterior,fila,columna);
                                     }
                                }
                                if(piezaAnterior.tipoPieza().equals("Reyna"))
                                {
                                    int f_aux, c_aux,x,y;
                                     f_aux = posicionAnterior.getFila();
                                     c_aux = posicionAnterior.getColumna();
                                     x = posicionActual.getFila();
                                     y = posicionActual.getColumna();
                                    try{
                                        if((x==f_aux) || (y==c_aux) || (Math.abs((y-c_aux)/(x-f_aux))==1))
                                        {
                                            matar(posicionAnterior, posicionActual,piezaAnterior,fila,columna);
                                        }
                                    }catch(ArithmeticException e){
                                        
                                    }
                                }
                                if (piezaAnterior.tipoPieza().equals("Rey"))
                                {
                                    int f_aux, c_aux,x,y;
                                     f_aux = posicionAnterior.getFila();
                                     c_aux = posicionAnterior.getColumna();
                                     x = posicionActual.getFila();
                                     y = posicionActual.getColumna();
                                     if(((x==f_aux+1) && (y==c_aux+1)) || ((x==f_aux+1)&&(y==c_aux)) || ((x==f_aux+1)&&(y == c_aux-1)) || ((x==f_aux)&&(y==c_aux-1))
                                             || ((x==f_aux-1)&&(y==c_aux-1)) || ((x==f_aux -1 )&&(y==c_aux)) || ((x==f_aux-1)&&(y==c_aux+1)) || ((x==f_aux)&&(y==c_aux+1)))
                                     {
                                         matar(posicionAnterior, posicionActual,piezaAnterior,fila,columna);
                                     }
                                     
                                }
                                
//                                else{
//                                   matar(posicionAnterior, posicionActual,piezaAnterior,fila,columna);
//                            
//                                }
                            }
                            // actualizamos el color
                            if ((posicionAnterior.getFila() + posicionAnterior.getColumna()) % 2 == 0) {
                                casilla[posicionAnterior.getFila()][posicionAnterior.getColumna()].setBackground(Color.white);
                            } else {                    
                                casilla[posicionAnterior.getFila()][posicionAnterior.getColumna()].setBackground(new Color(0x00a6ac));
                            }
                            posicionAnterior.setFila(posicionActual.getFila());
                            posicionAnterior.setColumna(posicionActual.getColumna());
                            piezaPulsada=false;                               
                        }                        
                    }
                });
                if ((i + j) % 2 == 0) {
                    casilla[i][j].setBackground(Color.white);
                } else {                    
                    casilla[i][j].setBackground(new Color(0x00a6ac));
                }   
                tableroPanel.add(casilla[i][j]);
                casilla[i][j].setEnabled(false);
            }
        }
        mostrarTablero();
        setVisible(true);        
    }
    public void matar(Posicion posicionAnterior, Posicion posicionActual, Pieza piezaAnterior,int fila, int columna){
        tablero.estado.remove(posicionActual.toString()); // sacamos la pieza del diccionario
        casilla[posicionActual.getFila()][posicionActual.getColumna()].setIcon(null);
        tablero.actualizarEstado(posicionAnterior, posicionActual);
        piezaAnterior.actualizarPosicion(posicionActual);
        casilla[fila][columna].setIcon(casilla[posicionAnterior.getFila()][posicionAnterior.getColumna()].getIcon());
        casilla[posicionAnterior.getFila()][posicionAnterior.getColumna()].setIcon(null);
        casilla[posicionAnterior.getFila()][posicionAnterior.getColumna()].setBackground(casilla[posicionAnterior.getFila()][posicionAnterior.getColumna()].getBackground());
    }
    
    public boolean hayFicha(Posicion posicionAnterior, Posicion posicionActual)
    {
        int posAntFil = posicionAnterior.getFila();
        int posAntCol = posicionAnterior.getColumna();
        boolean hayFicha = false; 
        Pieza pieza;
        pieza = tablero.comprobarPosicion(posicionAnterior);
        
        if (!pieza.equals("Caballo"))
        {
            // Movimiento en diagonal
            if ((posicionActual.getFila() != posicionAnterior.getFila()) && (posicionActual.getColumna() !=posicionAnterior.getColumna()))
            {
                if ((posicionActual.getFila() > posicionAnterior.getFila()) && (posicionActual.getColumna() > posicionAnterior.getColumna()))
                {
                    posAntCol++;
                    posAntFil++;
                    while ((casilla[posAntFil][posAntCol].getIcon() == null) && (posicionActual.getColumna() > posAntCol))
                    {
                        posAntCol++;
                        posAntFil++;
                    }
                    if (posicionActual.getColumna() > posAntCol)
                        hayFicha = true;
                }
                if (posicionActual.getFila() < posicionAnterior.getFila() && posicionActual.getColumna() > posicionAnterior.getColumna())
                {
                    posAntCol++;
                    posAntFil--;
                    while ((casilla[posAntFil][posAntCol].getIcon() == null) && (posicionActual.getColumna() > posAntCol))
                    {
                        posAntCol++;
                        posAntFil--;
                    }
                    if (posicionActual.getColumna() > posAntCol)
                        hayFicha = true;
                }
                if (posicionActual.getFila() > posicionAnterior.getFila() && posicionActual.getColumna() < posicionAnterior.getColumna())
                {
                    posAntCol--;
                    posAntFil++;
                    while ((casilla[posAntFil][posAntCol].getIcon() == null) && (posicionActual.getColumna() < posAntCol))
                    {
                        posAntCol--;
                        posAntFil++;
                    }
                    if (posicionActual.getColumna() < posAntCol)
                        hayFicha = true;       
                }
                if (posicionActual.getFila() < posicionAnterior.getFila() && posicionActual.getColumna() < posicionAnterior.getColumna())
                {
                    posAntCol--;
                    posAntFil--;
                    while ((casilla[posAntFil][posAntCol].getIcon() == null) && (posicionActual.getColumna() < posAntCol))
                    {
                        posAntCol--;
                        posAntFil--;
                    }
                    if (posicionActual.getColumna() < posAntCol)
                        hayFicha = true;
                }       
            }
            // Movimiento horizontal
            if ((posicionActual.getFila() == posicionAnterior.getFila()) && (posicionActual.getColumna() !=posicionAnterior.getColumna()))
            {
                if (posicionActual.getColumna() < posicionAnterior.getColumna())
                {
                    posAntCol--;
                while ((casilla[posAntFil][posAntCol].getIcon() == null) && posAntCol > posicionActual.getColumna())
                {
                    posAntCol--;
                }
                if (posAntCol > posicionActual.getColumna())
                    hayFicha = true;
            }
            if (posicionActual.getColumna() > posicionAnterior.getColumna())
            {
                posAntCol++;
                while ((casilla[posAntFil][posAntCol].getIcon() == null) && posAntCol < posicionActual.getColumna())
                {
                    posAntCol++;
                }
                if (posAntCol < posicionActual.getColumna())
                    hayFicha = true;
            }   
            return hayFicha;
        }
        // Movimiento vertical
        if ((posicionActual.getFila() != posicionAnterior.getFila()) && (posicionActual.getColumna() ==posicionAnterior.getColumna()))
        {
            if (posicionActual.getFila() < posicionAnterior.getFila())
            {
                posAntFil--;
                while ((casilla[posAntFil][posAntCol].getIcon() == null) && posAntFil > posicionActual.getFila())
                {
                    posAntFil--;
                }
                if (posAntFil > posicionActual.getFila())
                    hayFicha = true;
                }
                if (posicionActual.getFila() > posicionAnterior.getFila())
                {
                    posAntFil++;
                    while ((casilla[posAntFil][posAntCol].getIcon() == null) && posAntFil < posicionActual.getFila())
                    {
                        posAntFil++;
                    }
                    if (posAntFil < posicionActual.getFila())
                        hayFicha = true;
                }            
            }
        }
        return hayFicha;
    }
    
    public void moverFicha(String seleccionActual, String seleccionAnterior)
    {
        movimientos.anadirMovimiento("blancas", seleccionActual, seleccionAnterior);
        tablero.ejecutarMovimiento(movimientos);
    }

    public final void mostrarTablero()
    {
        // Pasamos la posicion de las piezas a  la clase tablero
        tablero.colocarPiezas();
        // Colocamos las piezas en la vista                
        casilla[0][0].setIcon(new ImageIcon(VistaTablero.class.getResource("torren.png")));
        casilla[0][1].setIcon(new ImageIcon(VistaTablero.class.getResource("caballon.png")));
        casilla[0][2].setIcon(new ImageIcon(VistaTablero.class.getResource("alfiln.png")));
        casilla[0][3].setIcon(new ImageIcon(VistaTablero.class.getResource("reyn.png")));
        casilla[0][4].setIcon(new ImageIcon(VistaTablero.class.getResource("reinan.png")));
        casilla[0][5].setIcon(new ImageIcon(VistaTablero.class.getResource("alfiln.png")));
        casilla[0][6].setIcon(new ImageIcon(VistaTablero.class.getResource("caballon.png")));
        casilla[0][7].setIcon(new ImageIcon(VistaTablero.class.getResource("torren.png")));
        casilla[7][0].setIcon(new ImageIcon(VistaTablero.class.getResource("torreb.png")));
        casilla[7][1].setIcon(new ImageIcon(VistaTablero.class.getResource("caballob.png")));
        casilla[7][2].setIcon(new ImageIcon(VistaTablero.class.getResource("alfilb.png")));
        casilla[7][3].setIcon(new ImageIcon(VistaTablero.class.getResource("reyb.png")));
        casilla[7][4].setIcon(new ImageIcon(VistaTablero.class.getResource("reinab.png")));
        casilla[7][5].setIcon(new ImageIcon(VistaTablero.class.getResource("alfilb.png")));
        casilla[7][6].setIcon(new ImageIcon(VistaTablero.class.getResource("caballob.png")));
        casilla[7][7].setIcon(new ImageIcon(VistaTablero.class.getResource("torreb.png")));
        
        for (int i = 0; i < 8; i++) {
            casilla[1][i].setIcon(new ImageIcon(VistaTablero.class.getResource("peonn.png")));
            casilla[6][i].setIcon(new ImageIcon(VistaTablero.class.getResource("peonb.png")));
        }   
    }
    
    public void setEstado(String ultima, String turno, String pulsada){
        String estado = "Último movimiento: "+ultima+"\nJuegan "+turno+"\nSeleccionada: "+pulsada;
        informacion.setText(estado);
        validate();
        repaint();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        statusPanel = new javax.swing.JPanel();
        j1TextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        j2TextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jugarBoton = new javax.swing.JButton();
        tableroPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        j1TextField.setText("Jugador 1");
        j1TextField.setToolTipText("Nombre jugador 1");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Master Chess");

        j2TextField.setText("Jugador 2");
        j2TextField.setToolTipText("Nombre jugador 2");

        jLabel2.setText("Blancas");

        jLabel3.setText("Negras");

        jugarBoton.setText("Jugar");
        jugarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jugarBotonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(statusPanelLayout.createSequentialGroup()
                        .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(j1TextField)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(j2TextField, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jugarBoton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(5, 5, 5)
                .addComponent(j1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(j2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jugarBoton)
                .addContainerGap(234, Short.MAX_VALUE))
        );

        getContentPane().add(statusPanel, java.awt.BorderLayout.LINE_START);

        javax.swing.GroupLayout tableroPanelLayout = new javax.swing.GroupLayout(tableroPanel);
        tableroPanel.setLayout(tableroPanelLayout);
        tableroPanelLayout.setHorizontalGroup(
            tableroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 512, Short.MAX_VALUE)
        );
        tableroPanelLayout.setVerticalGroup(
            tableroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 433, Short.MAX_VALUE)
        );

        getContentPane().add(tableroPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jugarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jugarBotonActionPerformed
        // Activamos los botones
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                casilla[i][j].setEnabled(true);
            }
        }
        // Guardamos el nombre de los jugadores
        jugador1 = j1TextField.getText();
        jugador2 = j2TextField.getText();
        
        /* 
            Cambiamos al panel de estadisticas: 
            - Ultimo movimiento: orig, dest
            - Turno de blancas/negras
        */
        remove(statusPanel);
        
        // nuevo panel con borde y titulo
        JPanel estado = new JPanel();
        estado.setBorder(new TitledBorder("Jugadas"));
        
        // cuadro de texto que mostrara la informacion, con el color de fondo
        // del panel y que no sea editable por el usuario.
        informacion.setText("Último movimiento: d6 a3 \nJuegan Blancas: c8 a6");
        informacion.setBackground(this.getContentPane().getBackground());
        informacion.setEditable(false);
        
        // añadimos el cuadro de texto al panel
        estado.add(informacion, BorderLayout.CENTER);
        add(estado, BorderLayout.WEST);
        
        // refrescamos la vista
        validate();
        setVisible(true);
    }//GEN-LAST:event_jugarBotonActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(VistaTablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(VistaTablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(VistaTablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(VistaTablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
// //               VistaTablero tablero = new VistaTablero();
////                Pieza pieza = new Pieza();
////                tablero.setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField j1TextField;
    private javax.swing.JTextField j2TextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jugarBoton;
    private javax.swing.JPanel statusPanel;
    private javax.swing.JPanel tableroPanel;
    // End of variables declaration//GEN-END:variables

}
