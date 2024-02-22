package estructura;

public class Pila<T> {

    Nodo<T> tope;

    public Pila() {
        this.tope = null;
    }
// Método para inserción (push)

    public void push(T elemento) {
        Nodo<T> nuevoNodo = new Nodo<>(elemento);
        nuevoNodo.siguiente = tope;
        tope = nuevoNodo;
    }
// Método para eliminación (pop)

    // Método para eliminación (pop)
    public T pop() {
        if (isEmpty()) {
            System.out.println("La pila está vacía");
            return null;
        }
        T elemento = tope.elemento; 
        tope = tope.siguiente; 
        return elemento;
    }

// Método para verificar si la pila está vacía
    public boolean isEmpty() {
        return tope == null;
    }
// Método para vaciar la pila

    public void vaciarPila() {
        tope = null;
    }
// Método para mostrar los elementos de la pila

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
