
package model;

public class Persona {
    private String nombres_completos;
    private int edad;
    private int DNI;
  

    public Persona(String nombres_completos, int edad, int DNI) {
        this.nombres_completos = nombres_completos;
        this.edad = edad;
        this.DNI = DNI;
    
    }

    public Persona( String nombres_completos) {
       
        this.nombres_completos = nombres_completos;
    }

    /**
     * @return the nombres_completos
     */
    public String getNombres_completos() {
        return nombres_completos;
    }

    /**
     * @param nombres_completos the nombres_completos to set
     */
    public void setNombres_completos(String nombres_completos) {
        this.nombres_completos = nombres_completos;
    }

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * @return the DNI
     */
    public int getDNI() {
        return DNI;
    }

    /**
     * @param DNI the DNI to set
     */
    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    /**
     * @return the nro_telefono
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
