
package estructura;


public class ListaEnlazada<T> {
    private Nodo<T> cabeza; // Referencia al primer nodo de la lista
    private int tamaño; // Contador para el tamaño de la lista

    // Constructor para inicializar la lista enlazada
    public ListaEnlazada() {
        cabeza = null;
        tamaño = 0;
    }

    // Método para añadir elementos a la lista
    public void añadir(T elemento) {
        if (cabeza == null) {
            cabeza = new Nodo<>(elemento);
        } else {
            Nodo<T> actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = new Nodo<>(elemento);
        }
        tamaño++;
    }

    // Método para imprimir los elementos de la lista
    public void imprimir() {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            System.out.println(actual.elemento);
            actual = actual.siguiente;
        }
    }
}

