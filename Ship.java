import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ship here.
 * 
 * @author Abithan 
 * @version (a version number or a date)
 */
public class Ship extends Player
{
    public void act()
    {
        followCube();
    }
    
    private void followCube()
    {
        double cubeX = Cube.cube.getExactX();
        double cubeY = Cube.cube.getExactY();
        
        setLocation(cubeX, cubeY);
    }
}
