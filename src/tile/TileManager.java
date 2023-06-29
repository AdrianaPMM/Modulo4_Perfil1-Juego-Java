package tile;

import java.awt.Graphics2D;
import java.io.IOException;
import javax.imageio.ImageIO;
import ventanas.Tutorial;

public class TileManager {
    Tutorial tt;
    Tile[] tile;
    
    public TileManager(Tutorial Tt)
    {
        this.tt = Tt;
        
        tile = new Tile[10];
        
        getTileImage();
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
    
    public void Draw(Graphics2D g2)
    {
        
        int maxScreenCol = 27; //48 px cada uno, lo que da un total de 1296 de ancho
        int maxScreenrow = 13; //48 px cada uno, lo que da un total de 624 de alto
        
        int col = 0;    
        int row = 0;
        int x = 0;    
        int y = 0;
        
        //Dibujar nubes en x, col
        while(col < maxScreenrow)
        {
            g2.drawImage(tile[1].image, x, y, 1296, 360, null);
            col++;
            
            x += 1296; //Posicion x de la nube en cada dibujo
            
            if(col == maxScreenCol)
            {
                col = 0;
                x=0;
                row++;
                y = 0; //posicion y de la nube en cada dibujo
            }
        }
    }
}
