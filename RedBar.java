import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Red bar class (background of health bars)
 * 
 * @author Kelton
 * @version
 */
public class RedBar extends SuperSmoothMover
{
    // image for the bar
    private GreenfootImage image;
    
    /**
     * Constructor for creating a red bar
     * 
     * @param xScale: x scale
     * @param yScale: y scale
     * @param isBoss: whether the bar it is created for is a boss or not
     */
    public RedBar(double xScale, double yScale) {
        // regular bar image
        image = new GreenfootImage("redBar.png");
        setImage(image);
        image.scale((int)(image.getWidth() * xScale), (int)(image.getHeight() * yScale));
        
    }
    
    /**
     * Method for setting the locaiton of the bar
     * 
     * @param x: x location
     * @param y: y location
     */
    public void setPos(double x, double y) {
        // has a y offset
        setLocation(x, y);
    }
}
