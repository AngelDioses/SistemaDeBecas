
package estructura;

import model.Estudiante;

public class NodoArbol {
    public Estudiante dato;
    public NodoArbol izquierda, derecha;

    public NodoArbol(Estudiante dato) {
        this.dato = dato;
        this.izquierda = null;
        this.derecha = null;
    }
}
