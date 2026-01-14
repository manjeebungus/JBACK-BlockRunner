import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hitbox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Hitbox extends SuperSmoothMover
{
    protected int sizeX;
    protected int sizeY;
    protected GreenfootImage image;
    
    public Hitbox(int sizeX, int sizeY)
    {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        
        setHitboxImage();
    }
    
    private void setHitboxImage()
    {
        image = new GreenfootImage(sizeX, sizeY);
        setImage(image);
    }
}
