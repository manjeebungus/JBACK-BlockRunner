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
    private boolean spacePressed = false;
    private double speedY = 0;
    private final int groundHeight = ScrollWorld.SCREEN_HEIGHT - ScrollWorld.GROUND_OFFSET + ScrollWorld.TILE_SIZE;

    
    public Cube()
    {
        cube = this;
        isGrounded = false;
    }
    
    public void act()
    {
        if (getY() - speedY > groundHeight)
        {
            isGrounded = true;
            spacePressed = false;
            setLocation(getX(), groundHeight - getImage().getHeight());
            speedY = 0;
        }
        
        if (Greenfoot.isKeyDown("space") && !spacePressed)
        {
            spacePressed = true;
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
        speedY = 10;
        isGrounded = false;
    }
}
