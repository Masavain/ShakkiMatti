
package shakkimatti.nappulat;

import shakkimatti.logiikka.Pelilauta;
import shakkimatti.nappulat.Ratsu;
import java.util.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import shakkimatti.nappulat.Kuningas;
import shakkimatti.nappulat.Sotilas;
import javafx.scene.layout.*;
import shakkimatti.logiikka.Pelaaja;


public class RatsuTest {
    
    private Pelilauta lauta;
    
    public RatsuTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.lauta = new Pelilauta();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void eiLiikuJosEiMahdollinenSiirto(){
        Ratsu ratsu = new Ratsu(1,0,Pelaaja.MUSTA);
        ratsu.liiku(1, 1, lauta.getLauta());
        assertEquals(ratsu.getX()+","+ratsu.getY(), "1,0");
    }
    
    
    @Test
    public void liikkuuOikeaanKoordinaattiin1(){
        Ratsu ratsu = new Ratsu(1,0,Pelaaja.MUSTA);
        ratsu.liiku(0, 2, lauta.getLauta());
        assertEquals(ratsu.getX()+","+ratsu.getY(), "0,2");
    }
    
    @Test
    public void mahdSiirrot1(){
        Ratsu ratsu = new Ratsu(4,4,Pelaaja.MUSTA);
        String[] koordit  = new String[]{"5,6", "6,5", "3,6", "2,5", "3,2", "2,3", "5,2", "6,3"};
        List<String> oikearivi = Arrays.asList(koordit);
        
        assertEquals(ratsu.mahdollisetSiirrot(lauta.getLauta()), oikearivi);
    }
    
    @Test
    public void mahdSyonnit(){
        Ratsu ratsu = new Ratsu(4,4,Pelaaja.MUSTA);
        lauta.asetaNappula(ratsu, 4, 4);
        Sotilas solttu1 = new Sotilas(5,6,Pelaaja.VALKOINEN, false);
        Sotilas solttu2 = new Sotilas(6,5,Pelaaja.VALKOINEN, false);
        Sotilas solttu3 = new Sotilas(3,6,Pelaaja.VALKOINEN, false);
        Sotilas solttu4 = new Sotilas(2,5,Pelaaja.VALKOINEN, false);
        Sotilas solttu5 = new Sotilas(3,2,Pelaaja.VALKOINEN, false);
        Sotilas solttu6 = new Sotilas(2,3,Pelaaja.VALKOINEN, false);
        Sotilas solttu7 = new Sotilas(5,2,Pelaaja.VALKOINEN, false);
        Sotilas solttu8 = new Sotilas(6,3,Pelaaja.VALKOINEN, false);
        lauta.asetaNappula(solttu1, 5, 6);
        lauta.asetaNappula(solttu2, 6, 5);
        lauta.asetaNappula(solttu3, 3, 6);
        lauta.asetaNappula(solttu3, 2, 5);
        lauta.asetaNappula(solttu3, 3, 2);
        lauta.asetaNappula(solttu3, 2, 3);
        lauta.asetaNappula(solttu3, 5, 2);
        lauta.asetaNappula(solttu3, 6, 3);
        
        String[] koordit  = new String[]{"5,6", "6,5", "3,6", "2,5", "3,2", "2,3", "5,2", "6,3"};
        List<String> oikearivi = Arrays.asList(koordit);
        
                
        assertEquals(ratsu.mahdollisetSyonnit(lauta.getLauta()), oikearivi);
    }
    
    @Test
    public void mahdSyonnit2(){
        Ratsu ratsu = new Ratsu(4,4,Pelaaja.MUSTA);
        lauta.asetaNappula(ratsu, 4, 4);
        
        
        String[] koordit  = new String[]{};
        List<String> oikearivi = Arrays.asList(koordit);
        
                
        assertEquals(ratsu.mahdollisetSyonnit(lauta.getLauta()), oikearivi);
    }
    
    @Test
    public void eiPaaseLaudaltaPois(){
        Ratsu ratsu = new Ratsu(1,0,Pelaaja.MUSTA);
        ratsu.liiku(0, -2, lauta.getLauta());
        assertEquals(ratsu.getX()+","+ratsu.getY(), "1,0");
    }
    
    @Test
    public void syotavaListalla(){
        Ratsu ratsu = new Ratsu(1,0,Pelaaja.MUSTA);
        Sotilas solttu = new Sotilas(3,1,Pelaaja.VALKOINEN,false);
        lauta.asetaNappula(ratsu, 1, 0);
        lauta.asetaNappula(solttu, 3, 1);
        
        assertTrue(ratsu.mahdollisetSyonnit(lauta.getLauta()).contains("3,1"));
    }
    
    @Test
    public void eiVoiSyodaOmanVarista(){
        Ratsu ratsu = new Ratsu(1,0,Pelaaja.MUSTA);
        Sotilas solttu = new Sotilas(3,1,Pelaaja.MUSTA,false);
        lauta.asetaNappula(ratsu, 1, 0);
        lauta.asetaNappula(solttu, 3, 1);
        
        assertFalse(ratsu.mahdollisetSyonnit(lauta.getLauta()).contains("3,1"));
    }
    
    @Test
    public void kuningastaEiVoiSyoda(){
        Ratsu ratsu = new Ratsu(1,0,Pelaaja.MUSTA);
        Kuningas kunkku = new Kuningas(3,1,Pelaaja.VALKOINEN);
        lauta.asetaNappula(ratsu, 1, 0);
        lauta.asetaNappula(kunkku, 3, 1);
        
        assertFalse(ratsu.mahdollisetSyonnit(lauta.getLauta()).contains("3,1"));
    }
}
