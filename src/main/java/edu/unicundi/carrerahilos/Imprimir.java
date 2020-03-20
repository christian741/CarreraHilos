
package edu.unicundi.carrerahilos;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *Clase que imprime 
 * @author Christian Diaz
 * @author Camilo Medina
 */
public class Imprimir {
    
    /**
     * Funcion que imprime la trayectoria de la carrera y corredor
     * @param mapa
     * @param posicion 
     */
     public static synchronized void imprimir(Map <Integer,String> mapa,int posicion){
        String cadena="";
        for (Integer k: mapa.keySet()) {
             cadena+=mapa.get(k);
        }
        
        System.out.print(cadena);
        System.out.println("");
         try {
             Thread.sleep(500);
         } catch (InterruptedException ex) {
             Logger.getLogger(Imprimir.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
}
