import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cube here.
 * 
 * @author Abithan Paskaranathan
 * Assisted by Kelton Kuan
 * @version (a version number or a date)
 */
public class Cube extends Player
{
    public static Cube cube;
    public static final int jumpHeight = 100;
    
    private boolean isGrounded = true;
    private double speedY = 0;
    private final int groundHeight = ScrollWorld.SCREEN_HEIGHT - ScrollWorld.GROUND_OFFSET + ScrollWorld.TILE_SIZE;

    
    public Cube()
    {
        cube = this;
        isGrounded = false;
    }
    
    public void act()
    {
        if (getY() > groundHeight)
        {
            isGrounded = true;
            setLocation(getX(), groundHeight - getImage().getHeight());
            speedY = 0;
        }
        
        if (Greenfoot.isKeyDown("space"))
        {
            jump();
        }
        
        setLocation(getX(), getY() - speedY);
        
        if (!isGrounded)
        {
            speedY-= 0.5;
        }
    }
    
    private void jump()
    {        
        speedY = 8;
        isGrounded = false;
    }
}
