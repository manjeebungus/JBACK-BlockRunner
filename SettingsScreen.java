import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SettingScreen here.
 * 
 * @author Kelton Kuan
 * @version (a version number or a date)
 */
public class SettingsScreen extends Menu
{
    private Color particleColour;
    /**
     * Constructor for objects of class SettingScreen.
     * 
     */
    public SettingsScreen()
    {
        super();
        particleColour = new Color(0,0,0);
        
        addObject(new ScreenChangeButton("Menu/StartScreen/blankUnpressed.png","Menu/StartScreen/blankPressed.png","buttonpress.wav", StartScreen.getScreen()),100,520);
    }
    
    public void act() {
        super.act();
        spawnDust();
    }
    private void spawnDust(){
        addObject(new Particle(0, 270, 8.0, 10, 30 + Greenfoot.getRandomNumber(25), particleColour), Greenfoot.getRandomNumber(1000), 600);
    }
}
