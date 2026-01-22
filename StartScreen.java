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
    private static StartScreenSound startScreenSound;
    public StartScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super();
        menu = this;
        
        UserData.load();
        
        startScreen = this;
        
        setBackground(new GreenfootImage("menu/StartScreen/startMenu.png"));

        //buttonSound = new ButtonSound(5, 100);
        //buttonSound.stop();
        
        //Background sound
        startScreenSound = new StartScreenSound(5, 80);
        startScreenSound.stop();
        
        addObject(new ScreenChangeButton("Menu/StartScreen/settingsUnpressed.png","Menu/StartScreen/settingsPressed.png","buttonpress.wav", new SettingsScreen()),800,420);//settings button
        addObject(new ScreenChangeButton("Menu/StartScreen/playUnpressed.png","Menu/StartScreen/playPressed.png","buttonpress.wav", new LevelSelectScreen()),500,370);//blank button
        addObject(new ScreenFadeIn(5, Color.BLACK), 500, 300);//to fade in from a level
    }
    
    public void act()
    {
        super.act();
        spawnDust();
        if (!soundPlayed)
        {
            if (UserData.getMusicVolume() != 0) {
                startScreenSound.playLoop(); // start music
            }
            soundPlayed = true;
        }
    }
    
    public void started()
    {
        startScreenSound.play();        
    }
    
    public void stopped()
    {
        startScreenSound.pause();
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
