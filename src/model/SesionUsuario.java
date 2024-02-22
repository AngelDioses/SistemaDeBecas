package model;

public class SesionUsuario {

    private static SesionUsuario instancia = null;
    private Usuario usuarioLogueado;

    private SesionUsuario() {
        // Constructor privado para prevenir instanciación
    }

    public static SesionUsuario getInstancia() {
        if (instancia == null) {
            instancia = new SesionUsuario();
        }
        return instancia;
    }

    public Usuario getUsuarioLogueado() {
        return usuarioLogueado;
    }

    public void setUsuarioLogueado(Usuario usuario) {
        this.usuarioLogueado = usuario;
    }
}
