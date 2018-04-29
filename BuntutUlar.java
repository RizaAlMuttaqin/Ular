import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BuntutUlar here.
 * 
 * @author Riza Al Muttaqin & Amira Aliyah 
 * @version 1.0
 */
public class BuntutUlar extends Actor
{
    /**
     * Act - do whatever the BuntutUlar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int umur = 0;
    private int nyawa;
    
    public BuntutUlar(int nyawa)
    {
        GreenfootImage img = new GreenfootImage(20, 20);
        img.fill();
        setImage(img);
        
        this.nyawa = nyawa;
    }
    
    public void act() 
    {
        // Add your action code here.
        if(umur == nyawa){
            getWorld().removeObject(this);
        }
        umur++;
    }    
}
