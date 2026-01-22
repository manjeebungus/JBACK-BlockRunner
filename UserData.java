import greenfoot.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileNotFoundException;


/**
 * Write a description of class UserData here.
 * 
 * @author Kelton Kuan
 * @version (a version number or a date)
 */
public class UserData  
{
    private static String username = "Random Runner";
    
    // Game values
    private static int musicVolume = 100; // int 0
    private static int sfxVolume = 100; // int 1
    private static int attempts = 0; // int 2
    
    private static final String fileName = "data.txt";
    
    
    public static void load() {
        try {
            Scanner scanner = new Scanner(new File(fileName));
            
            try {
                username = scanner.nextLine();
                musicVolume = Integer.parseInt(scanner.nextLine());
                sfxVolume = Integer.parseInt(scanner.nextLine());
                attempts = Integer.parseInt(scanner.nextLine());
            } catch(NumberFormatException e) {
                System.out.println("Found non-integer type");
                System.exit(1);
            }
        } catch (FileNotFoundException e) {
            username = "Random Runner";
            musicVolume = 100;
            sfxVolume = 100;
            attempts = 0;
        }
    }
    
    
    public static void save() {
        try {
            FileWriter fileWriter = new FileWriter(new File(fileName));
            PrintWriter output = new PrintWriter(fileWriter);
            
            output.println(username);
            output.println(musicVolume);
            output.println(sfxVolume);
            output.println(attempts);
            
            output.close();
        } catch (IOException e) {
            System.out.println("File error");
            System.exit(1);
        }
    }
    
    /**
     * Returns the user's music volume setting.
     *
     * @return the music volume level, typically in the range 0–100
     */
    public static int getMusicVolume() {
        return musicVolume;
    }
    
    /**
     * Returns the user's sound effect (SFX) volume setting.
     *
     * @return the sound effect volume level, typically in the range 0–100
     */
    public static int getSfxVolume() {
        return sfxVolume;
    }
    
    /**
     * Returns the total number of attempts the user has made.
     * <p>
     * An attempt is usually counted each time the player starts or restarts
     * a level.
     * </p>
     *
     * @return the number of attempts made by the user
     */
    public static int getAttempts() {
        return attempts;
    }
    
    /**
     * Determines whether this is the user's first time playing the game.
     * <p>
     * This method considers the user to be a first-time player if they have
     * not made any attempts yet.
     * </p>
     *
     * @return {@code true} if the user has made zero attempts; {@code false} otherwise
     */
    public static boolean isFirstTime() {
        return attempts == 0;
    }
    
    /**
     * Returns the Greenfoot Gallery username of the current player.
     *
     * @return the user's Gallery username if logged in, or "Guest" if the user
     *         is not logged in or user information is unavailable
     */
    public static String getUsername() {
        return username;
    }
    
    /**
     * Sets the user's music volume.
     * <p>
     * The value is clamped to the range 0–100 to prevent invalid volume levels.
     * </p>
     *
     * @param volume the new music volume level
     */
    public static void setMusicVolume(int volume) {
        musicVolume = Math.max(0, Math.min(100, volume));
        Sound.setMusicVolume(musicVolume);
        
        save();
    }
    
    /**
     * Sets the user's sound effect (SFX) volume.
     * <p>
     * The value is clamped to the range 0–100 to prevent invalid volume levels.
     * </p>
     *
     * @param volume the new sound effect volume level
     */
    public static void setSfxVolume(int volume) {
        sfxVolume = Math.max(0, Math.min(100, volume));
        Sound.setSfxVolume(sfxVolume);
        
        save();
    }
    
    /**
     * Sets the total number of attempts made by the user.
     * <p>
     * This value should normally only increase as the player restarts or
     * retries levels.
     * </p>
     *
     * @param value the new attempt count
     */
    public static void setAttempts(int value) {
        attempts = Math.max(0, value);
        save();
    }
    
    /**
     * Increments the user's attempt count by one.
     * <p>
     * This method should be called whenever the player starts or restarts
     * a level.
     * </p>
     */
    public static void incrementAttempts() {
        attempts++;
        save();
    }
}
