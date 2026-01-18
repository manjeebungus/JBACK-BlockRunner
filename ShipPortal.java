import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ShipPortal here.
 * 
 * @author Abithan
 * @version (a version number or a date)
 */
public class ShipPortal extends Portal
{
    public ShipPortal(double row, double col)
    {
        super(row, col, "images/Player/sPortal.png");
    }
    
    protected void onPortalContact(Player p)
    {
        //Checks if the player is not already a Ship
        if (!(p instanceof Ship))
        {
            calculateNewY(p, new Ship());
        }
    }
}