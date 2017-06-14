/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkimatti.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import shakkimatti.nappulat.Kuningas;
import shakkimatti.nappulat.Torni;

/**
 *
 * @author Masavain
 */
public class PaalogiikkaTest {

    private Paalogiikka peli;

    public PaalogiikkaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        peli = new Paalogiikka();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testaaAlustus() {
        Pelilauta lauta = peli.getPelilauta();
        assertEquals(lauta.toString(), "TRLQKLRT\n"
                + "SSSSSSSS\n"
                + "........\n"
                + "........\n"
                + "........\n"
                + "........\n"
                + "SSSSSSSS\n"
                + "TRLQKLRT\n");
    }

    @Test
    public void testaaPelaaja() {
        Pelaaja ans = Pelaaja.VALKOINEN;
        assertEquals(ans, peli.getPelaaja());
    }

    @Test
    public void testaaShakki() {
        peli.setPelilauta(new Pelilauta());
        Pelilauta lauta = peli.getPelilauta();
        lauta.asetaNappula(new Kuningas(3, 3, Pelaaja.VALKOINEN), 3, 3);
        lauta.asetaNappula(new Torni(3, 5, Pelaaja.MUSTA), 3, 5);

        assertTrue(peli.checkUhka(Pelaaja.VALKOINEN, 3, 3));
    }

    @Test
    public void testaaShakki2() {
        peli.setPelilauta(new Pelilauta());
        Pelilauta lauta = peli.getPelilauta();
        lauta.asetaNappula(new Kuningas(3, 3, Pelaaja.VALKOINEN), 3, 3);
        lauta.asetaNappula(new Torni(5, 5, Pelaaja.MUSTA), 5, 5);

        assertFalse(peli.checkUhka(Pelaaja.VALKOINEN, 3, 3));
    }

    @Test
    public void testaaShakkiMatti() {
        peli.setPelilauta(new Pelilauta());
        Pelilauta lauta = peli.getPelilauta();
        Kuningas kunkku = new Kuningas(4, 7, Pelaaja.VALKOINEN);
        Kuningas kunkku2 = new Kuningas(4, 5, Pelaaja.MUSTA);
        Torni torni = new Torni(0, 7, Pelaaja.MUSTA);
        lauta.asetaNappula(kunkku, 4, 7);
        lauta.asetaNappula(kunkku2, 4, 5);
        lauta.asetaNappula(torni, 0, 7);

        assertTrue(peli.checkShakkiMatti(Pelaaja.VALKOINEN));
    }
    
    @Test
    public void testaaShakkiMatti2() {
        peli.setPelilauta(new Pelilauta());
        Pelilauta lauta = peli.getPelilauta();
        Kuningas kunkku = new Kuningas(4, 7, Pelaaja.VALKOINEN);
        Torni torni = new Torni(0, 7, Pelaaja.MUSTA);
        lauta.asetaNappula(kunkku, 4, 7);
        lauta.asetaNappula(torni, 0, 7);

        assertFalse(peli.checkShakkiMatti(Pelaaja.VALKOINEN));
    }
    
    @Test
    public void testaaVuoronVaihto() {
        assertEquals(peli.getPelaaja(), Pelaaja.VALKOINEN);
    }
    
    @Test
    public void testaaVuoronVaihto2() {
        peli.vaihdaVuoroa();
        assertEquals(peli.getPelaaja(), Pelaaja.MUSTA);
    }
    
    @Test
    public void testaaVuoronVaihto3() {
        peli.vaihdaVuoroa();
        peli.vaihdaVuoroa();
        assertEquals(peli.getPelaaja(), Pelaaja.VALKOINEN);
    }
    
    @Test
    public void testaaVuoro() {
        Pelilauta lauta = peli.getPelilauta();
        assertTrue(peli.vuoro(6,6,6,5));
    }
    
    @Test
    public void testaaVuoro2() {
        peli.setPelilauta(new Pelilauta());
        Pelilauta lauta = peli.getPelilauta();
        Kuningas kunkku = new Kuningas(4, 7, Pelaaja.VALKOINEN);
        lauta.asetaNappula(kunkku, 4, 7);
        
        assertFalse(peli.vuoro(4,7,1,1));
    }
}
