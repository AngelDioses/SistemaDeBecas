package estructura;

/**
 * Esta clase representa un nodo que puede almacenar un elemento de tipo genérico.
 * @param <T> el tipo de elemento que el nodo puede almacenar.
 */
public class Nodo<T> {
    // Para ListaEnlazada
    T elemento; 
    Nodo<T> siguiente; 
    Nodo<T> previo;
    
    /**
     * Obtiene el elemento almacenado en el nodo.
     * @return el elemento almacenado en el nodo.
     */
    public T getElemento() {
        return elemento;
    }

    /**
     * Establece el elemento del nodo.
     * @param elemento el elemento a establecer en el nodo.
     */
    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    /**
     * Obtiene el nodo siguiente.
     * @return el nodo siguiente.
     */
    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    /**
     * Establece el nodo siguiente.
     * @param siguiente el nodo siguiente a establecer.
     */
    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }

    /**
     * Obtiene el nodo previo.
     * @return el nodo previo.
     */
    public Nodo<T> getPrevio() {
        return previo;
    }

    /**
     * Establece el nodo previo.
     * @param previo el nodo previo a establecer.
     */
    public void setPrevio(Nodo<T> previo) {
        this.previo = previo;
    }
    
    
    // Constructor para inicializar el nodo
    /**
     * Constructor para inicializar un nodo con un elemento dado.
     * @param elemento el elemento a almacenar en el nodo.
     */
    public Nodo(T elemento) {
        this.elemento = elemento;
        this.siguiente = null;
        this.previo = null;
    }
}
