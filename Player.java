import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;

/**
 * Abstract base class representing the player character.
 * Handles movement, gravity, collisions, interactions,
 * hitbox behavior, and death/reset logic.
 *
 * Concrete subclasses (e.g., Cube, Ship) define movement behavior.
 *
 * @author Kelton Kuan and Abithan
 * @author Brian (Hitbox interactions)
 * @version 1.0
 */
public abstract class Player extends SuperSmoothMover
{
    /** Jump sound shared by all player instances */
    protected static JumpSound jumpSound;
    protected static CubeCrashingSound cubeCrashingSound;

    /** Whether the player is currently touching the ground */
    protected boolean isGrounded = true;

    /** Tracks whether the jump key is currently pressed */
    protected boolean spacePressed = false;

    /** Whether the first jump has been made */
    protected boolean firstJumpMade = false;

    /** True if the player was removed or swapped (e.g., via portal) */
    protected boolean playerRemoved = false;
    protected boolean deathSoundPlayed = false;

    /** Vertical speed of the player */
    protected static double speedY;

    /** Player image reference */
    protected GreenfootImage image;

    /** Player hitbox used for collision detection */
    protected Hitbox hitbox;

    /** Tolerance used to distinguish lethal vs. non-lethal collisions */
    final double TOLERANCE = 20;

    /** Previous X position (used for collision resolution) */
    protected double prevX;

    /** Previous Y position (used for collision resolution) */
    protected double prevY;

    /** Whether the player is dead */
    protected boolean isDead;
    
    /**
     * Constructs a Player object and initializes
     * movement variables and the hitbox.
     */
    public Player() {
        isGrounded = true;
        speedY = 0;
        isDead = false;
        
        cubeCrashingSound = new CubeCrashingSound(5, 100);
        cubeCrashingSound.stop();
        
        hitbox = new Hitbox (this, ScrollWorld.TILE_SIZE, ScrollWorld.TILE_SIZE, 0, 0, Hitbox.HitboxType.PLAYER);
    }
    
    /**
     * Returns the player's hitbox.
     *
     * @return the player's Hitbox
     */
    public Hitbox getHitbox() { return hitbox; }
    
    /**
     * Called every frame.
     * Handles pausing, gravity, movement,
     * collision detection, and death logic.
     */
    public void act()
    {   
        if (ScrollWorld.getPause()) return;
        
        if (isDead) 
        {
            LevelSelectScreen.currentLevelSound.play();
            ScrollWorld.getWorld().resetWorld();
            return;
        }
        
        // HARD GROUND CLAMP (prevents going through the ground on mode switch)
        if (getExactY() > ScrollWorld.GROUND_HEIGHT - ScrollWorld.TILE_SIZE / 2)
        {
            setToGround(ScrollWorld.GROUND_HEIGHT - ScrollWorld.TILE_SIZE / 2);
        }
        
        prevX = getExactX();
        prevY = getExactY();
                
        //Return from act if the player was removed from collsions or other
        if (getWorld() == null) return;
        
        move();
    
        //If speed is positive, cube goes up (y-5) and if its negative cube goes down(y-(-5))
        setLocation(getExactX(), getExactY() - speedY);
        
        //checkFade();
        
        if (isGrounded) roundToClosestRotation();
        
        spawnGroundDust();
        
        checkCollisions();
    }

    
    /**
     * Defines how the player moves.
     * Implemented differently by each player mode.
     */
    protected abstract void move(); 
    
    /**
     * Checks collisions between the player and all world objects
     * and handles solid, hazard, and interactable behavior.
     */
    protected void checkCollisions()
    {
        // Get all WorldObjects with hitboxes
        ArrayList<WorldObject> objects = new ArrayList<>(getWorld().getObjects(WorldObject.class));
    
        boolean touchingSolid = false;
        
        //Iterate through world objects and interact differently based on intersecting objects
        for (WorldObject obj : objects)
        {
            Hitbox other = obj.getHitbox();
            if (other == null || !hitbox.intersects(other)) continue;
    
            switch (other.getType())
            {
                case SOLID: //Solid objects such as blocks
                    checkSolid(other);
                    touchingSolid = true;
                    break;
    
                case HAZARD: //Deadly objects
                    if (!isDead)
                    {
                        cubeCrashingSound.play();
                        deathEffect();
                        destroy();
                        LevelSelectScreen.currentLevelSound.stop();
                    }
                    break;
                
                case INTERACT:
                    checkInteraction(other, obj);
                    if (playerRemoved) return; //Some interactions remove player and swaps it out
                    break;
            }
        }
    
        //If the y distance between the ground an the cube is small enough, set the y
        //position to the ground
        if (speedY <= 0 && ScrollWorld.GROUND_HEIGHT - getExactY() < ScrollWorld.TILE_SIZE/2 + 10)
        {
            setToGround(ScrollWorld.GROUND_HEIGHT - ScrollWorld.TILE_SIZE/2);
        } else if (!touchingSolid){
            isGrounded = false;
        }
    }
    
    /**
     * Called automatically when the player is added to the world.
     * Attaches a HitboxRenderer for debugging/visualization.
     *
     * @param world the world the player was added to
     */
    @Override
    protected void addedToWorld(World world)
    {
        world.addObject(new HitboxRenderer(hitbox), getX(), getY());
    }
    
    /**
     * removeRenderer is primarily used when visible hitboxes are activated (in Hitbox class)
     * This is because of how portals work, they remove the actor and add another one,
     * so when I assign a hitbox render to it, the actor gets removed and causes an exception
     */
    public void removeRenderer() {
        World world = getWorld();
        if (world == null) return;
    
        ArrayList<HitboxRenderer> renderers = new ArrayList<>(getWorld().getObjects(HitboxRenderer.class));
        for (HitboxRenderer r : renderers) {
            if (r.getHitbox() != null && r.getHitbox().getOwner() == this) {
                world.removeObject(r);
                break;
            }
        }
    }
    
    /**
     * Handles interactions with INTERACT-type objects
     * such as portals, orbs, and pads.
     *
     * @param hit the hitbox intersecting the player
     * @param obj the world object being interacted with
     */
    protected void checkInteraction(Hitbox hit, WorldObject obj)
    {
        //Portal Interaction
        if (obj instanceof Portal) {
            ((Portal)obj).onPortalContact(this);
            playerRemoved = true; //Signals the player that it was removed and replaced
        }
        
        //Orb Interaction
        if (obj instanceof Orb)
        {
            ((Orb)obj).jumpOnClick(this);
        }
        
        //Pad Interaction
        if (obj instanceof Pad) {
            this.jump(13);
        
            // Cast the object to Pad so we can get its coordinates
            Pad pad = (Pad) obj;
            int padX = pad.getX();
            int padY = pad.getY();
        
            getWorld().addObject(new CirclePulse(200, 4, new Color(255, 255, 100), true), padX, padY+20);
            getWorld().addObject(new CirclePulse(400, 8, new Color(255, 255, 100), true), padX, padY+20);
        }
      
    }
    
    /**
     * Handles collision logic with solid tiles,
     * resolving top, bottom, and side collisions.
     *
     * @param tile the hitbox of the solid object
     */
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
                if (!isDead)
                {
                    cubeCrashingSound.play();
                    deathEffect();
                    destroy();
                    LevelSelectScreen.currentLevelSound.stop();
                }
            }
            else
            {
                return;
            }
        }
    }
    
    /**
     * Handles bottom (ceiling) collisions.
     *
     * @param txBottom bottom Y of the tile
     * @param minOverlap smallest overlap value
     * @param overlapBottom overlap from bottom
     * @return true if a fatal collision occurred
     */
    protected boolean bottomHit(double txBottom, double minOverlap, double overlapBottom) {
        // ----- BOTTOM (ceiling / head hit) -----
        if (minOverlap == overlapBottom && speedY > 0)
        {
            if (overlapBottom > TOLERANCE)
            {
                if (!isDead)
                {
                    cubeCrashingSound.play();
                    deathEffect();
                    destroy(); 
                    LevelSelectScreen.currentLevelSound.stop();
                }

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
     * Snaps the player to a ground surface and
     * resets vertical movement variables.
     *
     * @param yPos the Y-position of the ground surface
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
     * Marks the player as dead, hides the sprite,
     * and pauses the world briefly.
     */
    public void destroy() {
        isDead = true;
        getImage().setTransparency(0);
        
        ScrollWorld.setPause(60);
    }
    
    /**
     * Rounds the player's rotation to the nearest
     * right angle to ensure flat landings.
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
     * Initiates a jump by setting vertical speed
     * and updating grounded state.
     *
     * @param speed jump strength
     */
    protected void jump(double speed)
    {        
        speedY = speed;
        isGrounded = false;
        firstJumpMade = true;
    }
    
    /**
     * Spawns dust particles when the player
     * is grounded and moving.
     *
     * @author Chase Coulter
     */
    protected void spawnGroundDust()
    {
        if (!isGrounded) return;//only run code if grounded
        ScrollWorld.getWorld().spawnParticle(200, 25, 6, 8, 30,new Color(0, 0, 0),getX()-20, getY() + 20);
    }
    
    /**
     * Creates particle and pulse effects
     * when the player dies.
     *
     * @author Chase Coulter
     */
    private void deathEffect(){
        for(int i = 0; i<5; i++){
                getWorld().addObject(new Particle(Greenfoot.getRandomNumber(360), 180, 4.0 + Greenfoot.getRandomNumber(40) / 10.0, 10, 30 + Greenfoot.getRandomNumber(25), Color.BLACK  ), getX(), getY());
            }
        for(int i = 0; i<10; i++){
            getWorld().addObject(new Particle(Greenfoot.getRandomNumber(360), 180, 4.0 + Greenfoot.getRandomNumber(40) / 10.0, 10, 30 + Greenfoot.getRandomNumber(25), Color.GRAY), getX(), getY());
        }
        getWorld().addObject(new CirclePulse(200, 4, new Color(100,100,100)), getX(), getY());
        getWorld().addObject(new CirclePulse(400, 8, new Color(100,100,100)), getX(), getY());
    }



}
