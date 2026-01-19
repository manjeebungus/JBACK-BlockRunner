import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A portal type which changes the player into a Cube 
 * 
 * @author Abithan
 * @version (a version number or a date)
 */
public class CubePortal extends Portal
{
    /**
     * @param row the tile the portal is on vertically
     * @param col the tile the portal is on horizontally
     **/
    public CubePortal(double row, double col)
    {
        super(row, col, "images/Player/sPortal.png");
    }
    
    /**
     * @param p the player whose mode will change
     */
    protected void onPortalContact(Player p)
    {
        //Checks if the player is not already a cube
        if (!(p instanceof Cube))
        {
            calculateNewY(p, new Cube());
        }
    }
}
