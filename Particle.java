import greenfoot.*;  

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
    }
}
