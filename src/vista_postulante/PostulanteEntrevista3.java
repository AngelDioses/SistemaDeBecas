/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista_postulante;

import BD.Conexion;
import BD.DAOEstudiante;
import controlador.PostulanteControlador;
import controlador.controlador_estudiante;
import estructura.ListaEnlazada;
import estructura.Nodo;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
import vista_postulante.EstudianteDatosAcademicos;
import vista_postulante.Dashboard.*;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.Entrevista;
import model.Estudiante;
import model.PDFCombinador;
import model.ResumenPDF;
import model.SesionUsuario;
import model.Usuario;
import org.apache.pdfbox.multipdf.PDFMergerUtility;

/**
 *
 * @author ASUS ROG
 */
public class PostulanteEntrevista3 extends javax.swing.JPanel {

    /**
     * Creates new form EstudianteDatos
     */
    // En EstudianteDatosPersonales.java
    private ListaEnlazada<String> rutasPDF;
    private JFrame parentFrame;
    private PanelEst vistaPrincipal;
    private login1 login;
    private PostulanteControlador controlador;
    private Dashboard pr;

    public PostulanteEntrevista3(PanelEst vistaPrincipal) {

        initComponents();

        this.vistaPrincipal = vistaPrincipal;
        this.controlador = new PostulanteControlador(vistaPrincipal);
        parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        btn_finalizar.setBackground(Color.BLUE); // P.ej., azul en lugar del color de fondo de Windows
        btn_finalizar.setForeground(Color.WHITE);
        txt_r7.setLineWrap(true);
        txt_r7.setWrapStyleWord(true);
        txt_r8.setLineWrap(true);
        txt_r8.setWrapStyleWord(true);
       
    }

    public PostulanteEntrevista3(Dashboard vistaPrincipal) {

        initComponents();

        this.pr = vistaPrincipal;
        this.controlador = new PostulanteControlador(pr);
        parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        btn_finalizar.setBackground(Color.BLUE); // P.ej., azul en lugar del color de fondo de Windows
        btn_finalizar.setForeground(Color.WHITE);

    }

    private void finalizarClick() {
        //Se asegura que escojamos 4 pdfs
        String correo = SesionUsuario.getInstancia().getUsuarioLogueado().getCorreo();
        DAOEstudiante control = new DAOEstudiante();
        Estudiante estudiante = control.obtenerEstudiantePorCorreo(correo);
        
        controlador.guardarDatosEntrevista3(txt_r7, txt_r8);
        Entrevista entrevista = vistaPrincipal.getEntrevista(); // Debes implementar este método
        //Asignamos el puntaje al estudiante

        ResumenPDF generador = new ResumenPDF(entrevista);

        //Asignamos la ruta en el que guardaremos los pdfs
        String rutaEstudiante = "C:\\Users\\angel\\Desktop\\Entrevista\\" + estudiante.getCodigo();
          
        //Generamos el .tex con el metodo generarpdf
        generador.generarPDFEntrevista(rutaEstudiante + ".tex", entrevista,
                 "C:\\Users\\angel\\Desktop\\Entrevista", estudiante); //Es necesario instalar el MiKTexT

    }

    public boolean actualizarEstado(String usuarioCorreo) {
        String updateSql = "UPDATE usuariosEstudiantes SET esEntrevistado = 1 WHERE correo = ?";
        Conexion conexion = new Conexion();
        try (Connection cn = conexion.getConnection();
                PreparedStatement updateStatement = cn.prepareStatement(updateSql)) {

            // Actualiza a haPostulado = true
            updateStatement.setString(1, usuarioCorreo);
            updateStatement.executeUpdate();
            return true; // Postulación permitida y estado actualizado

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Por defecto no permitir postulación si hay excepción
    }

    @SuppressWarnings("unchecked")


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jOptionPane1 = new javax.swing.JOptionPane();
        jPanel1 = new javax.swing.JPanel();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        pnl_datosPersonales = new javax.swing.JPanel();
        btn_finalizar = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txt_r7 = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_r8 = new javax.swing.JTextArea();
        btn_anterior = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        jToggleButton1.setText("jToggleButton1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        pnl_datosPersonales.setBackground(new java.awt.Color(255, 255, 255));
        pnl_datosPersonales.setPreferredSize(new java.awt.Dimension(0, 539));

        btn_finalizar.setBackground(new java.awt.Color(21, 101, 192));
        btn_finalizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_finalizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_finalizarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_finalizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_finalizarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_finalizarMousePressed(evt);
            }
        });
        btn_finalizar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Finalizar");
        btn_finalizar.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, 30));

        jLabel8.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel8.setText("¿Estás dispuesto a participar en actividades o eventos relacionados con la beca? ");

        txt_r7.setColumns(20);
        txt_r7.setRows(5);
        jScrollPane3.setViewportView(txt_r7);

        jLabel10.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel10.setText("cómo planeas administrar los fondos de la beca? ");

        txt_r8.setColumns(20);
        txt_r8.setRows(5);
        jScrollPane1.setViewportView(txt_r8);

        btn_anterior.setBackground(new java.awt.Color(21, 101, 192));
        btn_anterior.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_anterior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_anteriorMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_anteriorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_anteriorMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_anteriorMousePressed(evt);
            }
        });
        btn_anterior.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        btn_anterior.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 30, 30));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Anterior");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        btn_anterior.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, 30));

        jLabel11.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel11.setText("¿Podrías proporcionarnos una visión más detallada de tu situación financiera y ");

        javax.swing.GroupLayout pnl_datosPersonalesLayout = new javax.swing.GroupLayout(pnl_datosPersonales);
        pnl_datosPersonales.setLayout(pnl_datosPersonalesLayout);
        pnl_datosPersonalesLayout.setHorizontalGroup(
            pnl_datosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_datosPersonalesLayout.createSequentialGroup()
                .addGroup(pnl_datosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_datosPersonalesLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(pnl_datosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 856, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnl_datosPersonalesLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(btn_anterior, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(163, 163, 163)
                                .addComponent(btn_finalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnl_datosPersonalesLayout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_datosPersonalesLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(pnl_datosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_datosPersonalesLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel8))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_datosPersonalesLayout.setVerticalGroup(
            pnl_datosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_datosPersonalesLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(pnl_datosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_anterior, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_finalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(138, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_datosPersonales, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_datosPersonales, javax.swing.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_finalizarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_finalizarMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_finalizarMousePressed

    private void btn_finalizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_finalizarMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_finalizarMouseExited

    private void btn_finalizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_finalizarMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_finalizarMouseEntered

    private void btn_finalizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_finalizarMouseClicked
        //Finalizamos el panel de postulacion
        finalizarClick();
        //Creamos un objeto del panel de estudiante para volver
        PanelEst principal = new PanelEst();
        String usuarioCorreo = SesionUsuario.getInstancia().getUsuarioLogueado().getCorreo();
        actualizarEstado(usuarioCorreo);
        JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);

        if (parentFrame != null) {
            parentFrame.dispose(); // Cierra la ventana actual
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo cerrar la ventana.");
        }
        principal.setVisible(true);

    }//GEN-LAST:event_btn_finalizarMouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel12MouseClicked

    private void btn_anteriorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_anteriorMouseClicked

        vistaPrincipal.retroceder();
        System.out.println();
    }//GEN-LAST:event_btn_anteriorMouseClicked

    private void btn_anteriorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_anteriorMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_anteriorMouseEntered

    private void btn_anteriorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_anteriorMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_anteriorMouseExited

    private void btn_anteriorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_anteriorMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_anteriorMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btn_anterior;
    private javax.swing.JPanel btn_finalizar;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JPanel pnl_datosPersonales;
    private javax.swing.JTextArea txt_r7;
    private javax.swing.JTextArea txt_r8;
    // End of variables declaration//GEN-END:variables
}
