
package model;


public class Usuario extends Persona{
    private int id;
    private String apellido;
    private String correo ;
    private String contraseña;
    private boolean haPostulado;
    
    public Usuario(String correo, String contraseña, String nombres_completos
    ,String apellido) {
        super(nombres_completos);
        this.correo = correo;
        this.contraseña = contraseña;
        this.apellido = apellido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Usuario() {
        super("");
        this.id = 0;
         this.correo = "";
        this.contraseña = "";
        this.apellido = "";
        this.haPostulado=false;
    }
    
     public boolean haPostulado() {
        return haPostulado;
    }

    public void setHaPostulado(boolean haPostulado) {
        this.haPostulado = haPostulado;
    }
     
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    
    
}
