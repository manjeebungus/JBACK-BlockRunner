import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SettingScreen here.
 * 
 * @author Kelton Kuan
 * @version (a version number or a date)
 */
public class SettingsScreen extends Menu
{
    private static SettingsScreen screen;
    
    private Color particleColour;
    
    private final double musicBarScale = 0.3; // scale of the music bar 
    private final int musicBarX = 200; // x position of the music bar
    private final int musicBarY = 200; // y position of the music bar
    private RedBar musicRedBar;
    private GreenBar musicGreenBar;
    private static StaticImage musicBar;
    
    private final double sfxBarScale = 0.3; // scale of the sfx bar 
    private final int sfxBarX = 200; // x position of the sfx bar
    private final int sfxBarY = 300; // y position of the sfx bar
    private RedBar sfxRedBar;
    private GreenBar sfxGreenBar;
    private static StaticImage sfxBar;
    
    /**
     * Constructor for objects of class SettingScreen.
     * 
     */
    public SettingsScreen()
    {
        super();
        menu = this;
        screen = this;
        
        particleColour = new Color(0,0,0);
        
        musicBarSetUp();
        sfxBarSetUp();
        updateMusicBar();
        updateSfxBar();
        
        addObject(new ScreenChangeButton("Menu/StartScreen/blankUnpressed.png","Menu/StartScreen/blankPressed.png","buttonpress.wav", StartScreen.getScreen()),100,520);
        
        addObject(new SettingsButton("Menu/minus.png","Menu/minus.png","buttonpress.wav", StartScreen.getScreen(), 0),100,200);
        addObject(new SettingsButton("Menu/plus.png","Menu/plus.png","buttonpress.wav", StartScreen.getScreen(), 1),300,200);
        
        
        addObject(new SettingsButton("Menu/minus.png","Menu/minus.png","buttonpress.wav", StartScreen.getScreen(), 2),100,300);
        addObject(new SettingsButton("Menu/plus.png","Menu/plus.png","buttonpress.wav", StartScreen.getScreen(), 3),300,300);
        
        setBackground("Menu/LevelSelectScreen/baseLine.png");
        
        
    }
    
    public void act() {
        super.act();
        
        
        spawnDust();
        
    }
    
    private void musicBarSetUp() {
        Color color = Color.RED;
        Color outline = Color.WHITE;
        Color clear = new Color(0, 0, 0, 0);
        int fontSize = 30;
        Font font = new Font(java.awt.Font.SERIF, fontSize);
        
        
        
        musicRedBar = new RedBar(musicBarScale, musicBarScale);
        musicGreenBar = new GreenBar(musicBarScale, musicBarScale);
        

        musicRedBar.getImage().setColor(new Color(50, 50, 50));
        musicRedBar.getImage().fill();
        musicGreenBar.getImage().setColor(new Color(100, 100, 200));
        musicGreenBar.getImage().fill();
        
        musicBar = new StaticImage("images/blank.png");
        GreenfootImage image = new GreenfootImage("Music Volume", fontSize, color, clear, outline);
        musicBar.getImage().scale(image.getWidth(), image.getHeight());
        musicBar.getImage().drawImage(image, 0, 0);
        
        addObject(musicRedBar, musicBarX, musicBarY);
        addObject(musicGreenBar, musicBarX, musicBarY);
        addObject(musicBar, musicBarX, musicBarY-50);
    }
    
    private void sfxBarSetUp() {
        Color color = Color.RED;
        Color outline = Color.WHITE;
        Color clear = new Color(0, 0, 0, 0);
        int fontSize = 30;
        Font font = new Font(java.awt.Font.SERIF, fontSize);
        
        sfxRedBar = new RedBar(sfxBarScale, sfxBarScale);
        sfxGreenBar = new GreenBar(sfxBarScale, sfxBarScale);

        sfxRedBar.getImage().setColor(new Color(50, 50, 50));
        sfxRedBar.getImage().fill();
        sfxGreenBar.getImage().setColor(new Color(100, 100, 200));
        sfxGreenBar.getImage().fill();
        
        sfxBar = new StaticImage("images/blank.png");
        GreenfootImage image = new GreenfootImage("Sfx Volume", fontSize, color, clear, outline);
        sfxBar.getImage().scale(image.getWidth(), image.getHeight());
        sfxBar.getImage().drawImage(image, 0, 0);
        
        addObject(sfxRedBar, sfxBarX, sfxBarY);
        addObject(sfxGreenBar, sfxBarX, sfxBarY);
        addObject(sfxBar, sfxBarX, sfxBarY-50);
    }
    
    public void updateMusicBar() {
        double progress = (double)UserData.getMusicVolume() / (double) 100;
        double displayProgress = Math.min(progress, 1.0);

        musicGreenBar.setPos(musicBarX, musicBarY, displayProgress);
    }
    
    public void updateSfxBar() {
        double progress = (double)UserData.getSfxVolume() / (double) 100;
        double displayProgress = Math.min(progress, 1.0);

        sfxGreenBar.setPos(sfxBarX, sfxBarY, displayProgress);
    }
    
    private void spawnDust(){
        addObject(new Particle(0, 270, 8.0, 10, 30 + Greenfoot.getRandomNumber(25), particleColour), Greenfoot.getRandomNumber(1000), 600);
    }
    
    public static SettingsScreen getScreen() {
        return screen;
    }
}
