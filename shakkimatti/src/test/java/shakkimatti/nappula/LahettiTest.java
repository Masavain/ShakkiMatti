package shakkimatti.nappula;

import shakkimatti.gui.Pelilauta;
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
        this.lauta = new Pelilauta(new GridPane());
    }

    @After
    public void tearDown() {
    }

    @Test
    public void eiLiikuJosEiMahdollinenSiirto() {
        Lahetti lahetti = new Lahetti(2, 0, 0);
        lahetti.liiku(2, 2, lauta.getLauta());
        assertEquals(lahetti.x + "," + lahetti.y, "2,0");
    }

    @Test
    public void liikkuuOikeaanKoordinaattiin() {
        Lahetti lahetti = new Lahetti(2, 0, 0);
        lahetti.liiku(1, 1, lauta.getLauta());
        assertEquals(lahetti.x + "," + lahetti.y, "1,1");
    }

    @Test
    public void eiPaaseLaudaltaPois() {
        Lahetti lahetti = new Lahetti(2, 0, 0);
        lahetti.liiku(0, -2, lauta.getLauta());
        assertEquals(lahetti.x + "," + lahetti.y, "2,0");
    }
    
    @Test
    public void syotavaListalla(){
        Lahetti lahetti = new Lahetti(2,0,0);
        Sotilas solttu = new Sotilas(2,1,1,false);
        lauta.asetaNappula(lahetti, 2, 0);
        lauta.asetaNappula(solttu, 3, 1);
        
        assertTrue(lahetti.mahdollisetSyonnit(lauta.getLauta()).contains("3,1"));
    }
    
    @Test
    public void eiVoiSyodaOmanVarista(){
        Lahetti lahetti = new Lahetti(2,0,0);
        Sotilas solttu = new Sotilas(2,1,0,false);
        lauta.asetaNappula(lahetti, 2, 0);
        lauta.asetaNappula(solttu, 3, 1);
        
        assertFalse(lahetti.mahdollisetSyonnit(lauta.getLauta()).contains("3,1"));
    }
    
    @Test
    public void kuningastaEiVoiSyoda(){
        Lahetti lahetti = new Lahetti(2,0,0);
        Kuningas kunkku = new Kuningas(2,1,1);
        lauta.asetaNappula(lahetti, 2, 0);
        lauta.asetaNappula(kunkku, 3, 1);
        
        assertFalse(lahetti.mahdollisetSyonnit(lauta.getLauta()).contains("3,1"));
    }
}
