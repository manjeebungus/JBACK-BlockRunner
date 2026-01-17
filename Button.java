import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @Author Chase Coulter
 * @Version v1.1
 */
public abstract class Button extends SuperSmoothMover
{
    private GreenfootImage staticImage,pressedImage;
    private boolean isPressed = false;
    private GreenfootSound sound;

    public Button(String staticName, String pressedName, String soundName)
    {
        staticImage = new GreenfootImage(staticName);
        pressedImage = new GreenfootImage(pressedName);
        sound = new GreenfootSound(soundName);
        setImage(staticImage);
    }
    public Button(String staticName, String pressedName)
    {
        staticImage = new GreenfootImage(staticName);
        pressedImage = new GreenfootImage(pressedName);
        setImage(staticImage);
        sound = new GreenfootSound("buttonpress.wav");
    }
    /**
     * defaults to having the same image for both
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
