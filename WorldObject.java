import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Abstract base class for all objects that exist in world space
 * rather than screen space.
 *
 * WorldObjects store their position in absolute world coordinates
 * and are rendered on screen relative to the camera position.
 * This allows for smooth scrolling and large levels.
 *
 * Hitbox interaction and rendering support are included for
 * collision detection and debugging.
 *
 * @author Kelton Kuan
 * @author Brian (Hitbox interactions and rendering)
 * @version 1.0
 */
public abstract class WorldObject extends SuperSmoothMover {
    /** X position in world coordinates (pixels) */
    protected double worldX;

    /** Y position in world coordinates (pixels) */
    protected double worldY;

    /**
     * Extra margin (in pixels) outside the screen
     * before the object is hidden.
     */
    protected int preload;

    /** Hitbox associated with this world object */
    protected Hitbox hitbox;
    
    /**
     * Constructs a WorldObject at the given world position
     * with a default preload distance.
     *
     * @param x initial world X coordinate
     * @param y initial world Y coordinate
     */
    public WorldObject(double x, double y) {
        this.worldX = x;
        this.worldY = y;
        this.preload = 64;
    }
    
    /**
     * Constructs a WorldObject at the given world position
     * with a custom preload distance.
     *
     * @param x initial world X coordinate
     * @param y initial world Y coordinate
     * @param preload extra distance outside the screen
     *                before the object is hidden
     */
    public WorldObject(double x, double y, int preload) {
        this.worldX = x;
        this.worldY = y;
        this.preload = preload;
    }

    /**
     * Updates the on-screen position of the object
     * based on the camera position.
     *
     * If the object is outside the visible screen bounds
     * (plus the preload margin), it is moved off-screen
     * to improve performance.
     *
     * @param camX current camera X position
     * @param camY current camera Y position
     * @param screenWidth width of the visible screen
     * @param screenHeight height of the visible screen
     */
    public void updateScreenPosition(double camX, double camY, int screenWidth, int screenHeight) {
        
    
        double screenX = worldX - camX;
        double screenY = worldY - camY;
    
        // Expand visibility check by preload value
        if (screenX + getImage().getWidth() / 2 < -preload ||
            screenX - getImage().getWidth() / 2 > screenWidth + preload ||
            screenY + getImage().getHeight() / 2 < -preload ||
            screenY - getImage().getHeight() / 2 > screenHeight + preload) {
    
            setLocation(-100, -100); // hide off-screen
        } else {
            setLocation(screenX + getImage().getWidth() / 2,
                    screenY + getImage().getHeight() / 2);
        }
    }

    /**
     * Moves the object by the specified amount
     * in world coordinates.
     *
     * @param dx change in X position
     * @param dy change in Y position
     */
    public void moveBy(double dx, double dy) {
        worldX += dx;
        worldY += dy;
    }
    
    /**
     * Returns the object's world X coordinate.
     *
     * @return world X position
     */
    public double getWorldX() {
        return worldX;
    }
    
    /**
     * Returns the object's world Y coordinate.
     *
     * @return world Y position
     */
    public double getWorldY() {
        return worldY;
    }
    
    /**
     * Returns the hitbox associated with this object.
     *
     * @return the object's Hitbox
     */
    public Hitbox getHitbox() {
        return hitbox;
    }

}