/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista_postulante;

import BD.Conexion;
import controlador.PostulanteControlador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import model.SesionUsuario;

/**
 *
 * @author ASUS ROG
 */
public class EstadoSolicitudAprobado extends javax.swing.JPanel {

    /**
     * Creates new form PostularBeca
     */
    PanelEst pnl_principal ;
    login1 login;
    public EstadoSolicitudAprobado(PanelEst pnl_principal ) {
        initComponents();
        this.pnl_principal = pnl_principal;
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lbl_estado = new javax.swing.JLabel();
        lbl_mensaje = new javax.swing.JLabel();
        btn_entrevista = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        lbl_mensaje1 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(620, 520));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel2.setText("Estado de la solicitud");

        lbl_estado.setBackground(new java.awt.Color(255, 255, 255));
        lbl_estado.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        lbl_estado.setForeground(new java.awt.Color(0, 51, 255));
        lbl_estado.setText("Aprobado");

        lbl_mensaje.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        lbl_mensaje.setText(" Responda con sinceridad el formulario");

        btn_entrevista.setBackground(new java.awt.Color(18, 90, 173));
        btn_entrevista.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_entrevista.setPreferredSize(new java.awt.Dimension(270, 51));
        btn_entrevista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_entrevistaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_entrevistaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_entrevistaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_entrevistaMousePressed(evt);
            }
        });
        btn_entrevista.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Tomar Entrevista");
        btn_entrevista.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 30));

        lbl_mensaje1.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        lbl_mensaje1.setText("Felicidades por la beca ! , haga Click en realizar entrevista.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(lbl_mensaje))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(btn_entrevista, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(195, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(52, Short.MAX_VALUE)
                    .addComponent(lbl_mensaje1)
                    .addGap(49, 49, 49)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addComponent(lbl_estado)
                .addGap(80, 80, 80)
                .addComponent(lbl_mensaje)
                .addGap(116, 116, 116)
                .addComponent(btn_entrevista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(149, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(136, 136, 136)
                    .addComponent(lbl_mensaje1)
                    .addContainerGap(368, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_entrevistaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_entrevistaMouseClicked
       PostulanteControlador control = new PostulanteControlador(pnl_principal);
       control.verificarEntrevista();
        
    }//GEN-LAST:event_btn_entrevistaMouseClicked
    private void tomarEntrevista(){
        pnl_principal.volverAlPanel(pnl_principal.e1, "respuesta1");
        
    }
    private void btn_entrevistaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_entrevistaMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_entrevistaMouseEntered

    private void btn_entrevistaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_entrevistaMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_entrevistaMouseExited

    private void btn_entrevistaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_entrevistaMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_entrevistaMousePressed
  



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btn_entrevista;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_estado;
    private javax.swing.JLabel lbl_mensaje;
    private javax.swing.JLabel lbl_mensaje1;
    // End of variables declaration//GEN-END:variables
}
