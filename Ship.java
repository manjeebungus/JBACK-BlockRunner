import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ship here.
 * 
 * @author Abithan 
 * @version (a version number or a date)
 */
public class Ship extends Player
{
    public Ship() {
        
    }
    
    protected void move() {
        if (Greenfoot.isKeyDown("space"))
        {
            speedY += 0.5;
        }
        else
        {
            speedY += -0.4;
        }

        if (speedY > 6) speedY = 6;
        if (speedY < -6) speedY = -6;

        if (speedY > 0) isGrounded = false;
    }
}
