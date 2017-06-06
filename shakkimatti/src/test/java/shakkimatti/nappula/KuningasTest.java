
package shakkimatti.nappula;

import shakkimatti.logiikka.Pelilauta;
import shakkimatti.nappulat.Kuningas;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import javafx.scene.layout.*;

import static org.junit.Assert.*;
import shakkimatti.logiikka.Pelaaja;
import shakkimatti.nappulat.Sotilas;


public class KuningasTest {
    
    private Pelilauta lauta;
    public KuningasTest() {
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
        Kuningas kingi = new Kuningas(4,0,Pelaaja.MUSTA);
        kingi.liiku(8, 8, lauta.getLauta());
        assertEquals(kingi.x+","+kingi.y, "4,0");
    }
    
    @Test
    public void liikkuuOikeaanKoordinaattiin(){
        Kuningas kingi = new Kuningas(4,0,Pelaaja.MUSTA);
        kingi.liiku(4, 1, lauta.getLauta());
        assertEquals(kingi.x+","+kingi.y, "4,1");
    }
    
    @Test
    public void eiPaaseLaudaltaPois(){
        Kuningas kingi = new Kuningas(4,0,Pelaaja.MUSTA);
        kingi.liiku(0, -2, lauta.getLauta());
        assertEquals(kingi.x+","+kingi.y, "4,0");
    }
    
    @Test
    public void syotavaListalla(){
        Kuningas kingi = new Kuningas(4,0,Pelaaja.MUSTA);
        Sotilas solttu = new Sotilas(4,1,Pelaaja.VALKOINEN,false);
        lauta.asetaNappula(kingi, 4, 0);
        lauta.asetaNappula(solttu, 4, 1);
        
        assertTrue(kingi.mahdollisetSyonnit(lauta.getLauta()).contains("4,1"));
    }
    
    @Test
    public void eiVoiSyodaOmanVarista(){
        Kuningas kingi = new Kuningas(4,0,Pelaaja.MUSTA);
        Sotilas solttu = new Sotilas(4,1,Pelaaja.MUSTA,false);
        lauta.asetaNappula(kingi, 4, 0);
        lauta.asetaNappula(solttu, 4, 1);
        
        assertFalse(kingi.mahdollisetSyonnit(lauta.getLauta()).contains("4,1"));
    }
    
    @Test
    public void kuningastaEiVoiSyoda(){
        Kuningas kingi = new Kuningas(4,0,Pelaaja.MUSTA);
        Kuningas kunkku = new Kuningas(4,1,Pelaaja.VALKOINEN);
        lauta.asetaNappula(kingi, 4, 0);
        lauta.asetaNappula(kunkku, 4, 1);
        
        assertFalse(kingi.mahdollisetSyonnit(lauta.getLauta()).contains("4,1"));
    }
}
