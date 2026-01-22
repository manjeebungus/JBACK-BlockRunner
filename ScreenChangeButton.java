import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @Author Chase Coulter
 * @Version v1.0
 * 
 * Button that switches the current world.
 * Optionally handles background music.
 */
public class ScreenChangeButton extends Button
{
    World world;
    private Sound soundBg;
    
    /**
     * @author Abithan
     */
    public ScreenChangeButton(String staticName, String pressedName,String sound,Sound bgSound, World world){
        super(staticName, pressedName,sound);
        this.world = world;
        soundBg = bgSound;
    }
    
    public ScreenChangeButton(String staticName, String pressedName,String sound,World world){
        super(staticName, pressedName,sound);
        this.world = world;
    }
    public ScreenChangeButton(String staticName, String pressedName,String sound){
        super(staticName, pressedName,sound);
        world = new ScrollWorld(Levels.levelTest());
    }
    public ScreenChangeButton(String staticName, String pressedName){
        super(staticName, pressedName);
        world = new ScrollWorld(Levels.levelTest());
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
        
        //@author Abithan
        //Only plays the background sound if it was set for each level
        if (soundBg != null) {
            LevelSelectScreen.currentLevelSound = soundBg;
            soundBg.playLoop();
        }
        
        //Make sure the sound was initialized before stopping it
        if (LevelSelectScreen.levelSelectSound != null) {
            LevelSelectScreen.levelSelectSound.stop();
        }
        
        if (LevelSelectScreen.currentLevelSound != null) {
            LevelSelectScreen.currentLevelSound.stop();
        }
    }
}
