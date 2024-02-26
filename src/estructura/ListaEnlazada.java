package estructura;

import model.Estudiante;

/**
 * Clase que representa una lista enlazada.
 * @param <T> Tipo de los elementos almacenados en la lista.
 */
public class ListaEnlazada<T> implements Coleccionable<T>{

    /** Referencia al primer nodo de la lista. */
    private Nodo<T> cabeza;
    
    /** Contador para el tamaño de la lista. */
    private int tamaño;

    /**
     * Método para obtener la cabeza de la lista.
     * @return El primer nodo de la lista.
     */
    public Nodo<T> getCabeza() {
        return cabeza;
    }

    /**
     * Método para obtener el tamaño de la lista.
     * @return El tamaño de la lista.
     */
    public int getTamaño() {
        return tamaño;
    }

    /**
     * Constructor para inicializar la lista enlazada.
     */
    public ListaEnlazada() {
        cabeza = null;
        tamaño = 0;
    }

    /**
     * Método para añadir elementos a la lista.
     * @param elemento El elemento a añadir.
     */
    public void insertar(T elemento){
        añadir(elemento);
    }

    /**
     * Método para añadir un elemento a la lista.
     * @param elemento El elemento a añadir.
     */
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
    
    /**
     * Método para obtener un elemento de la lista por índice.
     * @param indice El índice del elemento a obtener.
     * @return El elemento en la posición especificada.
     * @throws IndexOutOfBoundsException Si el índice está fuera de rango.
     */
    public T obtenerPorIndice(int indice) {
        if (indice < 0 || indice >= tamaño) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + indice);
        }
        Nodo<T> actual = cabeza;
        for (int i = 0; i < indice; i++) {
            actual = actual.siguiente;
        }
        return actual.elemento;
    }

    /**
     * Método para imprimir los elementos de la lista.
     */
    public void imprimir() {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            System.out.println(actual.elemento);
            actual = actual.siguiente;
        }
    }
}
