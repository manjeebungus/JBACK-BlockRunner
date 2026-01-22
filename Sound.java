import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Sound here.
 * 
 * @author Kelton Kuan (Taken from Binding of Issac)
 * @version 1.01 a lot of new methods
 * 
 */
public abstract class Sound extends Actor
{
    protected int index; // current index in the sounds array
    protected static int musicVolume;
    protected static int sfxVolume;
    protected int soundVolume;
    protected static ArrayList<Sound> musicList = new ArrayList<Sound>();
    protected static ArrayList<Sound> sfxList = new ArrayList<Sound>();
    
    //constructor with default volume
    public Sound() {
        index = 0;
    }
    protected void incrementIndex(int length) {
        index++;
        if (index >= length) {
            index = 0;
        }
    }
    
    public static void setMusicVolume(int volume) {
        musicVolume = volume;
        for (Sound s : musicList) {
            s.setSoundVolume();
        }
    }
    
    public static void setSfxVolume(int volume) {
        sfxVolume = volume;
        for (Sound s : sfxList) {
            s.setSoundVolume();
        }
    }
    
    public static void registerMusic(Sound s) {
        musicList.add(s);
    }
    
    public static void registerSfx(Sound s) {
        sfxList.add(s);
    }
    
    public abstract void play();
    
    public abstract void pause();
    
    public abstract void stop();
    
    public abstract void playLoop();
    
    public abstract void setSoundVolume();
    
    public abstract void setSoundVolume(int volume);
}
