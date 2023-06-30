package ventanas;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class enemigo1{
    
      public BufferedImage enemigoDRC, enemigoIZQ;
    
      Tutorial tt;
      int positionX;
     public int positionXOriginal = 1000;
     
    public enemigo1()
    {
        positionX = 1000;
        getPlayersImage();

    }
    
    public BufferedImage imageEnemy = null;   
    public void directionEnemigo()
    {
        positionX = 1000;
           iniciarThread1();
    }
    
    public void iniciarThread1()
{
   Thread jumpThread = new Thread(new Runnable() {
            @Override
            public void run() {
                imageEnemy = enemigoDRC;
           int targetX = 250; // Posición final del camino
                while (positionX > targetX) {
                    positionX += 8; // Incremento de 10 en cada iteración
                    imageEnemy = enemigoDRC;
                    //tt.repaint();
                    try {
                        Thread.sleep(10); // Pausa de 0.01 segundos
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //tt.repaint();
                imageEnemy = enemigoIZQ;
                while (positionX < positionXOriginal) {
                    positionX += 8; // Incremento de 10 en cada iteración
                    imageEnemy = enemigoIZQ;
                    //tt.repaint();
                    try {
                        Thread.sleep(10); // Pausa de 0.01 segundos
                    } catch (InterruptedException e) {
                            e.printStackTrace();
                    }
                }         
            
                
 }});
jumpThread.start();
}
    
    public void getPlayersImage()
    {
        try
        {
            enemigoDRC = ImageIO.read(getClass().getResourceAsStream("/res/players/enemigolvl1_DRC.png"));
            enemigoIZQ = ImageIO.read(getClass().getResourceAsStream("/res/players/enemigolvl1_IZQ.png"));
        }
        catch(IOException e){
        e.printStackTrace();}
    }
   
    
       public void Draw(Graphics2D g2)
    {
        directionEnemigo();
        g2.drawImage(imageEnemy, positionX, 200, 100, 100, null);
        
//        directionAragna();
//        g4.drawImage(imageArana, screenX2, playerAranaY, 200, 140, null);
    }
}
