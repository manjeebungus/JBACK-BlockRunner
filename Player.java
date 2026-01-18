import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Player here.
 * 
 * @author Kelton Kuan and Abithan
 * Hitbox interactions by Brian
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
    protected Hitbox hitbox;
    protected Mode currentMode = Mode.CUBE;
    
    final double TOLERANCE = 6;
    protected double prevX;
    protected double prevY;
    
    public Player() {
        hitbox = new Hitbox (this, ScrollWorld.TILE_SIZE, ScrollWorld.TILE_SIZE, 0, 0, Hitbox.HitboxType.PLAYER);
        
    }
    
    public Hitbox getHitbox() { return hitbox; }
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        prevX = getExactX();
        prevY = getExactY();
        
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
            setMode(Mode.CUBE);

            if (!shipsInWorld.isEmpty())
            {
                ScrollWorld.getWorld().addObject(new Cube(), getX(), getY());
                ScrollWorld.getWorld().removeObject(this);
                return;
            }
        }

        if (Greenfoot.isKeyDown("s"))
        {
            setMode(Mode.SHIP);
            if (shipsInWorld.isEmpty())
            {
                ScrollWorld.getWorld().addObject(new Ship(), getX(), getY());
                ScrollWorld.getWorld().removeObject(this);
                return;
            }
        }

        if (isGrounded) roundToClosestRotation();

        //If speed is positive, cube goes up (y-5) and if its negative cube goes down(y-(-5))
        setLocation(getExactX(), getExactY() - speedY);
        
        checkCollisions();
        spawnGroundDust();

    }
    
    protected abstract void move();
    
    protected void checkCollisions()
    {
        // Get all WorldObjects with hitboxes
        List<WorldObject> objects = getWorld().getObjects(WorldObject.class);
    
        boolean touchingSolid = false;
    
        for (WorldObject obj : objects)
        {
            Hitbox other = obj.getHitbox();
            if (other == null || !hitbox.intersects(other)) continue;
    
            switch (other.getType())
            {
                case SOLID:
                    checkSolid(other);
                    touchingSolid = true;
                    break;
    
                case HAZARD:
                    Greenfoot.stop(); // death
                    break;
    
                case INTERACT:
                    //checkInteraction(other); //uncomment this when added
                    break;
            }
        }
    
        //If the y distance between the ground an the cube is small enough, set the y
        //position to the ground
        if (speedY <= 0 && ScrollWorld.GROUND_HEIGHT - getExactY() < getImage().getHeight()/2 + 10)
        {
            setToGround(ScrollWorld.GROUND_HEIGHT - getImage().getHeight()/2);
        } else if (!touchingSolid){
            isGrounded = false;
        }
    }
    
    protected void checkSolid(Hitbox tile)
    {
        double pxLeft   = getExactX() - getImage().getWidth() / 2;
        double pxRight  = getExactX() + getImage().getWidth() / 2;
        double pxTop    = getExactY() - getImage().getHeight() / 2;
        double pxBottom = getExactY() + getImage().getHeight() / 2;
        
        double txLeft   = tile.left();
        double txRight  = tile.right();
        double txTop    = tile.top();
        double txBottom = tile.bottom();
        
        double overlapLeft   = pxRight - txLeft;
        double overlapRight  = txRight - pxLeft;
        double overlapTop    = pxBottom - txTop;
        double overlapBottom = txBottom - pxTop;
        
        double minOverlap = Math.min(
            Math.min(overlapLeft, overlapRight),
            Math.min(overlapTop, overlapBottom)
        );
        
        // ----- TOP (landing) -----
        if (minOverlap == overlapTop && speedY < 0)
        {
            setToGround(txTop - getImage().getHeight() / 2);
            return;
        }
        
        // ----- BOTTOM (head hit) -----
        // ----- BOTTOM (ceiling / head hit) -----
        if (minOverlap == overlapBottom && speedY > 0)
        {
            if (overlapBottom > TOLERANCE)
            {
                Greenfoot.stop(); // real head collision
            }
            else
            {
                // Small overlap → push player down instead of killing
                //setLocation(getExactX(), prevY);
                //speedY = 0;
            }
            return;
        }
        
        // ----- LEFT / RIGHT (side hit) -----
        if (minOverlap == overlapLeft || minOverlap == overlapRight)
        {
            if (minOverlap > TOLERANCE)
            {
                Greenfoot.stop();
            }
            else
            {
                return;
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
    
    /**
     * Sets variables nessesary in order to jump properly
     * @param speed the jump speed/height
     */
    protected void jump(double speed)
    {        
        speedY = speed;
        isGrounded = false;
        firstJumpMade = true;
    }
    
    /**
     * Sets the current mode for the player
     * @param newMode the new mode for the cube
     */
    protected void setMode(Mode newMode)
    {
        currentMode = newMode;
        speedY = 0;

        //Makes sure cube starts upright after changing modes
        if (newMode == Mode.CUBE)
        {
            setRotation(0);
        }
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
