import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * @author Chase Coulter
 * @version v1.4
 */
public class StartScreen extends World
{
    private GreenfootImage title;
    private static ButtonSound buttonSound;
    public StartScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1,false); 
        setBackground(new GreenfootImage("menu/StartScreen/startMenu.png"));

        //buttonSound = new ButtonSound(5, 100);
        //buttonSound.stop();
        //addText();
        addObject(new ScreenChangeButton("Menu/StartScreen/playUnpressed.png","Menu/StartScreen/playPressed.png","buttonpress.wav",new LevelSelectScreen()),500,370);//play button
        addObject(new ScreenChangeButton("Menu/StartScreen/settingsUnpressed.png","Menu/StartScreen/settingsPressed.png","buttonpress.wav"),800,420);//settings button
        addObject(new ScreenChangeButton("Menu/StartScreen/blankUnpressed.png","Menu/StartScreen/blankPressed.png","buttonpress.wav", new LevelSelectScreen()),200,420);//blank button
    }
    
    private void addText()
    {
        Color textColor = Color.BLACK;
        Color clear = new Color(0, 0, 0, 0);
        int fontSize = 100;
        
        title = new GreenfootImage("Block Runner", fontSize, textColor, clear);
        getBackground().drawImage(title, 250, 90);
    }
    
    public void act()
    {
        if (Greenfoot.mouseDragged(null))
        {
            spawnParticles();
        }
        if (Greenfoot.mouseClicked(null))
        {
            spawnParticles();
        }
        spawnDust();
    }
    private void spawnParticles(){
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null)
        {
            int x = mouse.getX();
            int y = mouse.getY();

            for(int i = 0; i<10; i++){
                addObject(new Particle(Greenfoot.getRandomNumber(360), 180, 4.0 + Greenfoot.getRandomNumber(40) / 10.0, 4, 30 + Greenfoot.getRandomNumber(25), Color.WHITE), x, y);
            }
        }
    }
    private void spawnDust(){
        addObject(new Particle(0, 90, 5.0, 10, 30 + Greenfoot.getRandomNumber(25), new Color(150,40,70)), 0, Greenfoot.getRandomNumber(600));
        addObject(new Particle(180, 90, 5.0, 10, 30 + Greenfoot.getRandomNumber(25), new Color(150,40,70)), 1000, Greenfoot.getRandomNumber(600));
        addObject(new Particle(0, 90, 5.0, 10, 30 + Greenfoot.getRandomNumber(25), new Color(200,140,70)), 0, Greenfoot.getRandomNumber(600));
        addObject(new Particle(180, 90, 5.0, 10, 30 + Greenfoot.getRandomNumber(25), new Color(200,140,70)), 1000, Greenfoot.getRandomNumber(600));
    }


}
