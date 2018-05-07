import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Gerakan here.
 * 
 * @author Much. Riza Al Muttaqin & Amira Aliyah
 * @version 1.0
 */
public class Gerakan extends Actor
{
    private static final double kecepatan_jalan = 5.0;
    
    /**
     * Berputar 90 derajat ke kanan (searah jarum jam).
     */
    public void belok()
    {
        belok(90);
    }
    
    /**
     * Belok 'sudut' derajat menuju ke kanan (searah jarum jam).
     */
    public void belok(int sudut)
    {
        setRotation(getRotation() + sudut);
    }
    
    /**
     * Maju sedikit ke posisi saat ini.
     */
    public void gerak()
    {
        gerak(kecepatan_jalan);
    }
    
    /**
     * Bergerak maju dengan jarak yang ditentukan ke arah saat ini.
     */
    public void gerak(double jarak)
    {
        double sudut = Math.toRadians(getRotation());
        int x = (int) Math.round(getX() + Math.cos(sudut) * jarak);
        int y = (int) Math.round(getY() + Math.sin(sudut) * jarak);
        
        setLocation(x,y);
    }
    
    /**
     * Menabrak Garis Tepi
     */
    public boolean garisTepi()
    {
        if(getX() < 20 || getX() > getWorld().getWidth() - 20)
            return true;
        if(getY() < 20 || getY() > getWorld().getHeight() - 20)
            return true;
        else
            return false;
    }
}
