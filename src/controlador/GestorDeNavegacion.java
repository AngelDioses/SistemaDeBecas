
package controlador;

import estructura.Pila;
import java.awt.CardLayout;
import javax.swing.JPanel;


public class GestorDeNavegacion {
    private static GestorDeNavegacion instancia;
  
    private Pila<String> historial = new Pila<>();

    public Pila<String> getHistorial() {
        return historial;
    }
    
    private GestorDeNavegacion() {
        // Constructor privado para prevenir instanciación directa
    }

    public static GestorDeNavegacion obtenerInstancia() {
        if (instancia == null) {
            instancia = new GestorDeNavegacion();
        }
        return instancia;
    }

   

        public void guardarPanel(String nombreDeLaCarta) {
            historial.push(nombreDeLaCarta); // Guarda el nombre del panel en el historial
            
        }

    public void retroceder(CardLayout gestorDeDiseño , JPanel panelPrincipal) {
       
            // Elimina el panel actual del historial
            if (!historial.isEmpty()) {
                String nombreDeLaCartaAnterior = historial.pop(); // Obtiene y elimina el nombre del panel anterior
                gestorDeDiseño.show(panelPrincipal, nombreDeLaCartaAnterior); // Muestra el panel anterior
                
            }
        
    }
}
    