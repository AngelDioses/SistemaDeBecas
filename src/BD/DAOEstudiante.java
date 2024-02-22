package BD;

import estructura.ListaEnlazada;
import estructura.ListaEnlazadaDoble;
import estructura.Nodo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Estudiante;
import model.Usuario;

public class DAOEstudiante {

    private static final String SELECT_ALL_POSTULANTES = "SELECT id, nombres, codigo, puntuacion FROM postulantes;";

    public void insertarEstudiante(Estudiante estudiante, String tb_baseDatos) {

        // Implementación de JDBC para insertar el estudiante en la tabla postulantes
        Conexion conexion = new Conexion();
        try (Connection connection = conexion.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(tb_baseDatos)) {
            preparedStatement.setString(1, estudiante.getNombres_completos());
            preparedStatement.setInt(2, estudiante.getCodigo());
            preparedStatement.setDouble(3, estudiante.getPuntuacion());
            preparedStatement.setString(4, estudiante.getEstado());
            preparedStatement.setString(5, estudiante.getEmail());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ListaEnlazadaDoble<Estudiante> obtenerEstudiantes() {
        ListaEnlazadaDoble<Estudiante> listaEstudiantes = new ListaEnlazadaDoble<>();
        // Usa la clase Conexion para establecer una conexión
        Conexion conexion = new Conexion();
        try (Connection connection = conexion.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_POSTULANTES);) {
            ResultSet rs = preparedStatement.executeQuery();
            //Utilizamos listaEnlazadaDoble para obtener los estudiantes
            while (rs.next()) {
                Estudiante estudiante = new Estudiante(
                        rs.getString("nombres"),
                        rs.getInt("codigo"),
                        rs.getDouble("puntuacion"));
                listaEstudiantes.insertarFinal(estudiante);
            }
        } catch (SQLException e) {
            // Manejar el error de SQL aquí
            e.printStackTrace();
        }
        return listaEstudiantes;
    }

    public boolean actualizarEstadoEstudiante(Estudiante estudiante) {
        String sql = "UPDATE postulantes SET estado = ? WHERE codigo = ?"; //Actualizamos el estado a traves del codigo del estudiante en la bd
        Conexion conexion = new Conexion();
        try (Connection connection = conexion.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, estudiante.getEstado());
            statement.setInt(2, estudiante.getCodigo());
            int filasAfectadas = statement.executeUpdate();
            return filasAfectadas > 0; //Retorna falso si no hubo filas que fueron afectadas
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public Estudiante obtenerEstudiantePorCorreo(String correo) {
    Estudiante estudiante = null; //Inicializamos un objeto estudiante
    String sql = "SELECT * FROM postulantes WHERE correo = ?"; //Sentencia que permite obtener el estudiante mediante el correo
    Conexion cn = new Conexion();
    Connection conn = cn.getConnection();
    try (
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        
        pstmt.setString(1, correo);
        
        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                //Setteamos sus campos en el estudiante que creamos al principio
                estudiante = new Estudiante();
                estudiante.setEmail(correo);
                estudiante.setCodigo(rs.getInt("codigo"));
                estudiante.setNombres_completos(rs.getString("nombres"));
              
            }
        }
    } catch (SQLException e) {
        System.out.println("Error al obtener el estudiante: " + e.getMessage());
    }
    return estudiante;
    }
}
