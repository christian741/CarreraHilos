
package edu.unicundi.carrerahilos;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase corredor del equipo B
 * @author Christian Diaz
 * @author Camilo Medina
 */
public class CorredorEquipoB1 extends Thread{
   
    
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
    public CorredorEquipoB1(Dato paso,Map<Integer,String> lista) {
        this.paso = paso;
        this.listaEquipoB=lista;
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
     * Metodo que simula la carrera
     */
    public void  iniciar(){
        int posicion=0;
        while(pasos<32 || pasos==32){
            int numero=movimientos.devolverNumero();
            pasos+=numero;
            posicion+=numero;
            listaEquipoB.put(posicion,"\033[31m *");
            Imprimir.imprimir(listaEquipoB,posicion);
            listaEquipoB.put(posicion, " ");
            synchronized(paso){
                if(terminoCarrera()==true){
                    paso.notify();
                    paso.setPasos(pasos);
                    break;
                }
            }
        }
        listaEquipoB.put(32, " ");
        listaEquipoB.put(33, " ");
        listaEquipoB.put(34, " ");
        listaEquipoB.put(35, " ");
        listaEquipoB.put(36, " ");
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
