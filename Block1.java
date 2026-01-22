import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TestBlock here.
 * 
 * @author Kelton Kuan
 * @version (a version number or a date)
 */
public class Block1 extends Tile
{
    private static final GreenfootImage image = new GreenfootImage("images/baseLine/block.png");
    
    public Block1(double row, double col) {
        super(row, col, image);
    }
}
