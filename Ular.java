import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ular here.
 * 
 * @author Riza Al Muttaqin
 * @version 1.0
 */
public class Ular extends Actor
{
    private final int kanan = 0;
    private final int bawah = 90;
    private final int kiri = 180;
    private final int atas = 270;
    
    private final int kecepatan = 10;
    private int counter = 0;
    
    public Ular()
    {
        GreenfootImage img = new GreenfootImage(30, 30);
        img.fill();
        setImage(img);
        
        setRotation(Greenfoot.getRandomNumber(4)*90);
    }
    
    public void act() 
    {
        // Add your action code here.
        gerakCuy();
        if(isTouching(makanan.class))
        {
            removeTouching(makanan.class);
            
            DuniaUlar dunia = (DuniaUlar)getWorld();
            dunia.TambahMakanan();
        }
    }
    
    private void gerakCuy()
    {
        counter ++;
        if(counter==kecepatan){
            move(1);
            counter = 0;
        }
        if(Greenfoot.isKeyDown("Kanan")){
            setRotation(kanan);
        }
        if(Greenfoot.isKeyDown("Bawah")){
            setRotation(bawah);
        }
        if(Greenfoot.isKeyDown("Kiri")){
            setRotation(kiri);
        }
        if(Greenfoot.isKeyDown("Atas")){
            setRotation(atas);
        }
    }
}
