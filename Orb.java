import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * An orb class which affects the player diffently if they jump while touching it
 * 
 * @author Abithan
 * @version (a version number or a date)
 */
public abstract class Orb extends WorldObject
{
    /**
     * @param row the tile the portal is on vertically
     * @param col the tile the portal is on horizontally
     * @param imageString the file location of the orbs image
     **/
    public Orb(double row, double col, String imageString)
    {
        super(col * ScrollWorld.TILE_SIZE, (ScrollWorld.rows - row - 1) * ScrollWorld.TILE_SIZE);
        
        //Set the image for the type of portal image given
        GreenfootImage image = new GreenfootImage(imageString);
        image.scale(ScrollWorld.TILE_SIZE, ScrollWorld.TILE_SIZE);
        setImage(image);
        
        hitbox = new Hitbox(this, ScrollWorld.TILE_SIZE + 3, ScrollWorld.TILE_SIZE + 3, 0, 0, Hitbox.HitboxType.INTERACT);
    }
    
    public Hitbox getHitbox() { return hitbox; }
    
    /**
     * @param p the player which is being lauched by the orb
     */
    protected abstract void jumpOnClick(Player p);
}
