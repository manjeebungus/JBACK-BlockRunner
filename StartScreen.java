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
    private MouseClickBox playButton;
    private static ButtonSound buttonSound;
    public StartScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        buttonSound = new ButtonSound(5, 100);
        buttonSound.stop();
        addText();
        addImage();
    }
    
    public void act()
    {
        if (Greenfoot.mouseClicked(playButton))
        {
            buttonSound.play();
            Greenfoot.setWorld(new ScrollWorld());
        }
    }
    
    private void addText()
    {
        Color textColor = Color.BLACK;
        Color clear = new Color(0, 0, 0, 0);
        int fontSize = 80;
        
        title = new GreenfootImage("Block Runner", fontSize, textColor, clear);
        getBackground().drawImage(title, 95, 70);
    }
    
    private void addImage()
    {
        playButton = new MouseClickBox();
        playButton.setImage("playButton.gif");
        playButton.getImage().scale(80, 80);
        addObject(playButton, 300, 220);
    }
}
