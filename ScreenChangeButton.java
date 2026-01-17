import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @Author Chase Coulter
 * @Version v1.0
 */
public class ScreenChangeButton extends Button
{
    public ScreenChangeButton(String staticName, String pressedName,String sound){
        super(staticName, pressedName);
        
    }
    public ScreenChangeButton(String staticName, String pressedName){
        super(staticName, pressedName);
    }
    public void act()
    {
        super.act();
    }
    protected void behaviour(){
        Greenfoot.setWorld(new ScrollWorld());
    }
}
