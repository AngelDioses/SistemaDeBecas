/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista_postulante;

import BD.Conexion;
import BD.DAOEstudiante;
import controlador.GestorDeNavegacion;
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
import model.Estudiante;
import model.PDFCombinador;
import model.ResumenPDF;
import model.SesionUsuario;
import org.apache.pdfbox.multipdf.PDFMergerUtility;

/**
 *
 * @author ASUS ROG
 */
public class EstudianteSustento extends javax.swing.JPanel {

    /**
     * Creates new form EstudianteDatos
     */
    // En EstudianteDatosPersonales.java
    private Dashboard vistaPrincipal;
    private ListaEnlazada<String> rutasPDF;
    private JFrame parentFrame;
 

    public EstudianteSustento(Dashboard vistaPrincipal) {

        initComponents();
        rutasPDF = new ListaEnlazada<>();
        this.vistaPrincipal = vistaPrincipal;

        parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        btn_finalizar.setBackground(Color.BLUE); // P.ej., azul en lugar del color de fondo de Windows
        btn_finalizar.setForeground(Color.WHITE);

    }

    private void recolectarRutasPDF(JFrame parent) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setMultiSelectionEnabled(true);
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("PDF Documents", "pdf"));

        int option = fileChooser.showOpenDialog(parent);
        if (option == JFileChooser.APPROVE_OPTION) {
            File[] archivosSeleccionados = fileChooser.getSelectedFiles();
            if (archivosSeleccionados.length == 4) {
                for (File archivo : archivosSeleccionados) {
                    rutasPDF.añadir(archivo.getAbsolutePath());
                }
            } else {
                JOptionPane.showMessageDialog(parent, "Debes seleccionar exactamente 4 archivos PDF.");
            }
        }
    }

    private void finalizarClick() {
        //Se asegura que escojamos 4 pdfs
        if (rutasPDF.getTamaño() == 4) {
            Estudiante estudiante = vistaPrincipal.getEstudiante(); // Debes implementar este método
            //Asignamos el puntaje al estudiante
            estudiante.setPuntuacion(vistaPrincipal.getPuntuacion());
            ResumenPDF generador = new ResumenPDF(estudiante);
            PDFCombinador combinador = new PDFCombinador();
            //Asignamos la ruta en el que guardaremos los pdfs

            String rutaEstudiante = "C:\\Users\\ASUS ROG\\Desktop\\Reportes\\" + estudiante.getCodigo(); //Ajustar ruta segun a donde quieras que se guarden

            //Generamos el .tex con el metodo generarpdf
            generador.generarPdfEstudiante(rutaEstudiante + ".tex", estudiante, "C:\\Users\\ASUS ROG\\Desktop\\Reportes"); //Es necesario instalar el MiKTexT

            //Combinamos los pdfs
            combinador.combinarPDFsDirectamente(rutasPDF, estudiante);

            //Accedemos a la bd de los estudiantes
            DAOEstudiante daoEstudiante = new DAOEstudiante();
            //Insertamos el estudiante que acaba de postular y ponemos en 'haPostulado' 

            daoEstudiante.insertarEstudiante(estudiante, "INSERT INTO "
                    + "postulantes (nombres, codigo, puntuacion, estado,correo) VALUES (?, ?, ?, ? ,?);");
            actualizarEstado(SesionUsuario.getInstancia().getUsuarioLogueado().getCorreo());
            //Abrimos la ventana principal
            JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);

            if (parentFrame != null) {
                parentFrame.dispose(); // Cierra la ventana actual
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo cerrar la ventana.");
            }
        }
    }

    public boolean actualizarEstado(String usuarioCorreo) {
        String updateSql = "UPDATE usuariosEstudiantes SET haPostulado = 1 WHERE correo = ?";
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
        pnl_datosPersonales = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        btn_finalizar = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btn_guardar = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btn_anterior = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
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

        pnl_datosPersonales.setBackground(new java.awt.Color(255, 255, 255));
        pnl_datosPersonales.setPreferredSize(new java.awt.Dimension(0, 539));

        jLabel9.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel9.setText("Por favor, seleccione los siguientes documentos en el orden indicado y en formato PDF:");

        jLabel16.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel16.setText("1. DNI");

        jLabel17.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel17.setText("4. Comprobante de promedio");

        jLabel18.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel18.setText("2. Reporte de matrícula ");

        jLabel19.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel19.setText("3. Certificado de SISFOH");

        jLabel20.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel20.setText("Haga clic en '...' para seleccionar los archivos.");

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

        btn_guardar.setBackground(new java.awt.Color(0, 0, 0));
        btn_guardar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_guardarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_guardarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_guardarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_guardarMousePressed(evt);
            }
        });
        btn_guardar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("...");
        btn_guardar.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, -1, 30));

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

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Anterior");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        btn_anterior.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, 30));

        javax.swing.GroupLayout pnl_datosPersonalesLayout = new javax.swing.GroupLayout(pnl_datosPersonales);
        pnl_datosPersonales.setLayout(pnl_datosPersonalesLayout);
        pnl_datosPersonalesLayout.setHorizontalGroup(
            pnl_datosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_datosPersonalesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_finalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
            .addGroup(pnl_datosPersonalesLayout.createSequentialGroup()
                .addGroup(pnl_datosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_datosPersonalesLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(pnl_datosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel9)
                            .addGroup(pnl_datosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel20)
                                .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(btn_anterior, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnl_datosPersonalesLayout.createSequentialGroup()
                        .addGap(342, 342, 342)
                        .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(170, Short.MAX_VALUE))
        );
        pnl_datosPersonalesLayout.setVerticalGroup(
            pnl_datosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_datosPersonalesLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(pnl_datosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnl_datosPersonalesLayout.createSequentialGroup()
                        .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)
                        .addComponent(btn_finalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_anterior, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_datosPersonales, javax.swing.GroupLayout.DEFAULT_SIZE, 822, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnl_datosPersonales, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_finalizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_finalizarMouseClicked
        //Finalizamos el panel de postulacion
        finalizarClick();
        //Creamos un objeto del panel de estudiante para volver
        PanelEst principal = new PanelEst();
        //Actualizamos el booleano "haPostulado" a true a traves del correo del usuario
        actualizarEstado(SesionUsuario.getInstancia().getUsuarioLogueado().getCorreo());

        principal.setVisible(true);
        System.out.println("antes: " + GestorDeNavegacion.obtenerInstancia().getHistorial());
        GestorDeNavegacion.obtenerInstancia().getHistorial().vaciarPila();
        System.out.println(GestorDeNavegacion.obtenerInstancia().getHistorial());
        System.out.println("despues: " + GestorDeNavegacion.obtenerInstancia().getHistorial());

    }//GEN-LAST:event_btn_finalizarMouseClicked

    private void btn_finalizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_finalizarMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_finalizarMouseEntered

    private void btn_finalizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_finalizarMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_finalizarMouseExited

    private void btn_finalizarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_finalizarMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_finalizarMousePressed

    private void btn_guardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_guardarMouseClicked
        recolectarRutasPDF(parentFrame); // Recolectamos las rutas pdf del ...
    }//GEN-LAST:event_btn_guardarMouseClicked

    private void btn_guardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_guardarMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_guardarMouseEntered

    private void btn_guardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_guardarMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_guardarMouseExited

    private void btn_guardarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_guardarMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_guardarMousePressed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseClicked

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
    private javax.swing.JPanel btn_guardar;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JPanel pnl_datosPersonales;
    // End of variables declaration//GEN-END:variables
}
