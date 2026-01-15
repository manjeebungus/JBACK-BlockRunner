/**
 * Write a description of class Levels here.
 * 
 * @author Kelton Kuan
 * @version (a version number or a date)
 */
public class Levels  
{
    // Tile meanings for now:
    // 0 blank tile
    // 1 test block
    
    private static int levelRows = 20;
    private static int levelCols = 200;
    private static int[][] level;
    
    private static void emptyLevel() {
        level = new int[levelRows][levelCols];
    }
    
    public static int[][] level1() {
        emptyLevel();
        
        level[0][20] = 1;
        
        return level;
    }
}
