
package controlador;

import estructura.Pila;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 * Clase que gestiona la navegación entre paneles de una interfaz gráfica.
 */
public class GestorDeNavegacion {
    private static GestorDeNavegacion instancia;
  
    private Pila<String> historial = new Pila<>();

    /**
     * Obtiene el historial de paneles visitados.
     * @return El historial de navegación.
     */
    public Pila<String> getHistorial() {
        return historial;
    }
    
    /**
     * Constructor privado para prevenir la instanciación directa.
     */
    private GestorDeNavegacion() {
        // Constructor privado para prevenir instanciación directa
    }

    /**
     * Obtiene la instancia única del gestor de navegación.
     * @return La instancia del gestor de navegación.
     */
    public static GestorDeNavegacion obtenerInstancia() {
        if (instancia == null) {
            instancia = new GestorDeNavegacion();
        }
        return instancia;
    }

    /**
     * Guarda el nombre de un panel en el historial de navegación.
     * @param nombreDeLaCarta El nombre del panel a guardar en el historial.
     */
    public void guardarPanel(String nombreDeLaCarta) {
        historial.push(nombreDeLaCarta); // Guarda el nombre del panel en el historial
    }

    /**
     * Retrocede a través del historial de navegación.
     * @param gestorDeDiseño El gestor de diseño de la interfaz gráfica.
     * @param panelPrincipal El panel principal donde se muestra la interfaz.
     */
    public void retroceder(CardLayout gestorDeDiseño , JPanel panelPrincipal) {
        // Elimina el panel actual del historial
        if (!historial.isEmpty()) {
            String nombreDeLaCartaAnterior = historial.pop(); // Obtiene y elimina el nombre del panel anterior
            gestorDeDiseño.show(panelPrincipal, nombreDeLaCartaAnterior); // Muestra el panel anterior
        }
    }
}
 