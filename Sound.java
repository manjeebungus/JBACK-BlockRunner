import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Abstract base class for handling music and sound effects.
 * Manages global volume control, sound registration,
 * and shared behavior between all sound types.
 *
 * Inspired by the sound system from *The Binding of Jordan*.
 *
 * @author Kelton Kuan
 * @version 1.01
 */
public abstract class Sound extends Actor
{
    /** Current index used for cycling through multiple sound files */
    protected int index;

    /** Global volume level for all music sounds */
    protected static int musicVolume;

    /** Global volume level for all sound effects */
    protected static int sfxVolume;

    /** Individual volume level for this sound instance */
    protected int soundVolume;

    /** List of all registered music sounds */
    protected static ArrayList<Sound> musicList = new ArrayList<Sound>();

    /** List of all registered sound effect sounds */
    protected static ArrayList<Sound> sfxList = new ArrayList<Sound>();
    
    /**
     * Constructs a Sound object with a default index value.
     */
    public Sound() {
        index = 0;
    }
    
    /**
     * Increments the sound index and wraps it back to zero
     * if it exceeds the given length.
     * Used for cycling through multiple sound variations.
     *
     * @param length the total number of sound variations
     */
    protected void incrementIndex(int length) {
        index++;
        if (index >= length) {
            index = 0;
        }
    }
    
    /**
     * Sets the global music volume and updates
     * all registered music sounds.
     *
     * @param volume the new music volume level
     */
    public static void setMusicVolume(int volume) {
        musicVolume = volume;
        for (Sound s : musicList) {
            s.setSoundVolume();
        }
    }
    
    /**
     * Sets the global sound effect volume and updates
     * all registered sound effects.
     *
     * @param volume the new sound effect volume level
     */
    public static void setSfxVolume(int volume) {
        sfxVolume = volume;
        for (Sound s : sfxList) {
            s.setSoundVolume();
        }
    }
    
    /**
     * Registers a Sound object as music so it can
     * be controlled by the global music volume.
     *
     * @param s the music sound to register
     */
    public static void registerMusic(Sound s) {
        musicList.add(s);
    }
    
    /**
     * Registers a Sound object as a sound effect
     * so it can be controlled by the global SFX volume.
     *
     * @param s the sound effect to register
     */
    public static void registerSfx(Sound s) {
        sfxList.add(s);
    }
    
    /**
     * Plays the sound once.
     */
    public abstract void play();
    
    /**
     * Pauses the sound if it is currently playing.
     */
    public abstract void pause();
    
    /**
     * Stops the sound and resets its playback position.
     */
    public abstract void stop();
    
    /**
     * Plays the sound continuously in a loop.
     */
    public abstract void playLoop();
    
    /**
     * Updates the sound's volume based on
     * the current global volume settings.
     */
    public abstract void setSoundVolume();
    
    /**
     * Sets the sound's volume to a specific value.
     *
     * @param volume the volume level to set
     */
    public abstract void setSoundVolume(int volume);
}
