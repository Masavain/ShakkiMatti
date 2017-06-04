
package shakkimatti.nappula;

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
        this.lauta = new Pelilauta(new GridPane());
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void eiLiikuJosEiMahdollinenSiirto(){
        Ratsu ratsu = new Ratsu(1,0,0);
        ratsu.liiku(1, 1, lauta.getLauta());
        assertEquals(ratsu.x+","+ratsu.y, "1,0");
    }
    
    
    @Test
    public void liikkuuOikeaanKoordinaattiin1(){
        Ratsu ratsu = new Ratsu(1,0,0);
        ratsu.liiku(0, 2, lauta.getLauta());
        assertEquals(ratsu.x+","+ratsu.y, "0,2");
    }
    
    @Test
    public void mahdSiirrot1(){
        Ratsu ratsu = new Ratsu(4,4,0);
        String[] koordit  = new String[]{"5,6", "6,5", "3,6", "2,5", "3,2", "2,3", "5,2", "6,3"};
        List<String> oikearivi = Arrays.asList(koordit);
        
        assertEquals(ratsu.mahdollisetSiirrot(lauta.getLauta()), oikearivi);
    }
    
    @Test
    public void mahdSyonnit(){
        Ratsu ratsu = new Ratsu(4,4,0);
        lauta.asetaNappula(ratsu, 4, 4);
        Sotilas solttu1 = new Sotilas(5,6,1, false);
        Sotilas solttu2 = new Sotilas(6,5,1, false);
        Sotilas solttu3 = new Sotilas(3,6,1, false);
        Sotilas solttu4 = new Sotilas(2,5,1, false);
        Sotilas solttu5 = new Sotilas(3,2,1, false);
        Sotilas solttu6 = new Sotilas(2,3,1, false);
        Sotilas solttu7 = new Sotilas(5,2,1, false);
        Sotilas solttu8 = new Sotilas(6,3,1, false);
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
        Ratsu ratsu = new Ratsu(4,4,0);
        lauta.asetaNappula(ratsu, 4, 4);
        
        
        String[] koordit  = new String[]{};
        List<String> oikearivi = Arrays.asList(koordit);
        
                
        assertEquals(ratsu.mahdollisetSyonnit(lauta.getLauta()), oikearivi);
    }
    
    @Test
    public void eiPaaseLaudaltaPois(){
        Ratsu ratsu = new Ratsu(1,0,0);
        ratsu.liiku(0, -2, lauta.getLauta());
        assertEquals(ratsu.x+","+ratsu.y, "1,0");
    }
    
    @Test
    public void syotavaListalla(){
        Ratsu ratsu = new Ratsu(1,0,0);
        Sotilas solttu = new Sotilas(3,1,1,false);
        lauta.asetaNappula(ratsu, 1, 0);
        lauta.asetaNappula(solttu, 3, 1);
        
        assertTrue(ratsu.mahdollisetSyonnit(lauta.getLauta()).contains("3,1"));
    }
    
    @Test
    public void eiVoiSyodaOmanVarista(){
        Ratsu ratsu = new Ratsu(1,0,0);
        Sotilas solttu = new Sotilas(3,1,0,false);
        lauta.asetaNappula(ratsu, 1, 0);
        lauta.asetaNappula(solttu, 3, 1);
        
        assertFalse(ratsu.mahdollisetSyonnit(lauta.getLauta()).contains("3,1"));
    }
    
    @Test
    public void kuningastaEiVoiSyoda(){
        Ratsu ratsu = new Ratsu(1,0,0);
        Kuningas kunkku = new Kuningas(3,1,1);
        lauta.asetaNappula(ratsu, 1, 0);
        lauta.asetaNappula(kunkku, 3, 1);
        
        assertFalse(ratsu.mahdollisetSyonnit(lauta.getLauta()).contains("3,1"));
    }
}
