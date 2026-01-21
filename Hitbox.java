import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.Color;

/**
 * Write a description of class Hitbox here. 
 * 
 * @author Brian Cheung
 * @version (a version number or a date)
 */
public class Hitbox
{
    private Actor owner; //Hitboxes need an owner, they should not remove objects
    private int sizeX, sizeY;
    private int offsetX, offsetY;
    
    //These are labels for what the hitbox is expected to work with
    //Enum explained in Player class
    public static enum HitboxType { 
        SOLID, HAZARD, INTERACT, PLAYER 
    }
    
    private HitboxType type;
    
    //This boolean is used for testing and balancing, off by default
    private static boolean hitboxVisible = false;
    
    //Hitbox constructor, requires size and offsets
    public Hitbox(Actor owner, int sizeX, int sizeY, int offsetX, int offsetY, HitboxType type)
    {
        this.owner = owner;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.type = type;
    }
    
    //Collision (with math)
    public boolean intersects(Hitbox other)
    {
        return getX() - sizeX / 2 < other.getX() + other.sizeX / 2 &&
               getX() + sizeX / 2 > other.getX() - other.sizeX / 2 &&
               getY() - sizeY / 2 < other.getY() + other.sizeY / 2 &&
               getY() + sizeY / 2 > other.getY() - other.sizeY / 2;
    }

    //This method is meant to be used when hitboxes are invisible by default 
    //Static method and variable so it applies to all hitboxes
    public static void setBoxVisible(boolean visible) { hitboxVisible = visible; }
    
    //Accessor/Getter methods
    public Actor getOwner() { return owner; }
    
    public int getX() { return owner.getX() + offsetX; }
    public int getY() { return owner.getY() + offsetY; }
    public int getWidth() { return sizeX; }
    public int getHeight() { return sizeY; }
    public static boolean isBoxVisible() { return hitboxVisible; }
    public HitboxType getType() { return type; }

    public int left()   { return getX() - sizeX / 2; } //X coordinate of left edge of hitbox
    public int right()  { return getX() + sizeX / 2; } //X coordinate of right edge
    public int top()    { return getY() - sizeY / 2; } //Y coordinate of top edge
    public int bottom() { return getY() + sizeY / 2; } //Y coordinate of bottom edge
    
}
