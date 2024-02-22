package estructura;

public class Nodo<T> {
    // Para ListaEnlazada
    T elemento; 
    Nodo<T> siguiente; 
    Nodo<T> previo;
    
    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo<T> getPrevio() {
        return previo;
    }

    public void setPrevio(Nodo<T> previo) {
        this.previo = previo;
    }
    
    
    // Constructor para inicializar el nodo
    public Nodo(T elemento) {
        this.elemento = elemento;
        this.siguiente = null;
        this.previo = null;
    }
   
    
    //Para lista doble enlazada
}
