package vista_admin1;

import vista_admin1.ControlPostulantes1;
import BD.DAOEstudiante;
import BD.DAOPostulante;
import controlador.PostulanteControlador;
import controlador.controlador_estudiante;
import estructura.Cola;
import estructura.ListaEnlazada;
import estructura.ListaEnlazadaDoble;
import estructura.Nodo;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Estudiante;
import model.ResumenPDF;
import vista_postulante.Dashboard;

public class ControlSeleccionados extends javax.swing.JPanel {

    Dashboard dashboard;
    double puntuacion;
    DefaultTableModel modelo;
    ListaEnlazadaDoble<Estudiante> listaEstudiantes;
    ControlPostulantes1 vistaPrincipal;
    Estudiante estudiante;
    Cola<Estudiante> colaAprobados;
   

    public ControlSeleccionados(ControlPostulantes1 vistaPrincipal) {
        initComponents();

        
        this.vistaPrincipal = vistaPrincipal;
        this.colaAprobados = vistaPrincipal.getColaAprobados(); 
        listaEstudiantes = new DAOEstudiante().obtenerEstudiantes();
        //Si presionamos en la columna del codigo abrimos el reporte
        tb_seleccionados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int fila = tb_seleccionados.rowAtPoint(evt.getPoint());
                int columna = tb_seleccionados.columnAtPoint(evt.getPoint());

                if (columna == 1) { 
                    Estudiante estudiante = listaEstudiantes.obtenerPorIndice(fila); // Obtiene el estudiante de la fila clickeada
                    PostulanteControlador controlador = new PostulanteControlador(dashboard);
                    controlador.abrirPDFEntrevista(estudiante);
                }
            }
        });
        llenarTablaConEstudiantes();

    }

    private void llenarTablaConEstudiantes() {
        String[] titulos = {"Nombre", "Código", "Puntuación", "Estado"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        Cola<Estudiante> colaAprobados = new Cola<>();
        DAOPostulante seleccionados = new DAOPostulante();
        seleccionados.cargarEstudiantesDeBD(colaAprobados,
                "SELECT * FROM seleccionados");
        // Recorremos los nodos sin desencolarlos
        // Recorre la cola y añade cada estudiante al modelo de la tabla
        while (!colaAprobados.isEmpty()) { // Asumiendo que tienes un método que verifica si la cola está vacía
            Estudiante estudiante = colaAprobados.desencolar(); // O el método que uses para obtener el siguiente elemento
            modelo.addRow(new Object[]{
                estudiante.getNombres_completos(),
                estudiante.getCodigo(),
                estudiante.getPuntuacion(),
                estudiante.getEstado()
            });
        }

        // Asigna el modelo al JTable y actualiza la UI
        tb_seleccionados.setModel(modelo);
        tb_seleccionados.revalidate();
        tb_seleccionados.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_visualizarP = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_seleccionados = new javax.swing.JTable();
        btn_actualizar = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        pnl_visualizarP.setBackground(new java.awt.Color(255, 255, 255));

        tb_seleccionados.setBackground(new java.awt.Color(255, 232, 214));
        tb_seleccionados.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        tb_seleccionados.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tb_seleccionados);

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
        btn_actualizar.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, -1, 30));

        jLabel1.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel1.setText("Para revisar las respuestas en la entrevista de los seleccionados");

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel2.setText(" apreta click en su codigo");

        javax.swing.GroupLayout pnl_visualizarPLayout = new javax.swing.GroupLayout(pnl_visualizarP);
        pnl_visualizarP.setLayout(pnl_visualizarPLayout);
        pnl_visualizarPLayout.setHorizontalGroup(
            pnl_visualizarPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_visualizarPLayout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addGroup(pnl_visualizarPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_visualizarPLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(129, 129, 129))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_visualizarPLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_visualizarPLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(229, 229, 229))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_visualizarPLayout.createSequentialGroup()
                        .addComponent(btn_actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(257, 257, 257))))
        );
        pnl_visualizarPLayout.setVerticalGroup(
            pnl_visualizarPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_visualizarPLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(btn_actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
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
                .addGap(0, 57, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_actualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_actualizarMouseClicked
        // Inicializa el modelo con los títulos de las columnas
        DefaultTableModel modelo = new DefaultTableModel(new Object[]{
            "Nombre", "Código", "Puntuación", "Estado"}, 0);

        DAOPostulante control = new DAOPostulante();
        ListaEnlazadaDoble<Estudiante> listaEstudiantes = new ListaEnlazadaDoble<>();
        control.cargarEstudiantesDeBD(listaEstudiantes, "SELECT * FROM seleccionados");

        Nodo<Estudiante> actual = listaEstudiantes.getInicio();
        while (actual != null) {
            Estudiante estudiante = actual.getElemento();
            Object[] fila = new Object[]{
                estudiante.getNombres_completos(),
                estudiante.getCodigo(),
                estudiante.getPuntuacion(),
                estudiante.getEstado()// Asegúrate de que este método devuelva algo que DefaultTableModel pueda manejar, como String o Boolean
            };
            modelo.addRow(fila);
            actual = actual.getSiguiente();
        }

        // Asigna el nuevo modelo al jTable1
        tb_seleccionados.setModel(modelo);
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btn_actualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnl_visualizarP;
    private javax.swing.JTable tb_seleccionados;
    // End of variables declaration//GEN-END:variables
}
