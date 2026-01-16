import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ship here.
 * 
 * @author Abithan 
 * @version (a version number or a date)
 */
public class Ship extends Player
{
    private GreenfootImage image;
    
    public void act()
    {
        followCube();
        
        shipImage();
    }

    private void shipImage()
    {
        image = new GreenfootImage("images/Player/ship1.png");
        image.scale(120, 100);
        setImage(image);
    }
    
    private void followCube()
    {
        double cubeX = Cube.cube.getExactX();
        double cubeY = Cube.cube.getExactY();
        
        setLocation(cubeX - 12, cubeY + 24);
        setRotation(Cube.cube.getPreciseRotation());
    }
}
