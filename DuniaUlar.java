import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DuniaUlar here.
 * 
 * @author (Much. Riza Al Muttaqin & Amira Aliyah) 
 * @version 1.0
 */
public class DuniaUlar extends World
{

    /**
     * Constructor for objects of class DuniaUlar.
     * 
     */
    public DuniaUlar()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(30, 20, 30);
        GreenfootImage img = new GreenfootImage(30, 30);
        img.drawRect(0, 0, 40, 40);
        setBackground(img);
        
        int x = Greenfoot.getRandomNumber(getWidth());
        int y = Greenfoot.getRandomNumber(getHeight());
        addObject(new Ular(), x, y);
        
        TambahMakanan();
    }
    
    public void TambahMakanan()
    {
        int x = Greenfoot.getRandomNumber(getWidth());
        int y = Greenfoot.getRandomNumber(getHeight());
        addObject(new makanan(), x, y);
    }
}
