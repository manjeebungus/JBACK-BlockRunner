import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartScreen extends World
{
    private GreenfootImage title;
    private ActorImage playButton;
    private static ButtonSound buttonSound;
    public StartScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        buttonSound = new ButtonSound(5, 100);
        buttonSound.stop();
        addText();
        addImage();
    }
    
    public void act()
    {
        if (Greenfoot.mouseClicked(playButton))
        {
            Greenfoot.setWorld(new ScrollWorld());
            buttonSound.play();
        }
    }
    
    private void addText()
    {
        Color textColor = Color.BLACK;
        Color clear = new Color(0, 0, 0, 0);
        int fontSize = 100;
        
        title = new GreenfootImage("Block Runner", fontSize, textColor, clear);
        getBackground().drawImage(title, 250, 70);
    }
    
    private void addImage()
    {
        playButton = new ActorImage("playButton.gif", 150, 150);
        addObject(playButton, 500, 300);
    }
}
