package tile;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;
import ventanas.Tutorial;
import ventanas.enemigo1;

public class TileManager {
    Tutorial tt;
    Tile[] tile;
    public int countVidas;
            
    public int maxScreenCol = 27; //48 px cada uno, lo que da un total de 1296 de ancho
    public int maxScreenRow = 13; //48 px cada uno, lo que da un total de 624 de alto
        
    int mapTileNum[][];

    Rectangle enemigoHitBox;
    Rectangle shipHitBox;
    Rectangle borderHitBox;
    
    public TileManager(Tutorial Tt)
    {
        this.tt = Tt;
        
        tile = new Tile[10];
        mapTileNum = new int[maxScreenCol][maxScreenRow];
        countVidas = 3;
        getTileImage();
        //loadMap();
    }
    
    
    
    public void getTileImage()
    {
        try
        {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/res/players/tiles/tutorialtileComplete.png"));
 
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/res/players/tiles/tutorialtileComplete2.png"));
              
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/res/players/tiles/rcolission1.png"));

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/res/players/enemigolvl1_DRC.png"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    ventanas.enemigo1 enemigo = new ventanas.enemigo1();
    public void DrawMap(Graphics2D g2)
    {
         int worldX2 = 0 * 48;
     int screenX2 = worldX2 - tt.player.worldX1 + tt.player.screenX;
    int positionX = screenX2;
        
            int col = 0;
            int worldCol1 = 0;
            int x = 0;
            int maxWorldCol = 50;

            g2.drawImage(tile[1].image, 0, -40, 550, 624, null);


               while(col < maxWorldCol)
               {
                 int tileNum = 0;

                  int worldX = worldCol1 * 48;
                  int screenX = worldX - tt.player.worldX1 + tt.player.screenX;
                 
                   g2.drawImage(tile[tileNum].image, screenX + x, -40, 1296, 624, null);

                   x += 1296; //Posicion x de la nube en cada dibujo
                   col++;

               }
               g2.drawImage(tile[2].image, 100 + screenX2, 0, 100, 624, null);
               borderHitBox = new Rectangle(100 + screenX2, 0, 100, 624);
                shipHitBox = new Rectangle(tt.player.screenX, tt.player.playerCabraY, 150, 130);
               boolean collisiona = checkCollision2();
                if (collisiona) {
                     tt.player.speed = 0;
                     tt.player.worldX1 += 50;
                }
                else
                {
                    tt.player.speed = 5;
                }
               
            g2.drawImage(tile[3].image, 1000 + positionX, 450, 90, 90, null);
            enemigoHitBox = new Rectangle(1000 + positionX, 450, 90, 90);
                            
             boolean collision = checkCollision();
                if (collision) {
                     tt.player.speed = 0;
                     countVidas -= 1;
                }
                else
                {
                    tt.player.speed = 5;
                }
                
            if(countVidas == 0)
            {
                
            }
    }
    
    public boolean checkCollision() {
    return enemigoHitBox.intersects(shipHitBox);
}
    
    public boolean checkCollision2() {
    return borderHitBox.intersects(shipHitBox);
}
    
    public void Draw(Graphics2D g2)
    {

//        //Dibujar mountain en x, col
//          //g2, col, row, x, y, tileNum, width, height, diference
        DrawMap(g2);
//        
//        //Dibujar nubes en x, col
//         //g2, col, row, x, y, tileNum, width, height, diference
//        DrawMap(g2, 0, 0, 1296, 0, 1, 1296, 270, -1296);  
//        
//        //Dibujar tree delante de back0 en x, col
//          //g2, col, row, x, y, tileNum, width, height, diference
//        DrawMap(g2, 0, 0, 200, 20, 5, 512, 512, -1000);
//        
//         //Dibujar cesped en x, col
//         //g2, col, row, x, y, tileNum, width, height, diference
//        DrawMap(g2, 0, 0, 230, 480, 3, 256, 80, -40);     
//   
//        //Dibujar tierra en x, col
//          //g2, col, row, x, y, tileNum, width, height, diference
//        DrawMap(g2, 0, 0, 1296, 560, 4, 1296, 26, -120);      
    }
}
