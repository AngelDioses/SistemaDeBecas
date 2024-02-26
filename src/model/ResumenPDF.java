package model;

import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Esta clase representa un generador de PDF para el resumen de un estudiante o una entrevista.
 */
public class ResumenPDF {
    private String ruta;
    private Estudiante estudiante;
    private Entrevista respuestas;

    /**
     * Constructor para inicializar un ResumenPDF para un estudiante.
     * @param estudiante el estudiante para el cual se generará el resumen.
     */
    public ResumenPDF(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    /**
     * Constructor para inicializar un ResumenPDF para una entrevista.
     * @param respuesta la entrevista para la cual se generará el resumen.
     */
    public ResumenPDF(Entrevista respuesta){
        this.respuestas = respuesta;
    }

    /**
     * Genera un PDF para el estudiante con la información proporcionada.
     * @param destino la ruta de destino para guardar el PDF generado.
     * @param estudiante el estudiante para el cual se generará el resumen.
     * @param directorio el directorio donde se realizará el procesamiento del PDF.
     */
    public void generarPdfEstudiante(String destino, Estudiante estudiante, String directorio) {
        //Escribimos el reporte
        escribirReporte(destino);
        procesarPDF(destino, directorio);
    }

    /**
     * Genera un PDF para la entrevista con la información proporcionada.
     * @param destino la ruta de destino para guardar el PDF generado.
     * @param entrevista la entrevista para la cual se generará el resumen.
     * @param directorio el directorio donde se realizará el procesamiento del PDF.
     * @param estudiante el estudiante relacionado con la entrevista.
     */
    public void generarPDFEntrevista(String destino, Entrevista entrevista, String directorio, Estudiante estudiante){
        escribirRespuestas(destino, entrevista, estudiante);
        procesarPDF(destino, directorio);
    }

    /**
     * Procesa el PDF utilizando pdflatex.
     * @param destino la ruta de destino para el PDF generado.
     * @param directorio el directorio donde se realizará el procesamiento del PDF.
     */
    public void procesarPDF(String destino , String directorio){
        try {
            // Usa ProcessBuilder para manejar el proceso
            ProcessBuilder builder = new ProcessBuilder("pdflatex", "-interaction=nonstopmode", destino);
            builder.directory(new File(directorio)); 
            builder.redirectErrorStream(true); // Redirige la salida de error al flujo estándar
            
            Process process = builder.start();
            
            // Espera a que el proceso termine y obtiene el código de salida
            int exitCode = process.waitFor();
            if (exitCode != 0) {
                System.out.println("pdflatex terminó con errores. Código de salida: " + exitCode);
                return;
            }
            File file = new File(destino.replaceFirst("\\.tex$", ".pdf"));
            System.out.println("Ruta absoluta del PDF: " + file.getAbsolutePath());
            
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Escribe el reporte del estudiante en formato LaTeX.
     * @param destino la ruta de destino para guardar el archivo LaTeX.
     */
    public void escribirReporte(String destino){
        //A través del FileWriter escribimos en código LaTeX, es necesario instalar el MikTeX 
        try (FileWriter writer = new FileWriter(destino)) {
            writer.write("\\documentclass{article}\n");
            writer.write("\\begin{document}\n");
            writer.write("\\section{Informacion del Estudiante}\n");
            writer.write("\\subsection*{Datos Personales}\n");
            writer.write("Nombres Completos: " + estudiante.getNombres_completos() + "\\\\\n");
            writer.write("Email: " + estudiante.getEmail() + "\\\\\n");
            writer.write("Edad: " + estudiante.getEdad() + "\\\\\n");
            writer.write("DNI: " + estudiante.getDNI() + "\n");
            writer.write("\\subsection*{Datos Académicos}\n");
            writer.write("Ciclo: " + estudiante.getCiclo() + "\\\\\n");
            writer.write("Observado: " + (estudiante.isEsObservado() ? "Sí" : "No") + "\\\\\n");
            writer.write("Código: " + estudiante.getCodigo() + "\\\\\n");
            writer.write("Promedio Ponderado: " + estudiante.getPonderado() + "\\\\\n");

            writer.write("\\subsection*{Clasificación Socioeconómica}\n");
            writer.write("Situación económica: " + estudiante.getClasificacion_socioeconomica() + "\\\\\n");
            writer.write("Participación en actividades extra: " + estudiante.getActividad_extra() + "\n");

            writer.write("\\subsection*{Situaciones Especiales}\n");
            writer.write("Discapacidad: " + (estudiante.isEsDiscapacitado() ? "Sí" : "No") + "\\\\\n");
            writer.write("Primer miembro universitario en la familia: " + (estudiante.isEsPrimerMiembroenU() ? "Sí" : "No") + "\\\\\n");
            writer.write("Perteneciente a comunidad indígena: " + (estudiante.isEsComunidadIndigena() ? "Sí" : "No") + "\\\\\n");
            writer.write("\\textbf{Puntuación total: " + estudiante.getPuntuacion()+ "}"+ "\n");
            writer.write("\\end{document}");

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Escribe las respuestas de la entrevista en formato LaTeX.
     * @param destino la ruta de destino para guardar el archivo LaTeX.
     * @param entrevista la entrevista de la cual se obtienen las respuestas.
     * @param estudiante el estudiante relacionado con la entrevista.
     */
    public void escribirRespuestas(String destino, Entrevista entrevista, Estudiante estudiante) {
        try (FileWriter writer = new FileWriter(destino)) {
            writer.write("\\documentclass{article}\n");
            writer.write("\\usepackage[utf8]{inputenc}\n");
            writer.write("\\begin{document}\n");
            writer.write("\\title{Informe de Entrevista para Beca}\n");
            writer.write("\\date{}\n");
            writer.write("\\maketitle\n");
            writer.write("\\section{Informacion del Estudiante}\n");
            writer.write("Nombres Completos: " + estudiante.getNombres_completos() + "\\\\\n");
            writer.write("Codigo de Estudiante: " + estudiante.getCodigo()+ "\\\\\n");
            
            writer.write("\\section*{Respuestas de la Entrevista}\n" + "\\\\\n");
 
            writer.write("Pregunta: ¿Puede confirmar que aceptará la beca si se le otorga? \\\\\n");
            writer.write("Respuesta: " + entrevista.getR1() + "\\\\\n" + "\\\\\n");

            writer.write("Pregunta: ¿Hay alguna circunstancia que pudiera cambiar su elegibilidad para la beca en el futuro próximo? \\\\\n");
            writer.write("Respuesta: " + entrevista.getR2() + "\\\\\n" + "\\\\\n");

            writer.write("Pregunta: ¿Cómo encaja esta beca en tus planes académicos y profesionales? \\\\\n");
            writer.write("Respuesta: " + entrevista.getR3() + "\\\\\n" + "\\\\\n" );

            writer.write("Pregunta: ¿Cómo piensas que la beca te ayudará a lograr tus objetivos?  \\\\\n");
            writer.write("Respuesta: " + entrevista.getR4()  + "\\\\\n" + "\\\\\n");

            writer.write("Pregunta: ¿De qué manera la ayuda financiera de la beca impactará tu vida estudiantil?  \\\\\n");
            writer.write("Respuesta: " + entrevista.getR5() + "\\\\\n" + "\\\\\n");

            writer.write("Pregunta: ¿Qué habilidades o experiencias esperas adquirir durante el período de la beca?  \\\\\n");
            writer.write("Respuesta: " + entrevista.getR6() + "\\\\\n" + "\\\\\n");

            writer.write("Pregunta: ¿Estás dispuesto a participar en actividades o eventos relacionados con la beca?  \\\\\n");
            writer.write("Respuesta: " + entrevista.getR7()  + "\\\\\n" + "\\\\\n");

            writer.write("Pregunta: ¿Podrías proporcionarnos una visión más detallada de tu situación "
                    + "financiera y cómo planeas administrar los fondos de la beca? "
                    +" \\\\\n" + "\\\\\n");
            writer.write("Respuesta: " + entrevista.getR8() + "\\\\\n"+ "\\\\\n");

            // Continuar con el resto de las preguntas y respuestas...
            writer.write("\\end{document}");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
