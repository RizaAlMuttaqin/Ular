import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ular here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ular extends Gerakan
{
    /**
     * Act - do whatever the Ular wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Ular(boolean kepala)
    {
        if(kepala)
        {
            setImage("Kepala.png");
        }
        else
        {
            setImage("Badan1.png");
        }
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
