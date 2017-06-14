package shakkimatti.nappulat;

import shakkimatti.logiikka.Pelilauta;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
    public void eiLiikuJosEiMahdollinenSiirto() {
        Kuningas kingi = new Kuningas(4, 0, Pelaaja.MUSTA);
        kingi.liiku(8, 8, lauta.getLauta());
        assertEquals(kingi.getX() + "," + kingi.getY(), "4,0");
    }

    @Test
    public void rajatapauksia() {
        Kuningas kingi = new Kuningas(10, 10, Pelaaja.MUSTA);
        System.out.println(kingi.mahdollisetSiirrot(lauta.getLauta()));
        assertTrue(kingi.mahdollisetSiirrot(lauta.getLauta()).isEmpty());
    }

    @Test
    public void liikkuuOikeaanKoordinaattiin() {
        Kuningas kingi = new Kuningas(4, 0, Pelaaja.MUSTA);
        kingi.liiku(4, 1, lauta.getLauta());
        assertEquals(kingi.getX() + "," + kingi.getY(), "4,1");
    }

    @Test
    public void eiPaaseLaudaltaPois() {
        Kuningas kingi = new Kuningas(4, 0, Pelaaja.MUSTA);
        kingi.liiku(0, -2, lauta.getLauta());
        assertEquals(kingi.getX() + "," + kingi.getY(), "4,0");
    }

    @Test
    public void syotavaListalla() {
        Kuningas kingi = new Kuningas(4, 0, Pelaaja.MUSTA);
        Sotilas solttu = new Sotilas(4, 1, Pelaaja.VALKOINEN, false);
        lauta.asetaNappula(kingi, 4, 0);
        lauta.asetaNappula(solttu, 4, 1);

        assertTrue(kingi.mahdollisetSiirrot(lauta.getLauta()).contains("4,1"));
    }

    @Test
    public void syotavaListalla2() {
        Kuningas kingi = new Kuningas(4, 0, Pelaaja.MUSTA);
        Sotilas solttu = new Sotilas(3, 1, Pelaaja.VALKOINEN, false);
        lauta.asetaNappula(kingi, 4, 0);
        lauta.asetaNappula(solttu, 3, 1);

        assertTrue(kingi.mahdollisetSiirrot(lauta.getLauta()).contains("3,1"));
    }

    @Test
    public void syotavaListalla3() {
        Kuningas kingi = new Kuningas(4, 0, Pelaaja.MUSTA);
        Sotilas solttu = new Sotilas(3, 1, Pelaaja.VALKOINEN, false);
        lauta.asetaNappula(kingi, 4, 0);
        lauta.asetaNappula(solttu, 3, 0);

        assertTrue(kingi.mahdollisetSiirrot(lauta.getLauta()).contains("3,0"));
    }

    @Test
    public void siirtojakahdeksaansuuntaan() {
        Kuningas kingi = new Kuningas(4, 4, Pelaaja.MUSTA);
        lauta.asetaNappula(kingi, 4, 4);
        assertTrue(kingi.mahdollisetSiirrot(lauta.getLauta()).contains("3,4"));
        assertTrue(kingi.mahdollisetSiirrot(lauta.getLauta()).contains("3,3"));
        assertTrue(kingi.mahdollisetSiirrot(lauta.getLauta()).contains("3,5"));
        assertTrue(kingi.mahdollisetSiirrot(lauta.getLauta()).contains("4,5"));
        assertTrue(kingi.mahdollisetSiirrot(lauta.getLauta()).contains("4,3"));
        assertTrue(kingi.mahdollisetSiirrot(lauta.getLauta()).contains("5,3"));
        assertTrue(kingi.mahdollisetSiirrot(lauta.getLauta()).contains("5,4"));
        assertTrue(kingi.mahdollisetSiirrot(lauta.getLauta()).contains("5,5"));
        
    }

    @Test
    public void syotavaListalla4() {
        Kuningas kingi = new Kuningas(4, 4, Pelaaja.MUSTA);

        Sotilas solttu = new Sotilas(3, 4, Pelaaja.VALKOINEN, false);
        Sotilas solttu1 = new Sotilas(3, 3, Pelaaja.VALKOINEN, false);
        Sotilas solttu2 = new Sotilas(3, 5, Pelaaja.VALKOINEN, false);
        Sotilas solttu3 = new Sotilas(4, 5, Pelaaja.VALKOINEN, false);
        Sotilas solttu4 = new Sotilas(4, 3, Pelaaja.VALKOINEN, false);
        Sotilas solttu5 = new Sotilas(5, 3, Pelaaja.VALKOINEN, false);
        Sotilas solttu6 = new Sotilas(5, 4, Pelaaja.VALKOINEN, false);
        Sotilas solttu7 = new Sotilas(5, 5, Pelaaja.VALKOINEN, false);

        lauta.asetaNappula(kingi, 4, 4);
        lauta.asetaNappula(solttu, 3, 4);
        lauta.asetaNappula(solttu1, 3, 3);
        lauta.asetaNappula(solttu2, 3, 5);
        lauta.asetaNappula(solttu3, 4, 5);
        lauta.asetaNappula(solttu4, 4, 3);
        lauta.asetaNappula(solttu5, 5, 3);
        lauta.asetaNappula(solttu6, 5, 4);
        lauta.asetaNappula(solttu7, 5, 5);

        assertTrue(kingi.mahdollisetSiirrot(lauta.getLauta()).contains("3,4"));
        assertTrue(kingi.mahdollisetSiirrot(lauta.getLauta()).contains("3,3"));
        assertTrue(kingi.mahdollisetSiirrot(lauta.getLauta()).contains("3,5"));
        assertTrue(kingi.mahdollisetSiirrot(lauta.getLauta()).contains("4,5"));
        assertTrue(kingi.mahdollisetSiirrot(lauta.getLauta()).contains("4,3"));
        assertTrue(kingi.mahdollisetSiirrot(lauta.getLauta()).contains("5,3"));
        assertTrue(kingi.mahdollisetSiirrot(lauta.getLauta()).contains("5,4"));
        assertTrue(kingi.mahdollisetSiirrot(lauta.getLauta()).contains("5,5"));

    }

    @Test
    public void eiVoiSyodaOmanVarista() {
        Kuningas kingi = new Kuningas(4, 0, Pelaaja.MUSTA);
        Sotilas solttu = new Sotilas(4, 1, Pelaaja.MUSTA, false);
        lauta.asetaNappula(kingi, 4, 0);
        lauta.asetaNappula(solttu, 4, 1);

        assertFalse(kingi.mahdollisetSiirrot(lauta.getLauta()).contains("4,1"));
    }

}
