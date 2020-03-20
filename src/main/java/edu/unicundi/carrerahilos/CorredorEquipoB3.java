
package edu.unicundi.carrerahilos;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Clase que representa el corredor tres del equipo B
 * @author Christian Diaz
 * @author Camilo Medina
 */
public class CorredorEquipoB3 extends Thread{

    
    Random movimientos;
    int pasos = 0;

    /**
     * Dato que sincroniza la carrera
     */
    final Dato paso;

    /**
     * Mapa para pintar la carrera
     */ 
     Map<Integer,String> listaEquipoB=new HashMap<>();

     /**
      * Variable para terminar el hilo
      */
     boolean terminar = true;

     /**
      *Clase para terminar otro hilo en caso de ganar
      */
    CorredorEquipoA3 corredorA;
     
    /**
      *Clase para terminar otro hilo en caso de ganar
      */
    CorredorEquipoC3 corredorC;
    
    /**
     * Constructor de la clase
     * @param paso
     * @param lista 
     */
    public CorredorEquipoB3(Dato paso,Map<Integer,String> lista) {
        this.paso = paso;
        movimientos=new Random();
        this.listaEquipoB=lista;
    }


    /**
     * Metodo para iniciar el hilo
     */
    @Override
    public void run() {
        while(terminar==true){
            iniciar();
        }
        
    }
    
    /**
     * Metodo para simular la carrera
     */
    public void iniciar(){
        synchronized(paso){
            
                try {
                    if(!terminoCarrera()){
                      paso.wait();
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(CorredorEquipoA2.class.getName()).log(Level.SEVERE, null, ex);
                }
            
        }
       
        int posicion=paso.getPasos();
        pasos=paso.getPasos();
        while(pasos<100 || pasos==100){
            int numero=movimientos.devolverNumero();
                pasos+=numero;
               posicion+=numero;
            
            
           listaEquipoB.put(posicion,"\033[31m *");
           Imprimir.imprimir(listaEquipoB, posicion);
           listaEquipoB.put(posicion, " ");   
           synchronized(paso){
                if(terminoCarrera()){
                    paso.notify();
                    paso.setPasos(pasos);
                    corredorA.stop();
                    corredorC.stop();
                    imprimirMedalla();
                    matarHilo();
                    break;
                }
            }
        }
    }
    
   /**
     * Metodo que determina si ya acabo la carrera
     * @return 
     */
    public boolean terminoCarrera(){
        boolean valor=false;
       if(pasos==100 || pasos>100){
          valor=true; 
       }
      return valor;
    }
    
    /**
     * Metodo para acabar el hilo
     */
     public void matarHilo(){
        this.terminar=false;
    }

    /**
     * Funcion que devuelve el objeto hilo corredor del equipo A
     * @return
     */
    public CorredorEquipoA3 getCorredorA() {
        return corredorA;
    }

    /**
     * Funcion que cambia el objeto hilo corredor del equipo A
     * @param corredorA
     */
    public void setCorredorA(CorredorEquipoA3 corredorA) {
        this.corredorA = corredorA;
    }

    /**
     * Funcion que devuelve el objeto hilo corredor del equipo A
     * @return
     */
    public CorredorEquipoC3 getCorredorC() {
        return corredorC;
    }

    /**
     * Funcion que cambia el objeto hilo corredor del equipo A
     * @param corredorC
     */
    public void setCorredorC(CorredorEquipoC3 corredorC) {
        this.corredorC = corredorC;
    }
    
    /**
     * Funcion que imprime la medalla en caso de ganar
     */
    public void imprimirMedalla(){
       
        System.out.println("\033[32m EQUIPO 2 Rojo ");
        System.out.println("\033[35m    GANADOR      ");
     
    }

    public int getPasos() {
        return pasos;
    }

    public void setPasos(int pasos) {
        this.pasos = pasos;
    }
    
}
