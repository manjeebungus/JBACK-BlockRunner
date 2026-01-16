/**
 * Write a description of class Levels here.
 * 
 * @author Kelton Kuan
 * @version (a version number or a date)
 */
public class Levels  
{
    // Tile ids for now:
    // 0 blank tile
    // 1 test block
    
    // Spike ids for now:
    // 10 placeholder
    
    private static int levelRows = 20;
    private static int levelCols = 200;
    private static int[][] level;
    
    private static void emptyLevel() {
        level = new int[levelRows][levelCols];
    }
    
    public static int[][] levelTest() {
        emptyLevel();
        level[0][20] = 10;
        level[0][21] = 10;
        level[0][25] = 1;
        level[1][25] = 10;
        level[0][34] = 10;
        level[0][35] = 1;
        level[0][38] = 1;
        level[1][38] = 1;
        return level;
    }
    
    public static int[][] level1() {
        emptyLevel();
        level[0][20] = 1;
        level[0][21] = 1;
        level[0][22] = 10;
        
        level[0][31] = 10;
        level[0][32] = 1;
        level[0][36] = 1;
        level[1][36] = 1;
        
        
        return level;
    }
}
