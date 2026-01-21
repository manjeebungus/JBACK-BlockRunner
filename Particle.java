import greenfoot.*;  

/**
 * @Author Chase Coulter
 * @Version v1.0
 * 
 * Particle class is a square-based particle engine meant to be as 
 * broad and customizable as possible, as to be reused as much as 
 * possible
 */
public class Particle extends Visual
{
    protected int lifeSpan;
    protected int maxLife;
    protected double speed;
    protected int initialDirection;
    protected int spread;
    protected int size;
    protected Color color;
    protected boolean fadeOut = true;
    protected double speedDecay;
    Boolean moving = false;
    protected int finalRotation = 0;
    double exactX;
    double exactY;

    /**
     * @Param int direction, initial direction of particles movement
     * @Param int spread, range +- direction, set to 0 if you want no spread
     * @Param double speed, initial speed of particles
     * @Param int size, size in pixels of particles
     * @Param int life, defines how long particles remain and their lifespan
     * @Param Color color, color of particles, always 255 alpha
     * 
     * 0dg = right
     * 90dg = down
     * 180dg = left
     * 270dg = up
     * 
     */
    public Particle(int direction, int spread, double speed, int size, int life, Color color){
        initialDirection = direction;
        this.spread = spread;
        this.speed = speed; 
        this.size = size;
        this.color = color;

        int variation = Math.max(1, life / 10);
        lifeSpan = life + Greenfoot.getRandomNumber(variation * 2 + 1) - variation;
        maxLife = lifeSpan;

        int finalDirection = direction + Greenfoot.getRandomNumber(spread * 2) - spread;
        setRotation(finalDirection);

        speedDecay = speed / maxLife;

        updateImage();
    }
    
    public Particle(int direction, int spread, double speed, int size, int life, Color color,Boolean bool){
        initialDirection = direction;
        this.spread = spread;
        this.speed = speed; 
        this.size = size;
        this.color = color;

        int variation = Math.max(1, life / 10);
        lifeSpan = life + Greenfoot.getRandomNumber(variation * 2 + 1) - variation;
        maxLife = lifeSpan;

        int finalDirection = direction + Greenfoot.getRandomNumber(spread * 2) - spread;
        setRotation(finalDirection);

        speedDecay = speed / maxLife;

        updateImage();
        moving = true;
        finalRotation = finalDirection;
    }

    private void updateImage()
    {
        GreenfootImage img = new GreenfootImage(size, size);
        int alpha = fadeOut ? (int)(255.0 * lifeSpan / maxLife) : 255;
        if(alpha < 0) alpha = 0;
        img.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), alpha));
        img.fill();
        setImage(img);
    }

    public void act()
    {
        move(speed);

        if(speed > 0) {
            speed -= speedDecay;
            if(speed < 0) speed = 0;
        } else if(speed < 0) {
            speed -= speedDecay;
            if(speed > 0) speed = 0;
        }

        lifeSpan--;
        updateImage();

        if(lifeSpan <= 0 && getWorld() != null){
            getWorld().removeObject(this);
        }
        
        if(moving){
            setRotation(0);
            move(-5.5);
            setRotation(finalRotation);
        }
    }
}
