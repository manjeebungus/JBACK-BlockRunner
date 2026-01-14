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
    public static int ROWS = 20;
    public static int COLS = 200;
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
    
    private int[][] objects = new int[ROWS][COLS];

    public ScrollWorld() {
        super(SCREEN_WIDTH, SCREEN_HEIGHT, 1, false);
        
        world = this;
        
        grid = new WorldObject[ROWS][COLS];
        
        objects[0][20] = 1;
        objects[1][20] = 1;
        
        objects[0][30] = 1;
        objects[0][31] = 1;
        objects[0][36] = 1;
        
        objects[0][42] = 1;
        objects[1][42] = 1;
        objects[0][43] = 1;
        objects[0][44] = 1;
        
        // Create all tiles
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                WorldObject worldObject = null;
                if (objects[r][c] != 0) {
                    worldObject = new TestBlock(r, c);
                } else {
                    worldObject = new Tile(r, c);
                }
                grid[r][c] = worldObject;
                if (worldObject != null) addObject(worldObject, -100, -100); // initially hide
            }
        }

        // The tile at (0,0) is part of the grid and will appear naturally
        
        Cube.cube = new Cube();
        addObject(Cube.cube, 200, 300);
        
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
        camX = Math.min(camX, COLS * TILE_SIZE - SCREEN_WIDTH);
        int groundRow = ROWS - 1;
        int groundWorldY = groundRow * TILE_SIZE;
        
        camY = groundWorldY - (SCREEN_HEIGHT - GROUND_OFFSET);
    }

    private void updateWorldObjects() {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
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