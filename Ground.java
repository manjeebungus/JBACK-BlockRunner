import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @Author Chase Coulter
 * @Version v1.0
 */
public class Ground extends WorldObject
{
    public Ground(String fileName){
        super(0,ScrollWorld.GROUND_HEIGHT);
        setImage(new GreenfootImage(fileName));
    }
    public void act()
    {
        setLocation(getX(),getY()+95);
    }
}
