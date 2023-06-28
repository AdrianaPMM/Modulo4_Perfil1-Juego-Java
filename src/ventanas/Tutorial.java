/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ventanas;

import entity.Player;
import fonts.Fuentes;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.Timer;

/**
 *
 * @author Paola Mejia
 */
public class Tutorial extends javax.swing.JPanel implements Runnable {

    //FPS
    int FPS = 60;
    
    KeyHandler KeyH = new KeyHandler();
    
    Fuentes tipoFuentes;
    Thread gameThread;
    
   Player player = new Player(this, KeyH);
     
    //final int originalTileSize = 50;
    //final int scale = 2;
        
    public final int tileSize1 = 200;
    public final int tileSizeW1 = 160;
    
    public final int tileSize2 = 200;
    public final int tileSizeW2 = 130;
     
    //Posision por defecto de los jugadores
    public int playerCabraY = 470;     
    public int playerAranaY = 500;
    
    private KeyHandler keyH;
        
    public Tutorial() { 
        initComponents();
     
        this.addKeyListener(KeyH);
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.requestFocus();
    }   

    public void startGameThread()
    {
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(51, 51, 51));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    @Override   
    public void run()
    {
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        
        while(gameThread != null)
        {
            currentTime = System.nanoTime();
            
            delta += (currentTime - lastTime) / drawInterval;
            
            lastTime = currentTime;
            
            if(delta >= 1)
            {
                Update();
                repaint();
                delta--;
            }
        }
    }

    public void Update()
    {
        player.Update();
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
             
        //Cabra
        Graphics2D g2 = (Graphics2D)g;
        //Arana
        Graphics2D g4 = (Graphics2D)g;
        
        player.Draw(g2, g4);

        g2.dispose();
        g4.dispose();
    }

        
//   public void run() {
//        
//        while(gameThread != null)
//        {
//            double drawInterval = 1000000000/FPS; //0.01666
//            double nextDrawTime = System.nanoTime() + drawInterval;
//            
//            //Se usara para actualizar la posicion de los personajes en el juego
//            Update();
//            //Y para "dibujar" en la pantalla la informacion actualizada
//            repaint();
//            
//            try {
//                
//                double remainingTime = nextDrawTime - System.nanoTime();
//                remainingTime = remainingTime/1000000;
//                
//                if(remainingTime < 0)
//                {
//                    remainingTime = 0;
//                }
//                
//                Thread.sleep((long)remainingTime);
//                
//                nextDrawTime += drawInterval;
//                
//            } catch (InterruptedException ex) {
//                Logger.getLogger(Tutorial.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
  
}
