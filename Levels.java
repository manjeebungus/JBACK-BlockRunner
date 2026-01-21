/**
 * Write a description of class Levels here.
 * 
 * @author Kelton Kuan
 * @version (a version number or a date)
 */
public class Levels  
{
    /**
     * Tile ids for now:
     * 0 blank tile
     * 1 test block
     * 2 block2
     * 3 ship portal
     * 4 cube portal
     * 5 jump pad
     * 6 jump orb
     * 
     *
     * Spike ids for now:
     * 10 placeholder
     */

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
        level[1][23] = 6;
        level[0][25] = 1;
        level[1][25] = 10;
        level[0][34] = 10;
        level[0][35] = 1;
        level[0][38] = 1;
        level[1][38] = 1;
        level[0][43] = 5;
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
        level[0][86] = 10;
        level[0][87] = 1;
        level[0][88] = 1;
        level[0][89] = 1;
        level[0][90] = 1;
        level[1][90] = 10;
        level[0][91] = 1;
        level[0][92] = 1;
        level[0][93] = 1;
        level[0][94] = 1;
        level[0][95] = 1;
        level[1][95] = 10;
        level[0][96] = 1;
        level[1][96] = 10;
        level[1][97] = 1;
        level[1][98] = 1;
        level[1][99] = 1;
        level[1][101] = 1;
        level[1][101] = 1;
        level[2][102] = 1;
        level[3][102] = 1;
        level[5][102] = 1;
        level[1][103] = 1;
        level[1][104] = 1;
        level[1][105] = 1;
        level[1][106] = 1;
        level[1][107] = 1;
        level[2][108] = 1;
        level[3][108] = 1;
        level[5][108] = 1;
        level[1][111] = 1;
        level[1][112] = 1;
        level[1][113] = 1;
        level[3][113] = 3;
        level[5][119] = 1;
        level[3][121] = 1;
        level[7][123] = 1;
        level[1][125] = 1;
        level[6][127] = 1;
        level[8][130] = 1;
        level[3][133] = 1;
        level[9][137] = 1;
        level[1][139] = 1;
        level[8][142] = 1;
        level[6][145] = 1;
        level[3][148] = 1;
        level[8][152] = 1;
        level[1][155] = 1;
        level[0][158] = 1;
        level[1][158] = 1;
        level[2][158] = 1;
        level[3][158] = 1;
        level[4][158] = 1;
        level[5][158] = 1;
        level[0][162] = 1;
        level[1][165] = 1;
        level[5][168] = 1;
        level[8][171] = 1;
        return level;
    }
    public static int[][] level2(){
        
        
        
        
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
        for(int i = 50; i <= 76; i++){
            level[0][i] = 10;
        }
        level[1][48] = 1;
        level[2][52] = 1;
        level[3][56] = 1;
        level[4][60] = 1;
        level[5][64] = 1;
        level[5][67] = 6;
        level[4][72] = 1;
        level[4][73] = 1;
        level[3][77] = 1;
        level[2][79] = 1;
        level[1][82] = 1;
        for(int i = 3 ; i <= 6; i++){
            level[i][85] = 1;
        }
        level[1][85] = 3;
        for(int i = 85 ; i <= 190; i++){
            level[7][i] = 1;
        }
        for(int i = 0; i <= 4; i++){
            level[i][105] = 1;
        }
        for(int i = 0; i <= 4; i++){
            level[i][125] = 1;
        }
        for(int i = 0; i <= 4; i++){
            level[i][145] = 1;
        }
        for(int i = 0; i <= 4; i++){
            level[i][165] = 1;
        }
        for(int i = 0; i <= 4; i++){
            level[i][185] = 1;
        }

        return level;
    }
    public static int[][] level3() {
        emptyLevel();
        level[0][15] = 10;
        level[0][21] = 10;
        level[0][22] = 10;
        level[0][28] = 10;
        level[0][29] = 10;
        level[0][30] = 1;
        level[0][31] = 1;
        level[1][31] = 10;
        level[0][39] = 10;
        level[0][40] = 1;
        level[1][40] = 1;
        level[2][44] = 1;
        for(int i = 44; i <= 54; i++){
            level[2][i] = 1;
        }
        level[3][50] = 10;
        level[3][54] = 1;
        level[0][57] = 10;
        level[0][65] = 1;
        level[1][69] = 1;
        level[2][73] = 1;
        level[3][77] = 1;
        for(int i = 77; i <= 84; i++){
            level[3][i] = 1;
        }
        for(int i = 0; i <= 4; i++){
            level[i][88] = 1;
        }
        level[0][91] = 10;
        level[0][92] = 10;
        level[0][100] = 1;
        level[1][104] = 1;
        level[2][108] = 1;
        level[3][112] = 1;
        level[4][116] = 1;
        level[5][120] = 1;
        for(int i = 102; i <= 118; i++){
            level[0][i] = 10;
        }
        level[7][120] = 3;
        for(int i = 0; i <= 4; i++){
            level[i][137] = 1;
        }
        for(int i = 9; i > 7; i--){
            level[i][137] = 1;
        }
        //first pillar
        for(int i = 0; i <= 2; i++){
            level[i][157] = 1;
        }
        for(int i = 9; i >= 6; i--){
            level[i][157] = 1;
        }
        //second pillar
        for(int i = 0; i <= 3; i++){
            level[i][177] = 1;
        }
        for(int i = 9; i >= 7; i--){
            level[i][177] = 1;
        }
        for(int i = 0; i <= 3; i++){
            level[i][190] = 1;
        }
        return level;
    }
}
