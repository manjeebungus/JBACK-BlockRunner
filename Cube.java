import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * The default player mode represented as a cube.
 * The cube can jump, rotate while airborne, and is
 * affected by gravity.
 *
 * This class defines the standard movement behavior
 * used in most levels.
 *
 * @author Abithan Paskaranathan
 * @author Kelton Kuan (assistance)
 * @version 1.0
 */
public class Cube extends Player
{
    /** Static reference to the active Cube instance */
    public static Cube cube;
    
    /**
     * Constructs a Cube player.
     * Initializes the cube image, jump sound,
     * and sets this instance as the active cube.
     */
    public Cube()
    {
        super();
        cube = this;
        //isGrounded = false;
        //speedY = 0;

        cubeImage();
        
        jumpSound = new JumpSound(5, 100);
        jumpSound.stop();
    }
    
    /**
     * Handles cube-specific movement logic.
     * Allows jumping when grounded and applies
     * gravity and rotation while airborne.
     */
    protected void move()
    {
        //Only allows for jumps only if the first jump has finished meaning the player is grounded
        if (Greenfoot.isKeyDown("space") && !spacePressed && isGrounded)
        {
            spacePressed = true; //Prevents the holding of space(flying)
            jumpSound.play();
            jump(9);
            for(int i = 0; i<10;i++){
                spawnJumpParticles();
            }
        }

        //keep decreasing speed while midair
        if (!isGrounded)
        {
            speedY-= 0.42; //Acts like gravity

            //Makes sure the cube doesn't turn when initialy falling
            //Using a count variable this if statement runs 40 times for one jump
            //airtime so turn a total of 180 degrees throughout 40 acts(180/40)
            if (firstJumpMade && !isGrounded) turn(4.5); 
        }
    }
    
    /**
     * Loads, scales, and applies the cube image
     * to the player.
     */
    private void cubeImage(){
        image = new GreenfootImage("images/Player/cube1.png");
        image.scale(ScrollWorld.TILE_SIZE, ScrollWorld.TILE_SIZE);
        setImage(image);
    }
    
    /**
     * Spawns particle effects when the cube jumps.
     * Particles originate from the bottom of the cube
     * to simulate a jump impulse.
     */
    private void spawnJumpParticles()
    {
        if (isGrounded) return;

        ScrollWorld world = ScrollWorld.getWorld();
        int baseX = getX();
        int baseY = getY();
        int direction = 130;
        int spread = 30;
        double speed = 2.0 + Greenfoot.getRandomNumber(4);
        int size = 12;
        int life = 30 + Greenfoot.getRandomNumber(20) - 5;
        Color color = new Color(200, 200, 200);
        world.spawnParticle(direction, spread, speed, size, life, color, baseX - 20, baseY + 20);
    }
}
