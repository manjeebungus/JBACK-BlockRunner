import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pad here.
 * 
 * @author Abithan and Brian
 * @version (a version number or a date)
 */
public class Pad extends WorldObject
{
    /**
     * @param row the tile the portal is on vertically
     * @param col the tile the portal is on horizontally
     **/
    public Pad(double row, double col)
    {
        super(col * ScrollWorld.TILE_SIZE, (ScrollWorld.rows - row - 1) * ScrollWorld.TILE_SIZE);
        
        //Set the image for the type of portal image given
        GreenfootImage image = new GreenfootImage("images/Player/pad.png");
        image.scale(ScrollWorld.TILE_SIZE, ScrollWorld.TILE_SIZE);
        setImage(image);
        
        hitbox = new Hitbox(this, ScrollWorld.TILE_SIZE, 10, 0, 18, Hitbox.HitboxType.INTERACT);
    }
    
    public Hitbox getHitbox() { return hitbox; }
    
    public void addedToWorld(World world)
    {
        world.addObject(new HitboxRenderer(hitbox), getX(), getY());
    }
}
