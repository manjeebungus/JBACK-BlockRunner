import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @Author Chase Coulter
 * @Version v1.1
 */
public class LevelSelectScreen extends Menu
{
    private int currentLevel = 1;
    private Color particleColour;
    public LevelSelectScreen()
    {    
        super(); 
        addObject(new SelectScreenButtons("Menu/LevelSelectScreen/next.png","Menu/LevelSelectScreen/nextPressed.png","buttonpress.wav",true),950,350);
        addObject(new SelectScreenButtons("Menu/LevelSelectScreen/last.png","Menu/LevelSelectScreen/lastPressed.png","buttonpress.wav",false),50,350);
        addObject(new ScreenChangeButton("Menu/StartScreen/blankUnpressed.png","Menu/StartScreen/blankPressed.png","buttonpress.wav", StartScreen.getScreen()),100,520);
        setScreen(1);
    }
    private void setScreen(int screen){
        switch(screen){
            case 1:
                particleColour = new Color(150,40,70);
                setBackground("menu/LevelSelectScreen/baseLine.png");
                addObject(new ScreenChangeButton("Menu/LevelSelectScreen/baseLineUnpressed.png","Menu/LevelSelectScreen/baseLinePressed.png","buttonpress.wav", new ScrollWorld(Levels.level1())),500,200);
                break;
            case 2:
                particleColour = new Color(40,150,70);
                setBackground("menu/LevelSelectScreen/frostByte.png");
                addObject(new ScreenChangeButton("Menu/LevelSelectScreen/frostByteUnpressed.png","Menu/LevelSelectScreen/frostBytePressed.png","buttonpress.wav", new ScrollWorld(Levels.level2())),500,200);
                break;
        }
    }
    public void act(){
        super.act();
        spawnDust();
    }
    private void spawnDust(){
        addObject(new Particle(0, 270, 8.0, 10, 30 + Greenfoot.getRandomNumber(25), particleColour), Greenfoot.getRandomNumber(1000), 600);
    }
    public void next(){
        currentLevel++;
        if(currentLevel>2){
            currentLevel = 2;
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
            removeObject(s);
        }
    }
}
