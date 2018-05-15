import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Main extends World
{
    private Ular badanUlar[];
    private makanan makanan;
    private Skor skor;
    private int arah;
    private boolean dimakan;
    private int status;
    public static final int BLOCK = 15;
    /**
     * Constructor for objects of class Main.
     * 
     */
    public Main()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(20*BLOCK, 30*BLOCK,1); 
    }
}