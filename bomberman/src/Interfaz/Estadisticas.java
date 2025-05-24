package Interfaz;

import Clases.Jugador;
import Inicio.Principal;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carlos Mario
 */
public class Estadisticas extends javax.swing.JFrame 
{
    private DefaultTableModel modelo;
    private Principal ventanaPrincipal;
    
    public Estadisticas(Principal ventanaP) 
    {
        initComponents();
        this.setLocationRelativeTo(null);
        this.ventanaPrincipal = ventanaP;
        this.modelo = (DefaultTableModel) resultados.getModel();
    }

    public void agregarResultados()
    {
        int tamaño = Principal.jugadores.size();
        for(Jugador jugador : Principal.jugadores)
        {
            modelo.addRow(new Object[]{jugador.getNombre(),jugador.getEstado()});
        }
             
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        resultados = new javax.swing.JTable();
        bAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        resultados.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        resultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Jugador", "Nivel Dificultad", "Tiempo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(resultados);

        bAceptar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        bAceptar.setText("Aceptar");
        bAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bAceptar)
                .addGap(55, 55, 55))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(bAceptar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAceptarActionPerformed
        this.ventanaPrincipal.setVisible(true);
        //this.resultados.removeAll();
        this.dispose();
    }//GEN-LAST:event_bAceptarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAceptar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable resultados;
    // End of variables declaration//GEN-END:variables
}
