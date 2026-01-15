import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class TestBlock here.
 * 
 * @author Kelton Kuan
 * @version (a version number or a date)
 */
public class ScrollWorld extends World {
    private static ScrollWorld world;
    private Player player;
    
    public static final int TILE_SIZE = 48;
    public static int rows = 20;
    public static int cols = 200;
    public static final int SCREEN_WIDTH = 1000;
    public static final int SCREEN_HEIGHT = 600;
    public static final int GROUND_OFFSET = 200;
    public static final int GROUND_HEIGHT = ScrollWorld.SCREEN_HEIGHT - ScrollWorld.GROUND_OFFSET + ScrollWorld.TILE_SIZE;

    private WorldObject[][] grid;
    private double camX = 0;
    private double camY = 0;
    private final double SCROLL_SPEED = 5.5;
    private double scrollMultiplier = 1.00;
    private final double SPRINT_SPEED = 1.75;
    
    private int[][] objects;

    public ScrollWorld() {
        super(SCREEN_WIDTH, SCREEN_HEIGHT, 1, false);
        
        world = this;
        
        Greenfoot.setSpeed(50);
        
        int[][] level = Levels.level1();
        objects = level;
        
        rows = objects.length;
        cols = objects[0].length;
        
        grid = new WorldObject[rows][cols];
        
        // Create all tiles
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                WorldObject worldObject = null;
                
                switch (objects[r][c]) {
                    // blocks
                    case 1:
                        worldObject = new TestBlock(r, c);
                        break;
                    // spikes
                    case 10:
                        worldObject = new Spike(r, c);
                        break;
                    default:
                        //worldObject = new Tile(r, c);
                        break;
                }
                
                grid[r][c] = worldObject;
                if (worldObject != null) addObject(worldObject, -100, -100); // initially hide
            }
        }

        // The tile at (0,0) is part of the grid and will appear naturally
        
        player = new Cube();
        addObject(player, 200, 300);
        
        GreenfootImage ground = new GreenfootImage(SCREEN_WIDTH, 4);
        ground.setColor(new Color(0,0,0));
        ground.fill();
        getBackground().drawImage(ground, 0, GROUND_HEIGHT);
        
        int startRow = 5;
        int startCol = 5;
        
        int startX = startCol * TILE_SIZE;
        int startY = startRow * TILE_SIZE;
        
        //addObject(player, -100, -100); // will be placed correctly by updateScreenPosition
    }

    public void act() {
        handleSprintKey();
        autoScroll();
        updateWorldObjects();
    }
    
    private void handleSprintKey() {
        if (Greenfoot.isKeyDown("shift")) {
            scrollMultiplier = SPRINT_SPEED;
        } else {
            scrollMultiplier = 1.00;
        }
    }

    private void autoScroll() {
        camX += SCROLL_SPEED * scrollMultiplier;
    
        // Clamp camera so it doesn't go past world
        camX = Math.min(camX, cols * TILE_SIZE - SCREEN_WIDTH);
        int groundRow = rows - 1;
        int groundWorldY = groundRow * TILE_SIZE;
        
        camY = groundWorldY - (SCREEN_HEIGHT - GROUND_OFFSET);
    }

    private void updateWorldObjects() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] != null) {
                    grid[r][c].updateScreenPosition(camX, camY, SCREEN_WIDTH, SCREEN_HEIGHT);
                }
            }
        }
    }
    
    public static ScrollWorld getWorld() {
        return world;
    }
}