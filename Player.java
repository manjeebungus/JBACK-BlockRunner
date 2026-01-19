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
    protected static JumpSound jumpSound;

    protected boolean isGrounded = true;
    protected boolean spacePressed = false;
    protected boolean firstJumpMade = false;
    protected static double speedY;
    protected GreenfootImage image;
    protected Hitbox hitbox;
    
    final double TOLERANCE = 6;
    protected double prevX;
    protected double prevY;
    
    public Player() {
        isGrounded = true;
        speedY = 0;
        
        hitbox = new Hitbox (this, ScrollWorld.TILE_SIZE, ScrollWorld.TILE_SIZE, 0, 0, Hitbox.HitboxType.PLAYER);
        
    }
    
    public Hitbox getHitbox() { return hitbox; }
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // HARD GROUND CLAMP (prevents going through the ground on mode switch)
        if (getExactY() > ScrollWorld.GROUND_HEIGHT - ScrollWorld.TILE_SIZE / 2)
        {
            setToGround(ScrollWorld.GROUND_HEIGHT - ScrollWorld.TILE_SIZE / 2);
        }
        
        prevX = getExactX();
        prevY = getExactY();
        
        checkCollisions();
        
        move();

        if (isGrounded) roundToClosestRotation();

        //If speed is positive, cube goes up (y-5) and if its negative cube goes down(y-(-5))
        setLocation(getExactX(), getExactY() - speedY);
        
        
        
        if (getWorld() == null) return;
        
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
                    Greenfoot.setWorld(new ScrollWorld()); //Respawns
                    break;
    
                case INTERACT:
                    //checkInteraction(other); //uncomment this when added
                    if (obj instanceof Portal) {
                        ((Portal)obj).onPortalContact(this);
                        return;
                    }
                    break;
            }
        }
    
        //If the y distance between the ground an the cube is small enough, set the y
        //position to the ground
        if (speedY <= 0 && ScrollWorld.GROUND_HEIGHT - getExactY() < ScrollWorld.TILE_SIZE/2 + 10)
        {
            setToGround(ScrollWorld.GROUND_HEIGHT - getImage().getHeight()/2);
        } else if (!touchingSolid){
            isGrounded = false;
        }
    }
    
    protected void checkSolid(Hitbox tile)
    {
        double pxLeft   = getExactX() - ScrollWorld.TILE_SIZE / 2;
        double pxRight  = getExactX() + ScrollWorld.TILE_SIZE / 2;
        double pxTop    = getExactY() - ScrollWorld.TILE_SIZE / 2;
        double pxBottom = getExactY() + ScrollWorld.TILE_SIZE / 2;
        
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
            setToGround(txTop - ScrollWorld.TILE_SIZE / 2);
            return;
        }
        
        // ----- BOTTOM (head hit) -----
        if (bottomHit(txBottom, minOverlap, overlapBottom)) return;
        
        // ----- LEFT / RIGHT (side hit) -----
        if (minOverlap == overlapLeft || minOverlap == overlapRight)
        {
            if (minOverlap > TOLERANCE)
            {
                Greenfoot.setWorld(new ScrollWorld());
            }
            else
            {
                return;
            }
        }
    }
    
    protected boolean bottomHit(double txBottom, double minOverlap, double overlapBottom) {
        // ----- BOTTOM (ceiling / head hit) -----
        if (minOverlap == overlapBottom && speedY > 0)
        {
            if (overlapBottom > TOLERANCE)
            {
                Greenfoot.setWorld(new ScrollWorld()); // real head collision
                return true;
            }
            else
            {
                // Small overlap → push player down instead of killing
                //setLocation(getExactX(), prevY);
                //speedY = 0;
            }
            
        }
        return false;
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
        if (this instanceof Cube) roundToClosestRotation();
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
     * @Author Chase Coulter
     */
    protected void spawnGroundDust()
    {
        if (!isGrounded) return;//only run code if grounded
        ScrollWorld.getWorld().spawnParticle(200, 25, 6, 8, 30,new Color(0, 0, 0),getX()-20, getY() + 20);
    }
}
