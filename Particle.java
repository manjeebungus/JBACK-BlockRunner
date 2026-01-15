import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Particle is a general purpose particle engine based off square, single coloured images that fade out and slow down
 * This class is meant to be as general as possible, as to be used in as many places in this project as possible
 * 
 * ROTATION STARTS POINTING RIGHT AND INCREASES COUNTER CLOCKWISE
 * 
 * @Author Chase Coulter
 * @Verson v1.0
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
    protected boolean fadeOut = true;//in case i want to mess with this later
    
    /**
     * @Param int direction, direction of which way you want to shoot particles
     * @Param int spread, random spread around the direction you selected
     * @Param double speed, initial speed of particles
     * @Param int size, particle size in pixels
     * @Param int life, lifeSpan in acts
     * @Param Color color, color of particle
     */
    public Particle(int direction, int spread, double speed, int size, int life, Color color){
        initialDirection = direction;
        this.spread = spread;
        this.speed = speed; 
        this.size = size;
        lifeSpan = life;
        maxLife = life;
        this.color = color;
        int finalDirection = direction + Greenfoot.getRandomNumber(spread * 2)-spread;//sets final direction to direction +- spread
        setRotation(finalDirection); 
        updateImage();
    }
    
    /**
     * DEFAULTS TO BLACK
     * 
     * @Param int direction, direction of which way you want to shoot particles
     * @Param int spread, random spread around the direction you selected
     * @Param double speed, initial speed of particles
     * @Param int size, particle size in pixels
     * @Param int life, lifeSpan in acts
     */
    public Particle(int direction, int spread, double speed, int size, int life){
        initialDirection = direction;
        this.spread = spread;
        this.speed = speed; 
        this.size = size;
        lifeSpan = life;
        maxLife = life;
        this.color = (new Color(0,0,0,255));
        int finalDirection = direction + Greenfoot.getRandomNumber(spread * 2)-spread;//sets final direction to direction +- spread
        setRotation(finalDirection); 
        updateImage();
    }
    
    /**
     * handles fade out and deaccel
     */
    private void updateImage()
    {
        GreenfootImage img = new GreenfootImage(size, size);
        int alpha = 255;
        if (fadeOut)
        {
            alpha = (int)(255.0 * lifeSpan / maxLife);
            if (alpha < 1) alpha = 1;
        }
        img.setColor(color);
        img.fill();
        setImage(img);
    }
    
    public void act(){
        move(speed);
        lifeSpan--;
        updateImage();//fadeout and slow
        if(lifeSpan <=0 && getWorld() != null){ //if end of life and nullcheck
            getWorld().removeObject(this);
        }
    }
}
