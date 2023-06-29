/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventanas;

/**
 *
 * @author abc
 */

public class Hilos extends Thread{
    
    Nivel2_Helado nivelHelado;
    public Hilos(Nivel2_Helado nivelHelado){
        
        this.nivelHelado=nivelHelado;
    }
    
    public void run(){
        try{
            while (true) {
                nivelHelado.moverFondo();
                nivelHelado.moverPersonaje();
                sleep(200);
            }
        }
        catch(Exception e){
            System.out.println("Error en la ejecucion del proceso: " + e);
        }
    }
}
