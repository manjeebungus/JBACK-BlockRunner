import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @Author Chase Coulter
 * @Version v1.1
 */

/*
 * Level selection menu.
 * Handles background sounds, navigation buttons, and particle effects.
 */
public class LevelSelectScreen extends Menu
{
    protected static LevelSelectSound levelSelectSound;
    protected static Level1Sound level1Sound;
    protected static Level2Sound level2Sound;
    protected static Level3Sound level3Sound;
    protected static Sound currentLevelSound;
    
    private int currentLevel = 1;
    private Color particleColour;

    public LevelSelectScreen()
    {    
        super(); 
        menu = this;
        soundPlayed = false;
        
        // Background sound when selecting levels
        levelSelectSound = new LevelSelectSound(5, 80);
        levelSelectSound.stop();
        
        // Level sounds
        level1Sound = new Level1Sound(5, 80);
        level1Sound.stop();
        level2Sound = new Level2Sound(5, 80);
        level2Sound.stop();
        level3Sound = new Level3Sound(5, 80);
        level3Sound.stop();
        
        addObject(new SelectScreenButtons("Menu/LevelSelectScreen/next.png","Menu/LevelSelectScreen/nextPressed.png","buttonpress.wav",true),950,350);
        addObject(new SelectScreenButtons("Menu/LevelSelectScreen/last.png","Menu/LevelSelectScreen/lastPressed.png","buttonpress.wav",false),50,350);
        addObject(new ScreenChangeButton("Menu/StartScreen/blankUnpressed.png","Menu/StartScreen/blankPressed.png","buttonpress.wav", StartScreen.getScreen()),100,520);
        setScreen(1); // start at first level
    }
    
    private void setScreen(int screen){
        switch(screen){
            case 1:
                particleColour = new Color(150,40,70);
                setBackground("menu/LevelSelectScreen/baseLine.png");
                addObject(new ScreenChangeButton("Menu/LevelSelectScreen/baseLineUnpressed.png","Menu/LevelSelectScreen/baseLinePressed.png","buttonpress.wav",new Level1Sound(1, 100), new ScrollWorld(Levels.level1())),500,200);
                addObject(new ScreenChangeButton("Menu/StartScreen/blankUnpressed.png","Menu/StartScreen/blankPressed.png","buttonpress.wav", StartScreen.getScreen()),100,520);
                break;
            case 2:
                particleColour = new Color(40,150,70);
                setBackground("menu/LevelSelectScreen/frostByte.png");
                addObject(new ScreenChangeButton("Menu/LevelSelectScreen/frostByteUnpressed.png","Menu/LevelSelectScreen/frostBytePressed.png","buttonpress.wav",new Level2Sound(1, 100), new ScrollWorld(Levels.level2())),500,200);
                addObject(new ScreenChangeButton("Menu/StartScreen/blankUnpressed.png","Menu/StartScreen/blankPressed.png","buttonpress.wav", StartScreen.getScreen()),100,520);
                break;
            case 3:
                particleColour = new Color(40,150,70);
                setBackground("menu/LevelSelectScreen/drift.png");
                addObject(new ScreenChangeButton("Menu/LevelSelectScreen/driftUnpressed.png","Menu/LevelSelectScreen/driftPressed.png","buttonpress.wav",new Level3Sound(1, 100), new ScrollWorld(Levels.level3())),500,200);
                addObject(new ScreenChangeButton("Menu/StartScreen/blankUnpressed.png","Menu/StartScreen/blankPressed.png","buttonpress.wav", StartScreen.getScreen()),100,520);
                break;
        }
    }
    
    public void act(){
        super.act();
        spawnDust(); // add particles
        if (!soundPlayed)
        {
            if (UserData.getMusicVolume() != 0) {
                levelSelectSound.playLoop(); // start music
            }
            soundPlayed = true;
        }
    }
    
    public void started()
    {
        levelSelectSound.play();        
    }
    
    public void stopped()
    {
        levelSelectSound.pause();
    }
    
    private void spawnDust(){
        addObject(new Particle(0, 270, 8.0, 10, 30 + Greenfoot.getRandomNumber(25), particleColour), Greenfoot.getRandomNumber(1000), 600);
    }

    public void next(){
        currentLevel++;
        if(currentLevel>3){
            currentLevel = 3;
        }else{
            clear();
            setScreen(currentLevel);
        }
    }

    public void last(){
        currentLevel--;
        if(currentLevel<1){
            currentLevel = 1;
        }else{
            clear();
            setScreen(currentLevel);
        }
    }

    private void clear(){
        for(ScreenChangeButton s : getObjects(ScreenChangeButton.class)){
            removeObject(s); // remove old buttons
        }
    }
}
