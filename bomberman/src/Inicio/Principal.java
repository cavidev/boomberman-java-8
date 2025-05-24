package Inicio;

import Clases.Jugador;
import Interfaz.Estadisticas;
import Interfaz.Registro;
import java.applet.AudioClip;
import java.util.LinkedList;
import javax.swing.Timer;

/**
 *
 * @author Carlos Mario
 */
public class Principal extends javax.swing.JFrame 
{
    //private Fondo fondo;
    public static LinkedList<Jugador> jugadores = new LinkedList();
    private Registro ventanaRegistro;
    Timer timer;
    
    public Principal() 
    {
        musica();
        initComponents();        
        this.ventanaRegistro = new Registro(this);
        this.setLocationRelativeTo(null);
        /*fondo = new Fondo();
        fondo.setBounds(0, 0, 500, 500);
        this.add(fondo);*/
    }

    public void musica(){AudioClip sonidoJuego = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/juego.mid"));sonidoJuego.play();}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nivelDificultad = new javax.swing.ButtonGroup();
        bComenzar = new javax.swing.JButton();
        bEstadisticas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Principal");

        bComenzar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        bComenzar.setText("Comenzar");
        bComenzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bComenzarActionPerformed(evt);
            }
        });

        bEstadisticas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        bEstadisticas.setText("Estadisticas");
        bEstadisticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEstadisticasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(202, 202, 202)
                        .addComponent(bComenzar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(bEstadisticas, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(197, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(398, Short.MAX_VALUE)
                .addComponent(bComenzar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bEstadisticas)
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bComenzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bComenzarActionPerformed
        this.setVisible(false);
        ventanaRegistro.setVisible(true);
    }//GEN-LAST:event_bComenzarActionPerformed

    private void bEstadisticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEstadisticasActionPerformed
        Estadisticas resultados = new Estadisticas(this);
        resultados.agregarResultados();
        resultados.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bEstadisticasActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bComenzar;
    private javax.swing.JButton bEstadisticas;
    private javax.swing.ButtonGroup nivelDificultad;
    // End of variables declaration//GEN-END:variables
}
