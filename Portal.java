import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Portal here.
 * 
 * @author Abithan
 * @version (a version number or a date)
 */
public abstract class Portal extends WorldObject
{    
    public Portal(double row, double col, String imageString)
    {
        super(col * ScrollWorld.TILE_SIZE, (ScrollWorld.rows - row - 1) * ScrollWorld.TILE_SIZE);
        
        //Set the image for the type of portal image given
        GreenfootImage image = new GreenfootImage(imageString);
        image.scale(ScrollWorld.TILE_SIZE, ScrollWorld.TILE_SIZE * 2);
        setImage(image);
        
        hitbox = new Hitbox(this, ScrollWorld.TILE_SIZE, ScrollWorld.TILE_SIZE * 2, 0, 0, Hitbox.HitboxType.INTERACT);
    }
    
    protected abstract void onPortalContact(Player p);
    
    protected void calculateNewY(Player oldP, Player newP)
    {
        //Get the y position of the bottom of the player
        double bottomY = oldP.getExactY() + (oldP.getImage().getHeight()/2);
        
        //Calculate the y position of the new players center
        double newCenterY = bottomY - (newP.getImage().getHeight()/2);
        
        //Apply the same isGrounded condisions to the new player
        newP.isGrounded = oldP.isGrounded;
        newP.speedY = 0;
        
        ScrollWorld.getWorld().addObject(newP, oldP.getX(), (int)newCenterY); 
        ScrollWorld.getWorld().removeObject(oldP);
    }
}
