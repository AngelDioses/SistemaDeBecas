package estructura;

import model.Estudiante;

public class ListaEnlazada<T> implements Coleccionable<T>{

    private Nodo<T> cabeza; // Referencia al primer nodo de la lista
    private int tamaño; // Contador para el tamaño de la lista

    public Nodo<T> getCabeza() {
        return cabeza;
    }

    public int getTamaño() {
        return tamaño;
    }

    // Constructor para inicializar la lista enlazada
    public ListaEnlazada() {
        cabeza = null;
        tamaño = 0;
    }

    // Método para añadir elementos a la lista
    public void insertar(T elemento){
        añadir(elemento);
    }
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

    // Método para imprimir los elementos de la lista
    public void imprimir() {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            System.out.println(actual.elemento);
            actual = actual.siguiente;
        }
    }

}
