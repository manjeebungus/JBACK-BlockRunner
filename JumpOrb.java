import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A orb type which launches(jumps) the player if they jump while touching it
 * 
 * @author Abithan
 * Contributed to by Brian & Chase
 * @version (a version number or a date)
 */
public class JumpOrb extends Orb
{
    Boolean pulseSpawned = false;
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
            if(!pulseSpawned){
                getWorld().addObject(new CirclePulse(200, 4, new Color(255,255,100),true), getX(), getY());
                getWorld().addObject(new CirclePulse(400, 8, new Color(255,255,100),true), getX(), getY());
                pulseSpawned = true;
            }
        }
    }
    /**
     * @Author Chase Coulter
     */
    public void act(){
        getWorld().addObject(new Particle(Greenfoot.getRandomNumber(360), 180, 4.0 + Greenfoot.getRandomNumber(40) / 10.0, 4, 20 + Greenfoot.getRandomNumber(5), new Color(255,255,100),true), getX(), getY());
    }
}
