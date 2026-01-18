import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @Author Chase Coulter
 * @Version v1.0
 * 
 * ScreenChangeButton is an extension of Button, its behaviour is setting world to ScrollWorld
 */
public class ScreenChangeButton extends Button
{
    World world;
    public ScreenChangeButton(String staticName, String pressedName,String sound,World world){
        super(staticName, pressedName,sound);
        this.world = world;
    }
    public ScreenChangeButton(String staticName, String pressedName,String sound){
        super(staticName, pressedName,sound);
        world = new ScrollWorld();
    }
    public ScreenChangeButton(String staticName, String pressedName){
        super(staticName, pressedName);
        world = new ScrollWorld();
    }
    public void act()
    {
        super.act();
    }
    protected void behaviour() {
        World currentWorld = getWorld();
        if (currentWorld != null) {
            currentWorld.addObject(new ScreenWipe(1), 0, 300);
        }
        Greenfoot.setWorld(world);
    }

}
