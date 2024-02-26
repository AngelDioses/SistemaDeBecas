
package model;

/**
 * Esta clase representa una persona con su información básica.
 */
public class Persona {
    private String nombres_completos;
    private int edad;
    private int DNI;

    /**
     * Constructor para inicializar una persona con todos sus datos.
     * @param nombres_completos los nombres completos de la persona.
     * @param edad la edad de la persona.
     * @param DNI el número de identificación de la persona.
     */
    public Persona(String nombres_completos, int edad, int DNI) {
        this.nombres_completos = nombres_completos;
        this.edad = edad;
        this.DNI = DNI;
    }

    /**
     * Constructor para inicializar una persona solo con los nombres completos.
     * @param nombres_completos los nombres completos de la persona.
     */
    public Persona(String nombres_completos) {
        this.nombres_completos = nombres_completos;
    }

    /**
     * Obtiene los nombres completos de la persona.
     * @return los nombres completos de la persona.
     */
    public String getNombres_completos() {
        return nombres_completos;
    }

    /**
     * Establece los nombres completos de la persona.
     * @param nombres_completos los nombres completos de la persona.
     */
    public void setNombres_completos(String nombres_completos) {
        this.nombres_completos = nombres_completos;
    }

    /**
     * Obtiene la edad de la persona.
     * @return la edad de la persona.
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Establece la edad de la persona.
     * @param edad la edad de la persona.
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Obtiene el número de identificación de la persona.
     * @return el número de identificación de la persona.
     */
    public int getDNI() {
        return DNI;
    }

    /**
     * Establece el número de identificación de la persona.
     * @param DNI el número de identificación de la persona.
     */
    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    /**
     * Devuelve una representación en forma de cadena de la persona.
     * @return una cadena que representa la información de la persona.
     */
    @Override
    public String toString() {
        return "Persona{" +
                "nombres_completos='" + nombres_completos + '\'' +
                ", edad=" + edad +
                ", DNI=" + DNI +
                '}';
    }
}
