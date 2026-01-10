import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cube here.
 * 
 * @author Abithan Paskaranathan
 * Assisted by Kelton Kuan
 * @version (a version number or a date)
 */
public class Cube extends Player
{
    public static Cube cube;
    
    private boolean isGrounded = true;
    private boolean spacePressed = false;
    private boolean firstJumpMade = false;
    private double speedY = 0;
    private GreenfootImage image;
    
    public Cube()
    {
        cube = this;
        isGrounded = false;
        
        cubeImage();
    }
    
    public void act()
    {
        //if the y distance between the ground an the cube is small enough, set the y
        //position to the ground
        if (ScrollWorld.GROUND_HEIGHT - getY() < getImage().getHeight()/2 + 10)
        {
            isGrounded = true;
            spacePressed = false;
            setLocation(getX(), ScrollWorld.GROUND_HEIGHT - getImage().getHeight()/2);
            speedY = 0;
        }
        
        //Makes sure you can't hold space to "fly"
        if (Greenfoot.isKeyDown("space") && !spacePressed)
        {
            spacePressed = true;
            jump();
        }
        
        //If speed is positive, cube goes up (y-5) and if its negative cube goes down(y-(-5))
        setLocation(getX(), getY() - speedY);
        
        //keep decreasing speed while midair
        if (!isGrounded)
        {
            speedY-= 0.5; //Keep decreasing below zero so speed is negative and cube goes down
            
            //Makes sure the cube doesn't turn when initialy falling
            if (firstJumpMade) turn(2.25); 
        }
    }
    
    private void cubeImage(){
        image = new GreenfootImage("images/Player/cubePlaceholder.png");
        image.scale(ScrollWorld.TILE_SIZE, ScrollWorld.TILE_SIZE);
        setImage(image);
    }
    
    private void jump()
    {        
        speedY = 10;
        isGrounded = false;
        firstJumpMade = true;
    }
}
