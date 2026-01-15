import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

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
    private static JumpSound jumpSound;
    public Cube()
    {
        cube = this;
        isGrounded = false;
        
        cubeImage();
        jumpSound = new JumpSound(5, 100);
        jumpSound.stop();
    }
    
    public void act()
    {
        if (isGrounded) roundToClosestRotation();
        
        List<TestBlock> tilesTouching = getIntersectingObjects(TestBlock.class);
        for (Tile tile : tilesTouching) {
            if (getExactY() + ScrollWorld.TILE_SIZE > tile.getExactY()) {
                setToGround(tile.getExactY() - ScrollWorld.TILE_SIZE+0.1);
            }
        }
        
        //if the y distance between the ground an the cube is small enough, set the y
        //position to the ground
        if (ScrollWorld.GROUND_HEIGHT - getExactY() < getImage().getHeight()/2 + 10)
        {
            setToGround(ScrollWorld.GROUND_HEIGHT - getImage().getHeight()/2);
        } else if (tilesTouching.size() == 0){
            isGrounded = false;
        }
        
        //Makes sure you can't hold space to "fly"
        if (Greenfoot.isKeyDown("space") && !spacePressed && isGrounded)
        {
            spacePressed = true;
            jump();
            jumpSound.play();
        }
        
        //If speed is positive, cube goes up (y-5) and if its negative cube goes down(y-(-5))
        setLocation(getExactX(), getExactY() - speedY);
        
        //keep decreasing speed while midair
        if (!isGrounded)
        {
            speedY-= 0.5; //Keep decreasing below zero so speed is negative and cube goes down
            
            //Makes sure the cube doesn't turn when initialy falling
            //Using a count variable this if statement runs 40 times for one jump
            //airtime so turn a total of 180 degrees throughout 40 acts(180/40)
            if (firstJumpMade) turn(4.5); 
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
    
    /**
     * Sets all variables necessary in order to land the cube on a platform  
     * @param yPos the y position of the platform to land on
     */
    public void setToGround(double yPos)
    {
        isGrounded = true;
        spacePressed = false;
        setLocation(getExactX(), yPos);
        speedY = 0;
        roundToClosestRotation();
    }
    
    /**
     * This method rounds to the closest degree rotation to make sure the cube does not 
     * land on a wrong angle(makes sure its flat on the ground)
     */
    private void roundToClosestRotation()
    {
        int rotation = getRotation();
        
        if (rotation < 45)
        {
            setRotation(0);
            return;
        }
        
        if (rotation < 135)
        {
            setRotation(90);
            return;
        }
        
        if (rotation < 225)
        {
            setRotation(180);
            return;
        }
        
        if (rotation < 315)
        {
            setRotation(270);
            return;
        }
        
        setRotation(0);
    }
}
