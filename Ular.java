import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ular here.
 * 
 * @author Much. Riza Al Muttaqin
 * @version 1.0
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
            setImage("badan3.png");
        }
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
