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
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/res/players/tiles/rceleste.png"));
 
            
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/res/players/tiles/nubes1.png"));
           
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/res/players/tiles/mountain1.png"));
            
            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/res/players/tiles/grass1.png"));
            
            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/res/players/tiles/dirth1.png"));

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
    
    
    public void Draw(Graphics2D g2)
    {
        int col1 = 0;    
        int row1 = 0;
        int x1 = 0;    
        int y = 0;
                    
        //Dibujar nubes en x, col
        while(col1 < maxScreenRow)
        {
            y = 0; //posicion y de la nube en cada dibujo
            g2.drawImage(tile[1].image, x1, y, 1296, 360, null);
            col1++;
            
            x1 += 1296; //Posicion x de la nube en cada dibujo
            
            if(col1 == maxScreenCol)
            {
                col1 = 0;
                x1=0;
                row1++;
            }
        }
        
         //Dibujar cesped en x, col
        int col2 = 0;    
        int row2 = 0;
        int x2 = -10;    

        while(col2 < maxScreenRow)
        {
            y = 480; //posicion y del objeto en cada dibujo
            g2.drawImage(tile[3].image, x2, y, 256, 80, null);
            col2++;
            
            x2 += 230; //Posicion x del objeto en cada dibujo
            
            if(col2 == maxScreenCol)
            {
                col2 = 0;
                x2=0;
                row2++;
            }
        }
        
        //Dibujar tierra en x, col
        int col3 = 0;    
        int row3 = 0;
        int x3 = 0;   
        
        while(col3 < maxScreenRow)
        {
            y = 560; //posicion y del objeto en cada dibujo
            g2.drawImage(tile[4].image, x3, y, 1296, 26, null);
            col3++;
            
            x3 += 1296; //Posicion x del objeto en cada dibujo
            
            if(col3 == maxScreenCol)
            {
                col3 = 0;
                x3=0;
                row3++;
            }
        }
        
        
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
