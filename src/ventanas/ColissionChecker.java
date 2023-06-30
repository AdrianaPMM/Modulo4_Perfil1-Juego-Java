package ventanas;

import entity.Entity;

public class ColissionChecker {
    Tutorial tt;

    public ColissionChecker(Tutorial tt)
    {
        this.tt = tt;
    }
    
    public void checkTile(Entity entity)
    {
        int entityLeftWorldX = entity.worldX1 + entity.solidArea.x;
        int entityRightWorldX = entity.worldX1 + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.playerCabraY + entity.solidArea.y;
        int entityBottomWorldY = entity.playerCabraY + entity.solidArea.y + entity.solidArea.height;
        
        int entityLeftCol = entityLeftWorldX/48;
        int entityRightCol = entityRightWorldX/48;
        int entityTopRow = entityTopWorldY/48;
        int entityBottomRow = entityBottomWorldY/48;
        
        int tileNum1, tileNum2;
        switch(entity.directionCabra)
        {
            case "salto":
                entityTopRow = (entityTopWorldY - entity.speed) / 48;
                
                break;
            case "derecha":
                break;
            case "izquierda":
                break;
        }
    }
}
