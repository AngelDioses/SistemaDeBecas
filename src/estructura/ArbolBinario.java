
package estructura;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Estudiante;

public class ArbolBinario {
    public NodoArbol raiz;

    public ArbolBinario() {
        this.raiz = null;
    }
    public NodoArbol getRaiz() {
        return raiz;
    }

    public void insertar(Estudiante dato){
        raiz = insertarRecursivo(raiz,dato);
    }

    private NodoArbol insertarRecursivo(NodoArbol nodoActual, Estudiante dato){
        if(nodoActual == null){
            return new NodoArbol(dato);
        }

        if(nodoActual.dato.getPuntuacion() > dato.getPuntuacion()){
            nodoActual.izquierda = insertarRecursivo(nodoActual.izquierda, dato);
        }else if(nodoActual.dato.getPuntuacion() <= dato.getPuntuacion()){
            nodoActual.derecha = insertarRecursivo(nodoActual.derecha, dato);
        }
        else{ // Si la clave esta duplicada retorna el mismo nodo encontrado
            return nodoActual;
        }

        return nodoActual;
    }
    
     public void EnOrden(JTable tablaEstudiantes){
        BD.Conexion conexion1 = new BD.Conexion();

        Connection conn = conexion1.getConnection();
        
         DefaultTableModel modelo = new DefaultTableModel();
         
        String sql = "";
            
        modelo.addColumn("Nombre");
        modelo.addColumn("Codigo");
        modelo.addColumn("Puntuacion");
        
        tablaEstudiantes.setModel(modelo);
        
        sql = "select * from postulantes";
        
        String[] datos = new String[3];
       
        
        if (conexion1 != null) {
         try {
             Statement statement = conn.createStatement();
             ResultSet rs = statement.executeQuery(sql);
             
             while(rs.next()){
                 datos[0] = rs.getString(2);
                 datos[1] = rs.getString(3);
                 datos[2] = rs.getString(4);
                 
                 modelo.addRow(datos);
             }
             
             tablaEstudiantes.setModel(modelo);     
             
         } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo mostrar: "+e.toString());

         }
        }   
     }
     
     public ArbolBinario obtenerArbol(){
         ArbolBinario arbol = new ArbolBinario();
         BD.Conexion conexion1 = new BD.Conexion();

        Connection conn = conexion1.getConnection();
        
        
        String sql = "select * from postulantes";
        
        String[] datos = new String[4];
        Statement st;
        if (conexion1 != null) {
         try {
             Statement statement = conn.createStatement();
             ResultSet rs = statement.executeQuery(sql);
             
             while(rs.next()){
                 datos[0] = rs.getString(2);
                 datos[1] = rs.getString(3);
                 datos[2] = rs.getString(4);
                 datos[3] = rs.getString(5);
                 
                 arbol.insertar(new Estudiante(datos[0], 
                         Integer.parseInt(datos[1]), Double.parseDouble(datos[2]
                         ), datos[3]));
             }
             
         } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo mostrar: "+e.toString());

         }
        }
        return arbol;         
     }

    public void preOrden(JTable tablaEstudiantes){
        
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("Codigo");
        modelo.addColumn("Puntuacion");
        modelo.addColumn("Estado");
        tablaEstudiantes.setModel(modelo);
        preOrdenRecursivo(raiz, modelo);
    }
    
     
     public void preOrdenRecursivo(NodoArbol nodo, DefaultTableModel modelo){
        if(nodo != null){
            agregarFila(modelo, nodo.dato);
            preOrdenRecursivo(nodo.izquierda, modelo);
            preOrdenRecursivo(nodo.derecha, modelo);
        }
    }
     
    private void agregarFila(DefaultTableModel modelo, Estudiante estudiante){
        Object fila[] = {estudiante.getNombres_completos(), estudiante.getCodigo(), 
            estudiante.getPuntuacion(), estudiante.getEstado()};
        modelo.addRow(fila);
    }
    
    public void inOrden(JTable tablaEstudiantes){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("Codigo");
        modelo.addColumn("Puntuacion");
        modelo.addColumn("Estado");
        tablaEstudiantes.setModel(modelo);
        inOrdenRecursivo(raiz, modelo);
    }
    
     
     public void inOrdenRecursivo(NodoArbol nodo, DefaultTableModel modelo){
        if(nodo != null){
            inOrdenRecursivo(nodo.izquierda, modelo);
            agregarFila(modelo, nodo.dato);
            inOrdenRecursivo(nodo.derecha, modelo);
        }
    }
    
     public void postOrden(JTable tablaEstudiantes){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("Codigo");
        modelo.addColumn("Puntuacion");
        modelo.addColumn("Estado");
        tablaEstudiantes.setModel(modelo);
        postOrdenRecursivo(raiz, modelo);
    }
    
     
     public void postOrdenRecursivo(NodoArbol nodo, DefaultTableModel modelo){
        if(nodo != null){
            postOrdenRecursivo(nodo.izquierda, modelo);
            postOrdenRecursivo(nodo.derecha, modelo);
            agregarFila(modelo, nodo.dato);
        }
    }
    

    public void limpiarTodo(){
        raiz = null;
    }
}

