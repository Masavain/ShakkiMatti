package shakkimatti.logiikka;

import shakkimatti.logiikka.Pelilauta;
import shakkimatti.nappulat.Nappula;
import java.util.*;
import javafx.scene.layout.GridPane;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import shakkimatti.nappulat.Kuningas;
import shakkimatti.nappulat.Kuningatar;
import shakkimatti.nappulat.Lahetti;
import shakkimatti.nappulat.Ratsu;
import shakkimatti.nappulat.Torni;

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
    public void testaaAlustusMerkit() {
        
        
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
        assertEquals(tostring, "TRLQKLRT\n"
                + "S.SSSSSS\n"
                + ".S......\n"
                + "........\n"
                + "........\n"
                + "........\n"
                + "SSSSSSSS\n"
                + "TRLQKLRT\n");
    }

    @Test
    public void testaaValidiSiir() {
        Pelilauta peli = new Pelilauta();

        peli.asetaNappula(new Kuningas(0, 0, Pelaaja.MUSTA), 0, 0);
        assertTrue(peli.validiSiirrettava(Pelaaja.MUSTA, 0, 0));
    }
    
    @Test
    public void testaaSiirto() {
        Pelilauta peli = new Pelilauta();
        peli.asetaNappula(new Kuningas(0, 0, Pelaaja.MUSTA), 0, 0);
        assertTrue(peli.siirto(0, 0, 1, 1));
    }

    @Test
    public void testaaValidiSiir2() {
        Pelilauta peli = new Pelilauta();

        peli.asetaNappula(new Kuningas(0, 0, Pelaaja.MUSTA), 0, 0);
        assertFalse(peli.validiSiirrettava(Pelaaja.VALKOINEN, 0, 0));
    }
}
