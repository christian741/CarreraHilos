/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.carrerahilos;

/**
 *
 * @author ASUS-PC
 */
public class Carrera {

    public Carrera() {
    
    }
    
    public void empezar() {
        ObjetoComun obj = new ObjetoComun();
        Corredor c1 = new Corredor("Corredor", 1, obj);
        Corredor c2 = new Corredor("Corredor2", 2, obj);
        Corredor c3 = new Corredor("Corredor3", 2, obj);
        
        c1.start();
        c2.start();
        c3.start();
    }
    
    
    
}

