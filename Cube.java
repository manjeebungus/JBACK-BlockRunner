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
    
    private static String cubeImageString = "images/Player/cube1.png";
    
    public Cube()
    {
        super();
        
        cube = this;
        isGrounded = false;
        speedY = 0;
        currentMode = Mode.CUBE;

        cubeImage();
        jumpSound = new JumpSound(5, 60);
        jumpSound.stop();
    }
    
    public void act() {
        super.act();
        cubeImage();
    }

    protected void move()
    {
        //Makes sure you can't hold space to "fly"
        if (Greenfoot.isKeyDown("space") && !spacePressed && isGrounded)
        {
            spacePressed = true;
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

    private void cubeImage(){
        image = new GreenfootImage(cubeImageString);
        image.scale(ScrollWorld.TILE_SIZE, ScrollWorld.TILE_SIZE);
        setImage(image);
    }

    public static String getImageString()
    {
        return cubeImageString;
    }

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
