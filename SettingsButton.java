import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SettingsButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SettingsButton extends Button
{
    World world;
    int type;
    
    public SettingsButton(String staticName, String pressedName,String sound,World world, int type) {
        super(staticName, pressedName,sound);
        this.world = world;
        this.type = type;
    }
    
    /**
     * Act - do whatever the SettingsButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    
    protected void behaviour() {
        switch (type) {
            case 0:
                break;
            case 1:
                break;
        }
    }
}
