import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tombol here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tombol extends Actor
{
    /**
     * Act - do whatever the Tombol wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(String namaTombol) 
    {
        if (Greenfoot.mouseMoved(this)) {
            setImage(namaTombol + "_over.png");
        } else if (Greenfoot.mouseMoved(null)) {
            setImage(namaTombol + ".png");
        }
        if (Greenfoot.mousePressed(this)) {
            getImage().scale((int)Math.round(getImage().getWidth() * 0.9), (int)Math.round(getImage().getHeight() * 0.9));
        }
        if (Greenfoot.mouseClicked(null) || Greenfoot.mouseDragEnded(null)) {
            setImage(namaTombol + ".png"); 
        }
        if (Greenfoot.mouseClicked(this)) {
            setImage(namaTombol + ".png");
            Greenfoot.delay(5); 
            if      (namaTombol.equalsIgnoreCase("StartBtn")) Greenfoot.setWorld(new DuniaUlar());
            else if (namaTombol.equalsIgnoreCase("HelpBtn"))  Greenfoot.setWorld(new Help());
            else if (namaTombol.equalsIgnoreCase("BackBtn"))  Greenfoot.setWorld(new Menu());
            else if (namaTombol.equalsIgnoreCase("ExitBtn"))  Greenfoot.stop();
        }
    }    
}
