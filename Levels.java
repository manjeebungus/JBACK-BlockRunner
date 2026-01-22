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
     * 3 block3
     * 20 ship portal
     * 21 cube portal
     * 5 jump pad
     * 6 jump orb
     * 
     *
     * Spike ids for now:
     * 10 baseline
     * 11 baseline vertically flipped
     * 12 frostbyte
     * 13 frostbyte vertically flipped
     * 14 drift
     * 15 drift vertically flipped
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
        ScrollWorld.setEnvironment(
            "baseLine/background.png",
            "baseLine/foreground.png",
            "baseLine/foreground.png",
            "baseLine/glow.png"
        );
        
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
        level[3][113] = 20;
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
        level[1][169] = 21;
        level[8][171] = 1;
        level[2][172] = 1;
        level[3][172] = 10;
        level[2][173] = 1;
        level[3][173] = 10;
        level[2][174] = 1;
        level[3][174] = 10;
        level[0][176] = 5;
        level[4][176] = 11;
        level[5][176] = 1;
        level[2][179] = 1;
        level[3][179] = 10;
        level[3][180] = 10;
        level[2][180] = 1;
        level[2][181] = 1;
        level[2][182] = 1;
        level[2][183] = 1;
        
        return level;
    }
    public static int[][] level2(){
        emptyLevel();
        ScrollWorld.setEnvironment(
            "frostByte/background.png",
            "frostByte/foreground.png",
            "frostByte/foreground.png",
            "frostByte/glow.png"
        );
        
        level[0][15] = 12;
        level[0][21] = 12;
        level[0][22] = 12;
        level[0][30] = 12;
        level[0][31] = 2;
        level[0][32] = 12;
        level[0][33] = 12;
        level[0][34] = 12;
        level[0][35] = 2;
        level[1][35] = 2;
        level[0][36] = 12;
        level[0][37] = 12;
        level[0][38] = 12;
        level[0][39] = 2;
        level[1][39] = 2;
        level[2][39] = 2;
        for(int i = 50; i <= 76; i++){
            level[0][i] = 12;
        }
        level[1][48] = 2;
        level[2][52] = 2;
        level[3][56] = 2;
        level[4][60] = 2;
        level[5][64] = 2;
        level[5][67] = 6;
        level[4][72] = 2;
        level[4][73] = 2;
        level[3][77] = 2;
        level[0][77] = 5;
        level[2][79] = 2;
        level[1][82] = 2;
        for(int i = 3 ; i <= 6; i++){
            level[i][85] = 2;
        }
        level[1][85] = 20;
        for(int i = 85 ; i <= 190; i++){
            level[7][i] = 2;
        }
        
        level[5][92] = 2;
        level[4][92] = 13;
        level[5][93] = 2;
        level[4][93] = 13;
        level[5][94] = 2;
        level[4][94] = 13;
        
        level[0][98] = 2;
        level[1][98] = 12;
        level[0][99] = 2;
        level[1][99] = 12;
        level[0][100] = 2;
        level[1][100] = 12; 
        
        //Ship Pillars
        for(int i = 0; i <= 4; i++){
            level[i][105] = 2;
        }
        
        level[0][112] = 2;
        level[1][112] = 12;
        level[0][113] = 2;
        level[1][113] = 12;
        level[0][114] = 2;
        level[1][114] = 12; 
        
        level[5][116] = 2;
        level[4][116] = 13;
        level[5][117] = 2;
        level[4][117] = 13;
        level[5][118] = 2;
        level[4][118] = 13;
        
        for(int i = 0; i <= 4; i++){
            level[i][125] = 2;
        }
        
        //Below spike and blocks
        level[0][134] = 2;
        level[1][134] = 12;
        level[0][135] = 2;
        level[1][135] = 12;
        level[0][136] = 2;
        level[1][136] = 12; 
        level[0][137] = 2;
        level[1][137] = 12;
        
        //Above spike and blocks
        level[6][134] = 2;
        level[5][134] = 13;
        level[6][135] = 2;
        level[5][135] = 13;
        level[6][136] = 2;
        level[5][136] = 13; 
        level[6][137] = 2;
        level[5][137] = 13;
    
        for(int i = 0; i <= 4; i++){
            level[i][145] = 2;
        }
        
        level[5][152] = 2;
        level[4][152] = 13;
        level[5][153] = 2;
        level[4][153] = 13;
        level[5][154] = 2;
        level[4][154] = 13;
        
        level[0][158] = 2;
        level[1][158] = 12;
        level[0][159] = 2;
        level[1][159] = 12;
        level[0][160] = 2;
        level[1][160] = 12; 
        
        for(int i = 0; i <= 4; i++){
            level[i][165] = 2;
        }
        
        level[0][172] = 2;
        level[1][172] = 12;
        level[0][173] = 2;
        level[1][173] = 12;
        level[0][174] = 2;
        level[1][174] = 12; 
        
        level[5][178] = 2;
        level[4][178] = 13;
        level[5][179] = 2;
        level[4][179] = 13;
        level[5][180] = 2;
        level[4][180] = 13;
        
        for(int i = 0; i <= 4; i++){
            level[i][185] = 2;
        }

        return level;
    }
    
    public static int[][] level3()
    {
        emptyLevel();
        ScrollWorld.setEnvironment(
            "Drift/background.png",
            "Drift/foreground.png",
            "Drift/foreground.png",
            "Drift/glow.png"
        );
        
        // --- INTRO: Rhythmic Spikes ---
        level[0][15] = 14;
        level[0][21] = 14;
        level[0][22] = 14;
        
        // --- SECTION 1: The Staircase & Orb Timing ---
        level[0][30] = 3;
        level[2][33] = 3; // Elevated platform
        level[3][33] = 5; // Jump pad on top of stairs
        
        // Launch player over a pit of spikes
        for(int i = 35; i <= 45; i++) 
        {
            level[0][i] = 14; 
        }
        
        // Mid-air Orb Chain (Player is launched by pad at 34, hits orbs at 38 and 42)
        level[5][38] = 6; 
        level[6][42] = 6;
        
        // Landing platform
        for(int i = 46; i <= 54; i++) level[3][i] = 3;
        level[4][50] = 14; // Spike on the platform to jump over
        
        // --- SECTION 2: Tight Jumps ---
        level[0][60] = 14;
        level[0][61] = 14;
        level[1][63] = 6; // Low orb jump
        level[1][67] = 3;
        level[1][68] = 3;
        level[2][73] = 3;
        
        // Long flat stretch with "Triple Spikes" (Classic difficulty)
        for(int i = 77; i <= 100; i++) level[3][i] = 3;
        level[4][85] = 14;
        level[4][86] = 14;
        level[4][87] = 14; // Triple spike jump
        
        // --- SECTION 3: The Ship Portal Transition ---
        level[4][102] = 5; // Pad to launch into portal
        level[8][105] = 20; // Ship Portal high up
        
        // --- SECTION 4: Hard Ship Flying (The Gauntlet) ---
        // Floor and Ceiling for the ship section
        for(int i = 105; i <= 195; i++) {
            level[0][i] = 3;    // Floor
            level[10][i] = 3;   // Ceiling
            if(i % 5 == 0) {
                level[1][i] = 14;  // Ground spikes
                level[9][i] = 15;  // Ceiling spikes (flipped)
            }
        }
        
        // Obstacle Pillars (Tight Corridors)
        // Pillar 1: High Gap
        for(int i = 1; i <= 6; i++) level[i][120] = 3;
        
        // Pillar 2: Low Gap
        for(int i = 4; i <= 9; i++) level[i][135] = 3;
        
        // Pillar 3: Narrow Middle Gap
        for(int i = 1; i <= 3; i++) level[i][150] = 3;
        for(int i = 7; i <= 9; i++) level[i][150] = 3;
        
        // The "Zig-Zag" Spikes
        level[3][165] = 14;
        level[7][170] = 15;
        level[3][175] = 14;
        
        // --- SECTION 5: Final Cube Transition ---
        level[5][185] = 21; // Cube portal to finish
        
        // Final triple spike challenge
        for(int i = 185; i <= 199; i++) level[0][i] = 3;
        level[1][192] = 14;
        level[1][193] = 14;
        level[1][194] = 14;
    
        return level;
    }

    /*
    public static int[][] level3() {
        emptyLevel();
        ScrollWorld.setEnvironment(
            "Drift/background.png",
            "Drift/foreground.png",
            "Drift/foreground.png",
            "Drift/glow.png"
        );
        
        level[0][15] = 14;
        level[0][21] = 14;
        level[0][22] = 14;
        level[0][28] = 14;
        level[0][29] = 14;
        level[0][30] = 3;
        level[0][31] = 3;
        level[1][31] = 14;
        level[0][39] = 14;
        level[0][40] = 3;
        level[1][40] = 3;
        level[2][44] = 3;
        for(int i = 44; i <= 54; i++){
            level[2][i] = 3;
        }
        level[3][50] = 14;
        level[3][54] = 3;
        level[0][57] = 14;
        level[0][65] = 3;
        level[1][69] = 3;
        level[2][73] = 3;
        level[3][77] = 3;
        for(int i = 77; i <= 84; i++){
            level[3][i] = 3;
        }
        for(int i = 0; i <= 4; i++){
            level[i][88] = 3;
        }
        level[0][91] = 14;
        level[0][92] = 14;
        level[0][100] = 3;
        level[1][104] = 3;
        level[2][108] = 3;
        level[3][112] = 3;
        level[4][116] = 3;
        level[5][120] = 3;
        for(int i = 102; i <= 128; i++){
            level[0][i] = 14;
        }
        level[7][120] = 20;
        for(int i = 0; i <= 4; i++){
            level[i][137] = 3;
        }
        for(int i = 9; i > 7; i--){
            level[i][137] = 3;
        }
        //first pillar
        for(int i = 0; i <= 2; i++){
            level[i][157] = 3;
        }
        for(int i = 9; i >= 6; i--){
            level[i][157] = 3;
        }
        //second pillar
        for(int i = 0; i <= 3; i++){
            level[i][177] = 3;
        }
        for(int i = 9; i >= 7; i--){
            level[i][177] = 3;
        }
        for(int i = 0; i <= 3; i++){
            level[i][190] = 3;
        }
        return level;
    }*/
}
