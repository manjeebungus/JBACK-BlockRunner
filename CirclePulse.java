import greenfoot.*;

/**
 * @Author Chase Coulter
 * @Version v1.0
 * 
 * Expanding, fading circle effect.
 * Grows over time, fades out, then deletes itself
 * Optional flag makes it scroll with world
 */
public class CirclePulse extends Visual
{
    int alpha; // transparency
    int maxDiameter; // max size
    double diameter; // current size
    double growthSpeed; // speed
    Color color; // color
    Boolean bool = false; // move flag

    public CirclePulse(int maxSize,int Speed,Color color)
    {
        maxDiameter=maxSize; // set max
        growthSpeed=Speed; // set speed
        this.color=color;
        diameter=0;
        alpha=150;
        updateImage(); // init image
        getImage().setTransparency(alpha);
    }
    
    public CirclePulse(int maxSize,int Speed,Color color,Boolean bool)
    {
        maxDiameter=maxSize;
        growthSpeed=Speed;
        this.color=color;
        diameter=0;
        alpha=150;
        updateImage();
        getImage().setTransparency(alpha);
        this.bool = true; // enable move
    }

    public void act()
    {
        if(diameter<maxDiameter)diameter+=growthSpeed; // grow
        alpha -=5; // fade
        if(alpha<0)alpha=0;
        updateImage();
        getImage().setTransparency(alpha);
        if(alpha<=0&&getWorld()!=null)getWorld().removeObject(this); // delete
        if(bool){
            move(-5.5); // move
        }
    }

    void updateImage()
    {
        int d = Math.max(1,(int)diameter); // avoid zero
        GreenfootImage img=new GreenfootImage(d, d);
        img.setColor(color);
        img.fillOval(0, 0 , d-1, d-1);
        setImage(img);
    }
}
