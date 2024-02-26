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

/**
 * Clase controladora para gestionar las operaciones relacionadas con los estudiantes en la interfaz gráfica.
 */
public class controlador_estudiante {

    private Estudiante estudiante;
    private Dashboard vistaPrincipal;
    private String ruta;

    /**
     * Constructor para controlar la vista del dashboard.
     * @param dashboard El dashboard principal.
     */
    public controlador_estudiante(Dashboard dashboard) {
        this.vistaPrincipal = dashboard;
    }

    /**
     * Actualiza los datos relacionados con los requisitos del estudiante.
     * @param esPobre Indica si el estudiante es pobre.
     * @param esNoPobre Indica si el estudiante no es pobre.
     * @param esExtremaPobreza Indica si el estudiante está en extrema pobreza.
     * @param esDiscapacitado Indica si el estudiante tiene alguna discapacidad.
     * @param esPrimerMiembroU Indica si el estudiante es el primer miembro en la universidad.
     * @param esComunidadIndigena Indica si el estudiante pertenece a una comunidad indígena.
     * @param actividadesExtra Actividades extra realizadas por el estudiante.
     */
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

    /**
     * Actualiza los datos personales del estudiante.
     * @param nombreCompletoField Campo de texto para el nombre completo del estudiante.
     * @param edadField Campo de texto para la edad del estudiante.
     * @param correoField Campo de texto para el correo electrónico del estudiante.
     * @param dniField Campo de texto para el DNI del estudiante.
     */
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

    /**
     * Actualiza los datos académicos del estudiante.
     * @param cicloField Campo de texto para el ciclo académico del estudiante.
     * @param siObservado Radio button para indicar si el estudiante está observado.
     * @param noObservado Radio button para indicar si el estudiante no está observado.
     * @param codigoEstudianteField Campo de texto para el código del estudiante.
     * @param promedioField Campo de texto para el promedio ponderado del estudiante.
     */
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

    /**
     * Verifica los campos personales del estudiante.
     * @param nombreCompletoField Campo de texto para el nombre completo del estudiante.
     * @param edadField Campo de texto para la edad del estudiante.
     * @param correoField Campo de texto para el correo electrónico del estudiante.
     * @param dniField Campo de texto para el DNI del estudiante.
     * @return Verdadero si los campos personales son válidos, falso de lo contrario.
     */
    public boolean verificarCamposPersonales(JTextField nombreCompletoField, JTextField edadField,
            JTextField correoField, JTextField dniField) {
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

    /**
     * Abre el archivo PDF correspondiente al estudiante.
     * @param estudiante El estudiante cuyo archivo PDF se abrirá.
     */
    public void abrirPDF(Estudiante estudiante) {
        if (Desktop.isDesktopSupported()) {
            try {
                File myFile = new File("C:\\Users\\angel\\Desktop\\Reportes\\" + estudiante.getCodigo() + "_.pdf");
                Desktop.getDesktop().open(myFile);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "No se pudo abrir el archivo: " + ex.getMessage());
            }
        }
    }

    /**
     * Método para obtener la ruta del archivo.
     * @return La ruta del archivo.
     */
    public String getRuta() {
        return ruta;
    }
}
