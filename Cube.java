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
    //Enum is a class type for fixed constants that do not allow for other values
    ///than what is inside it
    public enum Mode {
        CUBE, SHIP
    }

    public static Cube cube;

    private static JumpSound jumpSound;

    private boolean isGrounded = true;
    private boolean spacePressed = false;
    private boolean firstJumpMade = false;
    private double speedY;
    private GreenfootImage image;
    private List<TestBlock> tilesTouching;
    private Mode currentMode = Mode.CUBE;

    public Cube()
    {
        cube = this;
        isGrounded = false;
        speedY = 0;
        currentMode = Mode.CUBE;

        cubeImage();
        jumpSound = new JumpSound(5, 100);
        jumpSound.stop();
    }

    public void act()
    {
        switch(currentMode)
        {
            case CUBE:
                handleCubeMovement();
                break;
            case SHIP:
                handleShipMovement();
                break;
        }

        List<Ship> shipsInWorld = ScrollWorld.getWorld().getObjects(Ship.class);
        if (Greenfoot.isKeyDown("c"))
        {
            currentMode = Mode.CUBE;

            if (!shipsInWorld.isEmpty())
            {
                ScrollWorld.getWorld().removeObject(shipsInWorld.getFirst());
            }
        }

        if (Greenfoot.isKeyDown("s"))
        {
            currentMode = Mode.SHIP;
            if (shipsInWorld.isEmpty())
            {
                ScrollWorld.getWorld().addObject(new Ship(), getX(), getY());
            }
        }

        if (isGrounded) roundToClosestRotation();

        
        checkCollsions();
        spawnGroundDust();
    }

    private void checkCollsions()
    {
        tilesTouching = getIntersectingObjects(TestBlock.class);
        for (Tile tile : tilesTouching) {
            if (speedY <= 0 && getExactY() + ScrollWorld.TILE_SIZE > tile.getExactY()) {
                setToGround(tile.getExactY() - ScrollWorld.TILE_SIZE+2);
            }
        }

        //If the y distance between the ground an the cube is small enough, set the y
        //position to the ground
        if (speedY <= 0 && ScrollWorld.GROUND_HEIGHT - getExactY() < getImage().getHeight()/2 + 10)
        {
            setToGround(ScrollWorld.GROUND_HEIGHT - getImage().getHeight()/2);
        } else if (tilesTouching.size() == 0){
            isGrounded = false;
        }
    }

    private void handleCubeMovement()
    {
        //Makes sure you can't hold space to "fly"
        if (Greenfoot.isKeyDown("space") && !spacePressed && isGrounded)
        {
            spacePressed = true;
            jumpSound.play();
            jump();
            for(int i = 0; i<10;i++){
                spawnJumpParticles();
            }
        }
        //If speed is positive, cube goes up (y-5) and if its negative cube goes down(y-(-5))
        setLocation(getExactX(), getExactY() - speedY);

        //keep decreasing speed while midair
        if (!isGrounded)
        {
            speedY-= 0.5; //Acts like gravity

            //Makes sure the cube doesn't turn when initialy falling
            //Using a count variable this if statement runs 40 times for one jump
            //airtime so turn a total of 180 degrees throughout 40 acts(180/40)
            if (firstJumpMade && tilesTouching.size() == 0) turn(4.5); 
        }
    }

    private void handleShipMovement()
    {
        if (Greenfoot.isKeyDown("space"))
        {
            speedY += 1.0;
        }
        else
        {
            speedY += -1.0;
        }

        if (speedY > 6) speedY = 6;
        if (speedY < -6) speedY = -6;

        setLocation(getExactX(), getExactY() - speedY);

        if (speedY > 0) isGrounded = false;
    }

    private void cubeImage(){
        image = new GreenfootImage("images/Player/cube1.png");
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
        if (currentMode == Mode.CUBE) roundToClosestRotation();
    }

    public void setMode(Mode newMode)
    {
        currentMode = newMode;
        speedY = 0;

        //Makes sure cube starts upright
        if (newMode == Mode.CUBE)
        {
            setRotation(0);
        }
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

    /**
     * @Author Chase Coulter
     */
    private void spawnGroundDust()
    {
        if (!isGrounded) return;//only run code if grounded
        ScrollWorld.getWorld().spawnParticle(200, 25, 6, 8, 30,new Color(0, 0, 0),getX()-20, getY() + 20);
    }

    private void spawnJumpParticles() {
        if (isGrounded) return;

        ScrollWorld world = ScrollWorld.getWorld();
        int baseX = getX();
        int baseY = getY();
        int direction = 90;
        int spread = 30;
        double speed = 2.0 + Greenfoot.getRandomNumber(4);
        int size = 12;
        int life = 30 + Greenfoot.getRandomNumber(20) - 5;
        Color color = new Color(200, 200, 200);
        world.spawnParticle(direction, spread, speed, size, life, color, baseX - 20, baseY + 20);
    }
}
