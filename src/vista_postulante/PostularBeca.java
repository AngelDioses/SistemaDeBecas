/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista_postulante;

import BD.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.SesionUsuario;

/**
 *
 * @author ASUS ROG
 */
public class PostularBeca extends javax.swing.JPanel {

    /**
     * Creates new form PostularBeca
     */
    PanelEst pnl_principal ;
    login1 login;
    public PostularBeca(PanelEst pnl_principal ) {
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btn_postular = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(620, 520));

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Poppins", 0, 24)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("                     \n                  \n\n                   Bienvenido al Sistema de Becas!\n       Empieza tu camino hacia el éxito académico\n           postulando a nuestras becas disponibles.\n        Da el primer paso hoy mismo y descubre las\n             oportunidades que tenemos para ti.\n");
        jScrollPane1.setViewportView(jTextArea1);

        btn_postular.setBackground(new java.awt.Color(21, 101, 192));
        btn_postular.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_postular.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_postularMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_postularMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_postularMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_postularMousePressed(evt);
            }
        });
        btn_postular.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_postular.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 30, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Postular A Beca");
        btn_postular.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, 30));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addComponent(btn_postular, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_postular, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 55, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    //Metodo para que cuando clickeemos en 'postular' nos mande al panel de postulacion
    private void btn_postularMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_postularMouseClicked
        // Establece conexion
        Conexion con = new Conexion();
        Connection cn = con.getConnection();
        String sql = "SELECT haPostulado FROM usuariosEstudiantes WHERE correo = ?"; //Busca el estado de postulacion a traves de correo
        PreparedStatement statement;
        try {
            statement = cn.prepareStatement(sql);
            statement.setString(1, SesionUsuario.getInstancia().getUsuarioLogueado().getCorreo()); 
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                boolean yaHaPostulado = resultSet.getBoolean("haPostulado"); //Guardamos en una variable el resultado de busqueda
                if (yaHaPostulado) { //Si es true, entonces es porque ya hubo una postulacion
                    JOptionPane.showMessageDialog(this, "No puedes intentar volver a postular"); 
                }
                else{
                    Dashboard d = new Dashboard(); // Caso contrario mostrar el panel de postulacion
                    d.setVisible(true);
                    pnl_principal.dispose();
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_btn_postularMouseClicked

    private void btn_postularMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_postularMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_postularMouseEntered

    private void btn_postularMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_postularMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_postularMouseExited

    private void btn_postularMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_postularMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_postularMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btn_postular;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
