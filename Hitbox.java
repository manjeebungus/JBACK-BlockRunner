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
    
    //These static variables are public so every class can refer to the same labels
    public static final int SOLID   = 0;
    public static final int HAZARD  = 1;
    public static final int TRIGGER = 2;
    public static final int PLAYER  = 3;
    
    private int type;
    
    private static boolean hitboxVisible = true;
    private Color boxColor = Color.RED; //default color
    
    //Hitbox constructor, requires size and offsets
    public Hitbox(Actor owner, int sizeX, int sizeY, int offsetX, int offsetY, int type)
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
    
    /**
     * The following methods are used for debug and testing purposes
     * Colors can be switched between red and blue (Red is for interactions, blue is for blocks)
     */
    
    /**
     *Visuals:
     *RED for cube and obstacles, 
     *BLUE for inner hitbox and blocks, 
     *GREEN for interactions (Portals, Orbs, etc)
     */
    public void setBoxRed()   { boxColor = Color.RED; }   
    public void setBoxBlue()  { boxColor = Color.BLUE; }
    public void setBoxGreen() { boxColor = Color.GREEN; }
    
    public void draw(GreenfootImage canvas)
    {
        if (!hitboxVisible || canvas == null) return;
    
        canvas.setColor(boxColor);
    
        int drawX = owner.getX() + offsetX - sizeX / 2;
        int drawY = owner.getY() + offsetY - sizeY / 2;
    
        canvas.drawRect(drawX, drawY, sizeX, sizeY);
    }
    
    //This method is meant to be used when hitboxes are invisible by default (not as of now)
    //Static method and variable so it applies to all hitboxes
    public static void setBoxVisible(boolean visible) { hitboxVisible = visible; }
    
    //Accessor/Getter methods
    public int getX() { return owner.getX() + offsetX; }
    public int getY() { return owner.getY() + offsetY; }
    public int getWidth() { return sizeX; }
    public int getHeight() { return sizeY; }
    public static boolean isBoxVisible() { return hitboxVisible; }

    public int left()   { return getX() - sizeX / 2; } //X coordinate of left edge of hitbox
    public int right()  { return getX() + sizeX / 2; } //X coordinate of right edge
    public int top()    { return getY() - sizeY / 2; } //Y coordinate of top edge
    public int bottom() { return getY() + sizeY / 2; } //Y coordinate of bottom edge
    
}
