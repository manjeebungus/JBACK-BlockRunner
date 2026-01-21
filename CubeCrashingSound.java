import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * 
 * @author Josh Ye asst. by Kelton Kuan
 * Class is taken from Binding of Issac
 * @version (a version number or a date)
 * Button sound effect credit to Robtop
 */
public class CubeCrashingSound extends Sound
{
    private static GreenfootSound[] sounds; // hold copies of the sound
    private static final String soundFile = "cubecrashing.wav";
    
    public CubeCrashingSound(int count, int volume) {
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
    
    public void stop() {
        for (GreenfootSound s : sounds) {
            s.stop();
        }
    }
}
