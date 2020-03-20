
package edu.unicundi.carrerahilos;

import java.util.HashMap;
import java.util.Map;


/**
 *Clase que inicia el hilo principal
 * @author Christian Diaz
 * @author Camilo Medina
 */
public class Principal extends Thread{

    
    Dato datoEquipo1=new Dato();
    Dato datoEquipo2=new Dato();
    Dato datoEquipo3=new Dato();

    /**
     * Mapa donde se guarda el recorrido del equipo A
     */
    Map<Integer,String> listaEquipoA=new HashMap<>();
    
    /**
     * Mapa donde se guarda el recorrido del equipo B
     */
    Map<Integer,String> listaEquipoB=new HashMap<>();
    
    /**
     * Mapa donde se guarda el recorrido del equipo C
     */
    Map<Integer,String> listaEquipoC=new HashMap<>();

    /**
     * Constructor de la clase
     * 30m = color Negro
     * 31m= Color Rojo
     * 32m= Verde
     */
    public Principal() {
        System.out.println("\u001B[30m Equipo 1 Negro");
         System.out.println("\u001B[31m Equipo 2 Rojo");
         System.out.println("\u001B[32m Equipo 3 Verde");
        llenarEquipo1();
        llenarEquipo2();
        llenarEquipo3();
    }

    @Override
    public void run() {
        inicioEquipos();
    }
    
    public void inicioEquipos(){
        CorredorEquipoA1 corredorUno1=new CorredorEquipoA1(datoEquipo1,listaEquipoA);
        CorredorEquipoA2 corredorDosA=new CorredorEquipoA2(datoEquipo1, listaEquipoA);
        CorredorEquipoA3 corredorTresA=new CorredorEquipoA3(datoEquipo1, listaEquipoA);
        
        CorredorEquipoB1 corredorUnoB=new CorredorEquipoB1(datoEquipo2,listaEquipoB);
        CorredorEquipoB2 corredorDosB=new CorredorEquipoB2(datoEquipo2, listaEquipoB);
        CorredorEquipoB3 corredorTresB=new CorredorEquipoB3(datoEquipo2, listaEquipoB);
        
        CorredorEquipoC1 corredorUnoC=new CorredorEquipoC1(datoEquipo3,listaEquipoC);
        CorredorEquipoC2 corredorDosC=new CorredorEquipoC2(datoEquipo3, listaEquipoC);
        CorredorEquipoC3 corredorTresC=new CorredorEquipoC3(datoEquipo3, listaEquipoC);

        corredorTresA.setCorredorB(corredorTresB);
        corredorTresA.setCorredorC(corredorTresC);
        
        corredorTresB.setCorredorA(corredorTresA);
        corredorTresB.setCorredorC(corredorTresC);
        
        corredorTresC.setCorredorA(corredorTresA);
        corredorTresC.setCorredorB(corredorTresB);
        
        corredorUno1.start();
        corredorDosA.start();
        corredorTresA.start();

        corredorUnoB.start();
        corredorDosB.start();
        corredorTresB.start();
        
        corredorUnoC.start();
        corredorDosC.start();
        corredorTresC.start();   
    }
    
    /**
     * Funcion que llena los espacios del mapa con relevos del equipo A
     */
    public void llenarEquipo1(){
        for (int i=0;i<100;i++) {
            listaEquipoA.put(i, " ");
        }
         listaEquipoA.put(33, "\033[30m A2");
         listaEquipoA.put(66,"\033[30m A3");
    }
    
    /**
     * Funcion que llena los espacios del mapa con relevos del equipo B
     */
    public void llenarEquipo2(){
        for (int i=0;i<100;i++) {
           listaEquipoB.put(i, " ");
        }
        listaEquipoB.put(33, "\033[31m *");
        listaEquipoB.put(66,"\033[31m *");
    }
    
    /**
     * Funcion que llena los espacios del mapa con relevos del equipo C
     */
    public void llenarEquipo3(){
        for (int i=0;i<100;i++) {
            listaEquipoC.put(i, " ");
        }
         listaEquipoC.put(33, "\033[32m C2");
         listaEquipoC.put(66,"\033[32m C3");
    }
   
}
