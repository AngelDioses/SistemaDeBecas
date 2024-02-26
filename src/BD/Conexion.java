
package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase para manejar la conexión a la base de datos.
 */
public class Conexion {
    private static Connection conn;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String pass = "12345";
    private static final String db = "Sistema_Becas";
    private static final String url = "jdbc:mysql://localhost/"+db+"";
    
    /**
     * Constructor de la clase Conexion.
     * Intenta establecer una conexión con la base de datos.
     */
    public Conexion(){
        conn = null;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, pass);
            
            // Conexión exitosa
            if(conn != null)
                System.out.println("Conexión establecida exitosamente");
        }catch (ClassNotFoundException | SQLException ex){
            // Error en la conexión
            System.out.println("Conexión Fallida:\n\n"+ex);
        }
    }
    
    /**
     * Método para obtener la conexión a la base de datos.
     * @return Objeto de tipo Connection que representa la conexión establecida.
     */
    public Connection getConnection(){
        return conn;
    }
}


