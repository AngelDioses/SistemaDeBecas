package estructura;

public class Cola<T> implements Coleccionable<T> {

    Nodo<T> frente;
    Nodo<T> fin;
    private int tamaño;

    public Cola() {
        this.frente = null;
        this.fin = null;
    }
// Método para inserción

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
// Método para eliminación

    public T desencolar() {
        if (isEmpty()) {
            System.out.println("La cola está vacía");
            return null;
        }

        Nodo<T> nodoAEliminar = frente; // Guarda el nodo actual de frente antes de modificarlo
        T elementoAEliminar = nodoAEliminar.elemento; // Guarda el elemento a eliminar

        if (frente == fin) { // Esto significa que solo hay un elemento en la cola
            frente = null; // La cola ahora está vacía
            fin = null;
        } else {
            frente = frente.siguiente; // Mueve el frente al siguiente nodo
        }

        tamaño--; // Decrementa el tamaño de la cola

        return elementoAEliminar; // Devuelve el elemento del nodo eliminado
    }

// Método para verificar si la cola está vacía
    public boolean isEmpty() {
        return frente == null;
    }

    public Nodo<T> peek() {
        return frente;
    }
// Método para vaciar la cola

    public void vaciarCola() {
        frente = null;
        fin = null;

    }

    public Nodo<T> getFrente() {
        return frente;
    }

    public void setFrente(Nodo<T> frente) {
        this.frente = frente;
    }

    public Nodo<T> getFin() {
        return fin;
    }

    public void setFin(Nodo<T> fin) {
        this.fin = fin;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }
    // Método para mostrar los elementos de la cola

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
