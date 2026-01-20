import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SettingScreen here.
 * 
 * @author Kelton Kuan
 * @version (a version number or a date)
 */
public class SettingsScreen extends Menu
{

    /**
     * Constructor for objects of class SettingScreen.
     * 
     */
    public SettingsScreen()
    {
        super();
        addObject(new ScreenChangeButton("Menu/StartScreen/blankUnpressed.png","Menu/StartScreen/blankPressed.png","buttonpress.wav", StartScreen.getScreen()),100,520);
    }
}
