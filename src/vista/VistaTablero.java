/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author OneFranc
 */
public class VistaTablero extends javax.swing.JFrame {
    JButton casilla[][] = new JButton[8][8];
    /**
     * Creates new form VistaTablero
     */
    public VistaTablero() {
        initComponents();  
        setSize(500, 500);
        tableroPanel.setLayout(new GridLayout(8, 8));
        
        // Dibujamos el tablero: cada casilla sera un JButton.
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                casilla[i][j] = new JButton();
                casilla[i][j].setSize(new Dimension(50,50));

                if ((i + j) % 2 == 0) {
                    casilla[i][j].setBackground(new Color(0x00a6ac));
                } else {
                    casilla[i][j].setBackground(Color.white);
                }   
                tableroPanel.add(casilla[i][j]);
            }
        }
        // Colocamos las piezas        
        casilla[0][0].setIcon(new ImageIcon(VistaTablero.class.getResource("torren.png")));
        casilla[0][1].setIcon(new ImageIcon(VistaTablero.class.getResource("caballon.png")));
        casilla[0][2].setIcon(new ImageIcon(VistaTablero.class.getResource("alfiln.png")));
        casilla[0][3].setIcon(new ImageIcon(VistaTablero.class.getResource("reinan.png")));
        casilla[0][4].setIcon(new ImageIcon(VistaTablero.class.getResource("reyn.png")));
        casilla[0][5].setIcon(new ImageIcon(VistaTablero.class.getResource("alfiln.png")));
        casilla[0][6].setIcon(new ImageIcon(VistaTablero.class.getResource("caballon.png")));
        casilla[0][7].setIcon(new ImageIcon(VistaTablero.class.getResource("torren.png")));

        casilla[7][0].setIcon(new ImageIcon(VistaTablero.class.getResource("torreb.png")));
        casilla[7][1].setIcon(new ImageIcon(VistaTablero.class.getResource("caballob.png")));
        casilla[7][2].setIcon(new ImageIcon(VistaTablero.class.getResource("alfilb.png")));
        casilla[7][3].setIcon(new ImageIcon(VistaTablero.class.getResource("reinab.png")));
        casilla[7][4].setIcon(new ImageIcon(VistaTablero.class.getResource("reyb.png")));
        casilla[7][5].setIcon(new ImageIcon(VistaTablero.class.getResource("alfilb.png")));
        casilla[7][6].setIcon(new ImageIcon(VistaTablero.class.getResource("caballob.png")));
        casilla[7][7].setIcon(new ImageIcon(VistaTablero.class.getResource("torreb.png")));
        
        for (int i = 0; i < 8; i++) {
            casilla[1][i].setIcon(new ImageIcon(VistaTablero.class.getResource("peonn.png")));
            casilla[6][i].setIcon(new ImageIcon(VistaTablero.class.getResource("peonb.png")));
        }
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        statsPanel = new javax.swing.JPanel();
        statsLabel = new javax.swing.JLabel();
        tableroPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        statsLabel.setText("DeepBlue 2.0");

        javax.swing.GroupLayout statsPanelLayout = new javax.swing.GroupLayout(statsPanel);
        statsPanel.setLayout(statsPanelLayout);
        statsPanelLayout.setHorizontalGroup(
            statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statsLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        statsPanelLayout.setVerticalGroup(
            statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statsLabel)
                .addContainerGap(860, Short.MAX_VALUE))
        );

        getContentPane().add(statsPanel, java.awt.BorderLayout.LINE_START);

        tableroPanel.setLayout(new java.awt.GridLayout());
        getContentPane().add(tableroPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaTablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaTablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaTablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaTablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaTablero().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel statsLabel;
    private javax.swing.JPanel statsPanel;
    private javax.swing.JPanel tableroPanel;
    // End of variables declaration//GEN-END:variables
}
