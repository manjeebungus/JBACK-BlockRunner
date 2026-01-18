import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @Author Chase Coulter
 * @Version v1.0
 */
public class LevelSelectScreen extends World
{
    public LevelSelectScreen()
    {    
        super(1000, 600, 1); 
        setBackground("menu/LevelSelectScreen/baseLine.png");
        addObject(new ScreenChangeButton("Menu/LevelSelectScreen/baseLineUnpressed.png","Menu/LevelSelectScreen/baseLinePressed.png","buttonpress.wav"),500,200);//play button
    }
}
