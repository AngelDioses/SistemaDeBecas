package model;

/**
 * Esta clase representa la sesión de usuario en la aplicación.
 */
public class SesionUsuario {

    private static SesionUsuario instancia = null;
    private Usuario usuarioLogueado;

    /**
     * Constructor privado para prevenir la instanciación externa.
     */
    private SesionUsuario() {
        // Constructor privado para prevenir instanciación
    }

    /**
     * Obtiene la instancia única de la sesión de usuario (implementación del patrón Singleton).
     * @return la instancia única de la sesión de usuario.
     */
    public static SesionUsuario getInstancia() {
        if (instancia == null) {
            instancia = new SesionUsuario();
        }
        return instancia;
    }

    /**
     * Obtiene el usuario actualmente logueado en la sesión.
     * @return el usuario logueado.
     */
    public Usuario getUsuarioLogueado() {
        return usuarioLogueado;
    }

    /**
     * Establece el usuario logueado en la sesión.
     * @param usuario el usuario a establecer como logueado.
     */
    public void setUsuarioLogueado(Usuario usuario) {
        this.usuarioLogueado = usuario;
    }
}
