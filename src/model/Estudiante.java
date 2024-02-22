
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
    
    public Estudiante(String nombres_completos, int codigo, double puntuacion) {
        super(nombres_completos);
        this.codigo = codigo;
        this.puntuacion = puntuacion;
    }
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

    public String getReporte() {
        return reporte;
    }

    public void setReporte(String reporte) {
        this.reporte = reporte;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public double getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(double puntuacion) {
        this.puntuacion = puntuacion;
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

    public String getEstado() {
        return estado;
    }

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
