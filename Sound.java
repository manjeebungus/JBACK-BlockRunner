import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sound here.
 * 
 * @author Kelton Kuan (Taken from Binding of Issac)
 * @version (a version number or a date)
 */
public class Sound extends Actor
{
    protected int index; // current index in the sounds array
    
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
}
