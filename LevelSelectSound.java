import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class lvlSelectSound here.
 * 
 * @author Abithan
 * Sounds found by Josh Ye
 * @version (a version number or a date)
 */
public class LevelSelectSound extends Sound
{
    private static GreenfootSound[] sounds; // hold copies of the sound
    private static final String soundFile = "levelchoosing.wav";
    
    public LevelSelectSound(int count, int volume) {
        sounds = new GreenfootSound[count];
        for (int i = 0; i < count; i++) {
            sounds[i] = new GreenfootSound(soundFile);
            sounds[i].setVolume(volume);
        }
        
        index = 0;
    }
    
    public void play() {
        //play the sound at the current index and go to the next index
        sounds[index].play();
        sounds[index].stop();
        sounds[index].play();
        incrementIndex(sounds.length);
    }
    
    public void playLoop()
    {
        sounds[index].playLoop();
    }
    
    public void pause()
    {
        for (GreenfootSound s : sounds) {
            s.pause();
        }
    }
    
    public void stop() {
        for (GreenfootSound s : sounds) {
            s.stop();
        }
    }
}
