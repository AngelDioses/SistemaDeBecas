/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructura;



import java.util.LinkedList;

public class MiHashMap<K, V>
        implements MiMapa<K, V> {
    private static int CAPACIDADINICIALPORDEFECTO = 4;
    // tamaño máximo de la tabla 2^30
    private static int CAPACIDADMAXIMA = 1 << 30;
    private static float MAXFACTORCARGAPORDEFECTO = 0.75f;
    int capacidad;
    int size = 0;
    float factordecarga = 0.5f;
    LinkedList<MiMapa.Cubeta<K, V>>[] tabla;

    public MiHashMap() {
        this(CAPACIDADINICIALPORDEFECTO, MAXFACTORCARGAPORDEFECTO);
    }

    public MiHashMap(int capacidad) {
        this(capacidad, 0.75f);
    }

    public MiHashMap(int capacidad, float factordecarga) {
    this.capacidad = capacidad;
    this.factordecarga = factordecarga;
    
    tabla = new LinkedList[capacidad];
    for (int i = 0; i < capacidad; i++) {
        tabla[i] = new LinkedList<>();
    }
}


    public boolean containsKey(K clave) {
        if (get(clave) != null)
            return true;
        else
            return false;
    }

    public V get(K clave) {
        int indiceCubeta = hash(clave.hashCode());
        if (tabla[indiceCubeta] != null) {
            LinkedList<Cubeta<K, V>> cubeta = tabla[indiceCubeta];
            for (Cubeta<K, V> entrada : cubeta)
                if (entrada.getClave().equals(clave))
                    return entrada.getValor();
        }
        return null;
    }

    private int hash(int hashcode) {
        return hashSuplementario(hashcode) & (capacidad - 1);
    }

    private int hashSuplementario(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    public int size() {
        return size;
    }

    public void clear() {
        size = 0;
        eliminaElementos();
    }

    public void eliminaElementos() {
        for (int i = 0; i < capacidad; i++) {
            if (tabla[i] != null) {
                tabla[i].clear();
            }
        }
    }
    public void put(K clave, V valor) {
    int indiceCubeta = hash(clave.hashCode());
    if (tabla[indiceCubeta] == null) {
        tabla[indiceCubeta] = new LinkedList<>();
    }
    // Buscar la clave en la cubeta. Si la clave ya existe, actualizamos el valor.
    // Si no, añadimos una nueva entrada.
    boolean encontrado = false;
    for (MiMapa.Cubeta<K, V> entrada : tabla[indiceCubeta]) {
        if (entrada.getClave().equals(clave)) {
            entrada.valor = valor;
            encontrado = true;
            break;
        }
    }
    if (!encontrado) {
        tabla[indiceCubeta].add(new MiMapa.Cubeta<>(clave, valor));
        size++;
    }
    
}


    public boolean isEmpty() {
        return size == 0;
    }

}
