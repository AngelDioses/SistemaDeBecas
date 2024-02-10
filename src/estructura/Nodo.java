package estructura;

public class Nodo<T> {
    T elemento; 
    Nodo<T> siguiente; 

    // Constructor para inicializar el nodo
    public Nodo(T elemento) {
        this.elemento = elemento;
        this.siguiente = null;
    }
}
