import greenfoot.*;

/**
 * @Author Chase Coulter
 * @Version v1.0
 */
public class CirclePulse extends Visual
{
    int alpha;
    int maxDiameter;
    double diameter;
    double growthSpeed;
    Color color;
    Boolean bool = false;

    public CirclePulse(int maxSize,int Speed,Color color)
    {
        maxDiameter=maxSize;
        growthSpeed=Speed;
        this.color=color;
        diameter=0;
        alpha=150;
        updateImage();
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
        this.bool = true;
    }

    public void act()
    {
        if(diameter<maxDiameter)diameter+=growthSpeed;
        alpha -=5;
        if(alpha<0)alpha=0;
        updateImage();
        getImage().setTransparency(alpha);
        if(alpha<=0&&getWorld()!=null)getWorld().removeObject(this);
        if(bool){
            move(-5.5);
        }
    }

    void updateImage()
    {
        int d = Math.max(1,(int)diameter);
        GreenfootImage img=new GreenfootImage(d, d);
        img.setColor(color);
        img.fillOval(0, 0 , d-1, d-1);
        setImage(img);
    }
}
