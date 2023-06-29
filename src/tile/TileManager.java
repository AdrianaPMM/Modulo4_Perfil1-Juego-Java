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
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/res/players/tiles/nubes1.png"));
           
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/res/players/tiles/mountain1.png"));
            
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/res/players/tiles/grass1.png"));
            
            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/res/players/tiles/dirth1.png"));

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public void Draw(Graphics2D g2)
    {
        g2.drawImage(tile[0].image, 0,0, 1300, 375, null);
    }
}
