/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventanas;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Paola Mejia
 */
public class KeyHandler implements KeyListener{

    public boolean upPressed, rightPressed, leftPressed, upPressedW, rightPressedD, leftPressedA;
    @Override
    public void keyTyped(KeyEvent e) {
    }
    

    @Override
    public void keyPressed(KeyEvent e) {
        
        int code = e.getKeyCode();
        //Controles de cabra----------------------
        if(code == KeyEvent.VK_UP)
        {
            //Tecla de flecha arriba
            upPressed = true;
        }
        
        if(code == KeyEvent.VK_RIGHT)
        {
            //Tecla de flecha derecha
            rightPressed = true;
        }
        
        if(code == KeyEvent.VK_LEFT)
        { 
            //Tecla de flecha izquierda
            leftPressed = true;
        }
        
        //Controles de arana---------------------
        if(code == KeyEvent.VK_W)
        {
            //Tecla de flecha arriba
            upPressedW = true;
        }
        
        if(code == KeyEvent.VK_D)
        {
            //Tecla de flecha derecha
            rightPressedD = true;
        }
        
        if(code == KeyEvent.VK_A)
        {
            //Tecla de flecha izquierda
            leftPressedA = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
        int code = e.getKeyCode();
        //Controles de cabra----------------------
        if(code == KeyEvent.VK_UP)
        {
            //Tecla de flecha arriba
            upPressed = false;
        }
        
        if(code == KeyEvent.VK_RIGHT)
        {
            //Tecla de flecha derecha
            rightPressed = false;
        }
        
        if(code == KeyEvent.VK_LEFT)
        {
            //Tecla de flecha izquierda
            leftPressed = false;
        }
        
        //Controles de arana---------------------
        if(code == KeyEvent.VK_W)
        {
            //Tecla de flecha arriba
            upPressedW = false;
        }
        
        if(code == KeyEvent.VK_D)
        {
            //Tecla de flecha derecha
            rightPressedD = false;
        }
        
        if(code == KeyEvent.VK_A)
        {
            //Tecla de flecha izquierda
            leftPressedA = false;
        }
    }
    
}
