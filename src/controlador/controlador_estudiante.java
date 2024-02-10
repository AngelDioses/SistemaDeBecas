package controlador;

import estructura.ListaEnlazada;
import model.Estudiante;

public class controlador_estudiante {

    private Estudiante estudianteActual;
    private ListaEnlazada<Estudiante> listaEstudiantes;
    private static controlador_estudiante instancia;

    private controlador_estudiante() {
        listaEstudiantes = new ListaEnlazada<>();
        estudianteActual = new Estudiante("", 0.0, 0, false, 0, 0, "", 0, "", 0, 0, 0);
    }

    public static controlador_estudiante getInstance() {
        if (instancia == null) {
            instancia = new controlador_estudiante();
        }
        return instancia;
    }

    // Métodos para manejar el estudianteActual
    public Estudiante getEstudianteActual() {
        return estudianteActual;
    }

    public void finalizarYGuardarPersona() {
        listaEstudiantes.añadir(estudianteActual);
        estudianteActual = null; // Preparar para la siguiente persona
        listaEstudiantes.imprimir();
    }
    public ListaEnlazada<Estudiante> getLista(){
        return listaEstudiantes;
    }

    public void actualizarDatosEstudiante(Estudiante datosEstudiante) {
        if (estudianteActual == null) {
            estudianteActual = datosEstudiante;
        } else {
            // Suponiendo que datosEstudiante contiene los datos actualizados para los campos específicos
            if (datosEstudiante.getNombres_completos() != null) {
                estudianteActual.setNombres_completos(datosEstudiante.getNombres_completos());
            }
            if (datosEstudiante.getEdad() != 0.0) {
                estudianteActual.setEdad(datosEstudiante.getEdad());
            }
            if (datosEstudiante.getEmail() != null) {
                estudianteActual.setEmail(datosEstudiante.getEmail());

                if (datosEstudiante.getDNI() != 0.0) {
                    estudianteActual.setDNI(datosEstudiante.getDNI());
                }

                // Y así sucesivamente para cada campo que pueda haber sido actualizado
                // ...
            }
        }
        
    }
    
}
