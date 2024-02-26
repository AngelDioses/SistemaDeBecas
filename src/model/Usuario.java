
package model;

/**
 * Esta clase representa un usuario del sistema.
 */
public class Usuario extends Persona{
    private int id;
    private String apellido;
    private String correo ;
    private String contraseña;
    private boolean haPostulado;
    
    /**
     * Constructor que inicializa un usuario con su correo, contraseña, nombres completos y apellido.
     * @param correo el correo electrónico del usuario.
     * @param contraseña la contraseña del usuario.
     * @param nombres_completos los nombres completos del usuario.
     * @param apellido el apellido del usuario.
     */
    public Usuario(String correo, String contraseña, String nombres_completos
    ,String apellido) {
        super(nombres_completos);
        this.correo = correo;
        this.contraseña = contraseña;
        this.apellido = apellido;
    }

    /**
     * Obtiene el ID del usuario.
     * @return el ID del usuario.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID del usuario.
     * @param id el ID del usuario a establecer.
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Establece al Usuario.
     */
    public Usuario() {
        super("");
        this.id = 0;
         this.correo = "";
        this.contraseña = "";
        this.apellido = "";
        this.haPostulado=false;
    }
    
    /**
     * Verifica si el usuario ha postulado.
     * @return true si el usuario ha postulado, false de lo contrario.
     */
     public boolean haPostulado() {
        return haPostulado;
    }

     /**
     * Establece si el usuario ha postulado.
     * @param haPostulado true si el usuario ha postulado, false de lo contrario.
     */
    public void setHaPostulado(boolean haPostulado) {
        this.haPostulado = haPostulado;
    }
     
    /**
     * Obtiene el apellido del usuario.
     * @return el apellido del usuario.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Establece el apellido del usuario.
     * @param apellido el apellido del usuario a establecer.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Obtiene el correo electrónico del usuario.
     * @return el correo electrónico del usuario.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico del usuario.
     * @param correo el correo electrónico del usuario a establecer.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene la contraseña del usuario.
     * @return la contraseña del usuario.
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * Establece la contraseña del usuario.
     * @param contraseña la contraseña del usuario a establecer.
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    
    
}
