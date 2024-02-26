
package estructura;

import model.Estudiante;

/**
 * Esta clase representa un nodo en un árbol binario.
 */
public class NodoArbol {
    /**
     * El dato almacenado en el nodo.
     */
    public Estudiante dato;
    
    /**
     * El hijo izquierdo del nodo.
     */
    public NodoArbol izquierda;
    
    /**
     * El hijo derecho del nodo.
     */
    public NodoArbol derecha;

    /**
     * Constructor para inicializar un nodo con un dato dado.
     * @param dato el dato a almacenar en el nodo.
     */
    public NodoArbol(Estudiante dato) {
        this.dato = dato;
        this.izquierda = null;
        this.derecha = null;
    }
}
