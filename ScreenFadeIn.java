import greenfoot.*;

/**
 * @Author Chase Coulter
 * @Version 1.0
 * 
 * Full-screen fade-in effect.
 * Starts opaque and fades to transparent.
 */
public class ScreenFadeIn extends Visual
{
    int alpha = 255; // start fully opaque
    int speed;
    Color color;

    public ScreenFadeIn(int speed, Color color)
    {
        this.speed = speed;
        this.color = color;

        GreenfootImage img = new GreenfootImage(1000, 600);
        img.setColor(color);
        img.fill();
        setImage(img);
        getImage().setTransparency(alpha);
    }

    public void act()
    {
        if(alpha > 0)
        {
            alpha -= speed; // fade in
            if(alpha < 0) alpha = 0;
            getImage().setTransparency(alpha);
        }
        else
        {
            // Fade complete, remove self from world
            if (getWorld() != null) {
                getWorld().removeObject(this);
            }
        }
    }

}
