import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public abstract class Button extends SuperSmoothMover
{
    private GreenfootImage staticImage,pressedImage;
    private boolean isPressed = false;

    public Button(String staticName, String pressedName)
    {
        staticImage = new GreenfootImage(staticName);
        pressedImage = new GreenfootImage(pressedName);
        setImage(staticImage);
    }
    /**
     * defaults to having the same image for both
     */
    public Button(String fileName)
    {
        staticImage = new GreenfootImage(fileName);
        pressedImage = staticImage;
        setImage(staticImage);
    }

    public void act()
    {
        if (Greenfoot.mousePressed(this))
        {
            isPressed = true;
            setImage(pressedImage);
        }
        if (isPressed && Greenfoot.mouseDragEnded(null))
        {
            isPressed = false;
            setImage(staticImage);
            if (Greenfoot.mouseClicked(this))
            {
                behaviour();
            }
        }
    }

    protected abstract void behaviour();
}
