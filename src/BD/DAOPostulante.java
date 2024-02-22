package BD;

import estructura.Cola;
import estructura.Coleccionable;
import estructura.ListaEnlazadaDoble;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Estudiante;

public class DAOPostulante {
    //Metodo para cargar los estudiantes de la BD a traves del uso de cualquier estructura que implemente el interface 'Coleccionable'
    public void cargarEstudiantesDeBD(Coleccionable<Estudiante> coleccionEstudiantes,
            String sql_tbl) {
        //Establecemos conexion
        Conexion conexion1 = new Conexion();

        Connection conn = conexion1.getConnection();
        //Si hay conexion
        if (conexion1 != null) {
            try {
                // Crear un Statement para ejecutar SQL
                Statement statement = conn.createStatement();

                // Ejecutamos una consulta SQL y procesamos los datos
                ResultSet resultSet = statement.executeQuery(sql_tbl);

                //Establecemos lo conseguido en la BD a los atributos de estudiantes
                while (resultSet.next()) {
                    Estudiante estudiante = new Estudiante();
                    estudiante.setId(resultSet.getInt("id"));
                    estudiante.setNombres_completos(resultSet.getString("nombres"));
                    estudiante.setCodigo(resultSet.getInt("codigo"));
                    estudiante.setPuntuacion(resultSet.getDouble("puntuacion"));
                    estudiante.setEstado(resultSet.getString("estado"));
                    
                    coleccionEstudiantes.insertar(estudiante);
                }

                // Cerramos
                resultSet.close();
                statement.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No se pudo establecer una conexión con la base de datos.");
        }
       
    }
    //Metodo para eliminarEstudiantes de la BD
    
    public void eliminarEstudianteEnBD(Estudiante estudiante) {
        Conexion conexionBD = new Conexion();
        Connection conn = conexionBD.getConnection(); // Obtiene la conexión a la BD

        String sql = "DELETE FROM postulantes WHERE nombres = ?"; //Sentencia que atraves del campo nombre eliminaremos los postulantes

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, estudiante.getNombres_completos()); // Ajusta este índice y método set según tu esquema de BD y tipo de dato
            int filasAfectadas = pstmt.executeUpdate(); //Ejecutamos la eliminacion

            if (filasAfectadas > 0) {
                System.out.println("Estudiante eliminado de la base de datos con éxito.");
            } else {
                System.out.println("No se pudo eliminar el estudiante de la base de datos.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
   
    

}
// Consulta SQL

