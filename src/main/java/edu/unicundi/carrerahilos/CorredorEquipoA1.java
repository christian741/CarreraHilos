
package edu.unicundi.carrerahilos;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase Corrdor del  equipo A
 * @@author Christian Diaz
 * @author Camilo Medina
 */
public class CorredorEquipoA1 extends Thread {
    
    
    Random movimientos;
    private int pasos=0;
    
    /**
     * Dato que sincroniza la carrera
     */
    final Dato paso;
   
    /**
     * Mapa para pintar la carrera
     */
    Map<Integer,String> listaEquipoA=new HashMap<>();
    
    /**
     * Constructor de la clase
     * @param paso
     * @param lista 
     */
    public CorredorEquipoA1(Dato paso,Map<Integer,String> lista) {
        this.paso = paso;
        this.listaEquipoA=lista;
        movimientos=new Random();    
    }
    
    
    /**
     * Metodo para iniciar el hilo
     */
    @Override
    public void run() {
       iniciar();
    }
    
    /**
     * Metodo donde se simula la carrera
     */
    public void  iniciar(){
        int posicion=0;
        while(pasos<32 || pasos==32){
            int numero=movimientos.devolverNumero();
                pasos+=numero;
                posicion+=numero;
            listaEquipoA.put(posicion,"\033[30m A1");
            Imprimir.imprimir(listaEquipoA,posicion);
            listaEquipoA.put(posicion, " ");
            
             synchronized(paso){
                if(terminoCarrera()==true){
                    paso.notify();
                    paso.setPasos(pasos);
                    break;
                }
            }
        }
        listaEquipoA.put(32, " ");  
        listaEquipoA.put(33, " ");  
        listaEquipoA.put(34, " "); 
        listaEquipoA.put(35, " "); 
        listaEquipoA.put(36, " "); 
    } 
    
    /**
     * Metodo que determina si acabo la carrera
     * @return 
     */
    public boolean terminoCarrera(){
        boolean valor=false;
       if(pasos==32 || pasos>32){
           valor=true; 
       }
          
      return valor;
    }

    public int getPasos() {
        return pasos;
    }

    public void setPasos(int pasos) {
        this.pasos = pasos;
    }

   
    
}
