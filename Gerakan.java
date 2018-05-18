import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Gerakan here.
 * 
 * @author Much. Riza Al Muttaqin & Amira Aliyah
 * @version 1.0
 */
public class Gerakan extends Actor
{   
    private void gerakan()  
    {  
        move(9);
        if (Greenfoot.getRandomNumber (100) < 10)  
            {  
                turn(Greenfoot.getRandomNumber (90-45));  
            }  
        if (atWorldEdge())
            {  
                turn(90);
            }  
    } 
    
    /**
     * Menabrak Garis Tepi
     */
    public boolean atWorldEdge()
    {
        if(getX() <= 0 || getX() >= getWorld().getWidth()-1)
            return true;
        if(getY() <= 0 || getY() >= getWorld().getHeight()-1)
            return true;
        else
            return false;
    }
}
