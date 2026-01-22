import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @Author Chase Coulter
 * Assisted by Kelton Kuan
 * @Version v1.0
 */
public class Ground extends WorldObject
{
    public Ground(String fileName,int x){
        super(x,ScrollWorld.GROUND_HEIGHT,1000);
        setImage(new GreenfootImage(fileName));
    }
    public void act()
    {
        checkPosition();
        setLocation(getX(),getY()+95);
        checkPosition();
    }
    private void checkPosition(){
        if(getX()<= -500){
            moveBy(1000,0);
        }
    }
}
