package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;
import ventanas.Tutorial;

public class TileManager {
    Tutorial tt;
    Tile[] tile;
    
            
    public int maxScreenCol = 27; //48 px cada uno, lo que da un total de 1296 de ancho
    public int maxScreenRow = 13; //48 px cada uno, lo que da un total de 624 de alto
        
    
    int mapTileNum[][];
    
    public TileManager(Tutorial Tt)
    {
        this.tt = Tt;
        
        tile = new Tile[10];
        mapTileNum = new int[maxScreenCol][maxScreenRow];
        
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
            tile[2].colision = true;
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
//    public void loadMap()
//    {
//        try
//        {
//            InputStream is = getClass().getResourceAsStream("/res/maps/mapaData01.txt");
//            BufferedReader br = new BufferedReader(new InputStreamReader(is));
//            
//            int col = 0;
//            int row = 0;
//            
//            while(col < maxScreenCol && row < maxScreenRow)
//            {
//                String line = br.readLine();
//                
//                while(col < maxScreenCol)
//                {
//                    String numbers[] = line.split(" ");
//                    
//                    int num = Integer.parseInt(numbers[col]);
//                    
//                    mapTileNum[col][row] = num;
//                    col++;
//                }
//                if(col == maxScreenCol)
//                {
//                    col = 0;
//                    row++;
//                }
//            }
//            br.close();
//                    
//        } catch(Exception e){}
//    }
    
//    
//    public void DrawMap(Graphics2D g2,int col, int row, int x2, int y, int tileNum, int width, int height, int firstx)
//    {
//       int x = firstx;
//         while(col < maxScreenCol)
//        {
//            g2.drawImage(tile[tileNum].image, x, y, width, height, null);
//            col++;
//
//            x += x2; //Posicion x del objetoen cada dibujo
//            
//            if(col == 0)
//            {
//               col = 0;
//                x = 0;
//               
//            }
//        }
//    }
    
        
    public void DrawMap(Graphics2D g2,int worldCol, int row, int x2, int y, int tileNum, int width, int height, int diference)
    {
        int diference1 = diference;
        int worldCol1 = 0;
         while(worldCol1 < tt.maxWorldCol)
        {
            int worldX = worldCol1 * 48;
            int screenX = worldX - tt.player.worldX1 + tt.player.screenX;
            
            g2.drawImage(tile[tileNum].image, screenX + diference1, y, width, height, null);
            worldCol1++;
            diference1 += diference * -1; 

            if(worldCol1 == tt.maxWorldCol)
            {System.out.println(worldCol1);
               worldCol1 = 0;
               row++;
            }
        }
    }
    
    public void Draw(Graphics2D g2)
    {

//        //Dibujar mountain en x, col
//          //g2, col, row, x, y, tileNum, width, height, diference
//        DrawMap(g2, 2, 0, 1296, 220, 2, 560, 322, -1000);
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
            g2.drawImage(tile[2].image, 100 + screenX, 0, 100, 624, null);
            g2.drawImage(tile[tileNum].image, screenX + x, -40, 1296, 624, null);
            System.out.println(col);
            
            x += 1296; //Posicion x de la nube en cada dibujo
            col++;
        }
    }
}
