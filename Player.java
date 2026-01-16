import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Player here.
 * 
 * @author Kelton Kuan and Abithan
 * @version (a version number or a date)
 */
public abstract class Player extends SuperSmoothMover
{
    //Enum is a class type for fixed constants that do not allow for other values
    ///than what is inside it
    public enum Mode {
        CUBE, SHIP
    }
    
    protected static JumpSound jumpSound;

    protected boolean isGrounded = true;
    protected boolean spacePressed = false;
    protected boolean firstJumpMade = false;
    protected double speedY;
    protected GreenfootImage image;
    protected List<Tile> tilesTouching;
    protected Hitbox hitbox;
    protected Mode currentMode = Mode.CUBE;
    
    public Player() {
        hitbox = new Hitbox (this, ScrollWorld.TILE_SIZE, ScrollWorld.TILE_SIZE, 0, 0);
        
    }
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move();
        
        switch(currentMode)
        {
            case CUBE:
                //handleCubeMovement();
                break;
            case SHIP:
                //handleShipMovement();
                break;
        }

        List<Ship> shipsInWorld = ScrollWorld.getWorld().getObjects(Ship.class);
        if (Greenfoot.isKeyDown("c"))
        {
            currentMode = Mode.CUBE;

            if (!shipsInWorld.isEmpty())
            {
                ScrollWorld.getWorld().removeObject(shipsInWorld.get(0));
                ScrollWorld.getWorld().removeObject(this);
                return;
            }
        }

        if (Greenfoot.isKeyDown("s"))
        {
            currentMode = Mode.SHIP;
            if (shipsInWorld.isEmpty())
            {
                ScrollWorld.getWorld().addObject(new Ship(), getX(), getY());
                ScrollWorld.getWorld().removeObject(this);
                return;
            }
        }

        if (isGrounded) roundToClosestRotation();

        
        checkCollisions();
        spawnGroundDust();
        
        //If speed is positive, cube goes up (y-5) and if its negative cube goes down(y-(-5))
        setLocation(getExactX(), getExactY() - speedY);
    
    }
    
    protected abstract void move();
    
    protected void checkCollisions()
    {
        tilesTouching = getIntersectingObjects(Tile.class);
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
        
        List<Spike> spikes = getWorld().getObjects(Spike.class);
        
        for (Spike s : spikes)
        {
            if (hitbox.intersects(s.getHitbox()))
            {
                Greenfoot.stop(); //placeholder for death
            }
        }
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
    
    /**
     * This method rounds to the closest degree rotation to make sure the cube does not 
     * land on a wrong angle(makes sure its flat on the ground)
     */
    protected void roundToClosestRotation()
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
    
    protected void jump(double speed)
    {        
        speedY = speed;
        isGrounded = false;
        firstJumpMade = true;
    }
    
    /**
     * @Author Chase Coulter
     */
    protected void spawnGroundDust()
    {
        if (!isGrounded) return;//only run code if grounded
        ScrollWorld.getWorld().spawnParticle(200, 25, 6, 8, 30,new Color(0, 0, 0),getX()-20, getY() + 20);
    }
}
