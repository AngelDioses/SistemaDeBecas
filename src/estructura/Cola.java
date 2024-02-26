package estructura;

/**
 * Clase que representa una estructura de datos de cola.
 * @param <T> Tipo de los elementos almacenados en la cola.
 */
public class Cola<T> implements Coleccionable<T> {
    /** Nodo delantero de la cola. */
    Nodo<T> frente;
    /** Nodo trasero de la cola. */
    Nodo<T> fin;
    /** Tamaño de la cola. */
    private int tamaño;

    /**
     * Constructor para crear una cola vacía.
     */
    public Cola() {
        this.frente = null;
        this.fin = null;
    }

    /**
     * Método para insertar un elemento en la cola.
     * @param elemento El elemento a insertar.
     */
    public void insertar(T elemento) {
        Nodo<T> nuevoNodo = new Nodo<>(elemento);
        if (isEmpty()) {
            frente = nuevoNodo;
            fin = nuevoNodo;
        } else {
            fin.siguiente = nuevoNodo;
            fin = nuevoNodo;
        }
        tamaño++;
    }

    /**
     * Método para eliminar y devolver el elemento del frente de la cola.
     * @return El elemento del frente de la cola.
     */
    public T desencolar() {
        if (isEmpty()) {
            System.out.println("La cola está vacía");
            return null;
        }
        Nodo<T> nodoAEliminar = frente;
        T elementoAEliminar = nodoAEliminar.elemento;
        if (frente == fin) {
            frente = null;
            fin = null;
        } else {
            frente = frente.siguiente;
        }
        tamaño--;
        return elementoAEliminar;
    }

    /**
     * Método para verificar si la cola está vacía.
     * @return true si la cola está vacía, false en caso contrario.
     */
    public boolean isEmpty() {
        return frente == null;
    }

    /**
     * Método para obtener el nodo del frente de la cola.
     * @return El nodo del frente de la cola.
     */
    public Nodo<T> peek() {
        return frente;
    }

    /**
     * Método para vaciar la cola, eliminando todos los elementos.
     */
    public void vaciarCola() {
        frente = null;
        fin = null;

    }

    /**
     * Método para obtener el nodo del frente de la cola.
     * @return El nodo del frente de la cola.
     */
    public Nodo<T> getFrente() {
        return frente;
    }

    /**
     * Método para establecer el nodo del frente de la cola.
     * @param frente El nuevo nodo del frente de la cola.
     */
    public void setFrente(Nodo<T> frente) {
        this.frente = frente;
    }

    /**
     * Método para obtener el nodo del final de la cola.
     * @return El nodo del final de la cola.
     */
    public Nodo<T> getFin() {
        return fin;
    }

    /**
     * Método para establecer el nodo del final de la cola.
     * @param fin El nuevo nodo del final de la cola.
     */
    public void setFin(Nodo<T> fin) {
        this.fin = fin;
    }

    /**
     * Método para obtener el tamaño de la cola.
     * @return El tamaño de la cola.
     */
    public int getTamaño() {
        return tamaño;
    }

    /**
     * Método para establecer el tamaño de la cola.
     * @param tamaño El nuevo tamaño de la cola.
     */
    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    /**
     * Método para mostrar los elementos de la cola.
     */
    public void mostrarCola() {
        if (isEmpty()) {
            System.out.println("La cola está vacía");
            return;
        }
        Nodo<T> temp = frente;
        System.out.print("Elementos de la cola: ");
        while (temp != null) {
            System.out.print(temp.elemento + " ");
            temp = temp.siguiente;
        }
        System.out.println();
    }
}
