import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * 
 * @author Josh Ye 
 * @version (a version number or a date)
 * Jump sound effect credit to Zapsplat
 */
public class JumpSound extends Sound
{
    private static GreenfootSound[] sounds; // hold copies of the sound
    private static final String soundFile = "jump.wav";
    
    public JumpSound(int count, int volume) {
        sounds = new GreenfootSound[count];
        for (int i = 0; i < count; i++) {
            sounds[i] = new GreenfootSound(soundFile);
        }
        setSoundVolume(volume);
        
        index = 0;
        
        registerSfx(this);
    }
    
    public void play() {
        //play the sound at the current index and go to the next index
        sounds[index].play();
        sounds[index].stop();
        sounds[index].play();
        incrementIndex(sounds.length);
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
    
    public void playLoop() {
        sounds[0].playLoop();
    }
    
    public void setSoundVolume() {
        for (GreenfootSound sound : sounds) {
            sound.setVolume(sfxVolume * soundVolume/100);
        }
    }
    
    public void setSoundVolume(int volume) {
        soundVolume = volume;
        for (GreenfootSound sound : sounds) {
            sound.setVolume(sfxVolume * soundVolume/100);
        }
    }
}
