import greenfoot.*;

/**
 * @Author Chase Coulter
 * @Version v1.0
 *
 * Full-screen fade effect.
 * Increases transparency over time until opaque.
 */
public class ScreenFade extends Visual
{
    int alpha = 0;
    int speed;
    Color color;
    int beta = 0;

    public ScreenFade(int speed, Color color)
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
        if(alpha < 255)
        {
            beta += speed;
            alpha = (int)(beta/3);
            if(alpha > 255) alpha = 255;
            getImage().setTransparency(alpha);
        }
    }
}
