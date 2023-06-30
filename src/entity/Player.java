package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import ventanas.KeyHandler;
import ventanas.Tutorial;

public class Player extends Entity{
    
    Tutorial tt;
    KeyHandler keyH;
    
    public final int screenX;
    public final int screenX2;
    
    
    public Rectangle shipHitBox;
    public Player(Tutorial tt, KeyHandler keyH)
    {
        this.tt = tt;
        this.keyH = keyH;
        
        screenX = (1296/2) - 100;
        screenX2 = ((1296/2) - 100) - 100;
        
       
        
        
        setDefaultValues();
        getPlayersImage();
    }
    
    int playerCabraX;
    int playerAranaX;
    
    
    public int playerAranaY;
    
    int playerCabraYORIGINAL = 410;
    int playerAranaYORIGINL = 433;
    
    public void setDefaultValues()
    {
        worldX1 = 250;
        worldX2 = 100;
        
        playerCabraX = 250;
        playerAranaX = 100;
        
        playerCabraY = 410;
        playerAranaY = 433;
        
        speed = 5;

        
        directionCabra = "derecha";
        directionArana = "derecha";
    }
    
    public void getPlayersImage()
    {
        try
        {
            cabra1DRC = ImageIO.read(getClass().getResourceAsStream("/res/players/kabra1_DRC.png"));
            cabra1IZQ = ImageIO.read(getClass().getResourceAsStream("/res/players/kabra1_IZQ.png"));
            
            cabra2DRC = ImageIO.read(getClass().getResourceAsStream("/res/players/kabra cami 2_DRC.png"));
            cabra2IZQ = ImageIO.read(getClass().getResourceAsStream("/res/players/kabra cami 2_IZQ.png"));
            
            cabra3DRC = ImageIO.read(getClass().getResourceAsStream("/res/players/kabra cami 3_DRC.png"));
            cabra3IZQ = ImageIO.read(getClass().getResourceAsStream("/res/players/kabra cami 3_IZQ.png"));
            
            //Arana---------------------------------------------------------------------
            
            arana1DRC = ImageIO.read(getClass().getResourceAsStream("/res/players/araña_paso(1).png"));
            arana1IZQ = ImageIO.read(getClass().getResourceAsStream("/res/players/araña_paso(1)_IZQ.png"));
            
            arana2DRC = ImageIO.read(getClass().getResourceAsStream("/res/players/araña_paso(2).png"));
            arana2IZQ = ImageIO.read(getClass().getResourceAsStream("/res/players/araña_paso(2)_IZQ.png"));
            
            arana3DRC = ImageIO.read(getClass().getResourceAsStream("/res/players/araña_paso(3).png"));
            arana3IZQ = ImageIO.read(getClass().getResourceAsStream("/res/players/araña_paso(3)_IZQ.png"));
            
            arana4DRC = ImageIO.read(getClass().getResourceAsStream("/res/players/araña_paso(4).png"));
            arana4IZQ = ImageIO.read(getClass().getResourceAsStream("/res/players/araña_paso(4)_IZQ.png"));
            
            arana5DRC = ImageIO.read(getClass().getResourceAsStream("/res/players/araña_paso(5).png"));
            arana5IZQ = ImageIO.read(getClass().getResourceAsStream("/res/players/araña_paso(5)_IZQ.png"));
        }
        catch(IOException e){
        e.printStackTrace();}
    }
    
    private boolean isJumpingCabra = false;
    private boolean isJumpingArana = false;
    public int count = 0;
    public int count2 = 0;
    
    public void Update()
    {
        if(keyH.upPressed == true 
          || keyH.rightPressed == true
          || keyH.leftPressed == true)
        {    
            //Controles de CABRA
            if(keyH.upPressed == true)
            {
                if(count == 0){
                directionCabra = "salto";
                jump(1);} else{}
            }
            if (keyH.rightPressed)
            {
                directionCabra = "derecha";
                worldX1 += speed;
            }
            if (keyH.leftPressed)
            {
                directionCabra = "izquierda";
                worldX1 -= speed;
            }
            spriteCabraCount++;
            
            if(spriteCabraCount>7)
            {
                if(spriteCabraNum == 1){spriteCabraNum = 2;}
                else if(spriteCabraNum == 2) {spriteCabraNum = 3;}
                else if(spriteCabraNum == 3) {spriteCabraNum = 1;}

                spriteCabraCount = 0;
            } else{}
        } else {spriteCabraNum = 1;}
        
        
        
        
        
        if(keyH.upPressedW == true
           || keyH.rightPressedD == true
           || keyH.leftPressedA == true)
        {
            //Controles de ARANA
              if(keyH.upPressedW == true)
            {
                if(count2 == 0){
                directionArana = "salto";
                jump(2);} else{}
            }
            if (keyH.rightPressedD)
            {
                directionArana = "derecha";
                worldX2 += speed;
            }
            if (keyH.leftPressedA)
            {
                directionArana = "izquierda";
                worldX2 -= speed;
            }
            spriteAranaCount++;

             if(spriteAranaCount>4)
            {
                if(spriteAranaNum == 1){spriteAranaNum = 2;}
                else if(spriteAranaNum == 2) {spriteAranaNum = 3;}
                else if(spriteAranaNum == 3) {spriteAranaNum = 4;}
                else if(spriteAranaNum == 4) {spriteAranaNum = 5;}
                else if(spriteAranaNum == 5) {spriteAranaNum = 1;}

                spriteAranaCount = 0;
            }else{}
        } else {spriteAranaNum = 1;}
    }
       
   
    BufferedImage imageCabra = null;
    public void directionKabra()
    {    
        if(directionCabra.equals("derecha"))
        {
          if(spriteCabraNum == 1) {imageCabra = cabra1DRC;}
          if(spriteCabraNum == 2) {imageCabra = cabra2DRC;}
          if(spriteCabraNum == 3) {imageCabra = cabra3DRC;}      
        }
        if(directionCabra.equals("izquierda"))
        {
           if(spriteCabraNum == 1) {imageCabra = cabra1IZQ;}
           if(spriteCabraNum == 2) {imageCabra = cabra2IZQ;}
           if(spriteCabraNum == 3) {imageCabra = cabra3IZQ;} 
        }
    }
    
    BufferedImage imageArana = null;
    public void directionAragna()
    {        
        if(directionArana.equals("derecha"))
        {
            if(spriteAranaNum == 1) {imageArana = arana1DRC;}
            if(spriteAranaNum == 2) {imageArana = arana2DRC;}
            if(spriteAranaNum == 3) {imageArana = arana3DRC;}
            if(spriteAranaNum == 4) {imageArana = arana4DRC;}
            if(spriteAranaNum == 5) {imageArana = arana5DRC;}
        }
        if(directionArana.equals("izquierda"))
        {
            if(spriteAranaNum == 1) {imageArana = arana1IZQ;}
            if(spriteAranaNum == 2) {imageArana = arana2IZQ;}
            if(spriteAranaNum == 3) {imageArana = arana3IZQ;}
            if(spriteAranaNum == 4) {imageArana = arana4IZQ;}
            if(spriteAranaNum == 5) {imageArana = arana5IZQ;}
        }
    }
    
    public void Draw(Graphics2D g2, Graphics2D g4)
    {
        directionKabra();
        g2.drawImage(imageCabra, screenX, playerCabraY, 150, 130, null);
        
//        directionAragna();
//        g4.drawImage(imageArana, screenX2, playerAranaY, 200, 140, null);
    }
    
    
    
    public void jump(int who) {
    if (!isJumpingCabra || !isJumpingArana) {
        isJumpingCabra = true;
        isJumpingCabra = true;
        Thread jumpThread = new Thread(new Runnable() {
            @Override
            public void run() {
           if(who == 1)
            {
                count = 1;
                int targetY = 250; // Posición final del salto
                while (playerCabraY > targetY) {
                    playerCabraY -= 8; // Incremento de 10 en cada iteración
                    directionKabra();
                    tt.repaint();
                    try {
                        Thread.sleep(10); // Pausa de 0.01 segundos
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                tt.repaint();
                while (playerCabraY < playerCabraYORIGINAL) {
                    playerCabraY += 8; // Incremento de 10 en cada iteración
                    directionKabra();
                    tt.repaint();
                    try {
                        Thread.sleep(10); // Pausa de 0.01 segundos
                    } catch (InterruptedException e) {
                            e.printStackTrace();
                    }
                }          
                isJumpingCabra = false;
                count = 0;
            }
                else
                {
                     count2 = 1;
                int targetY = 250; // Posición final del salto
                while (playerAranaY > targetY) {
                    playerAranaY -= 8; // Incremento de 10 en cada iteración
                     directionAragna();
                    tt.repaint();
                    try {
                        Thread.sleep(10); // Pausa de 0.01 segundos
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                tt.repaint();
                while (playerAranaY < playerAranaYORIGINL) {
                    playerAranaY += 8; // Incremento de 10 en cada iteración
                     directionAragna();
                    tt.repaint();
                    try {
                        Thread.sleep(10); // Pausa de 0.01 segundos
                    } catch (InterruptedException e) {
                            e.printStackTrace();
                    }
                }          
                isJumpingArana = false;
                count2 = 0;
                }
            }
        });
        jumpThread.start();
    }
}
}
