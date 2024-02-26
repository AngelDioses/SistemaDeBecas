/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructura;


import java.util.LinkedList;

/**
 * Esta clase representa una implementación de un mapa utilizando una tabla hash.
 * @param <K> el tipo de las claves.
 * @param <V> el tipo de los valores asociados a las claves.
 */
public class MiHashMap<K, V> implements MiMapa<K, V> {
    private static int CAPACIDADINICIALPORDEFECTO = 4;
    // tamaño máximo de la tabla 2^30
    private static int CAPACIDADMAXIMA = 1 << 30;
    private static float MAXFACTORCARGAPORDEFECTO = 0.75f;
    int capacidad;
    int size = 0;
    float factordecarga = 0.5f;
    LinkedList<MiMapa.Cubeta<K, V>>[] tabla;

    /**
     * Constructor por defecto que inicializa el mapa con capacidad y factor de carga por defecto.
     */
    public MiHashMap() {
        this(CAPACIDADINICIALPORDEFECTO, MAXFACTORCARGAPORDEFECTO);
    }

    /**
     * Constructor que inicializa el mapa con una capacidad específica y factor de carga por defecto.
     * @param capacidad la capacidad inicial del mapa.
     */
    public MiHashMap(int capacidad) {
        this(capacidad, 0.75f);
    }

    /**
     * Constructor que inicializa el mapa con una capacidad y factor de carga específicos.
     * @param capacidad la capacidad inicial del mapa.
     * @param factordecarga el factor de carga máximo del mapa.
     */
    public MiHashMap(int capacidad, float factordecarga) {
    this.capacidad = capacidad;
    this.factordecarga = factordecarga;
    
    tabla = new LinkedList[capacidad];
    for (int i = 0; i < capacidad; i++) {
        tabla[i] = new LinkedList<>();
    }
}


    /**
     * Verifica si el mapa contiene una clave específica.
     * @param clave la clave a buscar en el mapa.
     * @return true si el mapa contiene la clave, false de lo contrario.
     */
    public boolean containsKey(K clave) {
        if (get(clave) != null)
            return true;
        else
            return false;
    }

    /**
     * Obtiene el valor asociado a una clave específica.
     * @param clave la clave cuyo valor se desea obtener.
     * @return el valor asociado a la clave, o null si la clave no está presente en el mapa.
     */
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

    /**
     * Calcula el índice de la cubeta en la tabla hash.
     * @param hashcode el código hash de la clave.
     * @return el índice de la cubeta.
     */
    private int hash(int hashcode) {
        return hashSuplementario(hashcode) & (capacidad - 1);
    }

    /**
     * Realiza un hash suplementario para distribuir los elementos de manera uniforme.
     * @param h el código hash original.
     * @return el hash suplementario.
     */
    private int hashSuplementario(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    /**
     * Obtiene el tamaño del mapa.
     * @return el tamaño del mapa.
     */
    public int size() {
        return size;
    }

    /**
     * Elimina todos los elementos del mapa.
     */
    public void clear() {
        size = 0;
        eliminaElementos();
    }

    /**
     * Elimina todos los elementos de la tabla hash.
     */
    public void eliminaElementos() {
        for (int i = 0; i < capacidad; i++) {
            if (tabla[i] != null) {
                tabla[i].clear();
            }
        }
    }

    /**
     * Asocia el valor especificado con la clave especificada en este mapa.
     * @param clave la clave con la que se asociará el valor.
     * @param valor el valor que se asociará con la clave.
     */
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


    /**
     * Verifica si el mapa está vacío.
     * @return true si el mapa está vacío, false de lo contrario.
     */
    public boolean isEmpty() {
        return size == 0;
    }

}
