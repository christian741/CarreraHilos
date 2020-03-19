/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.carrerahilos;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS-PC
 */
public class HiloRandomico extends Thread{
    
    String nombre;
    
    public HiloRandomico(String nombre) {
        this.nombre = nombre;
    }
    
    
    @Override
    public void run() {
        Random rand = new Random();
        while(true) {
            try {
                Thread.sleep(500);
                /*int random = rand.nextInt(10);
                System.out.println(this.nombre + " " + random );
                if(random == 7) {
                    System.out.println("---------- Gané " + this.nombre);
                    break;
                }*/
            } catch (InterruptedException ex) {
                break;
                //Logger.getLogger(HiloMatematico.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }
    
}
