import greenfoot.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

/**
 * Handles persistent user data for Random Runner, including username,
 * music and SFX volume, and total attempts.
 * 
 * Data is stored in a local text file (data.txt) and automatically
 * loaded and saved when settings change.
 * 
 * @author Kelton
 * @version 1.1
 */
public class UserData {
    private static String username = "Random Runner";
    
    // Game settings
    private static int musicVolume = 100; // 0-100
    private static int sfxVolume = 100;   // 0-100
    private static int attempts = 0;      // number of times player has played

    private static final String fileName = "data.txt";

    /**
     * Loads the user data from the file.
     * If the file doesn't exist or contains invalid data, defaults are used.
     */
    public static void load() {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            username = scanner.nextLine();
            musicVolume = Integer.parseInt(scanner.nextLine());
            sfxVolume = Integer.parseInt(scanner.nextLine());
            attempts = Integer.parseInt(scanner.nextLine());
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Data file not found. Using default settings.");
        } catch (NumberFormatException e) {
            System.out.println("Data file contains invalid values. Using defaults.");
            username = "Random Runner";
            musicVolume = 100;
            sfxVolume = 100;
            attempts = 0;
        }
    }

    /**
     * Saves the current user data to the file.
     */
    public static void save() {
        try (PrintWriter output = new PrintWriter(new FileWriter(fileName))) {
            output.println(username);
            output.println(musicVolume);
            output.println(sfxVolume);
            output.println(attempts);
            output.close();
        } catch (IOException e) {
            System.out.println("Error saving user data.");
        }
    }

    /** Returns the user's music volume (0-100). */
    public static int getMusicVolume() {
        return musicVolume;
    }

    /** Returns the user's SFX volume (0-100). */
    public static int getSfxVolume() {
        return sfxVolume;
    }

    /** Returns the total number of attempts made by the player. */
    public static int getAttempts() {
        return attempts;
    }

    /** Returns true if the player has never played before. */
    public static boolean isFirstTime() {
        return attempts == 0;
    }

    /** Returns the user's username. */
    public static String getUsername() {
        return username;
    }

    /**
     * Sets the music volume and updates all music objects.
     * Clamped to 0-100.
     */
    public static void setMusicVolume(int volume) {
        musicVolume = Math.max(0, Math.min(100, volume));
        Sound.setMusicVolume(musicVolume);
        save();
    }

    /**
     * Sets the SFX volume and updates all SFX objects.
     * Clamped to 0-100.
     */
    public static void setSfxVolume(int volume) {
        sfxVolume = Math.max(0, Math.min(100, volume));
        Sound.setSfxVolume(sfxVolume);
        save();
    }

    /**
     * Sets the total attempts. Ensures non-negative value.
     */
    public static void setAttempts(int value) {
        attempts = Math.max(0, value);
        save();
    }

    /** Increments the attempt count by one and saves the data. */
    public static void incrementAttempts() {
        attempts++;
        save();
    }
}