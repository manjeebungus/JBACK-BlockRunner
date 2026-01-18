import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @Author Chase Coulter
 * @Version v1.0
 */
public class Menu extends World
{
    public Menu()
    {    
        super(1000, 600, 1,false);//all menus 1k x 600
        
    }
    public void act(){
        if (Greenfoot.mouseDragged(null))
        {
            spawnParticles();
        }
        if (Greenfoot.mouseClicked(null))
        {
            spawnParticles();
        }
    }
    protected void spawnParticles(){
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null)
        {
            int x = mouse.getX();
            int y = mouse.getY();

            for(int i = 0; i<10; i++){
                addObject(new Particle(Greenfoot.getRandomNumber(360), 180, 4.0 + Greenfoot.getRandomNumber(40) / 10.0, 4, 30 + Greenfoot.getRandomNumber(25), Color.WHITE), x, y);
            }
        }
    }
}
