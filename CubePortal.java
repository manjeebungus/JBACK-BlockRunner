import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CubePortal here.
 * 
 * @author Abithan
 * @version (a version number or a date)
 */
public class CubePortal extends Portal
{
    public CubePortal(double row, double col)
    {
        super(row, col, "images/Player/sPortal.png");
    }
    
    protected void onPortalContact(Player p)
    {
        //Checks if the player is not already a cube
        if (!(p instanceof Cube))
        {
            calculateNewY(p, new Cube());
        }
    }
}
