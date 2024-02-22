package vista_admin1;

import vista_admin1.ControlPostulantes1;
import BD.DAOEstudiante;
import BD.DAOPostulante;
import controlador.controlador_estudiante;
import estructura.ArbolBinario;
import estructura.Cola;
import estructura.ListaEnlazada;
import estructura.ListaEnlazadaDoble;
import estructura.Nodo;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Estudiante;
import model.ResumenPDF;
import vista_postulante.Dashboard;

public class VisualizarPostulantes extends javax.swing.JPanel {

    //Configuraciones iniciales
    Dashboard dashboard;
    double puntuacion;
    DefaultTableModel modelo;
    ListaEnlazadaDoble<Estudiante> listaEstudiantes;
    ControlPostulantes1 vistaPrincipal;
    Estudiante estudiante;
   
    ArbolBinario arbol = new ArbolBinario().obtenerArbol();

    public VisualizarPostulantes(ControlPostulantes1 vistaPrincipal) {
        initComponents();

        this.vistaPrincipal = vistaPrincipal;
        listaEstudiantes = new DAOEstudiante().obtenerEstudiantes(); //Inicializamos la lista doble con los estudiantes de la BD
        llenarTablaConEstudiantes(); //Llenamos el Jtable con los estudiantes - Metodo declarado despues
                                     
        //Si presionamos en la columna del codigo abrimos el reporte
        tb_postulantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) { //mouseevent
                int fila = tb_postulantes.rowAtPoint(evt.getPoint()); //filaseleccionada en el jtable
                int columna = tb_postulantes.columnAtPoint(evt.getPoint()); //columnaseleccionada en jtable

                if (columna == 1) { //Si presionamos en el codigo del estudiante
                    Estudiante estudiante = listaEstudiantes.obtenerPorIndice(fila); // Obtiene el estudiante de la fila clickeada
                    controlador_estudiante controlador = new controlador_estudiante(dashboard);
                    controlador.abrirPDF(estudiante); //Generamos su pdf
                }
            }
        });

    }

    //Uso de lista Enlazada para llenar el jtable
    private void llenarTablaConEstudiantes() {
        //Establecemos los encabezados de las columnas
        String[] titulos = {"Nombre", "Código", "Puntuación", "Estado"};
        modelo = new DefaultTableModel(null, titulos);

        // Llenar el modelo con datos
        Nodo<Estudiante> actual = listaEstudiantes.getInicio(); //Accedemos al primer estudiante de la lista
        //Empezamos a iterar
        while (actual != null) {
            Estudiante estudiante = actual.getElemento();
            estudiante.setEstado("Pendiente");
            Object[] fila = new Object[]{
                estudiante.getNombres_completos(),
                estudiante.getCodigo(),
                estudiante.getPuntuacion(),
                estudiante.getEstado()
            };
            modelo.addRow(fila); //Agregamos los datos al jtable
            actual = actual.getSiguiente(); //Accedemos al siguiente estudiante
        }

        // Asignar el modelo al jTable1
        tb_postulantes.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_visualizarP = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_postulantes = new javax.swing.JTable();
        btn_seleccionar = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btn_eliminar = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btn_actualizar = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        btnPreOrden = new javax.swing.JButton();
        btnInOrden = new javax.swing.JButton();
        btnPostOrden1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        pnl_visualizarP.setBackground(new java.awt.Color(255, 255, 255));

        tb_postulantes.setBackground(new java.awt.Color(255, 232, 214));
        tb_postulantes.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        tb_postulantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tb_postulantes);

        btn_seleccionar.setBackground(new java.awt.Color(0, 0, 0));
        btn_seleccionar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_seleccionar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_seleccionarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_seleccionarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_seleccionarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_seleccionarMousePressed(evt);
            }
        });
        btn_seleccionar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Seleccionar");
        btn_seleccionar.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 30));

        btn_eliminar.setBackground(new java.awt.Color(0, 0, 0));
        btn_eliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_eliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_eliminarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_eliminarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_eliminarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_eliminarMousePressed(evt);
            }
        });
        btn_eliminar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Eliminar");
        btn_eliminar.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, 30));

        btn_actualizar.setBackground(new java.awt.Color(0, 0, 0));
        btn_actualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_actualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_actualizarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_actualizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_actualizarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_actualizarMousePressed(evt);
            }
        });
        btn_actualizar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Actualizar");
        btn_actualizar.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 30));

        btnPreOrden.setText("PreOrden");
        btnPreOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreOrdenActionPerformed(evt);
            }
        });

        btnInOrden.setText("InOrden");
        btnInOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInOrdenActionPerformed(evt);
            }
        });

        btnPostOrden1.setText("PostOrden");
        btnPostOrden1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPostOrden1ActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel1.setText("Ordena a los postulantes ");

        javax.swing.GroupLayout pnl_visualizarPLayout = new javax.swing.GroupLayout(pnl_visualizarP);
        pnl_visualizarP.setLayout(pnl_visualizarPLayout);
        pnl_visualizarPLayout.setHorizontalGroup(
            pnl_visualizarPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_visualizarPLayout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(btnPreOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94)
                .addComponent(btnInOrden, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                .addGap(99, 99, 99)
                .addComponent(btnPostOrden1, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                .addGap(101, 101, 101))
            .addGroup(pnl_visualizarPLayout.createSequentialGroup()
                .addGroup(pnl_visualizarPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_visualizarPLayout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(jLabel1)
                        .addGap(64, 64, 64))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_visualizarPLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)))
                .addGroup(pnl_visualizarPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_seleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_visualizarPLayout.setVerticalGroup(
            pnl_visualizarPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_visualizarPLayout.createSequentialGroup()
                .addGroup(pnl_visualizarPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_visualizarPLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_seleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(292, 292, 292))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_visualizarPLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)))
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(pnl_visualizarPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPostOrden1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPreOrden))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl_visualizarP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl_visualizarP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 51, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
//Metodo para seleccionar el estudiant 
    private void btn_seleccionarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_seleccionarMouseClicked

        int filaSeleccionada = tb_postulantes.getSelectedRow(); 
        //Si seleccionamos una fila
        if (filaSeleccionada >= 0) {
            Estudiante estudianteSeleccionado = listaEstudiantes.obtenerPorIndice(filaSeleccionada); //Obtenemos el estudiante
            estudianteSeleccionado.setEstado("Aprobado");//Le asignamos aprobado en su atributo 'Estado'
            //Actualizamos en la BD su 'estado' atraves de DAOEstudiante
            DAOEstudiante controlador = new DAOEstudiante();
            controlador.actualizarEstadoEstudiante(estudianteSeleccionado);
            //Insertamos el estudiante en la BD seleccionados
            controlador.insertarEstudiante(estudianteSeleccionado, "INSERT INTO seleccionados "
                    + "(nombres, codigo, puntuacion, estado, correo) VALUES (?, ?, ?, ?,?);");

        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un estudiante de la lista.",
                    "Ningún estudiante seleccionado", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_btn_seleccionarMouseClicked

    private void btn_seleccionarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_seleccionarMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_seleccionarMouseEntered

    private void btn_seleccionarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_seleccionarMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_seleccionarMouseExited

    private void btn_seleccionarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_seleccionarMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_seleccionarMousePressed

    private void btn_eliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_eliminarMouseClicked
        int filaSeleccionada = tb_postulantes.getSelectedRow(); // Obtén la fila seleccionada
        if (filaSeleccionada != -1) { // Verifica si hay una fila seleccionada
            Estudiante estudiante = listaEstudiantes.obtenerPorIndice(filaSeleccionada); // Obtiene el estudiante de la lista
            if (estudiante != null) {
                listaEstudiantes.eliminar(estudiante); // Elimina el estudiante de la lista
                ((DefaultTableModel) tb_postulantes.getModel()).removeRow(filaSeleccionada); // Elimina la fila de la tabla
                DAOPostulante control = new DAOPostulante();
                control.eliminarEstudianteEnBD(estudiante);
            }
        } else {
            // Si no hay ninguna fila seleccionada, puedes mostrar un mensaje de error o advertencia.
            JOptionPane.showMessageDialog(null, "Por favor, selecciona un estudiante para eliminar.");
        }
    }//GEN-LAST:event_btn_eliminarMouseClicked

    private void btn_eliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_eliminarMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_eliminarMouseEntered

    private void btn_eliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_eliminarMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_eliminarMouseExited

    private void btn_eliminarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_eliminarMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_eliminarMousePressed
    //Parecido a llenarTabla , pero primero cargamos la listaenlazadadoble y de acuerdo a los cambios lo actualizamos
    private void btn_actualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_actualizarMouseClicked
        DefaultTableModel modelo = new DefaultTableModel(new Object[]{
            "Nombre", "Código", "Puntuación", "Estado"}, 0); 
        DAOPostulante control = new DAOPostulante();
        ListaEnlazadaDoble<Estudiante> listaEstudiantes = new ListaEnlazadaDoble<>();
        control.cargarEstudiantesDeBD(listaEstudiantes, "SELECT * FROM postulantes");
        Nodo<Estudiante> actual = listaEstudiantes.getInicio();
        while (actual != null) {
            Estudiante estudiante = actual.getElemento();
            Object[] fila = new Object[]{
                estudiante.getNombres_completos(),
                estudiante.getCodigo(),
                estudiante.getPuntuacion(),
                estudiante.getEstado(),
                
            };
            modelo.addRow(fila);
            actual = actual.getSiguiente();
        }

        // Asignar el modelo al jTable1
        tb_postulantes.setModel(modelo);

    }//GEN-LAST:event_btn_actualizarMouseClicked

    private void btn_actualizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_actualizarMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_actualizarMouseEntered

    private void btn_actualizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_actualizarMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_actualizarMouseExited

    private void btn_actualizarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_actualizarMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_actualizarMousePressed

    private void btnPreOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreOrdenActionPerformed
        arbol.preOrden(tb_postulantes);
    }//GEN-LAST:event_btnPreOrdenActionPerformed

    private void btnInOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInOrdenActionPerformed
        arbol.inOrden(tb_postulantes);
    }//GEN-LAST:event_btnInOrdenActionPerformed

    private void btnPostOrden1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPostOrden1ActionPerformed
        arbol.postOrden(tb_postulantes);
    }//GEN-LAST:event_btnPostOrden1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInOrden;
    private javax.swing.JButton btnPostOrden1;
    private javax.swing.JButton btnPreOrden;
    private javax.swing.JPanel btn_actualizar;
    private javax.swing.JPanel btn_eliminar;
    private javax.swing.JPanel btn_seleccionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnl_visualizarP;
    private javax.swing.JTable tb_postulantes;
    // End of variables declaration//GEN-END:variables
}
