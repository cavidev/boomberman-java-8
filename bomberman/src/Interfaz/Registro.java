package Interfaz;

import Clases.Jugador;
import Inicio.Principal;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos Mario
 */
public class Registro extends javax.swing.JFrame 
{
    private Principal ventanaPrincipal;
    
    public Registro(Principal ventanaP) 
    {
        initComponents();
        this.ventanaPrincipal = ventanaP;
        FondoEmpezar empezar = new FondoEmpezar();
        this.add(empezar);
        
        nivelDificultad.add(bRFacil);
        nivelDificultad.add(bRMedio);
        nivelDificultad.add(bRDificil);
        
        this.setLocationRelativeTo(null);
        empezar.setBounds(0, 0, 500, 500);
        this.add(empezar);
    }

    public void limpiarVentana()
    {
        this.nivelDificultad.clearSelection();
        this.nombreJugador.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nivelDificultad = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        bRDificil = new javax.swing.JRadioButton();
        bRMedio = new javax.swing.JRadioButton();
        bRFacil = new javax.swing.JRadioButton();
        bComenzar = new javax.swing.JButton();
        nombreJugador = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        bCancelar = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Empezar");

        bRDificil.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        bRDificil.setText("Juego Dificil");

        bRMedio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        bRMedio.setText("Juego Medio");

        bRFacil.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        bRFacil.setText("Juego Facil");

        bComenzar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        bComenzar.setText("Comenzar Juego");
        bComenzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bComenzarActionPerformed(evt);
            }
        });

        nombreJugador.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Jokerman", 0, 18)); // NOI18N
        jLabel1.setText("Digite su nombre");

        jLabel2.setFont(new java.awt.Font("Jokerman", 0, 18)); // NOI18N
        jLabel2.setText("Seleccione Dificultad");

        bCancelar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        bCancelar.setText("Cancelar");
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bRDificil)
                    .addComponent(bRMedio)
                    .addComponent(bRFacil))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombreJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bComenzar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bCancelar)))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombreJugador, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bRFacil, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bRMedio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bRDificil)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bComenzar)
                    .addComponent(bCancelar))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bComenzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bComenzarActionPerformed
        Jugador nuevo;
        if(bRFacil.isSelected())
        {
            if(nombreJugador.getText().equals(""))
            {nuevo = new Jugador("Usuario");}
            else
            {nuevo = new Jugador(nombreJugador.getText());}
            
            Escenario juego = new Escenario(11,11,502,521, 12, 5,nuevo,ventanaPrincipal);
            Principal.jugadores.add(nuevo);

            limpiarVentana();
            this.dispose();
            juego.setVisible(true);
        }
        else if(bRMedio.isSelected())
        {
            if(nombreJugador.getText().equals(""))
            {nuevo = new Jugador("Usuario");}
            else
            {nuevo = new Jugador(nombreJugador.getText());}
         
            Escenario juego = new Escenario(15,15,683,705,23,15,nuevo,ventanaPrincipal);
            Principal.jugadores.add(nuevo);
            limpiarVentana();
            this.dispose();
            juego.setVisible(true);
        }
        else if(bRDificil.isSelected())
        {
            if(nombreJugador.getText().equals(""))
            {nuevo = new Jugador("Usuario");}
            else
            {nuevo = new Jugador(nombreJugador.getText());}
            
            Escenario juego = new Escenario(26,15,1178,705,40,20,nuevo,ventanaPrincipal);
            Principal.jugadores.add(nuevo);
            limpiarVentana();
            this.dispose();
            juego.setVisible(true);
        }
        else
        {JOptionPane.showMessageDialog(null,"¡¡¡No selecciono el nivel de dificultad!!!","Atencion",JOptionPane.ERROR_MESSAGE);}
    }//GEN-LAST:event_bComenzarActionPerformed

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        limpiarVentana();
        this.dispose();
        this.ventanaPrincipal.setVisible(true);
    }//GEN-LAST:event_bCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bComenzar;
    private javax.swing.JRadioButton bRDificil;
    private javax.swing.JRadioButton bRFacil;
    private javax.swing.JRadioButton bRMedio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.ButtonGroup nivelDificultad;
    private javax.swing.JTextField nombreJugador;
    // End of variables declaration//GEN-END:variables
}
