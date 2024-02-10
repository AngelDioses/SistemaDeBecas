
package model;

public class Estudiante extends Persona {

    private String email;
    private double ponderado;
    private int ciclo;
    private boolean esObservado;
    private int codigo;
    private int clasificacion_socioeconomica;
    private String actividad_extra;
    private int situacion_especial;

    public Estudiante(String nombres_completos, int edad, int DNI, int nro_telefono) {
        super(nombres_completos, edad, DNI, nro_telefono);
    }

    public Estudiante(String email, double ponderado, int ciclo, boolean esObservado, int codigo,
            int clasificacion_socioeconomica, String actividad_extra, int situacion_especial, String nombres_completos,
            int edad, int DNI, int nro_telefono) {
        super(nombres_completos, edad, DNI, nro_telefono);
        this.email = email;
        this.ponderado = ponderado;
        this.ciclo = ciclo;
        this.esObservado = esObservado;
        this.codigo = codigo;
        this.clasificacion_socioeconomica = clasificacion_socioeconomica;
        this.actividad_extra = actividad_extra;
        this.situacion_especial = situacion_especial;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getPonderado() {
        return ponderado;
    }

    public void setPonderado(double ponderado) {
        this.ponderado = ponderado;
    }

    public int getCiclo() {
        return ciclo;
    }

    public void setCiclo(int ciclo) {
        this.ciclo = ciclo;
    }

    public boolean isEsObservado() {
        return esObservado;
    }

    public void setEsObservado(boolean esObservado) {
        this.esObservado = esObservado;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getClasificacion_socioeconomica() {
        return clasificacion_socioeconomica;
    }

    public void setClasificacion_socioeconomica(int clasificacion_socioeconomica) {
        this.clasificacion_socioeconomica = clasificacion_socioeconomica;
    }

    public String getActividad_extra() {
        return actividad_extra;
    }

    public void setActividad_extra(String actividad_extra) {
        this.actividad_extra = actividad_extra;
    }

    public int getSituacion_especial() {
        return situacion_especial;
    }

    public void setSituacion_especial(int situacion_especial) {
        this.situacion_especial = situacion_especial;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "email='" + email + '\'' +
                ", ponderado=" + ponderado +
                ", ciclo=" + ciclo +
                ", esObservado=" + esObservado +
                ", codigo=" + codigo +
                ", clasificacion_socioeconomica=" + clasificacion_socioeconomica +
                ", actividad_extra='" + actividad_extra + '\'' +
                ", situacion_especial=" + situacion_especial +
                "} " + super.toString();
    }

}
