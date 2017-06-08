package shakkimatti.logiikka;

import shakkimatti.nappulat.Nappula;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import shakkimatti.nappulat.Kuningas;
import shakkimatti.nappulat.Sotilas;

public class PelilautaTest {

    private Pelilauta lauta;

    public PelilautaTest() {
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
    public void testaaToStringTyhjallaLaudalla() {
        String tostring = lauta.toString();
        assertEquals(tostring, "........\n"
                + "........\n"
                + "........\n"
                + "........\n"
                + "........\n"
                + "........\n"
                + "........\n"
                + "........\n");
    }

    @Test
    public void testaaAlustusMerkki() {
        lauta.alustus();
        assertEquals(lauta.getLauta()[0][0].getMerkki(), "T");

    }

    @Test
    public void testaaAlustusNappula() {
        lauta.alustus();
        Nappula n = lauta.getLauta()[0][0];

        assertEquals(n, lauta.getLauta()[0][0]);

    }

    @Test
    public void testaaPelinappuloidenPaikatAlustuksenJalkeen() {
        lauta.alustus();
        String tostring = lauta.toString();
        assertEquals("TRLQKLRT\n"
                + "SSSSSSSS\n"
                + "........\n"
                + "........\n"
                + "........\n"
                + "........\n"
                + "SSSSSSSS\n"
                + "TRLQKLRT\n", lauta.toString());
    }

    @Test
    public void testaaToStringAlustuksenJaYhdenSiirronJalkeen() {
        lauta.alustus();

        Nappula namiska = lauta.getLauta()[1][1];
        lauta.siirto(namiska.getX(), namiska.getY(), 1, 2);
        String tostring = lauta.toString();
        assertEquals(lauta.toString(), "TRLQKLRT\n"
                + "S.SSSSSS\n"
                + ".S......\n"
                + "........\n"
                + "........\n"
                + "........\n"
                + "SSSSSSSS\n"
                + "TRLQKLRT\n");
    }

    @Test
    public void testaaTostringkahdesti() {
        lauta.alustus();

        Nappula namiska = lauta.getLauta()[1][1];
        String tostring = lauta.toString();
        assertEquals(lauta.toString(), tostring);
    }

    @Test
    public void testaaSiirto() {
        Pelilauta peli = new Pelilauta();
        peli.asetaNappula(new Kuningas(0, 0, Pelaaja.MUSTA), 0, 0);
        assertTrue(peli.siirto(0, 0, 1, 1));
    }
    
    @Test
    public void testaaSiirto2() {
        Pelilauta peli = new Pelilauta();
        peli.asetaNappula(new Kuningas(0, 0, Pelaaja.MUSTA), 0, 0);
        peli.asetaNappula(new Sotilas(1, 1, Pelaaja.VALKOINEN, false), 1, 1);
        assertFalse(peli.siirto(1, 1, 0, 0));
    }
    
    @Test
    public void testaaSiirto3() {
        Pelilauta peli = new Pelilauta();
        peli.asetaNappula(new Sotilas(0, 0, Pelaaja.VALKOINEN, false), 0, 0);
        peli.asetaNappula(new Sotilas(1, 1, Pelaaja.VALKOINEN, false), 1, 1);
        assertFalse(peli.siirto(1, 1, 0, 0));
    }
    
    @Test
    public void testaaSiirto4() {
        Pelilauta peli = new Pelilauta();
        Sotilas solttu = new Sotilas(0, 0, Pelaaja.MUSTA, false);
        peli.asetaNappula(solttu, 0, 0);
        peli.siirto(0, 0, 0, 1);
        
        assertEquals(solttu.getX()+","+solttu.getY(), "0,1");
    }

    @Test
    public void testaaValidiSiir() {
        lauta.asetaNappula(new Kuningas(0, 0, Pelaaja.MUSTA), 0, 0);
        assertTrue(lauta.validiSiirrettava(Pelaaja.MUSTA, 0, 0));
        assertFalse(lauta.validiSiirrettava(Pelaaja.MUSTA, 1, 1));
        assertFalse(lauta.validiSiirrettava(Pelaaja.VALKOINEN, 0, 0));
        assertFalse(lauta.validiSiirrettava(Pelaaja.VALKOINEN, 1, 1));

    }

}
