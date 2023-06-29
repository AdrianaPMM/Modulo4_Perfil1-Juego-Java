package entity;

import java.awt.image.BufferedImage;

public class Entity {
    public int worldX1, worldY, worldX2;
    public int speed;
    
    public BufferedImage 
            cabra1DRC, cabra1IZQ, 
            cabra2DRC, cabra2IZQ,  
            cabra3DRC, cabra3IZQ, 
            arana1DRC, arana1IZQ, 
            arana2DRC, arana2IZQ, 
            arana3DRC, arana3IZQ, 
            arana4DRC, arana4IZQ, 
            arana5DRC, arana5IZQ;
    
    public String directionCabra;
    public String directionArana;
    
    public int spriteCabraCount = 0;
    public int spriteCabraNum = 1;
    
    public int spriteAranaCount = 0;
    public int spriteAranaNum = 1;
}
