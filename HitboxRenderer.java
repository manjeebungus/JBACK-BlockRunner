import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.Color;

/**
 * Write a description of class HitboxRenderer here.
 * 
 * @author Brian Cheung
 * @version (a version number or a date)
 */
public class HitboxRenderer extends Actor
{
    private Hitbox hitbox;

    public HitboxRenderer(Hitbox hitbox)
    {
        this.hitbox = hitbox;
        updateImage();
    }

    public void act()
    {
        // Keep renderer aligned with owner
        setLocation(hitbox.getX(), hitbox.getY());
        updateImage(); //updates if hitbox visibility changes dynamically
    }

        
    /**
     *Visuals:
     *RED for cube and hazards, 
     *BLUE for inner hitbox and blocks, 
     *GREEN for interactions (Portals, Orbs, etc)
     */
    
    public void updateImage()
    {
        if (!Hitbox.isBoxVisible()) { 
            setImage(new GreenfootImage(1, 1)); // basically invisible
            return;
        }

        Color color = Color.RED; // default
        switch (hitbox.getType()) {
            case SOLID:    color = Color.BLUE; break;
            case INTERACT: color = Color.GREEN; break;
        }

        GreenfootImage img = new GreenfootImage(hitbox.getWidth(), hitbox.getHeight());
        img.setColor(color);
        img.drawRect(0, 0, hitbox.getWidth() - 1, hitbox.getHeight() - 1);
        setImage(img);
    }
    
    //This accessor is to prevent Player hitbox from causing exceptions
    public Hitbox getHitbox() {
        return hitbox;
    }
}
