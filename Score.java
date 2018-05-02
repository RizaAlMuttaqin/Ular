import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Font;
/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Actor
{
    private int nilai = 0;
    private int target = 0;
    private String text;
    private int panjangSkor;

    /**
     * Score - sets up the score object
     */
    public Score()
    {
        this("");
    }

    /**
     * setText - sets the text of the score
     */
    public Score(String prefix)
    {
        text = prefix;
        panjangSkor = (text.length() + 2) * 10;
        
        setImage(new GreenfootImage(panjangSkor, 16));
        GreenfootImage skor = getImage();
        skor.setColor(Color.WHITE);
        UpdateSkor();
    }

    public void act(){
       if(nilai < target){
           nilai++;
           UpdateSkor();
        }
        else if(nilai > target){
           nilai--;
           UpdateSkor();
        }
    }
    
    public void tambah(int skor){
        target += skor;
    }
    
    public void kurang(int skor){
        target -= skor;
    }
    
    public int ambilNilai(){
        return nilai;
    }
    
    /**
     * Membuat Gambar}
    */
    private void UpdateSkor(){
       GreenfootImage skor = getImage();
       skor.clear();
       skor.drawString(text + nilai, 1, 12);
    }
}
