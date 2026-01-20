import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A orb type which launches(jumps) the player if they jump while touching it
 * 
 * @author Abithan
 * Contributed to by Brian
 * @version (a version number or a date)
 */
public class JumpOrb extends Orb
{
    public JumpOrb(double row, double col)
    {
        super(row, col, "images/Player/jumpOrb.png");
    }
    
    /**
     * @param p the player which is being lauched by the orb
     */
    protected void jumpOnClick(Player p)
    {
        if (Greenfoot.isKeyDown("space"))
        {
            p.jump(8);
        }
    }
}
