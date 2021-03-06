package shakkimatti.nappulat;

import java.util.Arrays;
import java.util.List;
import shakkimatti.logiikka.Pelilauta;
import shakkimatti.nappulat.Torni;
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

public class TorniTest {

    private Pelilauta lauta;

    public TorniTest() {
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
        Torni torni = new Torni(0, 0, Pelaaja.MUSTA);
        torni.liiku(1, 1, lauta.getLauta());
        assertEquals(torni.getX() + "," + torni.getY(), "0,0");
    }

    @Test
    public void liikkuuOikeaanKoordinaattiin() {
        Torni torni = new Torni(0, 0, Pelaaja.MUSTA);
        torni.liiku(0, 2, lauta.getLauta());
        assertEquals(torni.getX() + "," + torni.getY(), "0,2");
    }

    @Test
    public void liikuAlas() {
        Torni torni = new Torni(0, 7, Pelaaja.MUSTA);
        torni.liiku(0, 0, lauta.getLauta());
        assertEquals(torni.getX() + "," + torni.getY(), "0,0");
    }

    @Test
    public void liikkumisia() {
        Torni torni = new Torni(4, 4, Pelaaja.MUSTA);
        Sotilas solttu = new Sotilas(3, 4, Pelaaja.MUSTA, false);
        Sotilas solttu3 = new Sotilas(4, 5, Pelaaja.MUSTA, false);
        Sotilas solttu4 = new Sotilas(4, 3, Pelaaja.MUSTA, false);
        Sotilas solttu6 = new Sotilas(5, 4, Pelaaja.MUSTA, false);
        lauta.asetaNappula(torni, 4, 4);
        lauta.asetaNappula(solttu, 3, 4);
        lauta.asetaNappula(solttu3, 4, 5);
        lauta.asetaNappula(solttu4, 4, 3);
        lauta.asetaNappula(solttu6, 5, 4);

        assertFalse(torni.mahdollisetSiirrot(lauta.getLauta()).contains("3,4"));
        assertFalse(torni.mahdollisetSiirrot(lauta.getLauta()).contains("4,5"));
        assertFalse(torni.mahdollisetSiirrot(lauta.getLauta()).contains("4,3"));
        assertFalse(torni.mahdollisetSiirrot(lauta.getLauta()).contains("5,4"));
    }

    @Test
    public void liikuOik() {
        Torni torni = new Torni(0, 0, Pelaaja.MUSTA);
        torni.liiku(7, 0, lauta.getLauta());
        assertEquals(torni.getX() + "," + torni.getY(), "7,0");
    }

    @Test
    public void liikuVas() {
        Torni torni = new Torni(7, 0, Pelaaja.MUSTA);
        torni.liiku(0, 0, lauta.getLauta());
        assertEquals(torni.getX() + "," + torni.getY(), "0,0");
    }

    @Test
    public void syotavatOikein() {
        Torni torni = new Torni(5, 5, Pelaaja.MUSTA);
        lauta.asetaNappula(torni, 0, 0);
        Sotilas solttu1 = new Sotilas(5, 6, Pelaaja.VALKOINEN, false);
        Sotilas solttu2 = new Sotilas(6, 5, Pelaaja.VALKOINEN, false);
        Sotilas solttu3 = new Sotilas(5, 4, Pelaaja.VALKOINEN, false);
        Sotilas solttu4 = new Sotilas(4, 5, Pelaaja.VALKOINEN, false);
        lauta.asetaNappula(solttu1, 5, 6);
        lauta.asetaNappula(solttu2, 6, 5);
        lauta.asetaNappula(solttu3, 5, 4);
        lauta.asetaNappula(solttu3, 4, 5);

        String[] koordit = new String[]{"6,5", "4,5", "5,6", "5,4"};
        List<String> oikearivi = Arrays.asList(koordit);

        assertEquals(torni.mahdollisetSiirrot(lauta.getLauta()), oikearivi);

    }

    @Test
    public void eiPaaseLaudaltaPois() {
        Torni torni = new Torni(0, 0, Pelaaja.MUSTA);
        torni.liiku(0, -2, lauta.getLauta());
        assertEquals(torni.getX() + "," + torni.getY(), "0,0");
    }

    @Test
    public void ulkopuolella() {
        Torni torni = new Torni(10, 10, Pelaaja.MUSTA);
        torni.liiku(0, 10, lauta.getLauta());
        assertEquals(torni.getX() + "," + torni.getY(), "10,10");
    }

    @Test
    public void ulkopuolella2() {
        Torni torni = new Torni(-10, -10, Pelaaja.MUSTA);
        torni.liiku(0, -10, lauta.getLauta());
        assertEquals(torni.getX() + "," + torni.getY(), "-10,-10");
    }

    @Test
    public void syotavaListalla() {
        Torni torni = new Torni(1, 0, Pelaaja.MUSTA);
        Sotilas solttu = new Sotilas(3, 0, Pelaaja.VALKOINEN, false);
        lauta.asetaNappula(torni, 1, 0);
        lauta.asetaNappula(solttu, 3, 0);

        assertTrue(torni.mahdollisetSiirrot(lauta.getLauta()).contains("3,0"));
    }

    @Test
    public void eiVoiSyodaOmanVarista() {
        Torni torni = new Torni(1, 0, Pelaaja.MUSTA);
        Sotilas solttu = new Sotilas(3, 0, Pelaaja.MUSTA, false);
        lauta.asetaNappula(torni, 1, 0);
        lauta.asetaNappula(solttu, 3, 0);

        assertFalse(torni.mahdollisetSiirrot(lauta.getLauta()).contains("3,0"));
    }

}
