package estructura;

/**
 * Esta clase representa una pila genérica.
 * @param <T> el tipo de elementos que contendrá la pila.
 */
public class Pila<T> {

    /**
     * El nodo que representa el tope de la pila.
     */
    Nodo<T> tope;

    /**
     * Constructor para inicializar una pila vacía.
     */
    public Pila() {
        this.tope = null;
    }

    /**
     * Inserta un elemento en la pila (push).
     * @param elemento el elemento a insertar en la pila.
     */
    public void push(T elemento) {
        Nodo<T> nuevoNodo = new Nodo<>(elemento);
        nuevoNodo.siguiente = tope;
        tope = nuevoNodo;
    }

    /**
     * Elimina y devuelve el elemento en la cima de la pila (pop).
     * @return el elemento eliminado de la cima de la pila, o null si la pila está vacía.
     */
    public T pop() {
        if (isEmpty()) {
            System.out.println("La pila está vacía");
            return null;
        }
        T elemento = tope.elemento; 
        tope = tope.siguiente; 
        return elemento;
    }

    /**
     * Verifica si la pila está vacía.
     * @return true si la pila está vacía, false de lo contrario.
     */
    public boolean isEmpty() {
        return tope == null;
    }

    /**
     * Vacía la pila, eliminando todos los elementos.
     */
    public void vaciarPila() {
        tope = null;
    }

    /**
     * Muestra los elementos de la pila.
     */
    public void mostrarPila() {
        Nodo temp = tope;
        System.out.print("Elementos de la pila: ");
        while (temp != null) {
            System.out.print(temp.elemento + " ");
            temp = temp.siguiente;
        }
        System.out.println();
    }
}
