import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @Author Chase Coulter
 * @Version v1.1
 */
public class LevelSelectScreen extends Menu
{
    public LevelSelectScreen()
    {    
        super(); 
        setBackground("menu/LevelSelectScreen/baseLine.png");
        addObject(new ScreenChangeButton("Menu/LevelSelectScreen/baseLineUnpressed.png","Menu/LevelSelectScreen/baseLinePressed.png","buttonpress.wav"),500,200);//play button
    }
    public void act(){
        super.act();
        spawnDust();
    }
    private void spawnDust(){
        addObject(new Particle(0, 270, 8.0, 10, 30 + Greenfoot.getRandomNumber(25), new Color(150,40,70)), Greenfoot.getRandomNumber(1000), 600);
    }
}
