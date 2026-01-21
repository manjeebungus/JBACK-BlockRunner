import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class TestBlock here.
 * 
 * @author Kelton Kuan
 * @version (a version number or a date)
 * 
 * @assisted Chase Coulter
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
    
    private static String background, glow;
    private static String grnd1,grnd2;
    private static Ground ground1, ground2;
    
    private static boolean isPaused;
    private static int pauseActs;
    
    private boolean hPreviouslyDown = false; //Meant for hitbox visibility toggle

    public ScrollWorld(int[][] level) {
        super(SCREEN_WIDTH, SCREEN_HEIGHT, 1, false);
        isPaused = false;
        pauseActs = 0;
        
        setEnvironment(background, grnd1, grnd2, glow);
        
        if (background == null) background = "baseLine/background.png";
        addObject(new StaticImage(background),500,300);
        
        if (grnd1 == null) grnd1 = "baseLine/foreground.png";
        if (grnd2 == null) grnd2 = "baseLine/foreground.png";
        ground1 = new Ground(grnd1, 0);
        ground2 = new Ground(grnd2, 1000);
        addObject(ground1,500,300);
        addObject(ground2,1500,300);
        
        if (glow == null) glow = "baseLine/glow.png";
        addObject(new StaticImage(glow),500,329);
        world = this;
        
        Greenfoot.setSpeed(52);
        scrollMultiplier = 1.00;

        //level = Levels.level1();

        //level = Levels.level2();
 
        objects = level;
        
        rows = objects.length;
        cols = objects[0].length;
        
        grid = new WorldObject[rows][cols];
        
        // Create all tiles
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                WorldObject worldObject = null;
                
                switch (objects[r][c]) {
                    //Blocks
                    case 1:
                        worldObject = new TestBlock(r, c);
                        break;
                    case 2:
                        worldObject = new Block2(r, c);
                        break;
                    case 3:
                        worldObject = new Block3(r, c);
                        break;
                    //Portals
                    case 20:
                        worldObject = new ShipPortal(r, c);
                        break;
                    case 21:
                        worldObject = new CubePortal(r, c);
                        break;
                    //Pad
                    case 5:
                        worldObject = new Pad(r, c);
                        break;
                    //Orbs
                    case 6:
                        worldObject = new JumpOrb(r, c);
                        break;
                    //Spikes
                    case 10:
                        worldObject = new Spike1(r, c);
                        break;
                    case 11:
                        worldObject = new Spike2(r, c);
                        break;
                    case 12:
                        worldObject = new Spike3(r, c);
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
        
        int groundRow = rows - 1;
        int groundWorldY = groundRow * TILE_SIZE;
        camY = groundWorldY - (SCREEN_HEIGHT - GROUND_OFFSET);
        
        //addObject(player, -100, -100); // will be placed correctly by updateScreenPosition
        
        // Hitboxes always on top
        setPaintOrder(HitboxRenderer.class);
        
        addObject(new ScreenFadeIn(5, Color.BLACK), 500, 300);
    }
    
    public void act() {
        if (pauseActs <= 0) {
            isPaused = false;
        }
        
        if (!isPaused) {
            autoScroll(); // horizontal scrolling
            updateWorldObjects();
        }
        
        pauseActs--;
        
        handleHitboxToggle();
    }
    
    public void started()
    {
        if (LevelSelectScreen.currentLevelSound != null) {
            LevelSelectScreen.currentLevelSound.playLoop();
        }
    }
    
    public void stopped()
    {
        if (LevelSelectScreen.currentLevelSound != null) {
            LevelSelectScreen.currentLevelSound.pause();
        }
    }
    
    private void autoScroll() {
        camX += SCROLL_SPEED * scrollMultiplier;
    
        // Clamp camera so it doesn't go past world
        camX = Math.min(camX, cols * TILE_SIZE - SCREEN_WIDTH);
        
        
        //camY = groundWorldY - (SCREEN_HEIGHT - GROUND_OFFSET);
    }
    
    private void updateWorldObjects() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] != null) {
                    grid[r][c].updateScreenPosition(camX, camY, SCREEN_WIDTH, SCREEN_HEIGHT);
                }
            }
        }
        ground1.updateScreenPosition(camX, camY, SCREEN_WIDTH, SCREEN_HEIGHT);
        ground2.updateScreenPosition(camX, camY, SCREEN_WIDTH, SCREEN_HEIGHT);
    }
    
    //Press h to toggle visible hitboxes, used for testing and serious players
    private void handleHitboxToggle()
    {
        boolean hDown = Greenfoot.isKeyDown("h");
    
        if (hDown && !hPreviouslyDown)
        {
            Hitbox.setBoxVisible(!Hitbox.isBoxVisible());
        }
    
        hPreviouslyDown = hDown;
    }
    
    /**
     * @Author Chase Coulter
     */
    public void spawnParticle(int direction,int spread,double speed,int size,int life,Color color,int x, int y)
    {
        addObject(new Particle(direction,spread,speed,size,life,color),x, y);
    }
    
    public void resetWorld() {
        Greenfoot.setWorld(new ScrollWorld(objects));
    }
    
    public void moveCameraY(double amount) {
        camY += amount;
    }
    
    public double getCameraY() {
        return camY;
    }
    
    public static ScrollWorld getWorld() {
        return world;
    }
    
    public static boolean getPause() {
        return isPaused;
    }
    
    public static void setPause(int acts) {
        isPaused = true;
        pauseActs = acts;
    }
    
    public static void setEnvironment(String bg, String g1, String g2, String g) {
        background = bg;
        grnd1 = g1;
        grnd2 = g2;
        glow = g;
    }
}