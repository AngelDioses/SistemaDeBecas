
package estructura;


/**
 * Interfaz para definir una colección genérica.
 *
 * @param <T> Tipo de elementos que contendrá la colección.
 */
public interface Coleccionable<T> {
    
    /**
     * Método para insertar un elemento en la colección.
     *
     * @param elemento El elemento a insertar en la colección.
     */
    void insertar(T elemento);
}
