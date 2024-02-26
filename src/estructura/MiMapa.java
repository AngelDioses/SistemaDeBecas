
package estructura;

/**
 * Esta interfaz representa un mapa genérico.
 * @param <K> el tipo de las claves.
 * @param <V> el tipo de los valores asociados a las claves.
 */
public interface MiMapa<K,V> {
     /**
      * Elimina todos los elementos del mapa.
      */
     void clear();
     
     /**
      * Verifica si el mapa contiene una clave específica.
      * @param clave la clave a buscar en el mapa.
      * @return true si el mapa contiene la clave, false de lo contrario.
      */
     boolean containsKey(K clave);
     
     /**
      * Verifica si el mapa está vacío.
      * @return true si el mapa está vacío, false de lo contrario.
      */
     boolean isEmpty();
     
     /**
      * Obtiene el tamaño del mapa.
      * @return el tamaño del mapa.
      */
     int size();
     
     /**
      * Esta clase interna estática representa una cubeta en el mapa, que contiene una clave y un valor.
      * @param <K> el tipo de la clave.
      * @param <V> el tipo del valor.
      */
      static class Cubeta<K,V> {
          K clave;
          V valor;
          
          /**
           * Constructor para crear una nueva cubeta con la clave y valor especificados.
           * @param clave la clave de la cubeta.
           * @param valor el valor asociado a la clave.
           */
        public Cubeta(K clave, V valor) {
            this.clave = clave;
            this.valor = valor;
        }

        /**
         * Obtiene la clave de la cubeta.
         * @return la clave de la cubeta.
         */
        public K getClave() {
            return clave;
        }
        
        /**
         * Obtiene el valor asociado a la clave en la cubeta.
         * @return el valor asociado a la clave.
         */
        public V getValor() {
            return valor;
        }

        /**
         * Devuelve una representación en cadena de la cubeta.
         * @return una representación en cadena de la cubeta.
         */
        @Override
        public String toString() {
            return "Cubeta{" + "clave=" + clave + ", valor=" + valor + '}';
        }
      }
}
