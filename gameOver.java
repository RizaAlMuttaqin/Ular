import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class gameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class gameOver extends World
{
    private Skor skor;
    public static final int BLOCK = 15;
    
    /**
     * Constructor for objects of class gameOver.
     * 
     */
    public gameOver()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(20*BLOCK, 30*BLOCK,1);
    }
    
    public void act()
    {
        buttons button = new buttons();
        addObject(button,150,350);
        addObject(skor, 19*BLOCK, 8);
    }
}
