package BD;

import java.sql.*;
import javax.swing.JOptionPane;
import model.Usuario;

/**
 * Clase que maneja las operaciones de acceso a datos para los usuarios.
 */
public class DAOUser {

    // Modificar de acuerdo a tu configuración de MySQL
    private String jdbcURL = "jdbc:mysql://localhost:3306/Sistema_Becas";
    private String jdbcUsername = "root";
    private String jdbcPassword = "12345";

    /**
     * Valida los datos ingresados por el usuario.
     * @param username El nombre de usuario.
     * @param password La contraseña del usuario.
     * @param sql_table La consulta SQL para validar al usuario.
     * @return true si el usuario es válido, false si no lo es.
     */
    public boolean validarUsuario(String username, String password, String sql_table) {
        boolean resultado = false;
        // Intentamos establecer la conexión
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
                PreparedStatement preparedStatement = connection.prepareStatement(sql_table)) {
            // Establecemos los parámetros
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            // Si ejecuta de manera correcta entonces el usuario es válido
            try (ResultSet rs = preparedStatement.executeQuery()) {
                resultado = rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    /**
     * Inserta un nuevo usuario en la base de datos.
     * @param nombre El nombre del usuario.
     * @param apellidos Los apellidos del usuario.
     * @param correo El correo electrónico del usuario.
     * @param contrasena La contraseña del usuario.
     */
    public void insertarUsuario(String nombre, String apellidos, String correo, String contrasena) {
        // Verificamos que no sean vacíos los campos
        if (nombre == null || nombre.isEmpty() || apellidos == null || apellidos.isEmpty()
                || correo == null || correo.isEmpty() || contrasena == null || contrasena.isEmpty()) {

            JOptionPane.showMessageDialog(null, "Por favor, completa todos los campos.", "Información incompleta", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Establecemos conexión a BD
        Conexion conexion = new Conexion();
        Connection conn = conexion.getConnection();
        PreparedStatement pstmt = null;

        try {

            // A través de esta sentencia insertamos los usuarios
            String sql = "INSERT INTO usuariosEstudiantes (nombres, apellidos, correo, contrasena ,haPostulado"
                    + ") VALUES (?, ?, ?, ? ,?)";
            pstmt = conn.prepareStatement(sql);

            // Establecer los valores de los parámetros.
            pstmt.setString(1, nombre);
            pstmt.setString(2, apellidos);
            pstmt.setString(3, correo);
            pstmt.setString(4, contrasena);
            pstmt.setBoolean(5, false); // False por defecto

            // Ejecutamos la sentencia SQL.
            pstmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Registro exitoso.", "Registro", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();

            JOptionPane.showMessageDialog(null, "Error al registrar el usuario: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Cerrar los recursos.
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Obtiene un usuario de la base de datos según sus credenciales.
     * @param correo El correo electrónico del usuario.
     * @param password La contraseña del usuario.
     * @return Un objeto Usuario si se encuentra en la base de datos, null si no se encuentra.
     */
    public Usuario obtenerUsuarioPorCredenciales(String correo, String password) {
        // Establecemos conexión
        Usuario usuario = null;
        Conexion cn = new Conexion();
        Connection con = cn.getConnection();
        try (

            // Sentencia SQL
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM usuariosEstudiantes WHERE correo = ? AND contrasena = ?")) {

            pstmt.setString(1, correo);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                usuario = new Usuario();
                // Guardamos la info de los campos especificados de la BD en el usuario
                usuario.setCorreo(rs.getString("correo"));
                usuario.setContraseña(rs.getString("contrasena"));
                usuario.setNombres_completos(rs.getString("nombres"));
                usuario.setApellido(rs.getString("apellidos"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }
}
