
package edu.unicundi.carrerahilos;

/**
 * Clase que calcula un numero random
 * @author Christian Diaz
 * @author Camilo Medina
 */
public class Random {
    
    /**
     * Funcion que devuelve un numero aleatorio entre 1 y 3
     * @return 
     */
    public int devolverNumero(){
        int valorEntero =(int) Math.floor(Math.random()*(1-4+1)+4);
        return valorEntero;
        
    }
}
