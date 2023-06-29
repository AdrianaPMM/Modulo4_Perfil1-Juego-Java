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
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/res/players/tiles/rBack0.png"));
 
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/res/players/tiles/nubes1.png"));
           
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/res/players/tiles/mountain1.png"));
            
            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/res/players/tiles/grass1.png"));
            
            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/res/players/tiles/dirth1.png"));
            
            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/res/players/tiles/tree.png"));

            
             tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/res/players/tiles/tre80.png"));

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
    
    
    public void DrawMap(Graphics2D g2,int col, int row, int x2, int y, int tileNum, int width, int height, int firstx)
    {
       int x = firstx;
         while(col < maxScreenRow)
        {
            g2.drawImage(tile[tileNum].image, x, y, width, height, null);
            col++;

            x += x2; //Posicion x del objetoen cada dibujo
            
            if(col == maxScreenCol)
            {
               col = 0;
                x = 0;
               
            }
        }
    }
    
    public void Draw(Graphics2D g2)
    {

        //Dibujar mountain en x, col
          //g2, col, row, x, y, tileNum, width, height, firstx
        DrawMap(g2, 0, 0, 1296, 220, 2, 560, 322, 30);
        
        //Dibujar nubes en x, col
         //g2, col, row, x, y, tileNum, width, height, firstx
        DrawMap(g2, 0, 0, 0, 0, 1, 1296, 360, 0);  
        
        //Dibujar tree delante de back0 en x, col
          //g2, col, row, x, y, tileNum, width, height, firstx
        DrawMap(g2, 10, 0, 20, 20, 5, 512, 512, 750);
        
         //Dibujar cesped en x, col
         //g2, col, row, x, y, tileNum, width, height, firstx
        DrawMap(g2, 0, 0, 230, 480, 3, 256, 80, -10);     
   
        //Dibujar tierra en x, col
          //g2, col, row, x, y, tileNum, width, height, firstx
        DrawMap(g2, 0, 0, 1226, 560, 4, 1296, 26, 0);  
        
        
        
        
        
        
        
         //Dibujar nubes en x, col
//        while(col < maxScreenRow)
//        {
//            int tileNum = mapTileNum[col][row];
//            
//            g2.drawImage(tile[tileNum].image, x, y, 48, 48, null);
//            col++;
//            
//            x += 48; //Posicion x de la nube en cada dibujo
//            
//            if(col == maxScreenCol)
//            {
//                col = 0;
//                x=0;
//                row++;
//                y += 48; //posicion y de la nube en cada dibujo
//            }
//        }
    }
}
