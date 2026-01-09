import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cube here.
 * 
 * @author Abithan Paskaranathan
 * @version (a version number or a date)
 */
public class Cube extends Player
{
    public static final int jumpHeight = 0;
    
    public void act()
    {
        move(2);
        
        if (Greenfoot.isKeyDown("space"))
        {
            jump();
        }
    }
    
    private void jump()
    {
        
    }
}
