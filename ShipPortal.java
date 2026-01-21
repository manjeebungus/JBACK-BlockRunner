import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A portal type which turns the player into a Ship
 * 
 * @author Abithan
 * @version (a version number or a date)
 */
public class ShipPortal extends Portal
{
    /**
     * @param row the tile the portal is on vertically
     * @param col the tile the portal is on horizontally
     **/
    public ShipPortal(double row, double col)
    {
        super(row, col, "images/shipPortal.png");
    }
    
    /**
     * @param p the player whose mode will change
     */
    protected void onPortalContact(Player p)
    {
        //Checks if the player is not already a Ship
        if (!(p instanceof Ship))
        {
            calculateNewY(p, new Ship());
        }
    }
}