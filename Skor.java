import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Graphics;
import java.awt.Color;
/**
 * Write a description of class Skor here.
 * 
 * @author Much. Riza Al Muttaqin
 * @version 1.0
 */
public class Skor extends Actor
{
    /**
     * Act - do whatever the Skor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private static final Color textColor = new Color(255,100,0);
    
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
        panjangTeks = (teks.length() + 15) * 10;
        
        setImage(new GreenfootImage(panjangTeks, 25));
        GreenfootImage gambar = getImage();
        Font font = gambar.getFont();
        gambar.setFont(font.deriveFont(24.0F));
        gantiGambar();
    }
    
    public void act() 
    {
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
     * Memasukkan Skor
     */
    private void gantiGambar()
    {
        GreenfootImage gambar = getImage();
        gambar.clear();
        gambar.drawString(teks + nilai, 1, 25);
    }
}
