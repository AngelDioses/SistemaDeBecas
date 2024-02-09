
package model;


public class Estudiante extends Persona {
    
    private String email ; 
    private double ponderado;
    private int ciclo; 
    private boolean esObservado;
    private int codigo;

    public Estudiante(String email, double ponderado, int ciclo, boolean esObservado, int codigo, String nombres_completos, int edad, int DNI, int nro_telefono) {
        super(nombres_completos, edad, DNI, nro_telefono);
        this.email = email;
        this.ponderado = ponderado;
        this.ciclo = ciclo;
        this.esObservado = esObservado;
        this.codigo = codigo;
    }

    
    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the ponderado
     */
    public double getPonderado() {
        return ponderado;
    }

    /**
     * @param ponderado the ponderado to set
     */
    public void setPonderado(double ponderado) {
        this.ponderado = ponderado;
    }

    /**
     * @return the ciclo
     */
    public int getCiclo() {
        return ciclo;
    }

    /**
     * @param ciclo the ciclo to set
     */
    public void setCiclo(int ciclo) {
        this.ciclo = ciclo;
    }

    /**
     * @return the esObservado
     */
    public boolean isEsObservado() {
        return esObservado;
    }

    /**
     * @param esObservado the esObservado to set
     */
    public void setEsObservado(boolean esObservado) {
        this.esObservado = esObservado;
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
}
