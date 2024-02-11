
package model;

public class Estudiante extends Persona {

    private String email;
    private double ponderado;
    private int ciclo;
    private boolean esObservado;
    private int codigo;
    private String clasificacion_socioeconomica;
    private String actividad_extra;
    private boolean esDiscapacitado;
    private boolean esPrimerMiembroenU;
    private boolean esComunidadIndigena;

    public Estudiante(String email, double ponderado, int ciclo, boolean esObservado, int codigo,
            String clasificacion_socioeconomica, String actividad_extra, boolean esDiscapacitado,
            boolean esPrimerMiembroenU, boolean esComunidadIndigena, String nombres_completos, int edad, int DNI) {
        super(nombres_completos, edad, DNI);
        this.email = email;
        this.ponderado = ponderado;
        this.ciclo = ciclo;
        this.esObservado = esObservado;
        this.codigo = codigo;
        this.clasificacion_socioeconomica = clasificacion_socioeconomica;
        this.actividad_extra = actividad_extra;
        this.esDiscapacitado = esDiscapacitado;
        this.esPrimerMiembroenU = esPrimerMiembroenU;
        this.esComunidadIndigena = esComunidadIndigena;
    }

    public Estudiante() {
        super("", 0, 0);

        this.email = "";
        this.ponderado = 0.0;
        this.ciclo = 0;
        this.esObservado = false;
        this.codigo = 0;
        this.clasificacion_socioeconomica = "";
        this.actividad_extra = "";
        this.esDiscapacitado = false;
        this.esPrimerMiembroenU = false;
        this.esComunidadIndigena = false;

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

    public String getClasificacion_socioeconomica() {
        return clasificacion_socioeconomica;
    }

    public void setClasificacion_socioeconomica(String clasificacion_socioeconomica) {
        this.clasificacion_socioeconomica = clasificacion_socioeconomica;
    }

    public String getActividad_extra() {
        return actividad_extra;
    }

    public void setActividad_extra(String actividad_extra) {
        this.actividad_extra = actividad_extra;
    }

    public boolean isEsDiscapacitado() {
        return esDiscapacitado;
    }

    public void setEsDiscapacitado(boolean esDiscapacitado) {
        this.esDiscapacitado = esDiscapacitado;
    }

    public boolean isEsPrimerMiembroenU() {
        return esPrimerMiembroenU;
    }

    public void setEsPrimerMiembroenU(boolean esPrimerMiembroenU) {
        this.esPrimerMiembroenU = esPrimerMiembroenU;
    }

    public boolean isEsComunidadIndigena() {
        return esComunidadIndigena;
    }

    public void setEsComunidadIndigena(boolean esComunidadIndigena) {
        this.esComunidadIndigena = esComunidadIndigena;
    }

    @Override
    public String toString() {
        return "Estudiante{" + " " + super.toString() +
                "email='" + email + '\'' +
                ", ponderado=" + ponderado +
                ", ciclo=" + ciclo +
                ", esObservado=" + esObservado +
                ", codigo=" + codigo +
                ", clasificacion_socioeconomica=" + clasificacion_socioeconomica +
                ", actividad_extra='" + actividad_extra + '\'' +
                ", esDiscapacitado=" + esDiscapacitado +
                ", esPrimerMiembroenU=" + esPrimerMiembroenU +
                ", esComunidadIndigena=" + esComunidadIndigena +
                '}';
    }

}
