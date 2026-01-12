import greenfoot.*;

/**
 * Write a description of class TestBlock here.
 * 
 * @author Kelton Kuan
 * @version (a version number or a date)
 */
public class Tile extends WorldObject {
    private static final Color borderColor = new Color(30, 30, 30, 30);
    
    public Tile(double row, double col) {
        super(col * ScrollWorld.TILE_SIZE, (ScrollWorld.ROWS-row-1) * ScrollWorld.TILE_SIZE);
        
        // Ask region for the color
        Color tileColor = new Color(150, 150, 150);

        // Draw tile
        GreenfootImage img = new GreenfootImage(ScrollWorld.TILE_SIZE, ScrollWorld.TILE_SIZE);
        img.setColor(tileColor);
        img.fillRect(0, 0, ScrollWorld.TILE_SIZE, ScrollWorld.TILE_SIZE);

        img.setColor(borderColor);
        img.drawRect(0, 0, ScrollWorld.TILE_SIZE - 1, ScrollWorld.TILE_SIZE - 1);

        setImage(img);
    }
    
    public Tile (double row, double col, GreenfootImage image) {
        super(col * ScrollWorld.TILE_SIZE, (ScrollWorld.ROWS-row-1) * ScrollWorld.TILE_SIZE);
        
        image.scale(ScrollWorld.TILE_SIZE, ScrollWorld.TILE_SIZE);
        
        setImage(image);
    }
}