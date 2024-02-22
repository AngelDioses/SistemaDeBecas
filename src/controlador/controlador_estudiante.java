package controlador;

import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.Estudiante;
import vista_postulante.Dashboard;

public class controlador_estudiante {

    private Estudiante estudiante;
    private Dashboard vistaPrincipal;
    private String ruta;
    
    /* Metodos y constructores para controlar la vista */
    
    public controlador_estudiante(Dashboard dashboard) {
        this.vistaPrincipal = dashboard;

    }
    
    public void actualizarDatosRequisito(boolean esPobre, boolean esNoPobre, boolean esExtremaPobreza,
            boolean esDiscapacitado, boolean esPrimerMiembroU, boolean esComunidadIndigena, String actividadesExtra) {

        // Obtener la instancia actual del estudiante y actualizarla
        Estudiante datosEstudiante = vistaPrincipal.getEstudiante();

        // Actualizar el objeto estudiante con la nueva información
        datosEstudiante.setClasificacion_socioeconomica(
                esPobre ? "Pobre" : esNoPobre ? "No pobre" : esExtremaPobreza ? "Extrema pobreza" : "");
        datosEstudiante.setEsDiscapacitado(esDiscapacitado);
        datosEstudiante.setEsPrimerMiembroenU(esPrimerMiembroU);
        datosEstudiante.setEsComunidadIndigena(esComunidadIndigena);
        datosEstudiante.setActividad_extra(actividadesExtra);

        
    }

    public void actualizarDatosPersonales(JTextField nombreCompletoField, JTextField edadField, JTextField correoField,
            JTextField dniField) {
        if (verificarCamposPersonales(nombreCompletoField, edadField, correoField, dniField)) {
            try {
                String nombres = nombreCompletoField.getText();
                int edad = Integer.parseInt(edadField.getText());
                String email = correoField.getText();
                int dni = Integer.parseInt(dniField.getText());
                Estudiante datosEstudiante = vistaPrincipal.getEstudiante();

                vistaPrincipal.getLista().añadir(datosEstudiante);

                datosEstudiante.setNombres_completos(nombres);
                datosEstudiante.setEdad(edad);
                datosEstudiante.setEmail(email);
                datosEstudiante.setDNI(dni);

                System.out.println("Estudiante actualizado: ");
                vistaPrincipal.getLista().imprimir();

                // Cambiar al siguiente panel
                vistaPrincipal.mostrarPanel("datosAcademicos");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this.vistaPrincipal, "Ingrese los datos en el formato correcto.");
            }
        }

    }

    public void actualizarDatosAcademicos(JTextField cicloField, JRadioButton siObservado, JRadioButton noObservado,
            JTextField codigoEstudianteField, JTextField promedioField) {
        if (verificarCamposAcademicos(cicloField, siObservado, noObservado, codigoEstudianteField, promedioField)) {
            try {
                int ciclo = Integer.parseInt(cicloField.getText());
                boolean observado = siObservado.isSelected();
                int codigo = Integer.parseInt(codigoEstudianteField.getText());
                double ponderado = Double.parseDouble(promedioField.getText());

                Estudiante datosEstudiante = vistaPrincipal.getEstudiante();

                datosEstudiante.setCiclo(ciclo);
                datosEstudiante.setEsObservado(observado);
                datosEstudiante.setCodigo(codigo);
                datosEstudiante.setPonderado(ponderado);

                // Depuramos si es que funciona
                System.out.println("Estudiante actualizado: ");
                vistaPrincipal.getLista().imprimir();

                
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this.vistaPrincipal,
                        "Por favor, asegúrese de que todos los campos numéricos tengan el formato correcto.");
            }
        }

    }

    private boolean verificarCamposAcademicos(JTextField cicloField, JRadioButton siObservado, JRadioButton noObservado,
            JTextField codigoEstudianteField, JTextField promedioField) {
        // Validación para el ciclo
        if (!esCampoTextoValido(cicloField, "\\d+", "Por favor, ingrese el ciclo académico válido.")) {
            return false;
        }

        // Validación para el estado de observación
        if (!siObservado.isSelected() && !noObservado.isSelected()) {
            JOptionPane.showMessageDialog(vistaPrincipal, "Por favor, indique si es un alumno observado o no.",
                    "Validación de campo", JOptionPane.ERROR_MESSAGE);
            return false; // No es necesario enfocar un campo específico aquí
        }

        // Validación para el código del estudiante , 8 en UNMSM
        if (!esCampoTextoValido(codigoEstudianteField, "\\d{8}",
                "Por favor, ingrese un código de estudiante válido.")) {
            return false;
        }

        // Validación para el promedio ponderado
        if (!esCampoTextoValido(promedioField, "\\d+(\\.\\d+)?", "Por favor, ingrese un promedio ponderado válido.")) {
            return false;
        }

        // Si todas las validaciones son exitosas
        return true;
    }

    private boolean esCampoTextoValido(JTextField campo, String regex, String mensajeError) {
        String texto = campo.getText().trim();
        if (!texto.matches(regex)) {
            JOptionPane.showMessageDialog(this.vistaPrincipal, mensajeError, "Validación de campo",
                    JOptionPane.ERROR_MESSAGE);
            campo.requestFocus();
            return false;
        }
        return true;
    }

    public boolean verificarCamposPersonales(JTextField nombreCompletoField, JTextField edadField,
            JTextField correoField,
            JTextField dniField) {
        if (!esCampoTextoValido(nombreCompletoField, "[a-zA-Z\\s]+", "Por favor, ingrese nombres completos válidos.")) {
            return false;
        }
        if (!esCampoTextoValido(edadField, "\\d+", "Por favor, ingrese una edad válida.")) {
            return false;
        }
        if (!esCampoTextoValido(correoField, "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$",
                "Por favor, ingrese un correo electrónico válido.")) {
            return false;
        }
        if (!esCampoTextoValido(dniField, "\\d{8}", "Por favor, ingrese un DNI válido.")) {
            return false;
        }
        return true;
    }
    
        
     public void abrirPDF(Estudiante estudiante) {
        if (Desktop.isDesktopSupported()) {
            try {
                File myFile = new File("C:\\Users\\angel\\Desktop\\Reportes\\"+estudiante.getCodigo()+"_.pdf");
                Desktop.getDesktop().open(myFile);
            } catch (IOException ex) {
                
                JOptionPane.showMessageDialog(null, "No se pudo abrir el archivo: " + ex.getMessage());
            }
        }
    }
     // Método para obtener la ruta
    public String getRuta() {
        return ruta;
    }
}
