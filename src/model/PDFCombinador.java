package model;

import estructura.ListaEnlazada;
import estructura.Nodo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.pdfbox.multipdf.PDFMergerUtility;

public class PDFCombinador {
    //Metodo para combinar los 5 pdfs (4 de sustento y 1 de reporte de estudiante)
     public void combinarPDFsDirectamente(ListaEnlazada<String> rutas, Estudiante estudiante) {
        try {
            /*Utilizamos la clase PDFM... de la libreria de PDFBox , 
            esto para unir pdfs del reporte del estudiante junto a los docs de sustento*/
            
            PDFMergerUtility combinador = new PDFMergerUtility();
            //Seleccionamos la ruta en la que se guardara el documento combinado
            combinador.setDestinationFileName("C:\\Users\\angel\\Desktop\\Reportes\\" + estudiante.getCodigo() + "_.pdf");
            //Guardamos la ruta del reporte en pdf generado del estudiante
            File ruta1 = new File("C:\\Users\\angel\\Desktop\\Reportes\\" + estudiante.getCodigo() + ".pdf");
            //Antes de iterar con la ayuda de la listaenlazada insertaremos el reporte del estudiante
            combinador.addSource(ruta1);

            //Comenzamos a iterar
            
            Nodo<String> actual = rutas.getCabeza(); //Guarda la primera ruta en un nodo String
            while (actual != null) {
                try {
                    File archivo = new File(actual.getElemento()); //  Guardamos la ruta en el archivo
                    if (!archivo.exists() || archivo.isDirectory()) { //Si el archivo no existe o no es valido
                        JOptionPane.showMessageDialog(null, "Archivo no válido o no encontrado: " + actual.getElemento());
                        return;
                    }
                    combinador.addSource(archivo); //combinamos el archivo con el reporte
                    actual = actual.getSiguiente(); //Se va a la siguiente ruta
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Error al añadir el archivo al combinador: " + e.getMessage());
                    return;
                }
            }

            try {
                combinador.mergeDocuments(null);
                JOptionPane.showMessageDialog(null, "Gracias por postular !");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al combinar los documentos: " + e.getMessage());
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}
