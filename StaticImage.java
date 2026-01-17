import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * @Author Chase Coulter
 * @Version v1.0
 * StaticImage is meant to be an easy way to add images with no behaviour
 * to project, such as an unmoving background
 */
public class StaticImage extends Visual
{
    public StaticImage(String fileName){
        setImage(new GreenfootImage(fileName));
    }
}
