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
        level[0][20] = 1;
        level[0][21] = 1;
        level[0][22] = 10;

        level[0][31] = 10;
        level[0][32] = 1;
        level[0][36] = 1;
        level[1][36] = 1;
        return level;
    }

    public static int[][] level1() {
        emptyLevel();

        level[0][20] = 10;
        level[0][21] = 10;
        level[0][25] = 1;
        level[1][25] = 10;
        level[0][34] = 10;
        level[0][35] = 1;
        level[0][38] = 1;
        level[1][38] = 1;
        level[1][45] = 1;
        level[2][49] = 1;
        level[3][53] = 1;
        level[4][57] = 1;
        level[5][61] = 1;
        level[6][65] = 1;
        level[0][46] = 10;
        level[0][47] = 10;
        level[0][48] = 10;
        level[0][49] = 10;
        level[0][50] = 10;
        level[0][51] = 10;
        level[0][52] = 10;
        level[0][53] = 10;
        level[0][54] = 10;
        level[0][55] = 10;
        level[0][56] = 10;
        level[0][57] = 10;
        level[0][58] = 10;
        level[0][59] = 10;
        level[0][60] = 10;
        level[0][61] = 10;
        level[7][65] = 10;
        level[3][75] = 1;
        level[3][76] = 1;
        level[3][77] = 1;
        level[3][78] = 1;
        level[3][79] = 1;
        level[3][80] = 1;
        level[3][81] = 1;
        level[3][82] = 1;
        level[3][83] = 1;
        level[3][84] = 1;
        level[3][85] = 1;
        level[3][86] = 1;
        level[3][87] = 1;
        level[3][88] = 1;
        level[3][89] = 1;
        level[3][90] = 1;
        
        level[4][79] = 10;
        level[4][80] = 10;
        level[4][84] = 10;
        level[4][85] = 10;
        level[4][86] = 10;
        level[0][79] = 10;
        level[0][82] = 10;
        level[0][83] = 10;
        
        return level;
    }
}
