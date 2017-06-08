package shakkimatti.nappulat;

import shakkimatti.logiikka.Pelilauta;
import shakkimatti.nappulat.Lahetti;
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

public class LahettiTest {

    private Pelilauta lauta;

    public LahettiTest() {
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
    public void eiLiikuJosEiMahdollinenSiirto() {
        Lahetti lahetti = new Lahetti(2, 0, Pelaaja.MUSTA);
        lahetti.liiku(2, 2, lauta.getLauta());
        assertEquals(lahetti.getX() + "," + lahetti.getY(), "2,0");
    }

    @Test
    public void liikkuuOikeaanKoordinaattiin() {
        Lahetti lahetti = new Lahetti(2, 0, Pelaaja.MUSTA);
        lahetti.liiku(1, 1, lauta.getLauta());
        assertEquals(lahetti.getX() + "," + lahetti.getY(), "1,1");
    }

    @Test
    public void eiPaaseLaudaltaPois() {
        Lahetti lahetti = new Lahetti(2, 0, Pelaaja.MUSTA);
        lahetti.liiku(0, -2, lauta.getLauta());
        assertEquals(lahetti.getX() + "," + lahetti.getY(), "2,0");
    }
    
    @Test
    public void syotavaListalla(){
        Lahetti lahetti = new Lahetti(2,0,Pelaaja.MUSTA);
        Sotilas solttu = new Sotilas(2,1,Pelaaja.VALKOINEN,false);
        lauta.asetaNappula(lahetti, 2, 0);
        lauta.asetaNappula(solttu, 3, 1);
        
        assertTrue(lahetti.mahdollisetSiirrot(lauta.getLauta()).contains("3,1"));
    }
    
    @Test
    public void eiVoiSyodaOmanVarista(){
        Lahetti lahetti = new Lahetti(2,0,Pelaaja.MUSTA);
        Sotilas solttu = new Sotilas(2,1,Pelaaja.MUSTA,false);
        lauta.asetaNappula(lahetti, 2, 0);
        lauta.asetaNappula(solttu, 3, 1);
        
        assertFalse(lahetti.mahdollisetSiirrot(lauta.getLauta()).contains("3,1"));
    }
    
}
