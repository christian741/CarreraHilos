
package edu.unicundi.carrerahilos;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Clase corredor dos del equipo B
   @author Christian Diaz
 * @author Camilo Medina
 */
public class CorredorEquipoB2 extends Thread{

    
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
      * Constructor de la clase
      * @param paso
      * @param lista 
      */
    public CorredorEquipoB2(Dato paso,Map<Integer,String> lista) {
        this.paso = paso;
        movimientos=new Random();
        this.listaEquipoB=lista;
    }
 
    /**
     * metodo que inicia el hilo
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
            
            listaEquipoB.put(posicion,"\033[31m *");
            Imprimir.imprimir(listaEquipoB, posicion);
            listaEquipoB.put(posicion," ");
            synchronized(paso){
                if(terminoCarrera()){
                    paso.notify();
                    paso.setPasos(pasos);
                    break;
                }
            }
            
        }
        listaEquipoB.put(62, " ");
        listaEquipoB.put(63, " ");
        listaEquipoB.put(64, " ");
        listaEquipoB.put(65, " ");
        listaEquipoB.put(66, " ");
        listaEquipoB.put(67, " ");
        listaEquipoB.put(68, " ");
        
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
