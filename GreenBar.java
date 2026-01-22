import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Green bar - used for health bars for enemies
 * 
 * @author Kelton
 * @version
 */
public class GreenBar extends SuperSmoothMover
{
    // image for the bar
    private GreenfootImage image;
    
    // how wide to originally start with
    private int startWidth;
    
    /**
     * Constructor for a green bar
     * 
     * @param xScale: horizontal scale
     * @param yScale: vertical scale
     */
    public GreenBar(double xScale, double yScale) {
        image = new GreenfootImage("greenBar.png");
        setImage(image);
        image.scale((int)(image.getWidth() * xScale), (int)(image.getHeight() * yScale));
        
        // sets start width to max size
        startWidth = image.getWidth();
    }
    
    /**
     * Changes the position and percentage of the green bar
     * 
     * @param x: new x location
     * @param y: new y location
     * @param percentage: new percentage of the bar
     */
    public void setPos(double x, double y, double percentage) {
        // removes if the percentage reaches 0
        if (percentage <= 0) {
            setLocation(x-startWidth/2, y);
            image.scale(1, image.getHeight());
            return;
        }
        
        // changes location
        setLocation(x - (int)startWidth*Math.max(0, (1-percentage))/2, y);
        
        // new scale
        image.scale(Math.max(1, Math.min(startWidth, (int)(startWidth*percentage))), image.getHeight());
    }
}

