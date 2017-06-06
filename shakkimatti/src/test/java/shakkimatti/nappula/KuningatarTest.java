
package shakkimatti.nappula;

import shakkimatti.logiikka.Pelilauta;
import shakkimatti.nappulat.Kuningatar;
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


public class KuningatarTest {
    
    private Pelilauta lauta;
    public KuningatarTest() {
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
        Kuningatar kuningatar = new Kuningatar(3,0,Pelaaja.MUSTA);
        kuningatar.liiku(8, 8, lauta.getLauta());
        assertEquals(kuningatar.x+","+kuningatar.y, "3,0");
    }
    
    @Test
    public void liikkuuOikeaanKoordinaattiin(){
        Kuningatar kuningatar = new Kuningatar(3,0,Pelaaja.MUSTA);
        kuningatar.liiku(3, 5, lauta.getLauta());
        assertEquals(kuningatar.x+","+kuningatar.y, "3,5");
    }
    
    @Test
    public void eiPaaseLaudaltaPois(){
        Kuningatar kuningatar = new Kuningatar(3,0,Pelaaja.MUSTA);
        kuningatar.liiku(0, -2, lauta.getLauta());
        assertEquals(kuningatar.x+","+kuningatar.y, "3,0");
    }
    
    @Test
    public void syotavaListalla(){
        Kuningatar kuningatar = new Kuningatar(4,0,Pelaaja.MUSTA);
        Sotilas solttu = new Sotilas(4,1,Pelaaja.VALKOINEN ,false);
        lauta.asetaNappula(kuningatar, 4, 0);
        lauta.asetaNappula(solttu, 4, 1);
        
        assertTrue(kuningatar.mahdollisetSyonnit(lauta.getLauta()).contains("4,1"));
    }
    
    @Test
    public void eiVoiSyodaOmanVarista(){
        Kuningatar kuningatar = new Kuningatar(4,0,Pelaaja.MUSTA);
        Sotilas solttu = new Sotilas(4,1,Pelaaja.MUSTA,false);
        lauta.asetaNappula(kuningatar, 4, 0);
        lauta.asetaNappula(solttu, 4, 1);
        
        assertFalse(kuningatar.mahdollisetSyonnit(lauta.getLauta()).contains("4,1"));
    }
    
    @Test
    public void kuningastaEiVoiSyoda(){
        Kuningatar kuningatar = new Kuningatar(4,0,Pelaaja.MUSTA);
        Kuningas kunkku = new Kuningas(4,1,Pelaaja.VALKOINEN);
        lauta.asetaNappula(kuningatar, 4, 0);
        lauta.asetaNappula(kunkku, 4, 1);
        
        assertFalse(kuningatar.mahdollisetSyonnit(lauta.getLauta()).contains("4,1"));
    }
}
