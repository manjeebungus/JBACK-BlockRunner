import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @Author Chase Coulter
 * @Version v1.0
 * 
 * ScreenChangeButton is an extension of Button, its behaviour is setting world to ScrollWorld
 */
public class ScreenChangeButton extends Button
{
    public ScreenChangeButton(String staticName, String pressedName,String sound){
        super(staticName, pressedName,sound);
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
