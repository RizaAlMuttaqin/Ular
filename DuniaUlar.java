import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DuniaUlar here.
 * 
 * @author Much. Riza Al Muttaqin & Amira Aliyah
 * @version 1.0
 */
public class DuniaUlar extends World
{
    /**
     * Variable yang diperlukan di game ini
     */
    private Ular badanUlar[];
    private makanan makanan;
    private Skor skor;
    private int arah;
    private boolean dimakan;
    private int status;
    public static final int BLOCK = 15;
    
    /**
     * Constructor for objects of class DuniaUlar.
     * 
     */
    public DuniaUlar()
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(20*BLOCK, 30*BLOCK,1);
        arah = 0;
        dimakan = false;
        status = 0;
    }
    
    /**
     * Status Permainan
     */
    public void act()
    {
        if(status==0)
        {
            setBackground("nice2.jpg");
            if(Greenfoot.getKey()!=null)
                status = 1;
            return;
        }
        else if(status==1)//Status Permainan Aktif
        {
            setBackground("Marble.jpg");
            
            makanan = new makanan();//Inisiasi makanan
            addObject(makanan,0,0);//Menambahkan makanan
            
            skor = new Skor("Skor");//Inisiasi skor
            addObject(skor, 19*BLOCK, 8);//Menambahkan skor
            
            badanUlar = new Ular[3];
            for(int i=0; i<badanUlar.length; i++)
            {
                badanUlar[i] = new Ular(i==0);
                addObject(badanUlar[i], 6*BLOCK+(badanUlar.length-i)*BLOCK, 2*BLOCK);
            }
            gantiPosisiMakanan();
            status = 2;
            return;
        }
        else if(status==-1)//Game Over
        {
            removeObjects(getObjects(null));
            setBackground("gameove.jpg");
            addObject(skor, 19*BLOCK, 8);
            return;
        }
        
        if(dimakan)
            gantiPosisiMakanan();//Mengganti posisi dari makanan
            
        if(Greenfoot.isKeyDown("right"))
        {
            if(arah == 1 || arah == 3)
                arah = 0;
        }
        else if(Greenfoot.isKeyDown("down"))
        {
            if(arah == 0 || arah == 2)
                arah = 1;
        }
        else if(Greenfoot.isKeyDown("left"))
        {
            if(arah == 1 || arah == 3)
                arah = 2;
        }
        else if(Greenfoot.isKeyDown("up"))
        {
            if(arah == 0 || arah == 2)
                arah = 3;
        }
        
        int putaran = badanUlar[0].getRotation();
        int previousLocationX = badanUlar[0].getX();
        int previousLocationY = badanUlar[0].getY();
        
        badanUlar[0].setRotation(arah*90);
        badanUlar[0].move(BLOCK);
        
        if(badanUlar[0].getX()!=previousLocationX || badanUlar[0].getY()!=previousLocationY)//Mengecek ketika ular menabrak garis tepi
        {
            for(int i=1; i < badanUlar.length; i++)
            {
                int sisaPutaran = badanUlar[i].getRotation();
                badanUlar[i].setRotation(putaran);
                
                previousLocationX = badanUlar[i].getX();
                previousLocationY = badanUlar[i].getY();
                badanUlar[i].move(BLOCK); // Badan Ular seluruhnya hanya begerak satu gerakan
                putaran = sisaPutaran;
            }
        
            if(badanUlar[0].getX()==makanan.getX() && badanUlar[0].getY()==makanan.getY())
            {
                ularTumbuh(previousLocationX, previousLocationY, putaran);
                gantiPosisiMakanan();
                skor.tambah(5);
            }
        
            for(int i = 1; i < badanUlar.length; i++)
            {
                if(badanUlar[0].getX()==badanUlar[i].getX() && badanUlar[0].getY() == badanUlar[i].getY())
                {
                    status = -1;
                }
            }
        }
        else
        {
            arah = putaran/90;
            badanUlar[0].setRotation(arah*90);
            status = -1;
        }
    }
    
    /**
     * Method untuk menambah panjang badan ular
     */
    private void ularTumbuh(int x, int y, int putaran)
    {
        Ular u = new Ular(false);
        Ular ularLama[] = new Ular[badanUlar.length];
        for(int i=0; i < badanUlar.length; i++)
        {
            ularLama[i] = badanUlar[i];
        }
        badanUlar = new Ular[badanUlar.length+1];
        for(int i=0; i<badanUlar.length-1; i++)
        {
            badanUlar[i] = ularLama[i];
        }
        badanUlar[badanUlar.length-1] = u;
        badanUlar[badanUlar.length-1].setRotation(putaran);
        addObject(badanUlar[badanUlar.length-1], x, y);// menambahkan actor baru Badan Ular
    }
    
    /**
     * Method untuk mengubah tempat dimana makanan ditampilkan
     */
    private void gantiPosisiMakanan()
    {
        int x = 0, y = 0;
        boolean penindihan = true;
        dimakan = false;
        
        while(penindihan)
        {
            x = Greenfoot.getRandomNumber(getWidth()/BLOCK);
            y = Greenfoot.getRandomNumber(getHeight()/BLOCK);
            
            for(int i = 0; i < badanUlar.length; i++)
            {
                //Kondisi untuk mengecek makanan agar tidak tersentuh ular
                if(x!=badanUlar[i].getX() || y != badanUlar[i].getY())
                {
                    penindihan = false;
                    break;
                }
            }
        }
        
        makanan.setLocation(x*BLOCK, y*BLOCK);
    }
}
