import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A player mode which allows the player to fly in a ship
 * 
 * @author Abithan 
 * @version (a version number or a date)
 */
public class Ship extends Player
{
    private GreenfootImage image;
    
    public Ship()
    {
        super();
        shipImage();
        this.hitbox = new Hitbox(this, ScrollWorld.TILE_SIZE, ScrollWorld.TILE_SIZE, 0, 0, Hitbox.HitboxType.PLAYER);
    }
    
    public void act()
    {
        super.act();
        
        //Rotates the ship based on speed & since speed changes overtime, so does the rotation
        setRotation(speedY * -3.0);
    }

    private void shipImage()
    {
        image = new GreenfootImage("images/Player/shipPlayer.png");
        image.scale((int)(ScrollWorld.TILE_SIZE * 1.5), (int)(ScrollWorld.TILE_SIZE * 1.5));
        setImage(image);
    }
    
    protected void move()
    {
        if (Greenfoot.isKeyDown("space"))
        {
            speedY += 0.5;
        }
        else
        {
            speedY -= 0.35;
        }

        if (speedY > 6) speedY = 6;
        if (speedY < -6) speedY = -6;

        if (speedY > 0) isGrounded = false;
    }
}
