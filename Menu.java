import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @Author Chase Coulter
 * @Version v1.0
 */
public class Menu extends World
{
    protected static Menu menu;
    
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
            spawnPulse();
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
            for(int i = 0; i<5; i++){
                addObject(new Particle(Greenfoot.getRandomNumber(360), 180, 2.0 + Greenfoot.getRandomNumber(20) / 10.0, 10, 30 + Greenfoot.getRandomNumber(25), Color.WHITE  ), x, y);
            }
            for(int i = 0; i<10; i++){
                addObject(new Particle(Greenfoot.getRandomNumber(360), 180, 2.0 + Greenfoot.getRandomNumber(20) / 10.0, 10, 30 + Greenfoot.getRandomNumber(25), Color.WHITE), x, y);
            }
        }
    }
    //this is a test
    protected void spawnPulse(){
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null)
        {
            int x = mouse.getX();
            int y = mouse.getY();
            addObject(new CirclePulse(50, 4, Color.WHITE), x, y);
            addObject(new CirclePulse(100, 8, Color.WHITE), x, y);
        }
    }
    
    protected static Menu getMenu() {
        return menu;
    }
}
