import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Chase Coulter
 * @version v1.4
 */
public class StartScreen extends Menu
{
    private static StartScreen startScreen;
    private GreenfootImage title;
    private static ButtonSound buttonSound;
    public StartScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super();
        UserData.load();
        
        startScreen = this;
        
        setBackground(new GreenfootImage("menu/StartScreen/startMenu.png"));

        //buttonSound = new ButtonSound(5, 100);
        //buttonSound.stop();
        //addObject(new ScreenChangeButton("Menu/StartScreen/playUnpressed.png","Menu/StartScreen/playPressed.png","buttonpress.wav",new LevelSelectScreen()),500,370);//play button
        addObject(new ScreenChangeButton("Menu/StartScreen/settingsUnpressed.png","Menu/StartScreen/settingsPressed.png","buttonpress.wav", new SettingsScreen()),800,420);//settings button
        addObject(new ScreenChangeButton("Menu/StartScreen/playUnpressed.png","Menu/StartScreen/playPressed.png","buttonpress.wav", new LevelSelectScreen()),500,370);//blank button
    }
    
    public void act()
    {
        super.act();
        spawnDust();
    }
    private void spawnDust(){
        addObject(new Particle(0, 90, 5.0, 10, 30 + Greenfoot.getRandomNumber(25), new Color(150,40,70)), 0, Greenfoot.getRandomNumber(600));
        addObject(new Particle(180, 90, 5.0, 10, 30 + Greenfoot.getRandomNumber(25), new Color(150,40,70)), 1000, Greenfoot.getRandomNumber(600));
        addObject(new Particle(0, 90, 5.0, 10, 30 + Greenfoot.getRandomNumber(25), new Color(200,140,70)), 0, Greenfoot.getRandomNumber(600));
        addObject(new Particle(180, 90, 5.0, 10, 30 + Greenfoot.getRandomNumber(25), new Color(200,140,70)), 1000, Greenfoot.getRandomNumber(600));
    }
    
    public static StartScreen getScreen() {
        return startScreen;
    }
}
