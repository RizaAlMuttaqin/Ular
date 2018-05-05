import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Graphics;

/**
 * Write a description of class Skor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Skor extends Actor
{
    /**
     * Act - do whatever the Skor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private static final Color textColor = new Color(255,0,0);
    
    private int nilai = 0;
    private int target = 0;
    private String teks;
    private int panjangTeks;
    
    public Skor()
    {
        this("");
    }
    public Skor(String prefix)
    {
        teks = prefix;
        panjangTeks = (teks.length() + 2) * 10;
        
        setImage(new GreenfootImage(panjangTeks, 16));
        GreenfootImage gambar = getImage();
        gantiGambar();
    }
    
    public void act() 
    {
        // Add your action code here.
        if(nilai < target)
        {
            nilai++;
            gantiGambar();
        }
        else if(nilai > target)
        {
            nilai--;
            gantiGambar();
        }
    }
    
    public void tambah(int skor)
    {
        target += skor;
    }
    
    public void kurang(int skor)
    {
        target -= skor;
    }
    
    public int ambilNilai()
    {
        return nilai;
    }
    
    /**
     * Memasukkan Gambar
     */
    private void gantiGambar()
    {
        GreenfootImage gambar = getImage();
        gambar.clear();
        gambar.drawString(teks + nilai, 1, 12);
    }
}
