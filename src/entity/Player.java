package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import ventanas.KeyHandler;
import ventanas.Tutorial;

public class Player extends Entity{
    
    Tutorial tt;
    KeyHandler keyH;
    
    public Player(Tutorial tt, KeyHandler keyH)
    {
        this.tt = tt;
        this.keyH = keyH;
        
        setDefaultValues();
        getPlayersImage();
    }
    
    int playerCabraX;
    int playerAranaX;
    
    int playerCabraY;
    int playerAranaY;
    
    public void setDefaultValues()
    {
        playerCabraX = 100;
        playerAranaX = 250;
        
        playerCabraY = 470;
        playerAranaY = 500;
        
        speed = 6;
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
            playerCabraX += speed;
        }
        if (keyH.leftPressed)
        {
            directionCabra = "izquierda";
            playerCabraX -= speed;
        }
        
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
            playerAranaX += speed;
        }
        if (keyH.leftPressedA)
        {
            directionArana = "izquierda";
            playerAranaX -= speed;
        }
    }
       
   
    BufferedImage imageCabra = null;
    public void directionKabra()
    {
        if(keyH.upPressed && directionCabra.equals("derecha")){imageCabra = cabra1DRC;}
        if(keyH.upPressed && directionCabra.equals("izquierda")){imageCabra = cabra1IZQ;}
        if(keyH.upPressed && keyH.rightPressed){imageCabra = cabra1DRC;}
        if(keyH.upPressed && keyH.leftPressed) {imageCabra = cabra1IZQ;}
        if(directionCabra.equals("derecha")){imageCabra = cabra1DRC;}
        if(directionCabra.equals("izquierda")){imageCabra = cabra1IZQ;}
    }
    
    BufferedImage imageArana = null;
    public void directionAragna()
    {
        if(keyH.upPressedW && directionArana.equals("derecha")){imageArana = arana1DRC;}
        if(keyH.upPressedW && directionArana.equals("izquierda")){imageArana = arana1IZQ;}
        if(keyH.upPressedW && keyH.rightPressedD){imageArana = arana1DRC;}
        if(keyH.upPressedW && keyH.leftPressedA) {imageArana = arana1IZQ;}
        if(directionArana.equals("derecha")){imageArana = arana1DRC;}
        if(directionArana.equals("izquierda")){imageArana = arana1IZQ;}
       
    }
    
    public void Draw(Graphics2D g2, Graphics2D g4)
    {
        directionKabra();
        g2.drawImage(imageCabra, playerCabraX, playerCabraY, tt.tileSizeW1, tt.tileSize1, null);
        
        directionAragna();
        g4.drawImage(imageArana, playerAranaX, playerAranaY, tt.tileSizeW2, tt.tileSize2, null);
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
                int targetY = 340; // Posición final del salto
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
                while (playerCabraY < 470) {
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
                int targetY = 340; // Posición final del salto
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
                while (playerAranaY < 500) {
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
