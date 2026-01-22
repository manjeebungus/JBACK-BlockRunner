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
        this.hitbox = new Hitbox(this, ScrollWorld.TILE_SIZE, ScrollWorld.TILE_SIZE, 0, 8, Hitbox.HitboxType.PLAYER);
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
            speedY += 0.45;
        }
        else
        {
            speedY -= 0.45;
        }
        
        //Makes sure the speed doesn't get too high or too low
        if (speedY > 6) speedY = 6;
        if (speedY < -6) speedY = -6;

        if (speedY > 0) isGrounded = false;
    }
    
    @Override
    protected boolean bottomHit(double txBottom, double minOverlap, double overlapBottom) {
        // ----- BOTTOM (ceiling / head hit) -----
        if (minOverlap == overlapBottom && speedY > 0)
        {
            if (overlapBottom > TOLERANCE)
            {
                setToGround(txBottom + ScrollWorld.TILE_SIZE / 2);
                return true;
            }
            else
            {
                // Small overlap → push player down instead of killing
                //setLocation(getExactX(), prevY);
                //speedY = 0;
            }
            
        }
        return false;
    }
}
