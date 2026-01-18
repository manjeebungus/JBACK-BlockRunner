import greenfoot.*;

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
    
    /**
     * Loads the user's saved data from the Greenfoot Gallery.
     * <p>
     * This method reads values from {@link greenfoot.UserInfo} and applies them
     * to the static fields in this class. It should be called once when the game
     * starts (for example, in the main menu or first world).
     * </p>
     *
     * <p>
     * If the user is not logged in to the Greenfoot Gallery, or if storage is not
     * available, this method does nothing and default values are used instead.
     * </p>
     *
     * <p>
     * Note: This method does not create new data. It only reads previously
     * saved values.
     * </p>
     */
    public static void load() {
        if (!UserInfo.isStorageAvailable()) return;
        
        UserInfo info = UserInfo.getMyInfo();
        if (info == null) return;
        
        username = info.getUserName();
        
        musicVolume = info.getInt(0);
        sfxVolume = info.getInt(1);
        attempts = info.getInt(2);
    }
    
    /**
     * Saves the user's current data to the Greenfoot Gallery.
     * <p>
     * This method writes the current values of the static fields in this class
     * to {@link greenfoot.UserInfo} so they can be restored in future sessions.
     * </p>
     *
     * <p>
     * Data is only saved if the user is logged in to the Greenfoot Gallery and
     * storage is available. If either condition is not met, this method does
     * nothing.
     * </p>
     *
     * <p>
     * This method should be called when an important change occurs, such as
     * updating settings, completing a level, or changing progress. It should
     * not be called every frame.
     * </p>
     */
    public static void save() {
        if (!UserInfo.isStorageAvailable()) return;
        
        UserInfo info = UserInfo.getMyInfo();
        if (info == null) return;
        
        info.setInt(0, musicVolume);
        info.setInt(1, sfxVolume);
        info.setInt(2, attempts);
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
