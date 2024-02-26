
package estructura;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Clase para establecer la conexión a una base de datos MySQL.
 */
public class Conexion {
    
    /** Objeto de conexión a la base de datos. */
    Connection conectar = null;
    
    /** Usuario de la base de datos. */
    String usuario = "root";
    
    /** Contraseña de la base de datos. */
    String contrasenia = "12345"; // Contraseña de la base de datos (¡asegúrate de ocultarla antes de compartir el código!)
    
    /** Nombre de la base de datos. */
    String bd = "sistema_becas";
    
    /** Dirección IP del servidor de la base de datos. */
    String ip = "localhost";
    
    /** Puerto de conexión a la base de datos. */
    String puerto = "3306";
    
    /** Cadena de conexión a la base de datos. */
    String cadena = "jdbc:mysql://"+ip+":"+puerto+"/"+bd;
    
    /**
     * Establece la conexión a la base de datos.
     * @return El objeto Connection que representa la conexión establecida.
     */
    public Connection estableceConexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar = DriverManager.getConnection(cadena, usuario, contrasenia);            
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectarse: "+e.toString());
        }
        return conectar;
    }
}
