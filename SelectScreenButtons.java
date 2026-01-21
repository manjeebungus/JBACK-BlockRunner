import greenfoot.*;
/**
 * @Author Chase Coulter
 * @Version v1.1
 */
public class SelectScreenButtons extends Button
{
    private boolean right;

    public SelectScreenButtons(String staticName, String pressedName, String sound, boolean right)
    {
        super(staticName, pressedName, sound);
        this.right = right;
    }

    public void act()
    {
        super.act();
    }

    @Override
    protected void behaviour()
    {
        World world = getWorld();
        
        if (world instanceof LevelSelectScreen)
        {
            LevelSelectScreen screen = (LevelSelectScreen) world;

            if (right)
            {
                screen.next();
                world.addObject(new ScreenWipe(1), -500, 300);
            }
            else
            {
                screen.last();
                world.addObject(new ScreenWipe(3), 1500, 300);
            }
        }
        
    }
}
