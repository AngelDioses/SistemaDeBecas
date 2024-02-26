
package model;

import java.util.HashMap;
import java.util.Map;

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
    private double puntuacion;
    private int id;
    private String reporte;
    private String estado;
    
    /**
     * Constructor para inicializar un estudiante con su nombre completo, código y puntuación.
     * @param nombres_completos los nombres completos del estudiante.
     * @param codigo el código del estudiante.
     * @param puntuacion la puntuación del estudiante.
     */
    public Estudiante(String nombres_completos, int codigo, double puntuacion) {
        super(nombres_completos);
        this.codigo = codigo;
        this.puntuacion = puntuacion;
    }
    
    /**
     * Constructor para inicializar un estudiante con su código, puntuación, reporte y nombre completo.
     * @param codigo el código del estudiante.
     * @param puntuacion la puntuación del estudiante.
     * @param reporte el reporte del estudiante.
     * @param nombres_completos los nombres completos del estudiante.
     */
    public Estudiante(int codigo, double puntuacion, String reporte, String nombres_completos) {
        super(nombres_completos);
        this.codigo = codigo;
        this.puntuacion = puntuacion;
        this.reporte = reporte;
    }
    public Estudiante(String nombres, int codigo, double puntuacion, String estado) {
        super(nombres);
        this.codigo = codigo;
        this.puntuacion = puntuacion;
        this.estado = estado;
    }
    
    /**
     * Constructor para inicializar un estudiante con sus datos completos.
     * @param email el correo electrónico del estudiante.
     * @param ponderado el ponderado del estudiante.
     * @param ciclo el ciclo del estudiante.
     * @param esObservado indica si el estudiante está siendo observado.
     * @param codigo el código del estudiante.
     * @param clasificacion_socioeconomica la clasificación socioeconómica del estudiante.
     * @param actividad_extra la actividad extra del estudiante.
     * @param esDiscapacitado indica si el estudiante tiene alguna discapacidad.
     * @param esPrimerMiembroenU indica si el estudiante es el primer miembro en la universidad.
     * @param esComunidadIndigena indica si el estudiante pertenece a una comunidad indígena.
     * @param puntuacion la puntuación del estudiante.
     * @param nombres_completos los nombres completos del estudiante.
     * @param edad la edad del estudiante.
     * @param DNI el DNI del estudiante.
     */
    public Estudiante(String email, double ponderado, int ciclo, boolean esObservado, int codigo, String clasificacion_socioeconomica, String actividad_extra, boolean esDiscapacitado, boolean esPrimerMiembroenU, boolean esComunidadIndigena, double puntuacion, String nombres_completos, int edad, int DNI) {
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
        this.puntuacion = puntuacion;
    }
    
    /**
     * Constructor por defecto para inicializar un estudiante con valores predeterminados.
     */
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
        this.puntuacion = 0;
        this.estado = "Pendiente";

    }

    /**
     * Obtiene el reporte del estudiante.
     * @return el reporte del estudiante.
     */
    public String getReporte() {
        return reporte;
    }

    /**
     * Establece el reporte del estudiante.
     * @param reporte el reporte del estudiante.
     */
    public void setReporte(String reporte) {
        this.reporte = reporte;
    }
    
    /**
     * Obtiene el ID del estudiante.
     * @return el ID del estudiante.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID del estudiante.
     * @param id el ID del estudiante.
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Obtiene la puntuación del estudiante.
     * @return la puntuación del estudiante.
     */
    public double getPuntuacion() {
        return puntuacion;
    }

     /**
     * Establece la puntuación del estudiante.
     * @param puntuacion la puntuación del estudiante.
     */
    public void setPuntuacion(double puntuacion) {
        this.puntuacion = puntuacion;
    }

    /**
     * Establece la emaildel estudiante.
     * @return el email del estudiante.
     */
    public String getEmail() {
        return email;
    }

     /**
     * Establece el email del estudiante.
     * @param email email del estudiante.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Establece el ponderado del estudiante.
     * @return el ponderado del estudiante.
     */
    public double getPonderado() {
        return ponderado;
    }

     /**
     * Establece el ponderado del estudiante.
     * @param ponderado ponderadodel estudiante
     */
    public void setPonderado(double ponderado) {
        this.ponderado = ponderado;
    }

    /**
     * Establece el ciclo del estudiante.
     * @return el ciclo del estudiante.
     */
    public int getCiclo() {
        return ciclo;
    }

     /**
     * Establece el ciclo del estudiante.
     * @param ciclo ciclo del estudiante.
     */
    public void setCiclo(int ciclo) {
        this.ciclo = ciclo;
    }

    /**
     * Establece la observacion del estudiante.
     * @return observacion del estudiante.
     */
    public boolean isEsObservado() {
        return esObservado;
    }

     /**
     * Establece si el estudiante es observado
     * @param esObservado si el estudiante es observado
     */
    public void setEsObservado(boolean esObservado) {
        this.esObservado = esObservado;
    }

    /**
     * Establece el codigo del estudiante.
     * @return el codigo del estudiante.
     */
    public int getCodigo() {
        return codigo;
    }

     /**
     * Establece el codigo del estudiante
     * @param codigo codigo del estudiante
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

     /**
     * Establece la clasificacion socieconomica del estudiante.
     * @return la clasificacion socieconomica del estudiante.
     */
    public String getClasificacion_socioeconomica() {
        return clasificacion_socioeconomica;
    }

    /**
     * Establece la clasificacion socieconomica del estudiante
     * @param clasificacion_socioeconomica la clasificacion socieconomica del estudiante
     */
    public void setClasificacion_socioeconomica(String clasificacion_socioeconomica) {
        this.clasificacion_socioeconomica = clasificacion_socioeconomica;
    }

     /**
     * Establece la actividad extra del estudiante.
     * @return la actividad extra del estudiante.
     */
    public String getActividad_extra() {
        return actividad_extra;
    }

    /**
     * Establece el actividad extra del estudiante
     * @param actividad_extra actividad extra del estudiante
     */
    public void setActividad_extra(String actividad_extra) {
        this.actividad_extra = actividad_extra;
    }

     /**
     * Establece si el estudiante es discapacitado.
     * @return discapacidad del estudiante.
     */
    public boolean isEsDiscapacitado() {
        return esDiscapacitado;
    }

    /**
     * Establece si el estudiante es discapacitado
     * @param esDiscapacitdo si el estudiante es discapacitado
     */
    public void setEsDiscapacitado(boolean esDiscapacitado) {
        this.esDiscapacitado = esDiscapacitado;
    }

    /**
     * Establece si el estudiante es primer miembro de la familia en universidad
     * @return primer miembro de la familia en universidad
     */
    public boolean isEsPrimerMiembroenU() {
        return esPrimerMiembroenU;
    }

    /**
     * Establece el si el estudiante es primer miembro de la familia en universidad
     * @param esPrimerMiembroenU si el estudiante es primer miembro de la familia en universidad
     */
    public void setEsPrimerMiembroenU(boolean esPrimerMiembroenU) {
        this.esPrimerMiembroenU = esPrimerMiembroenU;
    }

    /**
     * Establece si el estudiante es de comunidad indigena.
     * @return comunidad del estudiante.
     */
    public boolean isEsComunidadIndigena() {
        return esComunidadIndigena;
    }

    /**
     * Establece si el estudiante pertenece a una comunidad indigena
     * @param esComunidadIndigena si el estudiante pertenece a una comunidad indigena
     */
    public void setEsComunidadIndigena(boolean esComunidadIndigena) {
        this.esComunidadIndigena = esComunidadIndigena;
    }

    /**
     * Establece estado del estudiante.
     * @return estado del estudiante.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece estado del estudiante
     * @param estado estado del estudiante
     */
    public void setEstado(String estado) {
        this.estado = estado;
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
