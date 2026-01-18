import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Represents a screen wipe effect that can move in one of four directions.
 * 
 * The effect is a colored rectangle that can slide across the screen to create
 * transitions between scenes or visual effects in the game.
 * 
 * Directions:
 * 0 - Up
 * 1 - Right
 * 2 - Down
 * 3 - Left
 * 
 * @Chase Coulter
 * @V1.0
 */
public class ScreenWipe extends Visual
{
    private int direction; // Direction of the wipe: 0 = up, 1 = right, 2 = down, 3 = left

    /**
     * Creates a ScreenWipe object with a solid colored rectangle and a specified direction.
     *
     * @param direction The direction the wipe will move (0 = up, 1 = right, 2 = down, 3 = left)
     */
    public ScreenWipe(int direction) {
        // Create a solid rectangle covering the screen
        GreenfootImage img = new GreenfootImage(1000, 600);
        img.setColor(new Color(15, 23, 61, 255));
        img.fill();
        setImage(img);

        this.direction = direction;
    }

    /**
     * Called on each act step. Moves the screen wipe in the specified direction.
     */
    public void act() {
        switch(direction) {
            case 0: // Up
                setLocation(getX(), getY() - 25);
                break;
            case 1: // Right
                move(50);
                break;
            case 2: // Down
                setLocation(getX(), getY() + 25);
                break;
            case 3: // Left
                move(-50);
                break;
            default:
                // Optional: handle invalid directions
                break;
        }
    }
}
