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
    public void testaaSyonnit() {
        Lahetti lahetti = new Lahetti(5, 5, Pelaaja.MUSTA);
        Sotilas solttu1 = new Sotilas(6, 6, Pelaaja.VALKOINEN, false);
        Sotilas solttu2 = new Sotilas(4, 4, Pelaaja.VALKOINEN, false);
        Sotilas solttu3 = new Sotilas(4, 6, Pelaaja.VALKOINEN, false);
        Sotilas solttu4 = new Sotilas(6, 4, Pelaaja.VALKOINEN, false);

        lauta.asetaNappula(lahetti, 5, 5);
        lauta.asetaNappula(solttu1, 6, 6);
        lauta.asetaNappula(solttu2, 4, 4);
        lauta.asetaNappula(solttu3, 4, 6);
        lauta.asetaNappula(solttu4, 6, 4);

        assertTrue(lahetti.mahdollisetSiirrot(lauta.getLauta()).contains("6,6"));
        assertTrue(lahetti.mahdollisetSiirrot(lauta.getLauta()).contains("4,4"));
        assertTrue(lahetti.mahdollisetSiirrot(lauta.getLauta()).contains("4,6"));
        assertTrue(lahetti.mahdollisetSiirrot(lauta.getLauta()).contains("6,4"));
    }

    @Test
    public void testaaSyonnit2() {
        Lahetti lahetti = new Lahetti(5, 5, Pelaaja.MUSTA);
        Sotilas solttu1 = new Sotilas(6, 6, Pelaaja.MUSTA, false);
        Sotilas solttu2 = new Sotilas(4, 4, Pelaaja.MUSTA, false);
        Sotilas solttu3 = new Sotilas(4, 6, Pelaaja.MUSTA, false);
        Sotilas solttu4 = new Sotilas(6, 4, Pelaaja.MUSTA, false);
        lauta.asetaNappula(lahetti, 5, 5);
        lauta.asetaNappula(solttu1, 6, 6);
        lauta.asetaNappula(solttu2, 4, 4);
        lauta.asetaNappula(solttu3, 4, 6);
        lauta.asetaNappula(solttu4, 6, 4);

        assertFalse(lahetti.mahdollisetSiirrot(lauta.getLauta()).contains("6,6"));
        assertFalse(lahetti.mahdollisetSiirrot(lauta.getLauta()).contains("4,4"));
        assertFalse(lahetti.mahdollisetSiirrot(lauta.getLauta()).contains("4,6"));
        assertFalse(lahetti.mahdollisetSiirrot(lauta.getLauta()).contains("6,4"));
    }

    @Test
    public void testaaUlkopuolella() {
        Lahetti lahetti = new Lahetti(-1, -1, Pelaaja.MUSTA);
        Lahetti lahetti2 = new Lahetti(-1, 10, Pelaaja.MUSTA);
        Lahetti lahetti3 = new Lahetti(10, 10, Pelaaja.MUSTA);
        Lahetti lahetti4 = new Lahetti(10, -1, Pelaaja.MUSTA);

        System.out.println(lahetti.mahdollisetSiirrot(lauta.getLauta()));

        assertTrue(lahetti.mahdollisetSiirrot(lauta.getLauta()).isEmpty());
        assertTrue(lahetti2.mahdollisetSiirrot(lauta.getLauta()).isEmpty());
        assertTrue(lahetti3.mahdollisetSiirrot(lauta.getLauta()).isEmpty());
        assertTrue(lahetti4.mahdollisetSiirrot(lauta.getLauta()).isEmpty());
    }

    @Test
    public void testaaRajatapaukset() {
        Lahetti lahetti = new Lahetti(-1, 6, Pelaaja.MUSTA);
        Lahetti lahetti2 = new Lahetti(5, -1, Pelaaja.MUSTA);
        Lahetti lahetti3 = new Lahetti(11, 6, Pelaaja.MUSTA);
        Lahetti lahetti4 = new Lahetti(5, 10, Pelaaja.MUSTA);
        
        assertTrue(lahetti.mahdollisetSiirrot(lauta.getLauta()).isEmpty());
        System.out.println(lahetti2.mahdollisetSiirrot(lauta.getLauta()));
        assertTrue(lahetti2.mahdollisetSiirrot(lauta.getLauta()).isEmpty());
        assertTrue(lahetti3.mahdollisetSiirrot(lauta.getLauta()).isEmpty());
        assertTrue(lahetti4.mahdollisetSiirrot(lauta.getLauta()).isEmpty());
    }

    @Test
    public void syotavaListalla() {
        Lahetti lahetti = new Lahetti(2, 0, Pelaaja.MUSTA);
        Sotilas solttu = new Sotilas(2, 1, Pelaaja.VALKOINEN, false);
        lauta.asetaNappula(lahetti, 2, 0);
        lauta.asetaNappula(solttu, 3, 1);

        assertTrue(lahetti.mahdollisetSiirrot(lauta.getLauta()).contains("3,1"));
    }

    @Test
    public void eiVoiSyodaOmanVarista() {
        Lahetti lahetti = new Lahetti(2, 0, Pelaaja.MUSTA);
        Sotilas solttu = new Sotilas(2, 1, Pelaaja.MUSTA, false);
        lauta.asetaNappula(lahetti, 2, 0);
        lauta.asetaNappula(solttu, 3, 1);

        assertFalse(lahetti.mahdollisetSiirrot(lauta.getLauta()).contains("3,1"));
    }

}
