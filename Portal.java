import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A portal class which changes the mode of the player(Ex. Ship, Cube)
 * 
 * @author Abithan
 * @version (a version number or a date)
 */
public abstract class Portal extends WorldObject
{    
    /**
     * @param row the tile the portal is on vertically
     * @param col the tile the portal is on horizontally
     * @param imageString the file location of the portals image
     **/
    public Portal(double row, double col, String imageString)
    {
        super(col * ScrollWorld.TILE_SIZE, (ScrollWorld.rows - row - 1) * ScrollWorld.TILE_SIZE);
        
        //Set the image for the type of portal image given
        GreenfootImage image = new GreenfootImage(imageString);
        image.scale(ScrollWorld.TILE_SIZE, ScrollWorld.TILE_SIZE * 2);
        setImage(image);
        
        hitbox = new Hitbox(this, ScrollWorld.TILE_SIZE, ScrollWorld.TILE_SIZE * 2, 0, 0, Hitbox.HitboxType.INTERACT);
    }
    
    /**
     * An abstract method which has a interaction based on portal type
     * @param p the player whose mode will change
     */
    protected abstract void onPortalContact(Player p);

    /**
     * Calculates the Y position of the new player and adds it to the world
     * @param oldP the old player object
     * @param newP the new player to be added
     **/
    protected void calculateNewY(Player oldP, Player newP)
    {
        //Get the y position of the bottom of the player
        double bottomY = oldP.getExactY() + (oldP.getImage().getHeight()/2);
        
        //Calculate the y position of the new players center
        double newCenterY = bottomY - (newP.getImage().getHeight()/2);
        
        //Apply the same isGrounded conditions to the new player
        newP.isGrounded = oldP.isGrounded;
        newP.speedY = 0;
        
        //Add the new player to the world and remove the old one
        ScrollWorld.getWorld().addObject(newP, oldP.getX(), (int)newCenterY); 
        ScrollWorld.getWorld().removeObject(oldP);
    }
}
