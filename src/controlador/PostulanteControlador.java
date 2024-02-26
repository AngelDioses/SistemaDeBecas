package controlador;

import BD.Conexion;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import model.Entrevista;
import model.Estudiante;
import model.SesionUsuario;
import vista_postulante.Dashboard;
import vista_postulante.PanelEst;

/**
 * Clase controladora para gestionar las operaciones relacionadas con los postulantes.
 */
public class PostulanteControlador {

    private Estudiante estudiante;
    private PanelEst vistaPrincipal;
    private Dashboard p;
    private String ruta;

    /**
     * Constructor para controlar la vista de un panel específico.
     * @param pnl El panel de la vista principal.
     */
    public PostulanteControlador(PanelEst pnl) {
        this.vistaPrincipal = pnl;
    }

    /**
     * Constructor para controlar la vista del dashboard.
     * @param pnl El panel del dashboard.
     */
    public PostulanteControlador(Dashboard pnl) {
        this.p = pnl;
    }

    /**
     * Guarda los datos de la primera parte de la entrevista.
     * @param txt_r1 El área de texto para la respuesta 1.
     * @param txt_r2 El área de texto para la respuesta 2.
     * @param txt_r3 El área de texto para la respuesta 3.
     */
    public void guardarDatosEntrevista1(JTextArea txt_r1, JTextArea txt_r2, JTextArea txt_r3) {
        try {
            String r1 = txt_r1.getText();
            String r2 = txt_r2.getText();
            String r3 = txt_r3.getText();
            Entrevista datosEntrevista = vistaPrincipal.getEntrevista();

            datosEntrevista.setR1(r1);
            datosEntrevista.setR2(r2);
            datosEntrevista.setR3(r3);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this.vistaPrincipal, "Error, intente de nuevo");
        }
    }

    /**
     * Guarda los datos de la segunda parte de la entrevista.
     * @param txt_r1 El área de texto para la respuesta 1.
     * @param txt_r2 El área de texto para la respuesta 2.
     * @param txt_r3 El área de texto para la respuesta 3.
     */
    public void guardarDatosEntrevista2(JTextArea txt_r1, JTextArea txt_r2, JTextArea txt_r3) {
        try {
            String r1 = txt_r1.getText();
            String r2 = txt_r2.getText();
            String r3 = txt_r3.getText();
            Entrevista datosEntrevista = vistaPrincipal.getEntrevista();

            datosEntrevista.setR4(r1);
            datosEntrevista.setR5(r2);
            datosEntrevista.setR6(r3);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this.vistaPrincipal, "Error, intente de nuevo");
        }
    }

    /**
     * Guarda los datos de la tercera parte de la entrevista.
     * @param txt_r1 El área de texto para la respuesta 1.
     * @param txt_r2 El área de texto para la respuesta 2.
     */
    public void guardarDatosEntrevista3(JTextArea txt_r1, JTextArea txt_r2) {
        try {
            String r1 = txt_r1.getText();
            String r2 = txt_r2.getText();
            Entrevista datosEntrevista = vistaPrincipal.getEntrevista();

            datosEntrevista.setR7(r1);
            datosEntrevista.setR8(r2);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this.vistaPrincipal, "Error, intente de nuevo");
        }
    }

    /**
     * Abre el archivo PDF de la entrevista de un estudiante.
     * @param estudiante El estudiante del cual se abrirá el archivo PDF.
     */
    public void abrirPDFEntrevista(Estudiante estudiante) {
        // Asumiendo que cada estudiante tiene un archivo PDF único identificado por su código o nombre
        int nombreArchivo = estudiante.getCodigo(); // o getNombres_completos(), dependiendo de tu estructura
        String rutaPDF = "C:\\Users\\angel\\Desktop\\Reportes\\" + nombreArchivo + ".pdf";

        try {
            File archivoPDF = new File(rutaPDF);
            if (archivoPDF.exists()) {
                Desktop.getDesktop().open(archivoPDF);
            } else {
                JOptionPane.showMessageDialog(null, "El postulante aún no realizó la entrevista");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "El postulante aún no realizó la entrevista");
        }
    }

    /**
     * Verifica si el usuario ya ha tomado la entrevista.
     */
    public void verificarEntrevista() {
        Conexion con = new Conexion();
        Connection cn = con.getConnection();
        String sql = "SELECT esEntrevistado FROM usuariosEstudiantes WHERE correo = ?"; // Busca el estado de postulacion a través de correo
        PreparedStatement statement;
        try {
            statement = cn.prepareStatement(sql);
            statement.setString(1, SesionUsuario.getInstancia().getUsuarioLogueado().getCorreo());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                boolean yaHaPostulado = resultSet.getBoolean("esEntrevistado"); // Guardamos en una variable el resultado de búsqueda
                if (yaHaPostulado) { // Si es true, entonces es porque ya hubo una postulacion
                    JOptionPane.showMessageDialog(this.vistaPrincipal, "Ya tomó la entrevista");
                } else {
                    vistaPrincipal.volverAlPanel(vistaPrincipal.getE1(), "respuesta1");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
