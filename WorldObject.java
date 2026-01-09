import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WorldObject here.
 * 
 * @author Kelton Kuan
 * @version (a version number or a date)
 */
public abstract class WorldObject extends SuperSmoothMover {

    // World coordinates (pixels)
    protected double worldX;
    protected double worldY;

    public WorldObject(double x, double y) {
        this.worldX = x;
        this.worldY = y;
    }

    // Update screen position based on camera
    public void updateScreenPosition(double camX, double camY, int screenWidth, int screenHeight) {
        int preload = 64; // load tiles earlier
    
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

    // Move in world coordinates
    public void moveBy(double dx, double dy) {
        worldX += dx;
        worldY += dy;
    }

    public double getWorldX() {
        return worldX;
    }

    public double getWorldY() {
        return worldY;
    }

}