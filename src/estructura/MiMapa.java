
package estructura;

public interface MiMapa<K,V> {
     void clear();
     boolean containsKey(K clave);
     boolean isEmpty();
     //boolean containsValue(V valor);
     // todos los otros 
     int size();
      static class Cubeta<K,V> {
          K clave;
          V valor;
        public Cubeta(K clave, V valor) {
            this.clave = clave;
            this.valor = valor;
        }

        @Override
        public String toString() {
            return "Cubeta{" + "clave=" + clave + ", valor=" + valor + '}';
        }
        

        public K getClave() {
            return clave;
        }
        public V getValor() {
            return valor;
        }




    
      }
}

