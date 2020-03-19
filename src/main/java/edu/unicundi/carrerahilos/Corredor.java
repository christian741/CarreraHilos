/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.carrerahilos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS-PC
 */
public class Corredor extends Thread {

    private String nombre;
    private int posicion;
    private ObjetoComun obj;

    public Corredor(String nombre, int posicion, ObjetoComun obj) {
        this.nombre = nombre;
        this.posicion = posicion;
        this.obj = obj;
    }

    @Override
    public void run() {

        if (posicion == 1) {
            System.out.println("Inicio " + nombre);
            for (int i = 0; i < 33; i++) {
                try {
                    Thread.sleep(100);
                    System.out.println("*");
                    System.out.println(nombre + " Voy en el paso: " + i);
                } catch (InterruptedException ex) {
                    //Logger.getLogger(edu.unicundi.carrerahilos.notificacion.Corredor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            synchronized(obj){
                obj.notifyAll();
            }
            
            System.out.println("Corredor " + nombre + " Acabo");
        } else {
            synchronized(obj) {
                System.out.println("Corredor " + nombre + " en espera");
                try {
                    obj.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
                }                
            }
            System.out.println("Corredor " + nombre + " empiezo a correr");
        }

    }

}
