/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructura;

public class ListaEnlazadaDoble<T> implements Coleccionable<T>{

    /**
     * Nodo que representa el inicio de la lista.
     */
    Nodo<T> inicio;
    
    /**
     * Nodo que representa el final de la lista.
     */
    Nodo<T> fin;
    
    /**
     * Tamaño de la lista.
     */
    private int tamaño;
    
    /**
     * Constructor de la lista enlazada doble.
     */
    public ListaEnlazadaDoble() {
        this.inicio = null;
        this.fin = null;
    }

     /**
     * Obtiene el nodo de inicio de la lista.
     * @return el nodo de inicio.
     */
    public Nodo<T> getInicio() {
        return inicio;
    }

    /**
     * Obtiene el nodo final de la lista.
     * @return el nodo final.
     */
    public Nodo<T> getFin() {
        return fin;
    }
    
    /**
     * Obtiene el tamaño de la lista.
     * @return el tamaño de la lista.
     */
    public int getTamaño() {
        return tamaño;
    }

     /**
     * Establece el tamaño de la lista.
     * @param tamaño el nuevo tamaño de la lista.
     */
    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

     /**
     * Inserta un elemento al inicio de la lista.
     * @param elemento el elemento a insertar.
     */
    public void insertarInicio(T elemento) {
        Nodo<T> nuevo = new Nodo<>(elemento);
        if (inicio == null) {
            inicio = nuevo;
            fin = nuevo;
        } else {
            nuevo.siguiente = inicio;
            inicio.previo = nuevo;
            inicio = nuevo;
        }
    }

    @Override
    public void insertar(T elemento){
        insertarFinal(elemento);
    }

    /**
     * Inserta un elemento al final de la lista.
     * @param elemento el elemento a insertar.
     */
    public void insertarFinal(T elemento) {
        Nodo<T> nuevo = new Nodo<>(elemento);
        if (inicio == null) {
            inicio = nuevo;
            fin = nuevo;
        } else {
            nuevo.previo = fin;
            fin.siguiente = nuevo;
            fin = nuevo;
        }
        tamaño++;
    }

     /**
     * Inserta un elemento en la posición especificada.
     * @param elemento el elemento a insertar.
     * @param posicion la posición donde insertar el elemento.
     * @throws Exception si la posición es inválida.
     */
    public void insertarPorPosicion(T elemento, int posicion) throws Exception {
        if (posicion < 0) {
            throw new Exception("Posición inválida");
        }
        if (posicion == 0) {
            insertarInicio(elemento);
        } else {
            Nodo<T> nuevo = new Nodo<>(elemento);
            Nodo<T> actual = inicio;
            int contador = 0;
            while (actual != null && contador < posicion - 1) {
                actual = actual.siguiente;
                contador++;
            }
            if (actual == null) {
                throw new Exception("Posición inválida");
            }
            nuevo.siguiente = actual.siguiente;
            nuevo.previo = actual;
            if (actual.siguiente != null) {
                actual.siguiente.previo = nuevo;
            }
            actual.siguiente = nuevo;
        }
    }

     /**
     * Elimina el nodo siguiente al nodo que contiene el elemento especificado.
     * @param elemento el elemento después del cual eliminar.
     * @throws Exception si el valor no se encuentra o es el último elemento.
     */
    public void eliminarDespuesDe(T elemento) throws Exception {
        Nodo actual = inicio;
        while (actual != null && actual.elemento != elemento) {
            actual = actual.siguiente;
        }
        if (actual == null || actual == fin) {
            throw new Exception("Valor no encontrado o es el último elemento");
        }
        Nodo<T> eliminar = actual.siguiente;
        actual.siguiente = eliminar.siguiente;
        if (eliminar.siguiente != null) {
            eliminar.siguiente.previo = actual;
        }
        if (eliminar == fin) {
            fin = actual;
        }
    }

     /**
     * Elimina el nodo que contiene el elemento especificado.
     * @param elemento el elemento a eliminar.
     */
    public void eliminar(T elemento) {
        Nodo<T> actual = inicio; // Comienza en la cabeza de la lista.

        // Buscar el nodo que contiene al elemento.
        while (actual != null && !actual.elemento.equals(elemento)) {
            actual = actual.siguiente;
        }

        // Si se encuentra el elemento, actual no será null.
        if (actual != null) {
            // Si es el único nodo en la lista.
            if (actual == inicio && actual.siguiente == null) {
                inicio = null;
            } // Si es la cabeza de la lista, pero hay más nodos.
            else if (actual == inicio) {
                inicio = actual.siguiente;
                inicio.previo = null;
            } // Si es el último nodo de la lista.
            else if (actual.getSiguiente() == null) {
                actual.previo.siguiente = null;
            } // Si está en medio de la lista.
            else {
                actual.previo.siguiente = actual.siguiente;
                actual.siguiente.previo = actual.previo;
            }

            actual.siguiente = (null);
            actual.previo = (null);
        }
    }
    
     /**
     * Obtiene el elemento en la posición especificada.
     * @param indice el índice del elemento a obtener.
     * @return el elemento en la posición especificada.
     * @throws IndexOutOfBoundsException si el índice está fuera de rango.
     */
    public T obtenerPorIndice(int indice) {
        if (indice < 0 || indice >= tamaño) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + indice);
        }
        Nodo<T> actual = inicio;
        for (int i = 0; i < indice; i++) {
            actual = actual.siguiente;
        }
        return actual.elemento;
    }

     /**
     * Elimina el elemento en la posición especificada.
     * @param posicion la posición del elemento a eliminar.
     * @throws Exception si la posición es inválida o la lista está vacía.
     */
    public void eliminarPorPosicion(int posicion) throws Exception {
        if (posicion < 0) {
            throw new Exception("Posición inválida");
        }
        if (inicio == null) {
            throw new Exception("Lista vacía");
        }
        if (posicion == 0) {
            inicio = inicio.siguiente;
            if (inicio != null) {
                inicio.previo = null;
            }
            if (inicio == null) {
                fin = null;
            }
        } else {
            Nodo<T> actual = inicio;
            int contador = 0;
            while (actual != null && contador < posicion - 1) {
                actual = actual.siguiente;
                contador++;
            }
            if (actual == null || actual.siguiente == null) {
                throw new Exception("Posición inválida");
            }
            Nodo<T> eliminar = actual.siguiente;
            actual.siguiente = eliminar.siguiente;
            if (eliminar.siguiente != null) {
                eliminar.siguiente.previo = actual;
            }
            if (eliminar == fin) {
                fin = actual;
            }
        }
    }
}
