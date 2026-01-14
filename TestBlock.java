import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TestBlock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestBlock extends Tile
{
    private static final GreenfootImage image = new GreenfootImage("images/WorldObjects/block1/full.png");
    
    public TestBlock(double row, double col) {
        super(row, col, image);
    }
}
