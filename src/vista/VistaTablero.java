/*
 * Detached HEAD??
 * and open the template in the editor.
 */
package vista;

import ajedrez.Movimientos;
import ajedrez.IPieza;
import ajedrez.IJugador;
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
import javax.swing.JLabel;
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
    public static String seleccionAnterior;
    
    public static JButton casilla[][] = new JButton[8][8];
    /**
     * Creates new form VistaTablero
     */
    public VistaTablero(Tablero tab) 
    {
        
        tablero = tab;
        initComponents();  
        setSize(600,500);
        tableroPanel.setLayout(new GridLayout(8, 8));
        seleccionAnterior = " ";
        
        // Dibujamos el tablero: cada casilla sera un JButton.
        for (int i = 0; i < 8; i++) {
            final int fila = i;
            for (int j = 0; j < 8; j++) {
                final int columna = j;
                casilla[i][j] = new JButton();
                casilla[i][j].setSize(new Dimension(50,50));
                char[] c = {'a','b','c','d','e','f','g','h'};
                char[] f = {'8','7','6','5','4','3','2','1'};
                String s = new StringBuilder().append(c[columna]).append(f[fila]).toString();
                casilla[fila][columna].setActionCommand(s);
                casilla[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        setEstado("a6 c3", "Blancas: b2 h1", event.getActionCommand());
                        casilla[fila][columna].setSelected(true);
                        moverFicha(event.getActionCommand(),seleccionAnterior);
                        seleccionAnterior = event.getActionCommand();
                        
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
    
    public void moverFicha(String seleccionActual, String seleccionAnterior)
    {
        System.out.print(seleccionActual);
        System.out.print(seleccionAnterior);
        movimientos.anadirMovimiento("blancas", seleccionActual, seleccionAnterior);
        tablero.ejecutarMovimiento(movimientos);
    }

    public void mostrarTablero()
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
