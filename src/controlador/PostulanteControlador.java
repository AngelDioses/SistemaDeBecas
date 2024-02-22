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

public class PostulanteControlador {

    private Estudiante estudiante;
    private PanelEst vistaPrincipal;
    private Dashboard p;
    private String ruta;

    /* Metodos y constructores para controlar la vista */
    public PostulanteControlador(PanelEst pnl) {
        this.vistaPrincipal = pnl;

    }
    public PostulanteControlador(Dashboard pnl) {
        this.p = pnl;

    }

    public void guardarDatosEntrevista1(JTextArea txt_r1, JTextArea txt_r2,
            JTextArea txt_r3 ) {

        try {
            String r1 = txt_r1.getText();
            String r2 = txt_r2.getText();
            String r3 = txt_r3.getText();
            Entrevista datosEntrevista = vistaPrincipal.getEntrevista();

            datosEntrevista.setR1(r1);
            datosEntrevista.setR2(r2);
            datosEntrevista.setR3(r3);
        
           
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this.vistaPrincipal, "Errror , intente de nuevo");
        }
    
         

    }

    public void guardarDatosEntrevista2(JTextArea txt_r1, JTextArea txt_r2,
            JTextArea txt_r3) {

        try {
            String r1 = txt_r1.getText();
            String r2 = txt_r2.getText();
            String r3 = txt_r3.getText();
            Entrevista datosEntrevista = vistaPrincipal.getEntrevista();

            datosEntrevista.setR4(r1);
            datosEntrevista.setR5(r2);
            datosEntrevista.setR6(r3);
            // Cambiar al siguiente pane
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this.vistaPrincipal, "Errror , intente de nuevo");
        }
    }

    public void guardarDatosEntrevista3(JTextArea txt_r1, JTextArea txt_r2) {

        try {
            String r1 = txt_r1.getText();
            String r2 = txt_r2.getText();
            
            Entrevista datosEntrevista = vistaPrincipal.getEntrevista();

            datosEntrevista.setR7(r1);
            datosEntrevista.setR8(r2);
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this.vistaPrincipal, "Errror , intente de nuevo");
        }
    }
     public void abrirPDFEntrevista(Estudiante estudiante) {
    // Asumiendo que cada estudiante tiene un archivo PDF único identificado por su código o nombre
    int nombreArchivo = estudiante.getCodigo(); // o getNombres_completos(), dependiendo de tu estructura
  
    
    String rutaPDF = "C:\\Users\\ASUS ROG\\Desktop\\Entrevista\\" + nombreArchivo + ".pdf";
    
    try {
        File archivoPDF = new File(rutaPDF);
        if (archivoPDF.exists()) {
            Desktop.getDesktop().open(archivoPDF);
        } else {
            JOptionPane.showMessageDialog(null, "El postulante aún no realizó la entrevista");
        }
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "El postulante aún no realizó la entrevista" );
    }
}
     public void verificarEntrevista(){
           Conexion con = new Conexion();
        Connection cn = con.getConnection();
        String sql = "SELECT esEntrevistado FROM usuariosEstudiantes WHERE correo = ?"; //Busca el estado de postulacion a traves de correo
        PreparedStatement statement;
        try {
            statement = cn.prepareStatement(sql);
            statement.setString(1, SesionUsuario.getInstancia().getUsuarioLogueado().getCorreo()); 
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                boolean yaHaPostulado = resultSet.getBoolean("esEntrevistado"); //Guardamos en una variable el resultado de busqueda
                if (yaHaPostulado) { //Si es true, entonces es porque ya hubo una postulacion
                    JOptionPane.showMessageDialog(this.vistaPrincipal, "Ya tomó la entrevista"); 
                }
                else{
                    vistaPrincipal.volverAlPanel(vistaPrincipal.getE1(), "respuesta1");
                }
            }
        } catch (SQLException ex) {
             
            ex.printStackTrace();
        }
     }

}
