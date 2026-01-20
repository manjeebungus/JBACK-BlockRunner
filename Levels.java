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
    // 2 block2

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

        level[0][15] = 3;
        level[0][20] = 10;
        level[0][21] = 10;
        level[1][23] = 6;
        level[0][25] = 1;
        level[1][25] = 10;
        level[1][30] = 4;
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
        level[0][75] = 10;
        level[0][76] = 1;
        level[0][77] = 10;
        level[0][82] = 10;
        level[0][83] = 1;
        level[0][84] = 1;
        level[0][85] = 1;
        level[0][86] = 1;
        level[1][86] = 10;
        level[0][87] = 1;
        level[0][88] = 1;
        level[0][89] = 1;
        level[0][90] = 1;
        level[0][91] = 1;
        level[1][91] = 10;
        level[0][92] = 1;
        level[1][92] = 10;
        level[1][93] = 1;
        level[1][94] = 1;
        level[1][95] = 1;
        level[1][96] = 1;
        level[1][97] = 1;
        level[2][98] = 1;
        level[3][98] = 1;
        level[5][98] = 1;
        level[1][99] = 1;
        level[1][100] = 1;
        level[1][101] = 1;
        level[1][102] = 1;
        level[1][103] = 1;
        level[2][104] = 1;
        level[3][104] = 1;
        level[5][104] = 1;

        return level;
    }

    public static int[][] level2() {
        emptyLevel();
        level[0][15] = 10;
        level[0][21] = 10;
        level[0][22] = 10;
        level[0][30] = 10;
        level[0][31] = 1;
        level[0][32] = 10;
        level[0][33] = 10;
        level[0][34] = 10;
        level[0][35] = 1;
        level[1][35] = 1;
        level[0][36] = 10;
        level[0][37] = 10;
        level[0][38] = 10;
        level[0][39] = 1;
        level[1][39] = 1;
        level[2][39] = 1;
        
        

        return level;
    }
}
