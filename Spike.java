import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Spike here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spike extends WorldObject
{
    private static final Color borderColor = new Color(0, 0, 0, 255);
    
    public Spike(double row, double col) {
        super(col * ScrollWorld.TILE_SIZE, (ScrollWorld.rows-row-1) * ScrollWorld.TILE_SIZE);
        
        // Ask region for the color
        Color tileColor = new Color(150, 150, 150);

        // Draw tile
        GreenfootImage img = new GreenfootImage(ScrollWorld.TILE_SIZE, ScrollWorld.TILE_SIZE);
        img.clear();

        int size = ScrollWorld.TILE_SIZE;
        
        // Outer triangle (border)
        img.setColor(Color.BLACK);
        int[] xOuter = {0, size / 2, size};
        int[] yOuter = {size, 0, size};
        img.fillPolygon(xOuter, yOuter, 3);
        
        // Inner triangle (fill)
        img.setColor(new Color(150, 150, 150));
        int margin = 4;
        int[] xInner = {margin, size / 2, size - margin};
        int[] yInner = {size - margin/2, margin, size - margin/2};
        img.fillPolygon(xInner, yInner, 3);
        
        hitbox = new Hitbox(this, 12, 20, 0, 0, Hitbox.HitboxType.HAZARD);
        
        setImage(img);
    }
    
    public Spike(double row, double col, GreenfootImage image) {
        super(col * ScrollWorld.TILE_SIZE, (ScrollWorld.rows-row-1) * ScrollWorld.TILE_SIZE);
        
        image.scale(ScrollWorld.TILE_SIZE, ScrollWorld.TILE_SIZE);
        
        hitbox = new Hitbox(this, 12, 20, 0, 0, Hitbox.HitboxType.HAZARD);
        
        setImage(image);
    }
    
    public Hitbox getHitbox() { return hitbox; } //for the cube
    
    public void addedToWorld(World world)
    {
        world.addObject(new HitboxRenderer(hitbox), getX(), getY());
    }
}
