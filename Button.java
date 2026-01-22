import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @Author Chase Coulter
 * @Version v1.1
 * 
 * Button is an abstract superclass, meant to supply the basic framework
 * for the behaviour of any button
 * 
 * Handles mouse input, image swapping,
 * and triggers button behaviour.
 */
public abstract class Button extends SuperSmoothMover
{
    private GreenfootImage staticImage,pressedImage;
    private boolean isPressed = false;
    private GreenfootSound sound;

    /**
     * @Param String staticName, name of unpressed Image
     * @Param String pressedName, name of pressed Image
     * @Param String soundName, name of sound effect when clicking
     */
    public Button(String staticName, String pressedName, String soundName)
    {
        staticImage = new GreenfootImage(staticName);
        pressedImage = new GreenfootImage(pressedName);
        sound = new GreenfootSound(soundName);
        setImage(staticImage);
    }
    /**
     * @Param String staticName, name of unpressed Image
     * @Param String pressedName, name of pressed Image
     */
    public Button(String staticName, String pressedName)
    {
        staticImage = new GreenfootImage(staticName);
        pressedImage = new GreenfootImage(pressedName);
        setImage(staticImage);
        sound = new GreenfootSound("buttonpress.wav");
    }
    /**
     * @Param String fileName, name of unpressed AND pressed Images
     */
    public Button(String fileName)
    {
        staticImage = new GreenfootImage(fileName);
        pressedImage = staticImage;
        setImage(staticImage);
        sound = new GreenfootSound("buttonpress.wav");
    }

    public void act()
    {
        if (Greenfoot.mousePressed(this))
        {
            isPressed = true;
            setImage(pressedImage);
            sound.play();
        }
        if (isPressed && Greenfoot.mouseClicked(this))
        {
            isPressed = false;
            setImage(staticImage);
            behaviour();
            sound.stop();
        }
        if (isPressed && Greenfoot.mouseClicked(null))
        {
            isPressed = false;
            setImage(staticImage);
            sound.stop();
        }
    }

    protected abstract void behaviour();
}
