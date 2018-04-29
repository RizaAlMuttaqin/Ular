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
    
    private int makan = 0;
    public Ular()
    {
        GreenfootImage img = new GreenfootImage(20, 20);
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
            makan++;
            DuniaUlar dunia = (DuniaUlar)getWorld();
            dunia.TambahMakanan();
        }
        if(nabrakPinggiran()){
            Greenfoot.stop();
        }
        if(isTouching(BuntutUlar.class))
        {
            Greenfoot.stop();
        }
    }
    
    private boolean nabrakPinggiran()
    {
        switch(getRotation()){
            case kanan: return getX()==getWorld().getWidth()-1;
            case bawah: return getY()==getWorld().getHeight()-1;
            case kiri: return getX()==0;
            case atas: return getY()==0;
        }
        return false;
    }
    
    private void gerakCuy()
    {
        counter++;
        if(counter==kecepatan){
            getWorld().addObject(new BuntutUlar(makan*kecepatan), getX(), getY());
            move(1);
            counter = 0;
        }
        if(Greenfoot.isKeyDown("right")){
            setRotation(kanan);
        }
        if(Greenfoot.isKeyDown("down")){
            setRotation(bawah);
        }
        if(Greenfoot.isKeyDown("left")){
            setRotation(kiri);
        }
        if(Greenfoot.isKeyDown("up")){
            setRotation(atas);
        }
    }
}
