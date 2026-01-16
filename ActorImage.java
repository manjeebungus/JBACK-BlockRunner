import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Empty class for when the actual object cannot be used
 * (ex.to click on images on the background or just show the image of the actor)
 * 
 * @author Abithan 
 * @version (a version number or a date)
 */
public class ActorImage extends SuperSmoothMover
{
    private String imageString;
    private int scaleX;
    private int scaleY;
    private GreenfootImage image;
    
    public ActorImage(String imageString, int scaleX, int scaleY)
    {
        this.imageString = imageString;
        this.scaleX = scaleX;
        this.scaleY = scaleY;
        
        imageToSet();
    }
    
    private void imageToSet()
    {
        image = new GreenfootImage(imageString);
        image.scale(scaleX, scaleY);
        setImage(image);
    }
}
