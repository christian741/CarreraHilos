
package edu.unicundi.carrerahilos;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Clase que representa el corredor dos del equipo C
 * @author Christian Diaz
 * @author Camilo Medina
 */
public class CorredorEquipoC2 extends Thread{

     
    Random movimientos;
    int pasos=0;
    
    /**
     * Dato que sincroniza la carrera
     */
    final Dato paso;
   
    /**
     * Mapa para pintar la carrera
     */
     Map<Integer,String> listaEquipoC=new HashMap<>();
    

     /**
      * Constructor de la clase
      * @param paso
      * @param lista 
      */
    public CorredorEquipoC2(Dato paso,Map<Integer,String> lista) {
         this.paso = paso;
        movimientos=new Random();
        this.listaEquipoC=lista;
    }
    
    
    
    /**
     * Metodo para iniciar el hilo
     */
    @Override
    public void run() {
        iniciar();
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
        while(pasos<66 || pasos==66){
            int numero=movimientos.devolverNumero();
               pasos+=numero;
               posicion+=numero;
            
            listaEquipoC.put(posicion,"\033[32m C2");
            Imprimir.imprimir(listaEquipoC, posicion);
            listaEquipoC.put(posicion," ");
            synchronized(paso){
                if(terminoCarrera()){
                    paso.notify();
                    paso.setPasos(pasos);
                    break;
                }
            }
            
        }
        listaEquipoC.put(62, " ");
        listaEquipoC.put(63, " ");
        listaEquipoC.put(64, " ");
        listaEquipoC.put(65, " ");
        listaEquipoC.put(66, " ");
        listaEquipoC.put(67, " ");
        listaEquipoC.put(68, " ");    
    }
    
    /**
     * Metodo que evalua si ya se termino la carrea para el corredor
     * @return 
     */
    public boolean terminoCarrera(){
        boolean valor=false;
       if(pasos==66 || pasos>66){
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
